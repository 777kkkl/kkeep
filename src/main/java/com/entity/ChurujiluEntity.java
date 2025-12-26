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
 * 出入记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@TableName("churujilu")
public class ChurujiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChurujiluEntity() {
		
	}
	
	public ChurujiluEntity(T t) {
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
	 * 进入时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jinrushijian;
	
	/**
	 * 离开时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date likaishijian;
	
	/**
	 * 出入状态
	 */
					
	private String churuzhuangtai;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	
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
	 * 设置：进入时间
	 */
	public void setJinrushijian(Date jinrushijian) {
		this.jinrushijian = jinrushijian;
	}
	/**
	 * 获取：进入时间
	 */
	public Date getJinrushijian() {
		return jinrushijian;
	}
	/**
	 * 设置：离开时间
	 */
	public void setLikaishijian(Date likaishijian) {
		this.likaishijian = likaishijian;
	}
	/**
	 * 获取：离开时间
	 */
	public Date getLikaishijian() {
		return likaishijian;
	}
	/**
	 * 设置：出入状态
	 */
	public void setChuruzhuangtai(String churuzhuangtai) {
		this.churuzhuangtai = churuzhuangtai;
	}
	/**
	 * 获取：出入状态
	 */
	public String getChuruzhuangtai() {
		return churuzhuangtai;
	}
	/**
	 * 设置：登记日期
	 */
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}

}
