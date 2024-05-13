package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.RenyuanDao;
import com.entity.RenyuanEntity;
import com.service.RenyuanService;
import com.entity.view.RenyuanView;

/**
 * 用户表 服务实现类
 * @author 
 * @since 2021-03-04
 */
@Service("renyuanService")
@Transactional
public class RenyuanServiceImpl extends ServiceImpl<RenyuanDao, RenyuanEntity> implements RenyuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<RenyuanView> page =new Query<RenyuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
