package com.dao;

import com.entity.ShipinjiankongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShipinjiankongVO;
import com.entity.view.ShipinjiankongView;


/**
 * 视频监控
 * 
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface ShipinjiankongDao extends BaseMapper<ShipinjiankongEntity> {
	
	List<ShipinjiankongVO> selectListVO(@Param("ew") Wrapper<ShipinjiankongEntity> wrapper);
	
	ShipinjiankongVO selectVO(@Param("ew") Wrapper<ShipinjiankongEntity> wrapper);
	
	List<ShipinjiankongView> selectListView(@Param("ew") Wrapper<ShipinjiankongEntity> wrapper);

	List<ShipinjiankongView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinjiankongEntity> wrapper);

	
	ShipinjiankongView selectView(@Param("ew") Wrapper<ShipinjiankongEntity> wrapper);
	

}
