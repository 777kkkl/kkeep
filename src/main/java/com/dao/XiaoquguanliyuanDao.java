package com.dao;

import com.entity.XiaoquguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoquguanliyuanVO;
import com.entity.view.XiaoquguanliyuanView;


/**
 * 小区管理员
 * 
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface XiaoquguanliyuanDao extends BaseMapper<XiaoquguanliyuanEntity> {
	
	List<XiaoquguanliyuanVO> selectListVO(@Param("ew") Wrapper<XiaoquguanliyuanEntity> wrapper);
	
	XiaoquguanliyuanVO selectVO(@Param("ew") Wrapper<XiaoquguanliyuanEntity> wrapper);
	
	List<XiaoquguanliyuanView> selectListView(@Param("ew") Wrapper<XiaoquguanliyuanEntity> wrapper);

	List<XiaoquguanliyuanView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoquguanliyuanEntity> wrapper);

	
	XiaoquguanliyuanView selectView(@Param("ew") Wrapper<XiaoquguanliyuanEntity> wrapper);
	

}
