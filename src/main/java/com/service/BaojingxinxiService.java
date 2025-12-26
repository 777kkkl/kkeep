package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaojingxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaojingxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaojingxinxiView;


/**
 * 报警信息
 *
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface BaojingxinxiService extends IService<BaojingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaojingxinxiVO> selectListVO(Wrapper<BaojingxinxiEntity> wrapper);
   	
   	BaojingxinxiVO selectVO(@Param("ew") Wrapper<BaojingxinxiEntity> wrapper);
   	
   	List<BaojingxinxiView> selectListView(Wrapper<BaojingxinxiEntity> wrapper);
   	
   	BaojingxinxiView selectView(@Param("ew") Wrapper<BaojingxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaojingxinxiEntity> wrapper);

   	

}

