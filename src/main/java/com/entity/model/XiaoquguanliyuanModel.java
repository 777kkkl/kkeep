package com.entity.model;

import com.entity.XiaoquguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 小区管理员
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public class XiaoquguanliyuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 管理姓名
	 */
	
	private String guanlixingming;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 小区名称
	 */
	
	private String xiaoqumingcheng;
		
	/**
	 * 小区地址
	 */
	
	private String xiaoqudizhi;
				
	
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
			
}
