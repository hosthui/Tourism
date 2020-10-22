/**
 * 
 */
//添加组件
//Vue.component("add", {
//    template: "#addtemp",
//    props: ['items'],
//    data() {
//        return {
//            hotel: [{
//                uid: '',
//                hname: '',
//                address: '',
//                phone: '',
//                imag: '',
//                remark: '',
//                star: ''
//            }],
//            scenic: [{
//                sid: '',
//                sname: '',
//                address: '',
//                phone: '',
//                image: '',
//                introduction: '',
//                price: ''
//            }],
//            user:[{
//            	username:'',
//            	password:'',
//            	remark:'',
//            	sex:'',
//            	number:''
//            }],
//            hotelflag:true
//        }
//    },
//    methods: {
////    	点击进行添加的方法
//        update(data, name) {
//            if (name == 'hotel') {
//            	this.$http.post("hotel/findHotelByIdResult",{"hid":data.hid}).then(res=>{  //判断有无
//            		if(res.body.flag){
//            			 this.$http.post("hotel/addHlotel", {  //添加数据
//                             "hid": data.hid,
//                             "hname": data.hname,
//                             "address": data.address,
//                             "image": data.image,
//                             "phone": data.phone,
//                             "remark": data.remark,
//                             "star": data.star
//                         }).then(res => {
//                             console.log(res.body)
//                             if (res.body.flag == true) {
//                                 /* window.location.href="login.html";  跳转到所有酒店 */
//                                 vm.getfindall('hotel');
//                             } else {
//                                 alert(res.body.message);
//                             }
//                         })
//            		}else{
//            			alert("酒店id已经存在，不能添加")
//            		}
//            	})
//            
//            } else if (name == 'scenic') {
//            	this.$http.post("scenic/findScenicByIdResult",{"sid":data.sid}).then(res=>{  //判断有无这个id
//            		if(res.body.flag){
//                this.$http.post("scenic/addscenic", {  //添加数据
//                    "sid": data.sid,
//                    "sname": data.sname,
//                    "address": data.address,
//                    "image": data.image,
//                    "phone": data.phone,
//                    "introduction": data.introduction,
//                    "price": data.price
//                }).then(res => {
//                    if (res.body.flag == true) {
//                        vm.getfindall('scenic');
//                    } else {
//                        alert(res.body.message);
//                    }
//                })
//            		}else{
//            			alert("id存在无法添加")
//            		}
//            	})
//            }else if(name=='user'){
//            	this.$http.post("user/findUserByNameResult",{ //判断有无这个名字  
//            		"username":data.username,
//            		"admin":data.admin
//            	}).then(res=>{
//            		if(res.body.flag){
//            			this.$http.post("user/register",{   //添加数据
//							"username":data.username,
//							"password":data.password,
//							"remark":data.remark,
//							"sex":data.sex,
//							"number":data.number,
//							"admin":1
//						}).then(res=>{
//							if(res.body.flag==true){
//								  vm.getfindall('user');
//							}else{
//								 alert(res.body.message); 
//							}
//						})
//            		}else{
//            			alert("id存在无法添加")
//            		}
//            	})
//            }
//        }
//    }
//})
//        用户组件
Vue.component("user", {
    data() {
        return {
            uname: '',  //控制是否所有
            udata: {},
        }
    },
    props: ['items', 'pageno', 'toname','spageno','hpageno'],
    template: "#user",
    components: {
        //所有
        "findall": {
            data() {
                return {
                    list: null,
                    pageno: 1,   //当前页
                    hpageno:1,
                    spageno:1,
                    uname:'',
                    hname:'',
                    sname:'',
                    hid:'',
                    sid:''
                }
            },
            props: ['items', 'page','spage','hpage'],
            template: "#findall",
            methods: {
//            	控制进入子组件
                findallset(tname, name, v) {
//                    toname ：控制进入子组件， name：控制父组件名  v: 数据
                    this.$emit("getuname", tname, name, v)
                },
//                点击数字
                tosetname(i,totname) {
                	if(totname=='user'){
                		this.pageno = i
                		this.hpageno = 1
                		this.spageno = 1
                		console.log(this.hpageno+"===为酒店的i")
                	}else if(totname=='hotel'){
                		this.hpageno = i
                		this.pageno = 1
                		this.spageno = 1
                		console.log(this.pageno+"===为用户的i")
                	}else if(totname=='scenic'){
                		this.spageno = i
                		this.pageno = 1
                		this.hpageno = 1
                	}
                    vm.setname(i, totname)
                },
//                左边箭头
                leftsetname(toname) {
//                	存在bug
                	if(toname=='user'){
                        this.pageno = --this.pageno
                        this.hpageno = 1
                		this.spageno = 1
                        if (this.pageno > 0) {
                           vm.setname(this.pageno, toname)
                        }
                	}else if(toname=='hotel'){
                		  this.hpageno = --this.hpageno
                		  this.pageno = 1
                  		  this.spageno = 1
                          if (this.hpageno > 0) {
                             vm.setname(this.hpageno, toname)
                          }
                	}else if(toname=='scenic'){
                		  this.spageno = --this.spageno
                		  this.pageno = 1
                  		  this.hpageno = 1
                          if (this.spageno > 0) {
                             vm.setname(this.spageno, toname)
                          }
                	}
                },
//                右边的箭头
                rightsetname(toname) {
                    if(toname=='user'){
                        this.pageno = ++this.pageno
                        this.hpageno = 1
                		this.spageno = 1
                        if (this.pageno <= this.page) {
                           vm.setname(this.pageno, toname)
                        }
                	}else if(toname=='hotel'){
                		  this.hpageno = ++this.hpageno
                		  this.pageno = 1
                  		  this.spageno = 1
                          if (this.hpageno <= this.page) {
                             vm.setname(this.hpageno, toname)
                          }
                	}else if(toname=='scenic'){
                		  this.spageno = ++this.spageno
                		  this.pageno = 1
                  		  this.hpageno = 1
                          if (this.spageno <= this.page) {
                             vm.setname(this.spageno, toname)
                          }
                	}
                },
//                模糊查询  
                findbyname(name){
                	if(name=='user'){
                		if(this.uname==''){
                			this.$http.get("user/findall").then(res=>{
                				vm.setlikename(res.body,'user')
                				vm.setname(1,'user')
                			})
                		}else{
                		this.$http.post("user/findByNameLike",{"username":this.uname
                			}).then(res=>{
                			vm.setlikename(res.body,name)
                		 })
                		}
                	}else if(name=='hotel'){
                		if(this.hname==''){
                			alert("请输入要查找的酒店")
                		}else{
                		this.$http.post("hotel/findByNameLike",{"hname":this.hname,"hid":this.hid
            			}).then(res=>{
            				console.log(res.body)
            				if(res.body==''){
            					alert("没有查找出该酒店，请确认输入是否正确")
            				}else{
            			        vm.setlikename(res.body,name)
//            			        vm.setname(1,'hotel')
            				}
            		       })
                	  }
                	}else if(name=='scenic'){
                		this.$http.post("scenic/findByNameLike",{"sname":this.sname,"sid":this.sid
            			}).then(res=>{
            			if(res.body==''){
            					alert("没有查找出该景区，请确认输入信息是否正确")
            			}else{
            			      vm.setlikename(res.body,name)
            			}
            		})
                	}
                },
//                删除
                del(name, v, ty) {
                    if (ty == 'user') {
                        this.$http.post("user/deleteuser", {
                            "uid": v.uid
                        }).then(res => {
                            if (res.body.flag == true) {
                                alert("删除成功");
                                vm.setname(1, 'user')
                                vm.find('user','user')
                                this.pageno= 1
                            } else {
                                alert(res.body.message);
                            }
                        })
                    } else if (ty == 'hotel') {
                        this.$http.post("hotel/delHlotel", {
                            "hid": v.hid
                        }).then(res => {
                            console.log(res.body)
                            if (res.body.flag == true) {
                                alert("删除成功");
                                vm.setname(1, 'hotel')
                                 vm.find('user','hotel')
                                this.hpageno= 1
                            } else {
                                alert(res.body.message);
                            }
                        })
                    } else if (ty == 'scenic') {
                        this.$http.post("scenic/deletescenic", {
                            "sid": v.sid
                        }).then(res => {
                            console.log(res.body)
                            if (res.body.flag == true) {
                                alert("删除成功");
                                vm.setname(1, 'scenic')
                                vm.find('user','scenic')
                                this.spageno= 1
                            } else {
                                alert(res.body.message);
                            }
                        })
                    }
                },
//                添加
                add(name, modelname) {
                    this.$emit("getaddname", name, modelname)
                },
            }, 
        }, //组件结束
        //单个组件
        "findid": {
            props: ['data'],
            template: "#findid",
            methods: {
                update(v, name) {
                    // name：为要进入的组件， v为数据
                	console.log(v)
                    if (name == 'user') {
                        this.$http.post("user/updateuser", {
                            "username": v.username,
                            "password": v.password,
                            "uid": v.uid,
                            "number": v.number,
                            "sex": v.sex,
                            "remarek": v.remark,
                            "admin":v.admin
                        }).then(res => {
                            if (res.body.flag == true) {
                                alert(res.body.message);
                                // 先父组件发送数据 发送 name
                                vm.setname(1, 'user')
                                vm.find('user','user')
                                this.pageno= 1
                            } else { //报错
                                alert("后台报错：" + res.body.message);
                            }
                        })
                    } else if (name == 'hotel') {
                        id = v.hid
                        this.$http.post("hotel/updateHlotel", {
                            "oldid": id,
                            "hid": v.hid,
                            "hname": v.hname,
                            "address": v.address,
                            "image": v.image,
                            "phone": v.phone,
                            "remark": v.remark,
                            "star": v.star
                        }).then(res => {
                            /* console.log(res.body) */
                            if (res.body.flag == true) {
                                alert(res.body.message);
//                                this.$emit("getuname", "findall", name, {})
                                vm.find('user','hotel')
                                vm.setname(1, 'hotel')
                               this.hpageno= 1
                            } else {
                                alert(res.body.message);
                            }
                        })
                    } else if (name == 'scenic') {   //景区修改
                        id = v.sid
                        this.$http.post("scenic/updatescenic", {
                            "oldid": id,
                            "sid": v.sid,
                            "sname": v.sname,
                            "address": v.address,
                            "image": v.image,
                            "phone": v.phone,
                            "introduction": v.introduction,
                            "price": v.price
                        }).then(res => {
                            console.log(res.body)
                            if (res.body.flag == true) {
//                            	向父组件
//                                this.$emit("getuname", "findall", name, {})
                            	  vm.find('user','scenic')
                            	vm.setname(1, 'scenic')
                                this.spageno= 1
                            } else {
                                alert(res.body.message);
                            }
                        })
                    }
                },
            }
        },
//        添加组件
        "add":{
        	 template: "#addtemp",
        	    props: ['items'],
        	    data() {
        	        return {
        	            hotel: [{
        	                uid: '',
        	                hname: '',
        	                address: '',
        	                phone: '',
        	                imag: '',
        	                remark: '',
        	                star: ''
        	            }],
        	            scenic: [{
        	                sid: '',
        	                sname: '',
        	                address: '',
        	                phone: '',
        	                image: '',
        	                introduction: '',
        	                price: ''
        	            }],
        	            user:[{
        	            	username:'',
        	            	password:'',
        	            	remark:'',
        	            	sex:'',
        	            	number:''
        	            }],
        	            hotelflag:true
        	        }
        	    },
        	    methods: {
//        	    	点击进行添加的方法
        	        update(data, name) {
        	            if (name == 'hotel') {
        	            	if(data.hid!==null&&data.hname!==null&&data.address!==null&&data.phone!=null&&data.star!=null){
        	            	this.$http.post("hotel/findHotelByIdResult",{"hid":data.hid}).then(res=>{  //判断有无
        	            		if(res.body.flag){
        	            			 this.$http.post("hotel/addHlotel", {  //添加数据
        	                             "hid": data.hid,
        	                             "hname": data.hname,
        	                             "address": data.address,
        	                             "image": data.image,
        	                             "phone": data.phone,
        	                             "remark": data.remark,
        	                             "star": data.star
        	                         }).then(res => {
        	                             console.log(res.body)
        	                             if (res.body.flag == true) {
        	                            	 alert("添加成功")
        	                            	 vm.find('user','hotel')
        	                                 vm.setname(1, 'hotel')
        	                                this.hpageno= 1
        	                             } else {
        	                                 alert(res.body.message);
        	                             }
        	                         })
        	            		}else{
        	            			alert("酒店id已经存在，不能添加")
        	            		}
        	            	})  //回调结束
        	              }//不为空结束
        	              else{
        	            	  alert("请填写完整的信息")
        	              }
        	            } else if (name == 'scenic') {
        	            	if(data.sid!==null&&data.sname!==null&&data.address!==null&&data.phone!=null&&data.price!=null){
        	            	this.$http.post("scenic/findScenicByIdResult",{"sid":data.sid}).then(res=>{  //判断有无这个id
        	            		if(res.body.flag){
        	                this.$http.post("scenic/addscenic", {  //添加数据
        	                    "sid": data.sid,
        	                    "sname": data.sname,
        	                    "address": data.address,
        	                    "image": data.image,
        	                    "phone": data.phone,
        	                    "introduction": data.introduction,
        	                    "price": data.price
        	                }).then(res => {
        	                    if (res.body.flag == true) {
        	                    	alert("添加成功")
        	                    	 vm.find('user','scenic')
                                 	 vm.setname(1, 'scenic')
                                     this.spageno= 1
        	                    } else {
        	                        alert(res.body.message);
        	                    }
        	                })
        	            		}else{
        	            			alert("id存在无法添加")
        	            		}
        	            	})
        	            	}else{
        	            		alert("请填写完整的信息")
        	            	}
        	            }else if(name=='user'){
        	            	if(data.username!=null&&data.password!=null){
        	            		console.log(data.admin+"====为data.admin")
        	            	this.$http.post("user/findUserByNameResult",{ //判断有无这个名字  
        	            		"username":data.username,
        	            		"admin":"1"
        	            	}).then(res=>{
        	            		if(res.body.flag){
        	            			this.$http.post("user/register",{   //添加数据
        								"username":data.username,
        								"password":data.password,
        								"remark":data.remark,
        								"sex":data.sex,
        								"number":data.number,
        								"admin":1
        							}).then(res=>{
        								if(res.body.flag==true){
        									alert("添加成功")
        									console.log(res.body)
        									  vm.setname(1, 'user')
        		                                vm.find('user','user')
        		                                this.pageno= 1
        								}else{
        									 alert(res.body.message); 
        								}
        							})
        	            		}else{
        	            			alert("用户名存在无法添加")
        	            		}
        	            	})
        	            	}else{
        	            		alert("请填写完整的信息")
        	            	}
        	            }
        	        }
        	    }
        },
        "message":{
        	template:"#message",
        	props:['items'],
        	methods:{
        		delmessage(i){
        			this.$http.post("message/del",{
        				"tid":i,
        			}).then(res=>{
        				console.log(res.body.flag)
        				if(res.body.flag){
        					alert("删除成功")
        					vm.setmessname('user','message')
        				}else{
        					alert(res.body.message)
        				}
        			})
        		},
        	},
        }
    },
    methods: {	
        set(totname , name, v) {
            this.toname = totname
            this.udata  = v
        }
    }

})
//vue实例
var vm = new Vue({
    el: ".cent",
    data: {
        name: '', //控制组件名字 用户模块，酒店模块，景区模块
        list: [],  //获取的数据
        fname: '',  //  哪一个子模块 如 findall 或者 findid
        rows: 4,  //一页条数
        pageno: '', // 页数 ：总数除以条数
        hpageno:'',
        spageno:'',
        page: 1  ,// 当前页  第几页
        
    },
    methods: {
//    	分页查询
    	setlikename(v,hname){
    		if(hname=='user'){
       		 this.pageno = Math.ceil(v.length / this.rows)
       		 this.list = v
             this.list.setname = 'user'
             this.fname = "findall"
    		}else if(hname=='hotel'){
    			 this.hpageno = Math.ceil(v.length / this.rows)
           		 this.list = v
                 this.list.setname = 'hotel'
                 this.fname = "findall"
    		}else if(hname=='scenic'){
    			 this.spageno = Math.ceil(v.length / this.rows)
           		 this.list = v
                 this.list.setname = 'scenic'
                 this.fname = "findall"
    		}
    	},
//    	分页查询 ， 传递第几页，什么模块
        setname(i, hname) {
            this.page = i || this.page
            if (hname == 'user') {
            	 this.$http.get("user/findall", {
                 }).then(res => {
                     this.pageno = Math.ceil(res.body.length / this.rows)
            	})
                this.$http.post("user/findByPage", {
                    "rows": this.rows,
                    "page": this.page
                }).then(res => {
                    this.list = res.body
                    this.list.setname = 'user'
                    this.fname = "findall"
                })
            } else if (hname == 'hotel') {
//            	获取到有多少条数据
            	this.$http.get("hotel/findHotelalls").then(res => {
                    this.hpageno = Math.ceil(res.body.length / this.rows)
            	})
                this.$http.post("hotel/findByPage", {
                    "rows": this.rows,
                    "page": this.page
                }).then(res => {
                    this.list = res.body
                    this.list.setname = 'hotel'
                    this.fname = "findall"
                })
            } else if (hname == 'scenic') {
            	  this.$http.get("scenic/findall").then(res => {
                      this.spageno = Math.ceil(res.body.length / this.rows)
            	  })
            	 this.$http.post("scenic/findByPage", {
                     "rows": this.rows,
                     "page": this.page
                 }).then(res => {
                     this.list = res.body
                     this.list.setname = 'scenic'
                     this.fname = "findall"
                })
            }
        },
        // 来调用 控制显示所有  分页查询，然后进入  子模块
        getfindall(setname) {
            this.name = "user"
            if (setname == 'user') {
            	this.$http.post("user/findByPage", {
                    "rows": this.rows,
                    "page": this.page
                }).then(res => {
                    this.list = res.body
                    this.list.setname = 'user'
                    this.fname = "findall"
                })
            } else if (setname == 'hotel') {
            	 this.$http.post("hotel/findByPage", {
                     "rows": this.rows,
                     "page": this.page
                 }).then(res => {
                     this.list = res.body
                     this.list.setname = 'hotel'
                     this.fname = "findall"
                })
            } else if (setname == 'scenic') {
            	 this.$http.post("scenic/findByPage", {
                     "rows": this.rows,
                     "page": this.page
                 }).then(res => {
                     this.list = res.body
                     this.list.setname = 'scenic'
                     this.fname = "findall"
                })
            }
        },
        /* 添加信息  */
        addname(name, uname) {
            this.name = name
            if (uname == 'hotel') {
                this.list.setname = 'hotel'
            } else if (uname == 'scenic') {
                this.list.setname = uname
            }else if(uname=='user'){
            	this.list.setname = uname
            }
            this.fname = "add"
        },
//        进入user组件，获得全部    页数 = 总数/每页条数     this.list.setname 
        find(name, hname) {
            this.name = name
            if (hname == 'user') {
                this.$http.get("user/findall", {
                }).then(res => {
                    this.pageno = Math.ceil(res.body.length / this.rows)
                    this.list.setname = 'user'
                })
            } else if (hname == 'hotel') {
                this.$http.get("hotel/findHotelalls").then(res => {
                    this.hpageno = Math.ceil(res.body.length / this.rows)
                    this.list.setname = 'hotel'
                })
            } else if (hname == 'scenic') {
                this.$http.get("scenic/findall").then(res => {
                    this.spageno = Math.ceil(res.body.length / this.rows)
                    this.list.setname = 'scenic'
                })
            }
        },
        setmessname(name,hname){
        	this.name=name;
        	this.fname = hname;
        	this.$http.get("message/findall").then(
        		res=>{
        			this.list=res.body
        		}
        	)
        }
    },
    mounted() {
//    	页面挂载运行find方法，
//        this.find('user', '')
    },
})
//  导航的vue实例
var nav = new Vue({
	el:"#nav",
	data:{
		name:'未登录'
	},
	methods:{
		logo(){
			  var url = window.location.search; 
  	    if (url.indexOf("?") != -1) {
  	        this.name = url.substr(6);  
  	         this.flag=false
  	    }
		  }
	},
	 mounted() {
        this.logo()
    },
})