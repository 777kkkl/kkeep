<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="管理账号" prop="guanlizhanghao" >
					<el-input v-model="ruleForm.guanlizhanghao" placeholder="管理账号" clearable  :readonly="ro.guanlizhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="管理账号" prop="guanlizhanghao" >
					<el-input v-model="ruleForm.guanlizhanghao" placeholder="管理账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="管理姓名" prop="guanlixingming" >
					<el-input v-model="ruleForm.guanlixingming" placeholder="管理姓名" clearable  :readonly="ro.guanlixingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="管理姓名" prop="guanlixingming" >
					<el-input v-model="ruleForm.guanlixingming" placeholder="管理姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="小区名称" prop="xiaoqumingcheng" >
					<el-input v-model="ruleForm.xiaoqumingcheng" placeholder="小区名称" clearable  :readonly="ro.xiaoqumingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="小区名称" prop="xiaoqumingcheng" >
					<el-input v-model="ruleForm.xiaoqumingcheng" placeholder="小区名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="外卖账号" prop="waimaizhanghao" >
					<el-input v-model="ruleForm.waimaizhanghao" placeholder="外卖账号" clearable  :readonly="ro.waimaizhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="外卖账号" prop="waimaizhanghao" >
					<el-input v-model="ruleForm.waimaizhanghao" placeholder="外卖账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="外卖姓名" prop="waimaixingming" >
					<el-input v-model="ruleForm.waimaixingming" placeholder="外卖姓名" clearable  :readonly="ro.waimaixingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="外卖姓名" prop="waimaixingming" >
					<el-input v-model="ruleForm.waimaixingming" placeholder="外卖姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="配送平台" prop="peisongpingtai" >
					<el-input v-model="ruleForm.peisongpingtai" placeholder="配送平台" clearable  :readonly="ro.peisongpingtai"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="配送平台" prop="peisongpingtai" >
					<el-input v-model="ruleForm.peisongpingtai" placeholder="配送平台" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="进入时间" prop="jinrushijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.jinrushijian" 
						type="datetime"
						:readonly="ro.jinrushijian"
						placeholder="进入时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.jinrushijian" label="进入时间" prop="jinrushijian" >
					<el-input v-model="ruleForm.jinrushijian" placeholder="进入时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="离开时间" prop="likaishijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.likaishijian" 
						type="datetime"
						:readonly="ro.likaishijian"
						placeholder="离开时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.likaishijian" label="离开时间" prop="likaishijian" >
					<el-input v-model="ruleForm.likaishijian" placeholder="离开时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="出入状态" prop="churuzhuangtai" >
					<el-select :disabled="ro.churuzhuangtai" v-model="ruleForm.churuzhuangtai" placeholder="请选择出入状态" >
						<el-option
							v-for="(item,index) in churuzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="出入状态" prop="churuzhuangtai" >
					<el-input v-model="ruleForm.churuzhuangtai"
						placeholder="出入状态" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="登记日期" prop="dengjiriqi" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.dengjiriqi" 
						type="date"
						:readonly="ro.dengjiriqi"
						placeholder="登记日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.dengjiriqi" label="登记日期" prop="dengjiriqi" >
					<el-input v-model="ruleForm.dengjiriqi" placeholder="登记日期" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isMobile,
	} from "@/utils/validate";
	export default {
		data() {
			var validateMobile = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isMobile(value)) {
					callback(new Error("请输入正确的手机号码"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					guanlizhanghao : false,
					guanlixingming : false,
					xiaoqumingcheng : false,
					waimaizhanghao : false,
					waimaixingming : false,
					lianxidianhua : false,
					peisongpingtai : false,
					jinrushijian : false,
					likaishijian : false,
					churuzhuangtai : false,
					dengjiriqi : false,
					crossuserid : false,
					crossrefid : false,
				},
			
				ruleForm: {
					guanlizhanghao: '',
					guanlixingming: '',
					xiaoqumingcheng: '',
					waimaizhanghao: '',
					waimaixingming: '',
					lianxidianhua: '',
					peisongpingtai: '',
					jinrushijian: '',
					likaishijian: '',
					churuzhuangtai: '进入',
					dengjiriqi: '',
					crossuserid: '',
					crossrefid: '',
				},
		
				churuzhuangtaiOptions: [],

				rules: {
					guanlizhanghao: [
					],
					guanlixingming: [
					],
					xiaoqumingcheng: [
					],
					waimaizhanghao: [
					],
					waimaixingming: [
					],
					lianxidianhua: [
						{ validator: validateMobile, trigger: 'blur' },
					],
					peisongpingtai: [
					],
					jinrushijian: [
						{ required: true, message: '进入时间不能为空', trigger: 'blur' },
					],
					likaishijian: [
					],
					churuzhuangtai: [
						{ required: true, message: '出入状态不能为空', trigger: 'blur' },
					],
					dengjiriqi: [
					],
					crossuserid: [
					],
					crossrefid: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.dengjiriqi = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'){
					this.info(id);
				}else if(this.type=='logistics'){
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='guanlizhanghao'){
							this.ruleForm.guanlizhanghao = obj[o];
							this.ro.guanlizhanghao = true;
							continue;
						}
						if(o=='guanlixingming'){
							this.ruleForm.guanlixingming = obj[o];
							this.ro.guanlixingming = true;
							continue;
						}
						if(o=='xiaoqumingcheng'){
							this.ruleForm.xiaoqumingcheng = obj[o];
							this.ro.xiaoqumingcheng = true;
							continue;
						}
						if(o=='waimaizhanghao'){
							this.ruleForm.waimaizhanghao = obj[o];
							this.ro.waimaizhanghao = true;
							continue;
						}
						if(o=='waimaixingming'){
							this.ruleForm.waimaixingming = obj[o];
							this.ro.waimaixingming = true;
							continue;
						}
						if(o=='lianxidianhua'){
							this.ruleForm.lianxidianhua = obj[o];
							this.ro.lianxidianhua = true;
							continue;
						}
						if(o=='peisongpingtai'){
							this.ruleForm.peisongpingtai = obj[o];
							this.ro.peisongpingtai = true;
							continue;
						}
						if(o=='jinrushijian'){
							this.ruleForm.jinrushijian = obj[o];
							this.ro.jinrushijian = true;
							continue;
						}
						if(o=='likaishijian'){
							this.ruleForm.likaishijian = obj[o];
							this.ro.likaishijian = true;
							continue;
						}
						if(o=='churuzhuangtai'){
							this.ruleForm.churuzhuangtai = obj[o];
							this.ro.churuzhuangtai = true;
							continue;
						}
						if(o=='dengjiriqi'){
							this.ruleForm.dengjiriqi = obj[o];
							this.ro.dengjiriqi = true;
							continue;
						}
						if(o=='crossuserid'){
							this.ruleForm.crossuserid = obj[o];
							this.ro.crossuserid = true;
							continue;
						}
						if(o=='crossrefid'){
							this.ruleForm.crossrefid = obj[o];
							this.ro.crossrefid = true;
							continue;
						}
					}
					this.ruleForm.churuzhuangtai = '进入'; 				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.churuzhuangtaiOptions = "进入,离开".split(',')
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `churujilu/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					var objcross = this.$storage.getObj('crossObj');
					//更新跨表属性
					var crossuserid;
					var crossrefid;
					var crossoptnum;
					var finishNum = 0;
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
									else {
										crossuserid=this.$storage.get('userid');
										crossrefid=obj['id'];
										crossoptnum=this.$storage.get('statusColumnName');
										crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
									}
								}
								if(crossrefid && crossuserid) {
									this.ruleForm.crossuserid = crossuserid;
									this.ruleForm.crossrefid = crossrefid;
									let params = { 
										page: 1, 
										limit: 10, 
										crossuserid:this.ruleForm.crossuserid,
										crossrefid:this.ruleForm.crossrefid,
									} 
									await this.$http({ 
										url: "churujilu/page", 
										method: "get", 
										params: params 
									}).then(({ 
										data 
									}) => { 
										if (data && data.code === 0) {
											finishNum = data.data.total
										}
									})
								}
								if(finishNum>=crossoptnum) {
									this.$message.error(this.$storage.get('tips'));
									return false;
								}
							}
							
							await this.$http({
								url: `churujilu/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.churujiluCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.churujiluCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 20px 10px 20px 40px;
	}
	.add-update-preview {
		padding: 20px 0;
		background: #fff;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 49%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #9E9E9E;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #000;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 44px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #333;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 44px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #000;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 44px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #333;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 44px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #000;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 44px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #333;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 44px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #000;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 44px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #333;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 44px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #fff;
		background: #A40000;
		width: auto;
		font-size: 15px;
		line-height: 44px;
		height: 44px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #fff;
		background: #A40000;
		width: auto;
		font-size: 15px;
		line-height: 44px;
		height: 44px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		outline: none;
		color: #333;
		background: #ccc;
		width: auto;
		font-size: 16px;
		line-height: 44px;
		height: 44px;
		.iconfont {
			margin: 0 2px;
			color: #333;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		display: none;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 12px;
		color: #000;
		background: #fff;
		width: 100%;
		font-size: 14px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 1px solid #E8E8E8;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #333;
				background: #ccc;
				width: 100%;
				font-size: 14px;
				height: 120px;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #A40000;
			width: auto;
			font-size: 16px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #FF5959;
			width: auto;
			font-size: 16px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #FFA100;
			width: auto;
			font-size: 16px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #8D8D8D;
			width: auto;
			font-size: 16px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #43B27F;
			width: auto;
			font-size: 16px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
