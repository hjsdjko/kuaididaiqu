package com.dao;

import com.entity.DaiqundingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaiqundingdanView;

/**
 * 代取订单表 Dao 接口
 *
 * @author 
 * @since 2021-03-04
 */
public interface DaiqundingdanDao extends BaseMapper<DaiqundingdanEntity> {

   List<DaiqundingdanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
