package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaiqundingdanEntity;
import java.util.Map;

/**
 * 代取订单表 服务类
 * @author 
 * @since 2021-03-04
 */
public interface DaiqundingdanService extends IService<DaiqundingdanEntity> {

     PageUtils queryPage(Map<String, Object> params);

}