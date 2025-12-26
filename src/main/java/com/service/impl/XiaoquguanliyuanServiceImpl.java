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


import com.dao.XiaoquguanliyuanDao;
import com.entity.XiaoquguanliyuanEntity;
import com.service.XiaoquguanliyuanService;
import com.entity.vo.XiaoquguanliyuanVO;
import com.entity.view.XiaoquguanliyuanView;

@Service("xiaoquguanliyuanService")
public class XiaoquguanliyuanServiceImpl extends ServiceImpl<XiaoquguanliyuanDao, XiaoquguanliyuanEntity> implements XiaoquguanliyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoquguanliyuanEntity> page = this.selectPage(
                new Query<XiaoquguanliyuanEntity>(params).getPage(),
                new EntityWrapper<XiaoquguanliyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoquguanliyuanEntity> wrapper) {
		  Page<XiaoquguanliyuanView> page =new Query<XiaoquguanliyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XiaoquguanliyuanVO> selectListVO(Wrapper<XiaoquguanliyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoquguanliyuanVO selectVO(Wrapper<XiaoquguanliyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoquguanliyuanView> selectListView(Wrapper<XiaoquguanliyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoquguanliyuanView selectView(Wrapper<XiaoquguanliyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
