package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoqumenjinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoqumenjinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoqumenjinView;


/**
 * 小区门禁
 *
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
public interface XiaoqumenjinService extends IService<XiaoqumenjinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoqumenjinVO> selectListVO(Wrapper<XiaoqumenjinEntity> wrapper);
   	
   	XiaoqumenjinVO selectVO(@Param("ew") Wrapper<XiaoqumenjinEntity> wrapper);
   	
   	List<XiaoqumenjinView> selectListView(Wrapper<XiaoqumenjinEntity> wrapper);
   	
   	XiaoqumenjinView selectView(@Param("ew") Wrapper<XiaoqumenjinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoqumenjinEntity> wrapper);

   	

}

