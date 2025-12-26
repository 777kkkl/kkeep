package com.entity.view;

import com.entity.XiaoquguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 小区管理员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@TableName("xiaoquguanliyuan")
public class XiaoquguanliyuanView  extends XiaoquguanliyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoquguanliyuanView(){
	}
 
 	public XiaoquguanliyuanView(XiaoquguanliyuanEntity xiaoquguanliyuanEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoquguanliyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
