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


import com.dao.ShipinjiankongDao;
import com.entity.ShipinjiankongEntity;
import com.service.ShipinjiankongService;
import com.entity.vo.ShipinjiankongVO;
import com.entity.view.ShipinjiankongView;

@Service("shipinjiankongService")
public class ShipinjiankongServiceImpl extends ServiceImpl<ShipinjiankongDao, ShipinjiankongEntity> implements ShipinjiankongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShipinjiankongEntity> page = this.selectPage(
                new Query<ShipinjiankongEntity>(params).getPage(),
                new EntityWrapper<ShipinjiankongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShipinjiankongEntity> wrapper) {
		  Page<ShipinjiankongView> page =new Query<ShipinjiankongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShipinjiankongVO> selectListVO(Wrapper<ShipinjiankongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShipinjiankongVO selectVO(Wrapper<ShipinjiankongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShipinjiankongView> selectListView(Wrapper<ShipinjiankongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShipinjiankongView selectView(Wrapper<ShipinjiankongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
