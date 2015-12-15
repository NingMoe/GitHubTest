<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>企业注册—山东科技大学&mdash;大学生就业网</title>


<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../Js/jQuery.js"></script>
<script src="../Js/indexJs.js" type="text/javascript"></script>
</head>
<body>

		<div class=main_1>
			<!-- ----------head---------- -->
			<div>
				<jsp:include page="main.jsp" />
			</div>
			<!-- ----------left---------- -->
			<div>
				<jsp:include page="main_left.jsp" />
			</div>
			<!-- ----------right---------- -->
			<div class="rightdiv" id="body_1">
				<div class="sub">
					<div class="sub_top">
						<table width="701" height="47" border="0" cellspacing="0">
							<tr>
								<td width="351" background="../images/qiyezhuce_12.jpg" >&nbsp;</td>
								<td width="350" background="../images/sub1_13.jpg"
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;</span>
									&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 企业注册</td>
							</tr>
						</table>
					</div>
					<div class="sub_auto">

						<div class="fenye" style="text-align:left; line-height:24px;">
							<form method="post" name = "formenter"
								action="../servlet/EnterpriseRegisterServlet">
								<table width="638" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#bbbbbb" align="center">
									<tr>
										<td height="20" colspan="4" bgcolor="#999999"
											style="color:#FFF; font-weight:bold;">账号设置：( *为必填内容 ）</td>
									</tr>
									<tr>
										<td width="131" height="24" align="right" bgcolor="#FFFFFF">*
											用户名：</td>
										<td colspan="3" bgcolor="#FFFFFF"><input name="username" value=""
											type="text" id="username" size="18" /> &nbsp; <a href="javascript:check()">点击检查用户名</a></td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF">* 密码：</td>
										<td colspan="3" bgcolor="#FFFFFF"><input name="password"
											type="password" id="password" size="18"  value=""/>&nbsp;
										</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF">* 密码确认：</td>
										<td colspan="3" bgcolor="#FFFFFF"><input
											name="password2" type="password" id="password2" size="18" value="" />
										</td>
									</tr>
									<tr>
										<td height="20" colspan="4" align="left" bgcolor="#999999"
											style="color:#FFF; font-weight:bold;">企业基本信息：（此信息填写后不可再更改，请慎重填写）</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF"><span
											class="red">*</span> 公司名称：</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><input
											name="cname" type="text" id="cname" size="18" value="" />
										</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF">成立时间：</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><input
											name="cdate" type="text" id="cdate" size="18" value="" onClick="c.showMoreDay = true;c.show(getObjById('txt'),'2013-5-18',this)" />
									</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF"><span
											class="red">*</span> 所属行业：</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><select
											id="changye" name="changye">
												<option value="" selected="selected">请在以下列表中选择</option>
												<option value="计算机业">计算机业</option>
												<option value="电子电器、通讯设备">电子电器、通讯设备</option>
												<option value="科研设计、科技开发">科研设计、科技开发</option>
												<option value="机电设备、电力">机电设备、电力</option>
												<option value="仪器仪表、度量衡器">仪器仪表、度量衡器</option>
												<option value="机械制造及设备">机械制造及设备</option>
												<option value="各种车辆制造与销售">各种车辆制造与销售</option>
												<option value="动力、电力">动力、电力</option>
												<option value="化学化工、生物制药">化学化工、生物制药</option>
												<option value="五金矿产、金属制品">五金矿产、金属制品</option>
												<option value="纺织、服装">纺织、服装</option>
												<option value="农林牧副渔">农林牧副渔</option>
												<option value="轻工">轻工</option>
												<option value="房地产、建筑、装潢">房地产、建筑、装潢</option>
												<option value="造纸、印刷、包装">造纸、印刷、包装</option>
												<option value="木材、家具">木材、家具</option>
												<option value="广告、策划、设计">广告、策划、设计</option>
												<option value="新闻出版、广播电视">新闻出版、广播电视</option>
												<option value="信息咨询、人才交流">信息咨询、人才交流</option>
												<option value="金融、保险">金融、保险</option>
												<option value="交通运输">交通运输</option>
												<option value="邮政、电信">邮政、电信</option>
												<option value="综合性工商企业">综合性工商企业</option>
												<option value="市政、公用事业">市政、公用事业</option>
												<option value="教育事业">教育事业</option>
												<option value="医疗、卫生事业">医疗、卫生事业</option>
												<option value="文化、艺术">文化、艺术</option>
												<option value="文娱体育、办公用品">文娱体育、办公用品</option>
												<option value="日用生活服务">日用生活服务</option>
												<option value="商业服务">商业服务</option>
												<option value="物资供销">物资供销</option>
												<option value="饮食、旅游业">饮食、旅游业</option>
												<option value="粮油、副食">粮油、副食</option>
												<option value="其它">其它</option>
										</select>
										</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF"><span
											class="red"> </span><span class="red">*</span> 企业性质：</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><select
											id="ctype" name="ctype">
												<option value="" selected="selected">请在以下列表中选择</option>
												<option value="行政机关">行政机关</option>
												<option value="社会团体">社会团体</option>
												<option value="事业单位">事业单位</option>
												<option value="国有企业">国有企业</option>
												<option value="外资企业">外资企业</option>
												<option value="中外合资">中外合资</option>
												<option value="民营企业">民营企业</option>
												<option value="私营企业">私营企业</option>
										</select>
										</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF">雇员人数：</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><select
											id="cnum" name="cnum">
												<option value="" selected="selected">----请选择----</option>
												<option value="50人以下">50人以下</option>
												<option value="50&mdash;100人">50&mdash;100人</option>
												<option value="100&mdash;200人">100&mdash;200人</option>
												<option value="200&mdash;500人">200&mdash;500人</option>
												<option value="500&mdash;1000人">500&mdash;1000人</option>
												<option value="1000人以上">1000人以上</option>
										</select>
										</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF">注册资金：</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><select
											id="cmoney" name="cmoney">
												<option value="" selected="selected">----请选择----</option>
												<option value="100万以下">100万以下</option>
												<option value="100万－500万">100万－500万</option>
												<option value="500万－1000万">500万－1000万</option>
												<option value="1000万－5000万">1000万－5000万</option>
												<option value="5000万以上">5000万以上</option>
										</select>
										</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF"><span
											class="red">* </span>公司地址：</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><input
											id="caddr" size="50" name="caddr" value=""/>
										</td>
									</tr>
									<tr>
										<td height="24" align="right" bgcolor="#FFFFFF">*
											公司简介及业务简介</td>
										<td height="24" colspan="3" bgcolor="#FFFFFF"><textarea
												name="cmore" id="cmore" cols="60" rows="10" value=""></textarea>
										</td>
									</tr>
									<tr>
										<td height="24" colspan="4" align="left" bgcolor="#999999"
											style="color:#FFF; font-weight:bold;">企业联系方式：(此部分信息可以在登录后修改,请保证您的联系方式正确性,谢谢)</td>
									</tr>
									<tr>
										<td align="right" width="131" bgcolor="#ffffff"><span
											class="red">* </span>通讯地址</td>
										<td align="left" width="181" bgcolor="#ffffff"><input
											id="caddr2" maxlength="50" name="caddr2" value="" />
										</td>
										<td align="right" width="83" bgcolor="#ffffff"><span
											class="red">*</span> 邮政编码</td>
										<td align="left" width="238" bgcolor="#ffffff"><input
											id="czip" maxlength="6" name="czip" value="" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff"><span class="red">*</span>
											联系人</td>
										<td align="left" bgcolor="#ffffff"><input id="cperson"
											maxlength="20" name="cperson" value="" />
										</td>
										<td align="right" bgcolor="#ffffff">联系人职务</td>
										<td align="left" bgcolor="#ffffff"><input id="cposition"
											maxlength="10" name="cposition" value="" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff"><span class="red">*
										</span>联系电话</td>
										<td align="left" bgcolor="#ffffff"><input id="cphone"
											maxlength="20" name="cphone"  value=""/>
										</td>
										<td align="right" bgcolor="#ffffff">传真号码</td>
										<td align="left" bgcolor="#ffffff"><input id="cfax"
											maxlength="20" name="cfax" value="" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff">手机号码</td>
										<td align="left" bgcolor="#ffffff"><input id="cmobile"
											maxlength="11" name="cmobile" value="" />
										</td>
										<td align="right" bgcolor="#ffffff"><span class="red">*</span>
											电子邮箱</td>
										<td align="left" bgcolor="#ffffff"><input id="cemail"
											name="cemail" value="" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff">公司主页</td>
										<td align="left" bgcolor="#ffffff"><input id="cwww"
											name="cwww"  value=""/>
										</td>
										<td align="left" bgcolor="#ffffff">&nbsp;</td>
										<td align="left" bgcolor="#ffffff">&nbsp;</td>
									</tr>
									<tr>
										<td height="30" colspan="4" align="center" bgcolor="#FFFFFF"><input
											type="button"  value="注册"  onclick="javascript:JudgeEnterprise()"/>
											&nbsp; <input type="reset" name="button3" id="button3"
											value="重置" />
										</td>
									</tr>
								</table>
								<p>&nbsp;</p>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- ----------copyright---------- -->
			<div>
				<jsp:include page="copyright.jsp" />
			</div>
		</div>

	<!-- ----------share---------- -->
	<jsp:include page="main_share.jsp" />
</body>
</html>
