package com.dao;

import com.entity.KuaidiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidiView;

/**
 * 快递表 Dao 接口
 *
 * @author 
 * @since 2021-03-04
 */
public interface KuaidiDao extends BaseMapper<KuaidiEntity> {

   List<KuaidiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
