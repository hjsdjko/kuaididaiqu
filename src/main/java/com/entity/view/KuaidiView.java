package com.entity.view;

import com.entity.KuaidiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 快递表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-04
 */
@TableName("kuaidi")
public class KuaidiView extends KuaidiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public KuaidiView() {

	}

	public KuaidiView(KuaidiEntity kuaidiEntity) {
		try {
			BeanUtils.copyProperties(this, kuaidiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
