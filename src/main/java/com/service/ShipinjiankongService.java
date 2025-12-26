package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShipinjiankongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShipinjiankongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShipinjiankongView;


/**
 * 视频监控
 *
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface ShipinjiankongService extends IService<ShipinjiankongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinjiankongVO> selectListVO(Wrapper<ShipinjiankongEntity> wrapper);
   	
   	ShipinjiankongVO selectVO(@Param("ew") Wrapper<ShipinjiankongEntity> wrapper);
   	
   	List<ShipinjiankongView> selectListView(Wrapper<ShipinjiankongEntity> wrapper);
   	
   	ShipinjiankongView selectView(@Param("ew") Wrapper<ShipinjiankongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinjiankongEntity> wrapper);

   	

}

