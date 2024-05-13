package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuaidiEntity;
import java.util.Map;

/**
 * 快递表 服务类
 * @author 
 * @since 2021-03-04
 */
public interface KuaidiService extends IService<KuaidiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}