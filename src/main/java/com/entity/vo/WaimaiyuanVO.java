package com.entity.vo;

import com.entity.WaimaiyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 外卖员
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public class WaimaiyuanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
