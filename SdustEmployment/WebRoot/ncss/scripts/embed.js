  
  //获取登录状态
    function checkuserstate(){
		
		$.getJSON('http://job.ncss.org.cn/getlogstate?callback=?',
			function(data){
				if(data.islogin == '1'){					
					$('#login-userState').attr('style','display:block;');
					$('#login-main').attr('style','display:none;');					
					$('#login-userState').html('当前用户：<a href="http://job.ncss.org.cn/home" title="点击进入学生管理首页"><span>'
					+ data.fullname +'</span></a>&nbsp;&nbsp;毕业院校：<span>'
					+ data.orgname + '&nbsp;&nbsp;<a id="logout" href="http://job.ncss.org.cn/logout?rul='
					+ document.location.href
					+'">[退出]</a>'
					);
				} else{
						$.getJSON('http://job.ncss.org.cn/rec/getlogstate?callback=?',
							function(data){
								if(data.islogin == '1'){
									email = data.email;
									$('#login-userState').attr('style','display:block;');
									$('#login-main').attr('style','display:none;');
									$('#login-userState').html('当前用户：<a href="http://job.ncss.org.cn/rec/home" title="点击进入单位管理首页"><span>'
									+ data.fullname +'</span></a>&nbsp;&nbsp;单位名称：<span>'
									+ data.orgname + '&nbsp;&nbsp;<a id="logout" href="http://job.ncss.org.cn/rec/logout?rul='
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
	
	
	//获取职位列表,分页
	function searchjobs(board,viewdivID,psize,pindex,category,jobType,natureCode)
	{
		var divID="#"+viewdivID;
		var pagerObj = $("#pager");
		//var psize = 3;
		var pcount ="";
		var parms = getParams(psize,pindex,category,jobType,natureCode);
		$.getJSON('http://job.ncss.org.cn/json/searchjobcountp?callback=?',parms,
			function(data)
			{
				pcount = data.pcount;
				if(pcount==0)
		        		{
		          			$(divID).html('没有找到符合条件的记录');
		          			pagerObj.pagefoot({
		            			pagesize: psize,
		            			count: 0,
		            			css: "pager2",
		            			paging: null
		        			});
		        		}
		        		else
		        		{		        								
							onloadlst(board,viewdivID,psize,pindex,category,jobType,natureCode);							
		    				pagerObj.pagefoot({
		            			pagesize: psize,
								displaynum:5,
								displaylastNum: 0,								
		            			count: parseInt(pcount),
		            			css: "pager2",
		            			paging: function(page) {onloadlst(board,viewdivID,psize,page,category,jobType,natureCode);}
		        			});
		        		}
				/* if(0<data.pcount)
				{
					onloadlst(board,divID,parms);					
				}
				*/
			}
		);
	}
	
	//解析数据集合
	function onloadlst(board,viewdivID,psize,pindex,category,jobType,natureCode)
	{
		var params = getParams(psize,pindex,category,jobType,natureCode);
		$.getJSON('http://job.ncss.org.cn/json/searchjobp?callback=?',params,
				function(data)
				{	var lists = '';
					var divElement="#"+viewdivID;
					var date ;
					var areaCode;
					var area="";
					var recLink,jobLink;
					//var topFlag="";
					if(board=="job-zhaopin"){//招聘
											
						$.each(data.lst, function()
						{
							date = this.postDate.substring(5,10);
							areaCode = this.areaCode.substring(0,2);
							$.each(provinceItems, function(){
								if(this.id==areaCode){area=this.name;} 
							});
							jobLink="http://job.ncss.org.cn/job/view_job?jobId="+this.jobId;
							if(this.fromType==0){
								recLink="http://job.ncss.org.cn/job/view_rec?recId="+this.recId;
							}else{recLink=jobLink;}
							
							if(this.priority==1){
								lists += '<tr><td width="52%" class="font5">['
								+ area
								+']&nbsp;<a href="'
								+ recLink
								+ '" target="_blank">'
								+ this.recName
								+ '</a></td><td width="36%" class="font5"><a href="'
								+ jobLink
								+ '" target="_blank">'
								+ this.jobTitle 
								+ '</a></td><td width="12%" class="font5">'
								+ date
								+'</td></tr>';
							}else{
								lists += '<tr><td width="52%"><span class="font4">['
								+ area
								+']</span>&nbsp;<a href="'
								+ recLink
								+ '" target="_blank">'
								+ '<span class="font2">'
								+ this.recName
								+ '</span></a></td><td width="36%" class="font2"><a href="'
								+ jobLink
								+ '" target="_blank">'
								+ this.jobTitle 
								+ '</a></td><td width="12%" class="date">'
								+ date
								+'</td></tr>';
							}
							
						});
					
					
					}
					if(lists!='')
						{
							$(divElement).html(lists).children('tr:even').css({background:'#f8f8f8'});
						}else
						{
							$(divElement).html("页面加载中...");
						}
				}
				
		);
	}
	    	
	//初始化查询参数
	function getParams(psize,pindex,category,jobType,natureCode)
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
		    pindex: parseInt(pindex),//显示第？页
			callback:"test"};
		   return params;
	}