package com.entity.view;

import com.entity.XiaoqumenjinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 小区门禁
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@TableName("xiaoqumenjin")
public class XiaoqumenjinView  extends XiaoqumenjinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoqumenjinView(){
	}
 
 	public XiaoqumenjinView(XiaoqumenjinEntity xiaoqumenjinEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoqumenjinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
