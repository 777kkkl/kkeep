package com.entity.view;

import com.entity.ShipinjiankongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 视频监控
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@TableName("shipinjiankong")
public class ShipinjiankongView  extends ShipinjiankongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShipinjiankongView(){
	}
 
 	public ShipinjiankongView(ShipinjiankongEntity shipinjiankongEntity){
 	try {
			BeanUtils.copyProperties(this, shipinjiankongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
