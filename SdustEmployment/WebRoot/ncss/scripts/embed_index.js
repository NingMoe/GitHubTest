  
  //获取登录状态
    function checkuserstate(){
		
		$.getJSON('http://sdust.ncss.org.cn/getlogstate?callback=?',
			function(data){
				if(data.islogin == '1'){					
					$('#login-userState').attr('style','display:block;');
					$('#login-main').attr('style','display:none;');					
					$('#login-userState').html('当前用户：<a href="http://sdust.ncss.org.cn/home" title="点击进入学生管理首页"><span>'
					+ data.fullname +'</span></a>&nbsp;&nbsp;毕业院校：<span>'
					+ data.orgname + '&nbsp;&nbsp;<a id="logout" href="http://sdust.ncss.org.cn/logout?rul='
					+ document.location.href
					+'">[退出]</a>'
					);
				} else{
						$.getJSON('http://sdust.ncss.org.cn/rec/getlogstate?callback=?',
							function(data){
								if(data.islogin == '1'){
									email = data.email;
									$('#login-userState').attr('style','display:block;');
									$('#login-main').attr('style','display:none;');
									$('#login-userState').html('当前用户：<a href="http://sdust.ncss.org.cn/rec/home" title="点击进入单位管理首页"><span>'
									+ data.fullname +'</span></a>&nbsp;&nbsp;单位名称：<span>'
									+ data.orgname + '&nbsp;&nbsp;<a id="logout" href="http://sdust.ncss.org.cn/rec/logout?rul='
									+ document.location.href
									+'">[退出]</a>'
									);
									
								} else{
									$('#login-main').attr('style','display:block;');
									$('#login-userState').attr('style','display:none;');									
									}
							});
					}
				
			});
		 
    }
		
	//解析数据集合，有置顶，无分页，每单位只有一条职位
	function onloadlst(board,viewdivID,psize,category,jobType,natureCode)
	{
		var params = getParams(psize,category,jobType,natureCode);
		$.getJSON('http://sdust.ncss.org.cn/json/general_searchp?callback=?',params,
				function(data)
				{	var lists = '';
					var divElement="#"+viewdivID;
					var date ;
					var areaCode;
					var area="";
					var topFlag="";

					if(board=="index"){//首页
						$.each(data.lst, function()
						{							
							date = this.postDate.substring(5,10);
							areaCode = this.areaCode.substring(0,2);							
							$.each(provinceItems, function(){
								if(this.id==areaCode){area=this.name;}			 
							});
							
							var str=this.recName;
							if(str.length>8){
								str=str.substring(0,7);
							}
							
							if(this.priority==1){
								lists += '<tr><td class="hui21">['
								+ area
								+ ']&nbsp;<a class="hui21" href="http://sdust.ncss.org.cn/job/view_job?jobId='
								+ this.jobId
								+ '" target="_blank" title="职位名称：'
								+ this.jobTitle
								+ '&#10单位行业：' +this.industry+'&#10单位性质：' +this.nature 
								+'">'
								+ str
								+ '</a>('								
								+ date
								+')</td></tr>';
							}else{
								lists += '<tr><td class="hui21">['
								+ area
								+ ']&nbsp;<a class="hui21" href="http://sdust.ncss.org.cn/job/view_job?jobId='
								+ this.jobId
								+ '" target="_blank" title="职位名称：'
								+ this.jobTitle
								+ '&#10单位行业：' +this.industry+'&#10单位性质：' +this.nature 
								+'">'
								+ str
								+ '</a>('
								+ date
								+')</td></tr>';
							}
							
							
						});	
						
					}
					if(board=="job-index"){//招聘
						$.each(data.lst, function(i)
						{							
							var spaceDiv;
							date = this.postDate.substring(5,10);
							areaCode = this.areaCode.substring(0,2);				
							
							$.each(provinceItems, function(){
								if(this.id==areaCode){area=this.name;}			 
							});
							
							if((i+1)%6==0){
								spaceDiv='<div class="space"></div>';
							}else{spaceDiv='';}
							
							if(this.priority==1){
								lists += '<li><span class="font5">['
								+ area
								+ ']&nbsp;<a href="http://sdust.ncss.org.cn/job/view_job?jobId='
								+ this.jobId
								+ '" target="_blank" title="'
								+ this.jobTitle
								+ '">'
								+ this.recName
								+ '</a></span>('								
								+ date
								+ ')</li>'
								+ spaceDiv;
							}else{
								lists += '<li><span class="font4">['
								+ area
								+ ']</span>&nbsp;<span class="font2"><a href="http://sdust.ncss.org.cn/job/view_job?jobId='
								+ this.jobId
								+ '" target="_blank" title="'
								+ this.jobTitle
								+ '">'
								+ this.recName
								+ '</a></span>('								
								+ date
								+')</li>'
								+ spaceDiv;
							}
						
						});	
						
				}
					
					
					if(lists!='')
						{
							
							$(divElement).html(lists);
						}else
						{
							$(divElement).html("尚未发布信息...");
						}
				}
				
		);
	}
	    	
	//初始化查询参数
	function getParams(psize,category,jobType,natureCode)
	{
	   var params = {
			recName:"",
			natureCode:natureCode,
			industryCode:"",
			recScale:"",
			jobTitle:"",
			category:category,
			jobType:jobType,
			areaCode:"",
			degreeCode:"",
		    dayLimit:"-1",
			siteId:"",//默认空为全部，00为中心，10001为北京大学
		    psize: parseInt(psize),//每页条数
		    //pindex: parseInt(pindex),//显示第？页
			callback:"test"};
		   return params;
	}