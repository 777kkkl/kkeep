package com.entity.model;

import com.entity.ShenqingjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 申请记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public class ShenqingjiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
