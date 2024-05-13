package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 代取订单表
 *
 * @author 
 * @email
 * @date 2021-03-04
 */
@TableName("daiqundingdan")
public class DaiqundingdanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DaiqundingdanEntity() {

	}

	public DaiqundingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 代取快递名称 Search
     */
    @TableField(value = "name")
    private String name;
    /**
     * 代取快递名称 Search
     */
    @TableField(value = "takeACode")
    private String takeACode;

    public String getTakeACode() {
        return takeACode;
    }

    public void setTakeACode(String takeACode) {
        this.takeACode = takeACode;
    }

    /**
     * 订单发布人
     */
    @TableField(value = "yh_types")
    private Integer yhTypes;


    /**
     * 送件地址
     */
    @TableField(value = "consigneeSite")
    private String consigneeSite;


    /**
     * 收件人
     */
    @TableField(value = "consignee")
    private String consignee;


    /**
     * 收件人手机号
     */
    @TableField(value = "consigneeNumber")
    private String consigneeNumber;


    /**
     * 快递状态 Search
     */
    @TableField(value = "kdzt_types")
    private Integer kdztTypes;


    /**
     * 代取人
     */
    @TableField(value = "dqr_types")
    private Integer dqrTypes;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：代取快递名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：代取快递名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：订单发布人
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：订单发布人
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：送件地址
	 */
    public String getConsigneeSite() {
        return consigneeSite;
    }


    /**
	 * 获取：送件地址
	 */

    public void setConsigneeSite(String consigneeSite) {
        this.consigneeSite = consigneeSite;
    }
    /**
	 * 设置：收件人
	 */
    public String getConsignee() {
        return consignee;
    }


    /**
	 * 获取：收件人
	 */

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    /**
	 * 设置：收件人手机号
	 */
    public String getConsigneeNumber() {
        return consigneeNumber;
    }


    /**
	 * 获取：收件人手机号
	 */

    public void setConsigneeNumber(String consigneeNumber) {
        this.consigneeNumber = consigneeNumber;
    }
    /**
	 * 设置：快递状态 Search
	 */
    public Integer getKdztTypes() {
        return kdztTypes;
    }


    /**
	 * 获取：快递状态 Search
	 */

    public void setKdztTypes(Integer kdztTypes) {
        this.kdztTypes = kdztTypes;
    }
    /**
	 * 设置：代取人
	 */
    public Integer getDqrTypes() {
        return dqrTypes;
    }


    /**
	 * 获取：代取人
	 */

    public void setDqrTypes(Integer dqrTypes) {
        this.dqrTypes = dqrTypes;
    }

}
