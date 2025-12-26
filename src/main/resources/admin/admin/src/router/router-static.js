import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import xiaoquguanliyuan from '@/views/modules/xiaoquguanliyuan/list'
	import waimaiyuan from '@/views/modules/waimaiyuan/list'
	import shipinjiankong from '@/views/modules/shipinjiankong/list'
	import baojingxinxi from '@/views/modules/baojingxinxi/list'
	import shenqingjilu from '@/views/modules/shenqingjilu/list'
	import syslog from '@/views/modules/syslog/list'
	import churujilu from '@/views/modules/churujilu/list'
	import xiaoqumenjin from '@/views/modules/xiaoqumenjin/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/xiaoquguanliyuan',
		name: '小区管理员',
		component: xiaoquguanliyuan
	}
	,{
		path: '/waimaiyuan',
		name: '外卖员',
		component: waimaiyuan
	}
	,{
		path: '/shipinjiankong',
		name: '视频监控',
		component: shipinjiankong
	}
	,{
		path: '/baojingxinxi',
		name: '报警信息',
		component: baojingxinxi
	}
	,{
		path: '/shenqingjilu',
		name: '申请记录',
		component: shenqingjilu
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/churujilu',
		name: '出入记录',
		component: churujilu
	}
	,{
		path: '/xiaoqumenjin',
		name: '小区门禁',
		component: xiaoqumenjin
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
