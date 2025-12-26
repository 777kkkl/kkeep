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

import com.entity.ShipinjiankongEntity;
import com.entity.view.ShipinjiankongView;

import com.service.ShipinjiankongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 视频监控
 * 后端接口
 * @author
 * @email
 * @date 2024-12-11 20:50:53
 */
@RestController
@RequestMapping("/shipinjiankong")
public class ShipinjiankongController {
    @Autowired
    private ShipinjiankongService shipinjiankongService;








    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinjiankongEntity shipinjiankong,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shangchuanshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shangchuanshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xiaoquguanliyuan")) {
			shipinjiankong.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShipinjiankongEntity> ew = new EntityWrapper<ShipinjiankongEntity>();
                if(shangchuanshijianstart!=null) ew.ge("shangchuanshijian", shangchuanshijianstart);
                if(shangchuanshijianend!=null) ew.le("shangchuanshijian", shangchuanshijianend);
		PageUtils page = shipinjiankongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinjiankong), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinjiankongEntity shipinjiankong,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shangchuanshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shangchuanshijianend,
		HttpServletRequest request){
        EntityWrapper<ShipinjiankongEntity> ew = new EntityWrapper<ShipinjiankongEntity>();
                if(shangchuanshijianstart!=null) ew.ge("shangchuanshijian", shangchuanshijianstart);
                if(shangchuanshijianend!=null) ew.le("shangchuanshijian", shangchuanshijianend);

		PageUtils page = shipinjiankongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinjiankong), params), params));

				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinjiankongEntity shipinjiankong){
       	EntityWrapper<ShipinjiankongEntity> ew = new EntityWrapper<ShipinjiankongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinjiankong, "shipinjiankong"));
        return R.ok().put("data", shipinjiankongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinjiankongEntity shipinjiankong){
        EntityWrapper< ShipinjiankongEntity> ew = new EntityWrapper< ShipinjiankongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinjiankong, "shipinjiankong"));
		ShipinjiankongView shipinjiankongView =  shipinjiankongService.selectView(ew);
		return R.ok("查询视频监控成功").put("data", shipinjiankongView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinjiankongEntity shipinjiankong = shipinjiankongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shipinjiankong,deSens);
        return R.ok().put("data", shipinjiankong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinjiankongEntity shipinjiankong = shipinjiankongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shipinjiankong,deSens);
        return R.ok().put("data", shipinjiankong);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增视频监控")
    public R save(@RequestBody ShipinjiankongEntity shipinjiankong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shipinjiankong);
        shipinjiankongService.insert(shipinjiankong);
        return R.ok();
    }

    /**
     * 前台保存
     */
    @SysLog("新增视频监控")
    @RequestMapping("/add")
    public R add(@RequestBody ShipinjiankongEntity shipinjiankong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shipinjiankong);
        shipinjiankongService.insert(shipinjiankong);
        return R.ok().put("data",shipinjiankong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改视频监控")
    public R update(@RequestBody ShipinjiankongEntity shipinjiankong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinjiankong);
        //全部更新
        shipinjiankongService.updateById(shipinjiankong);

        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除视频监控")
    public R delete(@RequestBody Long[] ids){
        shipinjiankongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ShipinjiankongEntity shipinjiankong, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xiaoquguanliyuan")) {
            shipinjiankong.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ShipinjiankongEntity> ew = new EntityWrapper<ShipinjiankongEntity>();
        int count = shipinjiankongService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinjiankong), params), params));
        return R.ok().put("data", count);
    }



}
