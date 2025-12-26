package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XiaoqumenjinDao;
import com.entity.XiaoqumenjinEntity;
import com.service.XiaoqumenjinService;
import com.entity.vo.XiaoqumenjinVO;
import com.entity.view.XiaoqumenjinView;

@Service("xiaoqumenjinService")
public class XiaoqumenjinServiceImpl extends ServiceImpl<XiaoqumenjinDao, XiaoqumenjinEntity> implements XiaoqumenjinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoqumenjinEntity> page = this.selectPage(
                new Query<XiaoqumenjinEntity>(params).getPage(),
                new EntityWrapper<XiaoqumenjinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoqumenjinEntity> wrapper) {
		  Page<XiaoqumenjinView> page =new Query<XiaoqumenjinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XiaoqumenjinVO> selectListVO(Wrapper<XiaoqumenjinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoqumenjinVO selectVO(Wrapper<XiaoqumenjinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoqumenjinView> selectListView(Wrapper<XiaoqumenjinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoqumenjinView selectView(Wrapper<XiaoqumenjinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
