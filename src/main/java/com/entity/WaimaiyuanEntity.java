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
 * 外卖员
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@TableName("waimaiyuan")
public class WaimaiyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WaimaiyuanEntity() {
		
	}
	
	public WaimaiyuanEntity(T t) {
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
    @TableId
	private Long id;
	/**
	 * 外卖账号
	 */
					
	private String waimaizhanghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 外卖姓名
	 */
					
	private String waimaixingming;
	
	/**
	 * 年龄
	 */
					
	private Integer nianling;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 配送平台
	 */
					
	private String peisongpingtai;
	
	/**
	 * 信誉情况
	 */
					
	private Integer xinyuqingkuang;
	
	
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
	 * 设置：外卖账号
	 */
	public void setWaimaizhanghao(String waimaizhanghao) {
		this.waimaizhanghao = waimaizhanghao;
	}
	/**
	 * 获取：外卖账号
	 */
	public String getWaimaizhanghao() {
		return waimaizhanghao;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：外卖姓名
	 */
	public void setWaimaixingming(String waimaixingming) {
		this.waimaixingming = waimaixingming;
	}
	/**
	 * 获取：外卖姓名
	 */
	public String getWaimaixingming() {
		return waimaixingming;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：配送平台
	 */
	public void setPeisongpingtai(String peisongpingtai) {
		this.peisongpingtai = peisongpingtai;
	}
	/**
	 * 获取：配送平台
	 */
	public String getPeisongpingtai() {
		return peisongpingtai;
	}
	/**
	 * 设置：信誉情况
	 */
	public void setXinyuqingkuang(Integer xinyuqingkuang) {
		this.xinyuqingkuang = xinyuqingkuang;
	}
	/**
	 * 获取：信誉情况
	 */
	public Integer getXinyuqingkuang() {
		return xinyuqingkuang;
	}

}
