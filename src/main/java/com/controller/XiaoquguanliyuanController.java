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
import com.entity.TokenEntity;
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

import com.entity.XiaoquguanliyuanEntity;
import com.entity.view.XiaoquguanliyuanView;

import com.service.XiaoquguanliyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 小区管理员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-11 20:50:53
 */
@RestController
@RequestMapping("/xiaoquguanliyuan")
public class XiaoquguanliyuanController {
    @Autowired
    private XiaoquguanliyuanService xiaoquguanliyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		XiaoquguanliyuanEntity u = xiaoquguanliyuanService.selectOne(new EntityWrapper<XiaoquguanliyuanEntity>().eq("guanlizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"xiaoquguanliyuan",  "小区管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XiaoquguanliyuanEntity xiaoquguanliyuan){
    	//ValidatorUtils.validateEntity(xiaoquguanliyuan);
    	XiaoquguanliyuanEntity u = xiaoquguanliyuanService.selectOne(new EntityWrapper<XiaoquguanliyuanEntity>().eq("guanlizhanghao", xiaoquguanliyuan.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		xiaoquguanliyuan.setId(uId);
        xiaoquguanliyuanService.insert(xiaoquguanliyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        XiaoquguanliyuanEntity u = xiaoquguanliyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	XiaoquguanliyuanEntity u = xiaoquguanliyuanService.selectOne(new EntityWrapper<XiaoquguanliyuanEntity>().eq("guanlizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        xiaoquguanliyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoquguanliyuanEntity xiaoquguanliyuan,
		HttpServletRequest request){
        EntityWrapper<XiaoquguanliyuanEntity> ew = new EntityWrapper<XiaoquguanliyuanEntity>();



		PageUtils page = xiaoquguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoquguanliyuan), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoquguanliyuanEntity xiaoquguanliyuan, 
		HttpServletRequest request){
        EntityWrapper<XiaoquguanliyuanEntity> ew = new EntityWrapper<XiaoquguanliyuanEntity>();

		PageUtils page = xiaoquguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoquguanliyuan), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoquguanliyuanEntity xiaoquguanliyuan){
       	EntityWrapper<XiaoquguanliyuanEntity> ew = new EntityWrapper<XiaoquguanliyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoquguanliyuan, "xiaoquguanliyuan")); 
        return R.ok().put("data", xiaoquguanliyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoquguanliyuanEntity xiaoquguanliyuan){
        EntityWrapper< XiaoquguanliyuanEntity> ew = new EntityWrapper< XiaoquguanliyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoquguanliyuan, "xiaoquguanliyuan")); 
		XiaoquguanliyuanView xiaoquguanliyuanView =  xiaoquguanliyuanService.selectView(ew);
		return R.ok("查询小区管理员成功").put("data", xiaoquguanliyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoquguanliyuanEntity xiaoquguanliyuan = xiaoquguanliyuanService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xiaoquguanliyuan,deSens);
        return R.ok().put("data", xiaoquguanliyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoquguanliyuanEntity xiaoquguanliyuan = xiaoquguanliyuanService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xiaoquguanliyuan,deSens);
        return R.ok().put("data", xiaoquguanliyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增小区管理员") 
    public R save(@RequestBody XiaoquguanliyuanEntity xiaoquguanliyuan, HttpServletRequest request){
        if(xiaoquguanliyuanService.selectCount(new EntityWrapper<XiaoquguanliyuanEntity>().eq("guanlizhanghao", xiaoquguanliyuan.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
    	xiaoquguanliyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoquguanliyuan);
    	XiaoquguanliyuanEntity u = xiaoquguanliyuanService.selectOne(new EntityWrapper<XiaoquguanliyuanEntity>().eq("guanlizhanghao", xiaoquguanliyuan.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xiaoquguanliyuan.setId(new Date().getTime());
        xiaoquguanliyuanService.insert(xiaoquguanliyuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增小区管理员")
    @RequestMapping("/add")
    public R add(@RequestBody XiaoquguanliyuanEntity xiaoquguanliyuan, HttpServletRequest request){
        if(xiaoquguanliyuanService.selectCount(new EntityWrapper<XiaoquguanliyuanEntity>().eq("guanlizhanghao", xiaoquguanliyuan.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
    	xiaoquguanliyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoquguanliyuan);
    	XiaoquguanliyuanEntity u = xiaoquguanliyuanService.selectOne(new EntityWrapper<XiaoquguanliyuanEntity>().eq("guanlizhanghao", xiaoquguanliyuan.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xiaoquguanliyuan.setId(new Date().getTime());
        xiaoquguanliyuanService.insert(xiaoquguanliyuan);
        return R.ok().put("data",xiaoquguanliyuan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改小区管理员")
    public R update(@RequestBody XiaoquguanliyuanEntity xiaoquguanliyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoquguanliyuan);
        if(xiaoquguanliyuanService.selectCount(new EntityWrapper<XiaoquguanliyuanEntity>().ne("id", xiaoquguanliyuan.getId()).eq("guanlizhanghao", xiaoquguanliyuan.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
        //全部更新
        xiaoquguanliyuanService.updateById(xiaoquguanliyuan);
    if(null!=xiaoquguanliyuan.getGuanlizhanghao())
    {
        // 修改token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsername(xiaoquguanliyuan.getGuanlizhanghao());
        tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", xiaoquguanliyuan.getId()));
    }


        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除小区管理员")
    public R delete(@RequestBody Long[] ids){
        xiaoquguanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
