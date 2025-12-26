package com.dao;

import com.entity.XiaoqumenjinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoqumenjinVO;
import com.entity.view.XiaoqumenjinView;


/**
 * 小区门禁
 * 
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface XiaoqumenjinDao extends BaseMapper<XiaoqumenjinEntity> {
	
	List<XiaoqumenjinVO> selectListVO(@Param("ew") Wrapper<XiaoqumenjinEntity> wrapper);
	
	XiaoqumenjinVO selectVO(@Param("ew") Wrapper<XiaoqumenjinEntity> wrapper);
	
	List<XiaoqumenjinView> selectListView(@Param("ew") Wrapper<XiaoqumenjinEntity> wrapper);

	List<XiaoqumenjinView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoqumenjinEntity> wrapper);

	
	XiaoqumenjinView selectView(@Param("ew") Wrapper<XiaoqumenjinEntity> wrapper);
	

}
