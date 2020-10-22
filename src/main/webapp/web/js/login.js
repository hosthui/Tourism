/*var vm = new Vue({
	el:"#app",
	data:{
		username:'',
		password:'',
		items:'',
		admin:''
	},
	methods:{
		login(){
			this.$http.post("user/login",{
					"username": this.username,
					"password": this.password,
					"admin": this.admin
			}).then(res=>{
				console.log(res.body)
				if(res.body.flag==true){
					console.log(this.admin)
					if(this.admin=='0'){
						window.location.href="ttt.html";
					}else{
						window.location.href="index.html";
					}
					
				}else{
					 alert(res.body.message); 
				}
			},function(){
				alert("报错");
			})
		},
		findall(){
			this.$http.get("user/findall").then(res=>{
				this.items=res.body
			})
		},
		findallHotel(){
			this.$http.get("hotel/findall").then(res=>{
				console.log(res.body)
				this.items=res.body
			})
		},
		del(id){
			console.log(id);
			this.$http.post("user/deleteuser",{"uid":id}).then(res=>{
				console.log(res.body)
				if(res.body.flag==true){
					alert("删除成功");
					window.location.href="welcome.html";
				}else{
					 alert(res.body.message); 
				}
			})
		},
		update(id){
			this.$http.post("user/updateuser",{
				"username":"admin",
				"password":"123456",
				"uid":id
			}).then(res=>{
				console.log(res.body)
				if(res.body.flag==true){
					alert(res.body.message);
					this.findall();
//					window.location.href="welcome.html";
				}else{
					 alert(res.body.message); 
				}
			})
		}
		
	}
})*/

	var vm = new Vue({
		el:"#app",
		data:{
			username:'',
			password:'',
			items:'',
			admin:''
		},
		methods:{
			login(){
				this.$http.post("user/login",{
						"username": this.username,
						"password": this.password,
						"admin": this.admin
				}).then(res=>{
					console.log(res.body)
					console.log(this.username)
					if(res.body.flag==true){
						if(this.admin=='0'){
							window.location.href="ttt.html?name="+this.username;
						}else{
							/* window.location.href="index.html?name="+this.username; */
							window.location.href="/Tourism/?name="+this.username;
						} 
						
					}else{
						 alert(res.body.message); 
					}
				},function(){
					alert("报错");
				})
			},
			}
		})