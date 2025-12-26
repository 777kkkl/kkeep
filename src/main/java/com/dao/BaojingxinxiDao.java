package com.dao;

import com.entity.BaojingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BaojingxinxiVO;
import com.entity.view.BaojingxinxiView;


/**
 * 报警信息
 * 
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface BaojingxinxiDao extends BaseMapper<BaojingxinxiEntity> {
	
	List<BaojingxinxiVO> selectListVO(@Param("ew") Wrapper<BaojingxinxiEntity> wrapper);
	
	BaojingxinxiVO selectVO(@Param("ew") Wrapper<BaojingxinxiEntity> wrapper);
	
	List<BaojingxinxiView> selectListView(@Param("ew") Wrapper<BaojingxinxiEntity> wrapper);

	List<BaojingxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BaojingxinxiEntity> wrapper);

	
	BaojingxinxiView selectView(@Param("ew") Wrapper<BaojingxinxiEntity> wrapper);
	

}
