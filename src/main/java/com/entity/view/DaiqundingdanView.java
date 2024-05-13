package com.entity.view;

import com.entity.DaiqundingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 代取订单表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-04
 */
@TableName("daiqundingdan")
public class DaiqundingdanView extends DaiqundingdanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public DaiqundingdanView() {

	}
	private String dqrname;

	public String getDqrname() {
		return dqrname;
	}

	public void setDqrname(String dqrname) {
		this.dqrname = dqrname;
	}

	public DaiqundingdanView(DaiqundingdanEntity daiqundingdanEntity) {
		try {
			BeanUtils.copyProperties(this, daiqundingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
