package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.KuaidiEntity;
import com.service.KuaidiService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.DaiqundingdanEntity;

import com.service.DaiqundingdanService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 代取订单表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-04
*/
@RestController
@Controller
@RequestMapping("/daiqundingdan")
public class DaiqundingdanController {
    private static final Logger logger = LoggerFactory.getLogger(DaiqundingdanController.class);

    @Autowired
    private DaiqundingdanService daiqundingdanService;

    @Autowired
    private KuaidiService kuaidiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;

        if(role.equals("代取员")){
            params.put("yh",request.getSession().getAttribute("userId"));
            params.put("role",role);
            page = daiqundingdanService.queryPage(params);
        }else if(role.equals("用户")){
            params.put("yh",request.getSession().getAttribute("userId"));
            params.put("role",role);
            page = daiqundingdanService.queryPage(params);
        }else{
            page = daiqundingdanService.queryPage(params);
        }

        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        DaiqundingdanEntity daiqundingdan = daiqundingdanService.selectById(id);
        if(daiqundingdan!=null){
            return R.ok().put("data", daiqundingdan);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DaiqundingdanEntity daiqundingdan, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<DaiqundingdanEntity> queryWrapper = new EntityWrapper<DaiqundingdanEntity>()
            .eq("name", daiqundingdan.getName())
            .eq("yh_types", daiqundingdan.getYhTypes())
            .eq("consigneeSite", daiqundingdan.getConsigneeSite())
            .eq("consignee", daiqundingdan.getConsignee())
            .eq("consigneeNumber", daiqundingdan.getConsigneeNumber())
            .eq("kdzt_types", daiqundingdan.getKdztTypes())
            .eq("dqr_types", daiqundingdan.getDqrTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaiqundingdanEntity daiqundingdanEntity = daiqundingdanService.selectOne(queryWrapper);
        if(daiqundingdanEntity==null){
            daiqundingdanService.insert(daiqundingdan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaiqundingdanEntity daiqundingdan, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<DaiqundingdanEntity> queryWrapper = new EntityWrapper<DaiqundingdanEntity>()
            .notIn("id",daiqundingdan.getId())
            .eq("name", daiqundingdan.getName())
            .eq("yh_types", daiqundingdan.getYhTypes())
            .eq("consigneeSite", daiqundingdan.getConsigneeSite())
            .eq("consignee", daiqundingdan.getConsignee())
            .eq("consigneeNumber", daiqundingdan.getConsigneeNumber())
            .eq("kdzt_types", daiqundingdan.getKdztTypes())
            .eq("dqr_types", daiqundingdan.getDqrTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaiqundingdanEntity daiqundingdanEntity = daiqundingdanService.selectOne(queryWrapper);
        if(daiqundingdanEntity==null){
            daiqundingdanService.updateById(daiqundingdan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 发布代取订单
    */
    @RequestMapping("/Issuepickuporder")
    public R Issuepickuporder(@RequestBody Long ids, HttpServletRequest request){
        KuaidiEntity kuaidi = kuaidiService.selectById(ids);
        DaiqundingdanEntity daiqundingdan = new DaiqundingdanEntity();
        daiqundingdan.setName(kuaidi.getName());
        daiqundingdan.setTakeACode(UUID.randomUUID().toString().toString().replace("-","").substring(0,6));
        daiqundingdan.setConsignee(kuaidi.getConsignee());
        daiqundingdan.setConsigneeNumber(kuaidi.getConsigneeNumber());
        daiqundingdan.setConsigneeSite(kuaidi.getConsigneeSite());
        daiqundingdan.setYhTypes((Integer) request.getSession().getAttribute("userId"));
        daiqundingdan.setKdztTypes(2);
        Wrapper<DaiqundingdanEntity> queryWrapper = new EntityWrapper<DaiqundingdanEntity>()
                .eq("name", daiqundingdan.getName())
                .eq("yh_types", daiqundingdan.getYhTypes())
                .eq("consigneeSite", daiqundingdan.getConsigneeSite())
                .eq("consignee", daiqundingdan.getConsignee())
                .eq("consigneeNumber", daiqundingdan.getConsigneeNumber())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaiqundingdanEntity daiqundingdanEntity = daiqundingdanService.selectOne(queryWrapper);
        if(daiqundingdanEntity==null){
            kuaidi.setKdztTypes(5);
            kuaidiService.updateById(kuaidi);
            daiqundingdanService.insert(daiqundingdan);
            return R.ok();
        }else {
            return R.error(511,"这条快递信息已经发布过了");
        }
    }

    /**
    * 接单
    */
    @RequestMapping("/receiving")
    public R receiving(@RequestBody Long ids, HttpServletRequest request){
        DaiqundingdanEntity daiqundingdan = daiqundingdanService.selectById(ids);
        if(daiqundingdan == null){
            return R.error();
        }
        if(!request.getSession().getAttribute("role").equals("代取员")){
            return R.error("只有代取员可以接单哦");
        }
        daiqundingdan.setDqrTypes((Integer) request.getSession().getAttribute("userId"));
        daiqundingdan.setKdztTypes(4);
        daiqundingdanService.updateById(daiqundingdan);//根据id更新
        return R.ok();
    }


    /**
    * 收取
    */
    @RequestMapping("/reception")
    public R reception(@RequestBody Long ids, HttpServletRequest request){
        DaiqundingdanEntity daiqundingdan = daiqundingdanService.selectById(ids);
        if(daiqundingdan == null){
            return R.error();
        }
        KuaidiEntity name = kuaidiService.selectOne(new EntityWrapper<KuaidiEntity>().eq("name", daiqundingdan.getName()));
        if(name == null){
            return R.error();
        }
        if(daiqundingdan.getKdztTypes()== 3){
            return R.error("该订单已完成，请不要重复点击按钮");
        }
        if(daiqundingdan.getKdztTypes()!= 4){
            return R.error("该订单还未被接单，请不要重复点击接收按钮");
        }
        name.setKdztTypes(3);
        daiqundingdan.setKdztTypes(3);
        kuaidiService.updateById(name);
        daiqundingdanService.updateById(daiqundingdan);//根据id更新
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        daiqundingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

