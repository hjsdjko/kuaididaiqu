package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RenyuanEntity;
import java.util.Map;

/**
 * 用户表 服务类
 * @author 
 * @since 2021-03-04
 */
public interface RenyuanService extends IService<RenyuanEntity> {

     PageUtils queryPage(Map<String, Object> params);

}