package com.entity.model;

import com.entity.DaiqundingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 代取订单表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-04
 */
public class DaiqundingdanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 代取快递名称 Search
     */
    private String name;


    /**
     * 订单发布人
     */
    private Integer yhTypes;


    /**
     * 送件地址
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
     * 快递状态 Search
     */
    private Integer kdztTypes;


    /**
     * 代取人
     */
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
