<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="width=device-width ,initial-scale=1.0">
<title>${title}</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Together.css' type="text/css" />

	<script type="text/javascript">
			$(document).ready(function(){
				/* $("#tripdays").change(function(){
					$("#submit").click(); */
					
					})
					

// 		$("#submit").click(function(){
// 			$.ajax({
// 				url:"Filter" ,
// 				data:{tripname:$("#tripname").val() , triptype:$(":radio").focus().val() , 
// 					countrycity:$("#countrycity").val() ,tripdays:$("#tripdays").val() ,
// 					lowestprice:$("#lowestprice").val()},
// 				type:"POST",
// 				success:function(data){
// 					alert("隨便你")
// 				}
// 			})
// 		})
		
// 				$("#triptype").change(function(){
// 					$("#submit").click();
				
// 				})
// 				$("#triptype1").change(function(){
// 					$("#submit").click();
// 				})
		
			
			
			})
	
	</script>
</head>
<body>
<div class="ALLDIV">
	<div class="div0">
		<header class="header1">
			<div class="div1">
				<a href="${pageContext.request.contextPath}/"><label
					class="lab0">To-touring</label></a> <a href=""><label class="lab1">註冊</label></a>
				<a href="editor"><label class="lab1">登入</label><img class="img2"
					src="${pageContext.request.contextPath}/images/login.png"> </a> <img
					class="img1" alt="" src="">
				
			</div>
		</header>
			</div>
		<div class="togetherdiv0">
		<div style="float:left;margin:auto; width:25%;height:95%;">

					<fieldset><legend style="text-align:center;">偏好搜尋</legend>
					<form action="Filter" method="POST">
					<div class="Filterdiv"><span>輸入關鍵字，查詢行程:</span>
					<input type="text" size="12" name="tripname" id="tripname" value="${formtext}"/>
					</div>
					<div class="Filterdiv"><span>分類:</span>
					<input type="radio"  value="自訂旅行"  id="triptype" name="triptype"  /><label for="triptype">自訂旅行</label>
					<input type="radio"  value="套裝行程" id="triptype1" name="triptype" /><label for="triptype1">套裝行程</label>
					</div>
					<div class="Filterdiv"><span>輸入國家、城市關鍵字:</span>
					<input type="text" size="12" name="countrycity" value="${formtext2}" id="countrycity"/></div>
					<div class="Filterdiv"><span>行程天數</span>
		<select  id="tripdays" name="tripdays">
			<option value="1">1</option><option value="2">2</option>
			<option value="3">3</option><option value="4">4</option>
			<option value="5">5</option><option value="6">6</option>
			<option value="7">7</option><option value="8">8</option>
			<option value="9">9</option><option value="10">10</option>
			<option value="0">不拘</option>
						</select></div>
						<div class="Filterdiv"><span>基本開銷</span>
						<input  type="text" size="8" name="lowestprice" value="${formtext4}" id="lowestprice"/><span>以下</span></div>
						<div style="text-align:center;width:60%;margin:auto;">
						<input type="submit" value="查詢" id="submit">
						
						<a href="GetTogether" style="float:right;margin:0px;" id="submit1">查看全部</a>
						</div>
						<div class="Filterdiv" style="background-color:yellow;"><span style="color:red;">${error}</span></div>
					</form>
					
					</fieldset>
		</div>
		
		<div class="togetherdiv1">
		<div class="together" id="together">
		
			<c:forEach var="trip" items="${Together}">
			<a href="${pageContext.request.contextPath}/">
			<div class="togetherList">
			<div style="width:10%;height:90%;border:1px solid black;float:left;">
			<img src="${pageContext.request.contextPath}/images/login.png" style="width:90px;height:90px;">
			</div>
			<div style="float:left;border:1px solid black;margin:5px;width:85%;height:100px;">ID :${trip.tripId} 
			團名:	${trip.tripname}
			照片:	${trip.photo}
			分類:	${trip.triptype}<br>
			國家:	${trip.countrycity}
			天數:	${trip.tripdays}
			最低開銷:	${trip.lowestprice}</div>
				</div>
</a>
				
			</c:forEach>
		
		</div>
		</div>
		</div>
		</div>
</body>
</html>