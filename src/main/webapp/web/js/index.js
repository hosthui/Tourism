/**
 * 
 */
var vm = new Vue({
	  el:".carousel-inner",
	  data:{
/* 		  images:['web/imags/1.png','web/imags/2.png','web/imags/3.png','web/imags/4.png','web/imags/5.png'], */
	  },
	  methods: {
          img() {
        	  var url =window.location.search; 
        	  if(url!=''){
        		/* this.images=['imags/1.png','imags/2.png','imags/3.png','imags/4.png','imags/5.png'] */  
        	  }
              console.log(window.location.href)
              console.log(url)
          }
      },
      mounted() {
          this.img()
      }
  })
  var vmhead = new Vue({
	  el:"#header",
	  data:{
		  flag:true,
		  name:''
	  },
	  methods:{
		  logo(){
			  var url = window.location.search; 
      	    if (url.indexOf("?") != -1) {
      	        this.name = url.substr(6);  
      	         this.flag=false
      	    }
		  },
		  person(){
			  if(vmhead.name==''){
	    		   alert("还没有登录")
	    		   window.location.href="web/login.html"
	    	   }else{
			  window.location.href="web/personal.html?name="+this.name;
	    	   }
		  },
		  djd(){
			  if(vmhead.name==''){
//	    		   alert("还没有登录")
	    		   window.location.href="web/hotelone.html"
	    	   }else{
			  window.location.href="web/hotelone.html?name="+this.name;
	    	   }
		  },
		  djq(){
			  if(vmhead.name==''){
//	    		   alert("还没有登录")
	    		   window.location.href="web/scenicone.html"
	    	   }else{
			  window.location.href="web/scenicone.html?name="+this.name;
			  }
		  }
	  },
	  mounted(){
		  this.logo()
	  }
  })
  /* jquer 的点击 */  
$(function () {
      // 点击热门
      $("#rmyj").click(function (e) {
        e.preventDefault();
        $("#remen").fadeIn("3000");
        console.log("点击了热门游记")
        $("#zsremen").fadeOut("3000");
        $("#saixuan").fadeOut("3000");
      })
      // 点击筛选
      $("#saxuan").click(function (e) {
        $("#saixuan").fadeIn("3000")
      })
      // 点击最新
      $("#zxfb").click(function (e) {
        e.preventDefault();
        $("#remen").fadeOut("3000");
        $("#zsremen").fadeIn("3000");
        $("#saixuan").fadeOut("3000")
      })
//      点击写游记
      $("#xyj").click(function(e){
    	   e.preventDefault();
    	   console.log(vmhead.name+"===");
    	   if(vmhead.name==''){
    		   alert("还没有登录")
    		   window.location.href="web/login.html"
    	   }else{
    		   window.location.href="web/yj.html?name="+vmhead.name;
    	   }
      })
    })