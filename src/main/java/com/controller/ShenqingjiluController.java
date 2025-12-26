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

import com.entity.ShenqingjiluEntity;
import com.entity.view.ShenqingjiluView;

import com.service.ShenqingjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 申请记录
 * 后端接口
 * @author
 * @email
 * @date 2024-12-11 20:50:53
 */
@RestController
@RequestMapping("/shenqingjilu")
public class ShenqingjiluController {
    @Autowired
    private ShenqingjiluService shenqingjiluService;








    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingjiluEntity shenqingjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xiaoquguanliyuan")) {
			shenqingjilu.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("waimaiyuan")) {
			shenqingjilu.setWaimaizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingjiluEntity> ew = new EntityWrapper<ShenqingjiluEntity>();
		PageUtils page = shenqingjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingjilu), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingjiluEntity shenqingjilu,
		HttpServletRequest request){
        EntityWrapper<ShenqingjiluEntity> ew = new EntityWrapper<ShenqingjiluEntity>();

		PageUtils page = shenqingjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingjilu), params), params));

				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingjiluEntity shenqingjilu){
       	EntityWrapper<ShenqingjiluEntity> ew = new EntityWrapper<ShenqingjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingjilu, "shenqingjilu"));
        return R.ok().put("data", shenqingjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingjiluEntity shenqingjilu){
        EntityWrapper< ShenqingjiluEntity> ew = new EntityWrapper< ShenqingjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingjilu, "shenqingjilu"));
		ShenqingjiluView shenqingjiluView =  shenqingjiluService.selectView(ew);
		return R.ok("查询申请记录成功").put("data", shenqingjiluView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingjiluEntity shenqingjilu = shenqingjiluService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shenqingjilu,deSens);
        return R.ok().put("data", shenqingjilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingjiluEntity shenqingjilu = shenqingjiluService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shenqingjilu,deSens);
        return R.ok().put("data", shenqingjilu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增申请记录")
    public R save(@RequestBody ShenqingjiluEntity shenqingjilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingjilu);
        shenqingjiluService.insert(shenqingjilu);
        return R.ok();
    }

    /**
     * 前台保存
     */
    @SysLog("新增申请记录")
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingjiluEntity shenqingjilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingjilu);
        shenqingjiluService.insert(shenqingjilu);
        return R.ok().put("data",shenqingjilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改申请记录")
    public R update(@RequestBody ShenqingjiluEntity shenqingjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingjilu);
        //全部更新
        shenqingjiluService.updateById(shenqingjilu);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核申请记录")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShenqingjiluEntity> list = new ArrayList<ShenqingjiluEntity>();
        for(Long id : ids) {
            ShenqingjiluEntity shenqingjilu = shenqingjiluService.selectById(id);
            shenqingjilu.setSfsh(sfsh);
            shenqingjilu.setShhf(shhf);
            list.add(shenqingjilu);
        }
        shenqingjiluService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除申请记录")
    public R delete(@RequestBody Long[] ids){
        shenqingjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ShenqingjiluEntity shenqingjilu, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xiaoquguanliyuan")) {
            shenqingjilu.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("waimaiyuan")) {
            shenqingjilu.setWaimaizhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ShenqingjiluEntity> ew = new EntityWrapper<ShenqingjiluEntity>();
        int count = shenqingjiluService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingjilu), params), params));
        return R.ok().put("data", count);
    }



}
