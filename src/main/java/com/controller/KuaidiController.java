package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

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

import com.entity.KuaidiEntity;

import com.service.KuaidiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 快递表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-04
*/
@RestController
@Controller
@RequestMapping("/kuaidi")
public class KuaidiController {
    private static final Logger logger = LoggerFactory.getLogger(KuaidiController.class);

    @Autowired
    private KuaidiService kuaidiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = kuaidiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KuaidiEntity kuaidi = kuaidiService.selectById(id);
        if(kuaidi!=null){
            return R.ok().put("data", kuaidi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KuaidiEntity kuaidi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KuaidiEntity> queryWrapper = new EntityWrapper<KuaidiEntity>()
            .eq("name", kuaidi.getName())
            .eq("consigneeSite", kuaidi.getConsigneeSite())
            .eq("consignee", kuaidi.getConsignee())
            .eq("consigneeNumber", kuaidi.getConsigneeNumber())
            .eq("addresser", kuaidi.getAddresser())
            .eq("addresserNumber", kuaidi.getAddresserNumber())
            .eq("kdzt_types", kuaidi.getKdztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuaidiEntity kuaidiEntity = kuaidiService.selectOne(queryWrapper);
        if(kuaidiEntity==null){
            kuaidi.setTakeACode(UUID.randomUUID().toString().toString().replace("-","").substring(0,6));
            kuaidi.setKdztTypes(1);
            kuaidiService.insert(kuaidi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuaidiEntity kuaidi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KuaidiEntity> queryWrapper = new EntityWrapper<KuaidiEntity>()
            .notIn("id",kuaidi.getId())
            .eq("name", kuaidi.getName())
            .eq("consigneeSite", kuaidi.getConsigneeSite())
            .eq("consignee", kuaidi.getConsignee())
            .eq("consigneeNumber", kuaidi.getConsigneeNumber())
            .eq("addresser", kuaidi.getAddresser())
            .eq("addresserNumber", kuaidi.getAddresserNumber())
            .eq("kdzt_types", kuaidi.getKdztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuaidiEntity kuaidiEntity = kuaidiService.selectOne(queryWrapper);
        if(kuaidiEntity==null){
            kuaidiService.updateById(kuaidi);//根据id更新
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
        kuaidiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

