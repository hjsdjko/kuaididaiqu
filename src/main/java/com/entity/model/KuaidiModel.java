package com.entity.model;

import com.entity.KuaidiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 快递表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-04
 */
public class KuaidiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 快递名称 Search
     */
    private String name;


    /**
     * 收件地址
     */
    private String consigneeSite;


    /**
     * 收件人
     */
    private String consignee;


    /**
     * 收件人手机号
     */
    private String consigneeNumber;


    /**
     * 发件人
     */
    private String addresser;


    /**
     * 发件人手机号
     */
    private String addresserNumber;


    /**
     * 快递状态 Search
     */
    private Integer kdztTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
	 * 设置：快递名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：快递名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：收件地址
	 */
    public String getConsigneeSite() {
        return consigneeSite;
    }


    /**
	 * 获取：收件地址
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
	 * 设置：发件人
	 */
    public String getAddresser() {
        return addresser;
    }


    /**
	 * 获取：发件人
	 */

    public void setAddresser(String addresser) {
        this.addresser = addresser;
    }
    /**
	 * 设置：发件人手机号
	 */
    public String getAddresserNumber() {
        return addresserNumber;
    }


    /**
	 * 获取：发件人手机号
	 */

    public void setAddresserNumber(String addresserNumber) {
        this.addresserNumber = addresserNumber;
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
