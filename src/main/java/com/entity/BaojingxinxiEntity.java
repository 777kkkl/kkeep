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
 * 报警信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@TableName("baojingxinxi")
public class BaojingxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BaojingxinxiEntity() {
		
	}
	
	public BaojingxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 报警编号
	 */
					
	private String baojingbianhao;
	
	/**
	 * 管理账号
	 */
					
	private String guanlizhanghao;
	
	/**
	 * 管理姓名
	 */
					
	private String guanlixingming;
	
	/**
	 * 小区名称
	 */
					
	private String xiaoqumingcheng;
	
	/**
	 * 小区地址
	 */
					
	private String xiaoqudizhi;
	
	/**
	 * 报警内容
	 */
					
	private String baojingneirong;
	
	/**
	 * 报警时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date baojingshijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：报警编号
	 */
	public void setBaojingbianhao(String baojingbianhao) {
		this.baojingbianhao = baojingbianhao;
	}
	/**
	 * 获取：报警编号
	 */
	public String getBaojingbianhao() {
		return baojingbianhao;
	}
	/**
	 * 设置：管理账号
	 */
	public void setGuanlizhanghao(String guanlizhanghao) {
		this.guanlizhanghao = guanlizhanghao;
	}
	/**
	 * 获取：管理账号
	 */
	public String getGuanlizhanghao() {
		return guanlizhanghao;
	}
	/**
	 * 设置：管理姓名
	 */
	public void setGuanlixingming(String guanlixingming) {
		this.guanlixingming = guanlixingming;
	}
	/**
	 * 获取：管理姓名
	 */
	public String getGuanlixingming() {
		return guanlixingming;
	}
	/**
	 * 设置：小区名称
	 */
	public void setXiaoqumingcheng(String xiaoqumingcheng) {
		this.xiaoqumingcheng = xiaoqumingcheng;
	}
	/**
	 * 获取：小区名称
	 */
	public String getXiaoqumingcheng() {
		return xiaoqumingcheng;
	}
	/**
	 * 设置：小区地址
	 */
	public void setXiaoqudizhi(String xiaoqudizhi) {
		this.xiaoqudizhi = xiaoqudizhi;
	}
	/**
	 * 获取：小区地址
	 */
	public String getXiaoqudizhi() {
		return xiaoqudizhi;
	}
	/**
	 * 设置：报警内容
	 */
	public void setBaojingneirong(String baojingneirong) {
		this.baojingneirong = baojingneirong;
	}
	/**
	 * 获取：报警内容
	 */
	public String getBaojingneirong() {
		return baojingneirong;
	}
	/**
	 * 设置：报警时间
	 */
	public void setBaojingshijian(Date baojingshijian) {
		this.baojingshijian = baojingshijian;
	}
	/**
	 * 获取：报警时间
	 */
	public Date getBaojingshijian() {
		return baojingshijian;
	}

}
