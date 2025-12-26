<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__fadeInUp">
				<div class="login_form2">
					<div class="title-container">水径小区外卖管理系统</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">

						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>


					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
							<el-button type="primary" @click="register('waimaiyuan')" class="register">
								注册外卖员							</el-button>
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}

				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
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

	.login_form {
		padding: 30px 60px 20px;
		margin: 0;
		z-index: 1000;
		display: flex;
		min-height: 48vh;
		flex-wrap: wrap;
		border-radius: 0;
		box-shadow: inset 0px 0px 0px 0px #000;
		flex-direction: column;
		background: rgba(255,255,255,.9);
		width: 600px;
		align-items: flex-start;
		position: relative;
		height: auto;
		.login_form2 {
			flex-direction: column;
			display: flex;
			width: 100%;
		}
		.title-container {
			padding: 0 0;
			margin: 0 0 20px 0;
			color: #000;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 22px;
			line-height: 30px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 10px;
			display: flex;
			width: 100%;
			align-items: center;
			flex-wrap: wrap;
			.lable {
				color: #A40000;
				font-weight: bold;
				width: 100%;
				font-size: 15px;
				line-height: 30px;
				text-align: left;
			}
			input {
				border: 2px solid #D8D8D8;
				border-radius: 5px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 44px;
			}
			input:focus {
				border: 2px solid #A40000;
				border-radius: 5px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 44px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 2px solid #D8D8D8;
					border-radius: 5px;
					padding: 0 10px;
					color: #666;
					width: 100%;
					font-size: 14px;
					height: 44px;
				}
				input:focus {
					border: 2px solid #A40000;
					border-radius: 5px;
					padding: 0 10px;
					color: #000;
					width: 100%;
					font-size: 14px;
					height: 44px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-type {
			padding: 0;
			margin: 0;
			background: none;
			width: 100%;
			line-height: 24px;
			height: auto;
			/deep/ .el-radio__input .el-radio__inner {
				background: rgba(53, 53, 53, 0);
				border-color: #666;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #0d6efd;
				border-color: #0d6efd;
			}
			/deep/ .el-radio__label {
				padding: 0 10px;
				color: #000;
				display: inline-block;
				font-size: 16px;
				border-color: transparent;
				border-width: 0px 0 0;
				line-height: 40px;
				border-style: solid;
				height: 40px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				padding: 0 10px;
				color: #A40000;
				display: inline-block;
				font-size: 16px;
				border-color: #A40000;
				border-width: 0px 0 0;
				line-height: 40px;
				border-style: solid;
				height: 40px;
			}
		}
		.login-btn {
			border: 1px solid #D8D8D8;
			border-radius: 5px;
			padding: 20px 50px 0;
			margin: 0px auto 20px;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 25%;
			}
			.login-btn2 {
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				flex-wrap: wrap;
				order: 2;
			}
			.login-btn3 {
				padding: 0 0 10px;
				width: 100%;
				order: 1;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				background: #A40000;
				font-weight: 600;
				width: 100%;
				font-size: 24px;
				min-width: 68px;
				height: 50px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 5px;
				padding: 0 10px;
				margin: 0 20px 20px 0;
				color: #fff;
				background: #A40000;
				width: 30%;
				font-size: 16px;
				height: 40px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #000;
				background: none;
				width: 100%;
				font-size: 16px;
				text-align: center;
				height: 34px;
			}
			.forget:hover {
				color: #A40000;
				opacity: 1;
			}
		}
	}
}

</style>
