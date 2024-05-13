package com.entity.vo;

import com.entity.KuaidiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 快递表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-04
 */
@TableName("kuaidi")
public class KuaidiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 快递名称 Search
     */

    @TableField(value = "name")
    private String name;


    /**
     * 收件地址
     */

    @TableField(value = "consigneeSite")
    private String consigneeSite;

    /**
     * 收件地址
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
     * 发件人
     */

    @TableField(value = "addresser")
    private String addresser;


    /**
     * 发件人手机号
     */

    @TableField(value = "addresserNumber")
    private String addresserNumber;


    /**
     * 快递状态 Search
     */

    @TableField(value = "kdzt_types")
    private Integer kdztTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
