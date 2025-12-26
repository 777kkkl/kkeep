<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="rgsForm" class="rgs-form animate__animated animate__fadeInUp" :model="rgsForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">水径小区外卖管理系统</div>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('waimaizhanghao')?'required':''">外卖账号：</div>
						<el-input  v-model="ruleForm.waimaizhanghao"  autocomplete="off" placeholder="外卖账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('waimaixingming')?'required':''">外卖姓名：</div>
						<el-input  v-model="ruleForm.waimaixingming"  autocomplete="off" placeholder="外卖姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in waimaiyuanxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="waimaiyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('peisongpingtai')?'required':''">配送平台：</div>
						<el-input  v-model="ruleForm.peisongpingtai"  autocomplete="off" placeholder="配送平台"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='waimaiyuan'">
						<div class="lable" :class="changeRules('xinyuqingkuang')?'required':''">信誉情况：</div>
						<el-input  v-model.number="ruleForm.xinyuqingkuang" readonly autocomplete="off" placeholder="信誉情况"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('guanlizhanghao')?'required':''">管理账号：</div>
						<el-input  v-model="ruleForm.guanlizhanghao"  autocomplete="off" placeholder="管理账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('guanlixingming')?'required':''">管理姓名：</div>
						<el-input  v-model="ruleForm.guanlixingming"  autocomplete="off" placeholder="管理姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="xiaoquguanliyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('xiaoqumingcheng')?'required':''">小区名称：</div>
						<el-input  v-model="ruleForm.xiaoqumingcheng"  autocomplete="off" placeholder="小区名称"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xiaoquguanliyuan'">
						<div class="lable" :class="changeRules('xiaoqudizhi')?'required':''">小区地址：</div>
						<el-input  v-model="ruleForm.xiaoqudizhi"  autocomplete="off" placeholder="小区地址"  type="text"  />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            waimaiyuanxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){

			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='waimaiyuan'){
				this.ruleForm = {
					waimaizhanghao: '',
					mima: '',
					waimaixingming: '',
					nianling: '',
					xingbie: '',
					lianxidianhua: '',
					touxiang: '',
					peisongpingtai: '',
					xinyuqingkuang: '100',
				}
			}
			if(this.tableName=='xiaoquguanliyuan'){
				this.ruleForm = {
					guanlizhanghao: '',
					mima: '',
					guanlixingming: '',
					touxiang: '',
					lianxidianhua: '',
					xiaoqumingcheng: '',
					xiaoqudizhi: '',
				}
			}
			if ('waimaiyuan' == this.tableName) {
				this.rules.waimaizhanghao = [{ required: true, message: '请输入外卖账号', trigger: 'blur' }]
			}
			if ('waimaiyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('waimaiyuan' == this.tableName) {
				this.rules.waimaixingming = [{ required: true, message: '请输入外卖姓名', trigger: 'blur' }]
			}
			if ('waimaiyuan' == this.tableName) {
				this.rules.lianxidianhua = [{ required: true, message: '请输入联系电话', trigger: 'blur' }]
			}
			if ('waimaiyuan' == this.tableName) {
				this.rules.touxiang = [{ required: true, message: '请输入头像', trigger: 'blur' }]
			}
			if ('waimaiyuan' == this.tableName) {
				this.rules.peisongpingtai = [{ required: true, message: '请输入配送平台', trigger: 'blur' }]
			}
			if ('xiaoquguanliyuan' == this.tableName) {
				this.rules.guanlizhanghao = [{ required: true, message: '请输入管理账号', trigger: 'blur' }]
			}
			if ('xiaoquguanliyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('xiaoquguanliyuan' == this.tableName) {
				this.rules.xiaoqumingcheng = [{ required: true, message: '请输入小区名称', trigger: 'blur' }]
			}
			if ('xiaoquguanliyuan' == this.tableName) {
				this.rules.xiaoqudizhi = [{ required: true, message: '请输入小区地址', trigger: 'blur' }]
			}
			this.waimaiyuanxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        waimaiyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        xiaoquguanliyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.waimaizhanghao) && `waimaiyuan` == this.tableName){
				this.$message.error(`外卖账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `waimaiyuan` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `waimaiyuan` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.waimaixingming) && `waimaiyuan` == this.tableName){
				this.$message.error(`外卖姓名不能为空`);
				return
			}
			if(`waimaiyuan` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if((!this.ruleForm.lianxidianhua) && `waimaiyuan` == this.tableName){
				this.$message.error(`联系电话不能为空`);
				return
			}
			if(`waimaiyuan` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.touxiang) && `waimaiyuan` == this.tableName){
				this.$message.error(`头像不能为空`);
				return
			}
			if((!this.ruleForm.peisongpingtai) && `waimaiyuan` == this.tableName){
				this.$message.error(`配送平台不能为空`);
				return
			}
			if(`waimaiyuan` == this.tableName && this.ruleForm.xinyuqingkuang &&(!this.$validate.isIntNumer(this.ruleForm.xinyuqingkuang))){
				this.$message.error(`信誉情况应输入整数`);
				return
			}
			if((!this.ruleForm.guanlizhanghao) && `xiaoquguanliyuan` == this.tableName){
				this.$message.error(`管理账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `xiaoquguanliyuan` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `xiaoquguanliyuan` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`xiaoquguanliyuan` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
			if((!this.ruleForm.xiaoqumingcheng) && `xiaoquguanliyuan` == this.tableName){
				this.$message.error(`小区名称不能为空`);
				return
			}
			if((!this.ruleForm.xiaoqudizhi) && `xiaoquguanliyuan` == this.tableName){
				this.$message.error(`小区地址不能为空`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(https://www.51ldb.com/picture/b6bb72f1-48d2-47dc-832a-997ebc8b5b44.jpeg);
	background-repeat: no-repeat;
	overflow: hidden;
	background-size: cover;
	background: url(https://www.51ldb.com/picture/b6bb72f1-48d2-47dc-832a-997ebc8b5b44.jpeg);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center center;
	.rgs-form {
		.rgs-form2 {
		display: flex;
		width: 100%;
		justify-content: space-between;
		flex-wrap: wrap;
		}
		padding: 20px 60px 20px;
		margin: 20px auto;
		z-index: 1000;
		display: flex;
		flex-wrap: wrap;
		border-radius: 0;
		box-shadow: inset 0px 0px 0px 0px #000;
		flex-direction: column;
		background: rgba(255,255,255,.9);
		width: 600px;
		align-items: flex-start;
		position: relative;
		height: auto;
		.title {
			padding: 0 0;
			margin: 0 0 20px 0;
			color: #000;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 22px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0 0 0 0px;
			margin: 0 0 5px;
			width: 100%;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
			}
			.lable {
				padding: 0;
				color: #A40000;
				font-weight: bold;
				width: 100%;
				font-size: 15px;
				line-height: 30px;
				text-align: left;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 2px solid #D8D8D8;
				border-radius: 5px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 2px solid #A40000;
				border-radius: 5px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 2px solid #D8D8D8;
				border-radius: 5px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 2px solid #A40000;
				border-radius: 5px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 2px solid #D8D8D8;
				border-radius: 5px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 2px solid #A40000;
				border-radius: 5px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 2px solid #D8D8D8;
				cursor: pointer;
				border-radius: 5px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 2px solid #D8D8D8;
				cursor: pointer;
				border-radius: 5px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 2px solid #D8D8D8;
				cursor: pointer;
				border-radius: 5px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #666;
				display: none;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 14px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 0;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 2px solid #D8D8D8;
				border-radius: 5px 0 0 5px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				border-width: 2px 0 2px 2px;
				height: 34px;
			}
			input:focus {
				border: 2px solid #A40000;
				border-radius: 5px 0 0 5px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				border-width: 2px 0 2px 2px;
				height: 34px;
			}
			input::placeholder {
				color: #999;
				font-size: 14px;
			}
			button {
				border: 2px solid #A4000020;
				cursor: pointer;
				border-radius: 0 4px 4px 0;
				padding: 0;
				margin: 3px 0 0;
				color: #333;
				background: #A4000020;
				width: 150px;
				font-size: 15px;
				border-width: 2px 2px 2px 0;
				height: 34px;
			}
			button:hover {
				opacity: 0.8;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			margin: 20px auto 5px;
			color: #fff;
			background: #A40000;
			display: block;
			width: 100%;
			font-size: 24px;
			height: 50px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			border: 0px solid #C1C1C1;
			padding: 0 0px;
			color: #000;
			font-weight: 500;
			display: inline-block;
			text-decoration: underlinenone;
			font-size: 15px;
			line-height: 40px;
			border-radius: 40px;
			background: #fff;
			width: 100%;
			text-align: center;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
}

	::-webkit-scrollbar {
	  display: none;
	}
</style>
