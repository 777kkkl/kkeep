package com.entity.model;

import com.entity.BaojingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 报警信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public class BaojingxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
