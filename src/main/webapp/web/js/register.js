/**
 * 注册
 */
new Vue({
    el: "#app",
    data: {
        username: '',
        password: '',
        qrpawd: '',
        remark: '',
        sex: '',
        pawdac: true,
        qrpawdac: true
    },
    methods: {
        mima: function () {
            var uPattern = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
            if (uPattern.test(this.password)) {
                this.pawdac = true
            } else {
                this.pawdac = false
            }
        },
        yzmima: function () {
            if (this.password == this.qrpawd) {
                this.qrpawdac = true
            } else {
                this.qrpawdac = false
            }
        },
        regiest() {
            if (this.username == "" || this.password == "") {
                alert("请填写详细的信息")
            }else if(this.username=="root"){
            	alert("不能使用这个用户名，请更换一个")
            }else {
                this.$http.post("user/findUserByNameResult", { //判断有无这个名字  
                    "username": this.username,
                    "admin": 1
                }).then(res => {
                    if (res.body.flag) {
                        this.$http.post("user/register", {
                            "username": this.username,
                            "password": this.password,
                            "remark": this.remark,
                            "sex": this.sex
                        }).then(res => {
                            if (res.body.flag == true) {
                                alert("注册成功")
                                window.location.href = "login.html";
                            } else {
                                alert(res.body.message);
                            }
                        })
                    } else {
                    	alert("用户名已存在，请更换一个用户名")
                    }  
                })
            }
        },
    },
})