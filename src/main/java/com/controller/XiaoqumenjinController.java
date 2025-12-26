package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.XiaoqumenjinEntity;
import com.entity.view.XiaoqumenjinView;

import com.service.XiaoqumenjinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 小区门禁
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@RestController
@RequestMapping("/xiaoqumenjin")
public class XiaoqumenjinController {
    @Autowired
    private XiaoqumenjinService xiaoqumenjinService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoqumenjinEntity xiaoqumenjin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xiaoquguanliyuan")) {
			xiaoqumenjin.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaoqumenjinEntity> ew = new EntityWrapper<XiaoqumenjinEntity>();



		PageUtils page = xiaoqumenjinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoqumenjin), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoqumenjinEntity xiaoqumenjin, 
		HttpServletRequest request){
        EntityWrapper<XiaoqumenjinEntity> ew = new EntityWrapper<XiaoqumenjinEntity>();

		PageUtils page = xiaoqumenjinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoqumenjin), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoqumenjinEntity xiaoqumenjin){
       	EntityWrapper<XiaoqumenjinEntity> ew = new EntityWrapper<XiaoqumenjinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoqumenjin, "xiaoqumenjin")); 
        return R.ok().put("data", xiaoqumenjinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoqumenjinEntity xiaoqumenjin){
        EntityWrapper< XiaoqumenjinEntity> ew = new EntityWrapper< XiaoqumenjinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoqumenjin, "xiaoqumenjin")); 
		XiaoqumenjinView xiaoqumenjinView =  xiaoqumenjinService.selectView(ew);
		return R.ok("查询小区门禁成功").put("data", xiaoqumenjinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoqumenjinEntity xiaoqumenjin = xiaoqumenjinService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xiaoqumenjin,deSens);
        return R.ok().put("data", xiaoqumenjin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoqumenjinEntity xiaoqumenjin = xiaoqumenjinService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xiaoqumenjin,deSens);
        return R.ok().put("data", xiaoqumenjin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增小区门禁") 
    public R save(@RequestBody XiaoqumenjinEntity xiaoqumenjin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoqumenjin);
        xiaoqumenjinService.insert(xiaoqumenjin);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增小区门禁")
    @RequestMapping("/add")
    public R add(@RequestBody XiaoqumenjinEntity xiaoqumenjin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiaoqumenjin);
        xiaoqumenjinService.insert(xiaoqumenjin);
        return R.ok().put("data",xiaoqumenjin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改小区门禁")
    public R update(@RequestBody XiaoqumenjinEntity xiaoqumenjin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoqumenjin);
        //全部更新
        xiaoqumenjinService.updateById(xiaoqumenjin);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除小区门禁")
    public R delete(@RequestBody Long[] ids){
        xiaoqumenjinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
