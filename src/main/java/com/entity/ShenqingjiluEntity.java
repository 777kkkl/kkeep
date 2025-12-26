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
 * 申请记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@TableName("shenqingjilu")
public class ShenqingjiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShenqingjiluEntity() {
		
	}
	
	public ShenqingjiluEntity(T t) {
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
	 * 外卖账号
	 */
					
	private String waimaizhanghao;
	
	/**
	 * 外卖姓名
	 */
					
	private String waimaixingming;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 配送平台
	 */
					
	private String peisongpingtai;
	
	/**
	 * 信誉情况
	 */
					
	private Integer xinyuqingkuang;
	
	/**
	 * 配送截图
	 */
					
	private String peisongjietu;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
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
	/**
	 * 设置：配送截图
	 */
	public void setPeisongjietu(String peisongjietu) {
		this.peisongjietu = peisongjietu;
	}
	/**
	 * 获取：配送截图
	 */
	public String getPeisongjietu() {
		return peisongjietu;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
