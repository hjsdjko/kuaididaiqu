package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.RenyuanEntity;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.RenyuanEntity;

import com.service.RenyuanService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 用户表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-04
*/
@RestController
@Controller
@RequestMapping("/renyuan")
public class RenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(RenyuanController.class);

    @Autowired
    private RenyuanService renyuanService;


    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        RenyuanEntity user = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("account", username));
        if(user != null){
            if(!user.getRole().equals(role)){
                return R.error("权限不正常");
            }
            if(user==null || !user.getPassword().equals(password)) {
                return R.error("账号或密码不正确");
            }
            String token = tokenService.generateToken(user.getId(),user.getName(), "users", user.getRole());
            return R.ok().put("token", token);
        }else{
            return R.error("账号或密码或权限不对");
        }

    }


    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        RenyuanEntity user = renyuanService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody RenyuanEntity user){
        if(renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("account", user.getAccount())) !=null) {
            return R.error("用户已存在");
        }
        renyuanService.insert(user);
        return R.ok();
    }

    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String account, String name,HttpServletRequest request){
        RenyuanEntity user = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("account", account).eq("name",name));
        if(user==null) {
            return R.error("用户或账号不存在");
        }
        user.setPassword("123456");
        renyuanService.updateById(user);
        return R.ok("密码已重置为：123456");
    }
    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(params.get("dicCode") == null){
            if(!role.equals("管理员")){
                params.put("yh",request.getSession().getAttribute("userId"));
                params.put("role",request.getSession().getAttribute("role"));
                page = renyuanService.queryPage(params);
            }else{
                page = renyuanService.queryPage(params);
            }
        }else{
            page = renyuanService.queryPage(params);
        }

        return R.ok().put("data", page);
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page2")
    public R page2(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        page = renyuanService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        RenyuanEntity renyuan = renyuanService.selectById(id);
        if(renyuan!=null){
            return R.ok().put("data", renyuan);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @IgnoreAuth
    @RequestMapping("/save")
    public R save(@RequestBody RenyuanEntity renyuan, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<RenyuanEntity> queryWrapper = new EntityWrapper<RenyuanEntity>()
            .eq("name", renyuan.getName())
            .eq("account", renyuan.getAccount())
            .eq("role", renyuan.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenyuanEntity renyuanEntity = renyuanService.selectOne(queryWrapper);
        if("".equals(renyuan.getImgPhoto()) || "null".equals(renyuan.getImgPhoto())){
            renyuan.setImgPhoto(null);
        }
        if(renyuanEntity==null){
            renyuanService.insert(renyuan);
            return R.ok();
        }else {
            return R.error(511,"用户已存在");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RenyuanEntity renyuan, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<RenyuanEntity> queryWrapper = new EntityWrapper<RenyuanEntity>()
            .notIn("id",renyuan.getId())
            .eq("name", renyuan.getName())
            .eq("account", renyuan.getAccount())
            .eq("password", renyuan.getPassword())
            .eq("sex_types", renyuan.getSexTypes())
            .eq("mobile", renyuan.getMobile())
            .eq("role", renyuan.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenyuanEntity renyuanEntity = renyuanService.selectOne(queryWrapper);
        if("".equals(renyuan.getImgPhoto()) || "null".equals(renyuan.getImgPhoto())){
                renyuan.setImgPhoto(null);
        }
        if(renyuanEntity==null){
            renyuanService.updateById(renyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        renyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

