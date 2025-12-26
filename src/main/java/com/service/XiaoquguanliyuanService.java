package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoquguanliyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoquguanliyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoquguanliyuanView;


/**
 * 小区管理员
 *
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface XiaoquguanliyuanService extends IService<XiaoquguanliyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoquguanliyuanVO> selectListVO(Wrapper<XiaoquguanliyuanEntity> wrapper);
   	
   	XiaoquguanliyuanVO selectVO(@Param("ew") Wrapper<XiaoquguanliyuanEntity> wrapper);
   	
   	List<XiaoquguanliyuanView> selectListView(Wrapper<XiaoquguanliyuanEntity> wrapper);
   	
   	XiaoquguanliyuanView selectView(@Param("ew") Wrapper<XiaoquguanliyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoquguanliyuanEntity> wrapper);

   	

}

