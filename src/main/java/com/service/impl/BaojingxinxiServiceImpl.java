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


import com.dao.BaojingxinxiDao;
import com.entity.BaojingxinxiEntity;
import com.service.BaojingxinxiService;
import com.entity.vo.BaojingxinxiVO;
import com.entity.view.BaojingxinxiView;

@Service("baojingxinxiService")
public class BaojingxinxiServiceImpl extends ServiceImpl<BaojingxinxiDao, BaojingxinxiEntity> implements BaojingxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaojingxinxiEntity> page = this.selectPage(
                new Query<BaojingxinxiEntity>(params).getPage(),
                new EntityWrapper<BaojingxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaojingxinxiEntity> wrapper) {
		  Page<BaojingxinxiView> page =new Query<BaojingxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<BaojingxinxiVO> selectListVO(Wrapper<BaojingxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaojingxinxiVO selectVO(Wrapper<BaojingxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaojingxinxiView> selectListView(Wrapper<BaojingxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaojingxinxiView selectView(Wrapper<BaojingxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
