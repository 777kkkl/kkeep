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

import com.entity.BaojingxinxiEntity;
import com.entity.view.BaojingxinxiView;

import com.service.BaojingxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 报警信息
 * 后端接口
 * @author
 * @email
 * @date 2024-12-11 20:50:53
 */
@RestController
@RequestMapping("/baojingxinxi")
public class BaojingxinxiController {
    @Autowired
    private BaojingxinxiService baojingxinxiService;








    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaojingxinxiEntity baojingxinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baojingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baojingshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xiaoquguanliyuan")) {
			baojingxinxi.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaojingxinxiEntity> ew = new EntityWrapper<BaojingxinxiEntity>();
                if(baojingshijianstart!=null) ew.ge("baojingshijian", baojingshijianstart);
                if(baojingshijianend!=null) ew.le("baojingshijian", baojingshijianend);



		PageUtils page = baojingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baojingxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaojingxinxiEntity baojingxinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baojingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baojingshijianend,
		HttpServletRequest request){
        EntityWrapper<BaojingxinxiEntity> ew = new EntityWrapper<BaojingxinxiEntity>();
                if(baojingshijianstart!=null) ew.ge("baojingshijian", baojingshijianstart);
                if(baojingshijianend!=null) ew.le("baojingshijian", baojingshijianend);

		PageUtils page = baojingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baojingxinxi), params), params));

				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaojingxinxiEntity baojingxinxi){
       	EntityWrapper<BaojingxinxiEntity> ew = new EntityWrapper<BaojingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baojingxinxi, "baojingxinxi"));
        return R.ok().put("data", baojingxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaojingxinxiEntity baojingxinxi){
        EntityWrapper< BaojingxinxiEntity> ew = new EntityWrapper< BaojingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baojingxinxi, "baojingxinxi"));
		BaojingxinxiView baojingxinxiView =  baojingxinxiService.selectView(ew);
		return R.ok("查询报警信息成功").put("data", baojingxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaojingxinxiEntity baojingxinxi = baojingxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(baojingxinxi,deSens);
        return R.ok().put("data", baojingxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaojingxinxiEntity baojingxinxi = baojingxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(baojingxinxi,deSens);
        return R.ok().put("data", baojingxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增报警信息")
    public R save(@RequestBody BaojingxinxiEntity baojingxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(baojingxinxi);
        baojingxinxiService.insert(baojingxinxi);
        return R.ok();
    }

    /**
     * 前台保存
     */
    @SysLog("新增报警信息")
    @RequestMapping("/add")
    public R add(@RequestBody BaojingxinxiEntity baojingxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(baojingxinxi);
        baojingxinxiService.insert(baojingxinxi);
        return R.ok().put("data",baojingxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改报警信息")
    public R update(@RequestBody BaojingxinxiEntity baojingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baojingxinxi);
        //全部更新
        baojingxinxiService.updateById(baojingxinxi);

        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除报警信息")
    public R delete(@RequestBody Long[] ids){
        baojingxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,BaojingxinxiEntity baojingxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xiaoquguanliyuan")) {
            baojingxinxi.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<BaojingxinxiEntity> ew = new EntityWrapper<BaojingxinxiEntity>();
        int count = baojingxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baojingxinxi), params), params));
        return R.ok().put("data", count);
    }

}
