<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/editorpackage.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
<script type="text/javascript">
function dragStart(event) {
	  event.dataTransfer.setData("Text", event.target.id);
	  }
function dragStart2(event) {
	  var index = $(event.target).index()
	  event.dataTransfer.setData("Text", event.target.id);
	  event.dataTransfer.setData('index', index)
	}
	function dragEnd(event) {
		
	}

	function allowDrop(event) {
	  event.preventDefault();
	  
	}
	function bigdrop(event){
		var data = event.dataTransfer.getData("Text");	
		if($("#"+data).attr("class") =="123"){
			drop(event);
		}else{
			drop2(event);
		}	 
	}

	function drop(event) {
		event.preventDefault();	 
		var data = event.dataTransfer.getData("Text");	
		var eleObj =document.getElementById(data);
		var divObj = document.createElement("li");
		divObj.innerHTML=eleObj.innerHTML;
		divObj.setAttribute("class","li1");
		divObj.setAttribute("id",eleObj.innerHTML + "1")
		divObj.setAttribute("draggable","true");
		divObj.setAttribute("drop","drop2(event)");
		divObj.setAttribute("ondragstart","dragStart2(event)");
		divObj.setAttribute("ondragend","dragEnd(event)");
		event.currentTarget.appendChild(divObj);
		$("li").click(click);
		};
			
		function drop2(event){		
			event.preventDefault();	 
			event.stopPropagation();
			var data = event.dataTransfer.getData("Text");
			var oldParent = $("#"+data).parent().attr("id");
			var target = $(event.target);
			var targetParent = target.parent().attr("id");
			var oldIndex = event.dataTransfer.getData('index');
			var newIndex = target.index();			
			if(oldParent == targetParent){
			if (newIndex < oldIndex) {
			    target.before($("#"+oldParent+" "+"li:eq("+ oldIndex +")").remove())
			  } else {
			    target.after($("#"+oldParent+" "+"li:eq("+ oldIndex +")").remove())
			  }	
			}else{
				 target.before($("#"+oldParent+" "+"li:eq("+ oldIndex +")").remove())
			}
		}
	function click(event){
		var innerclick = this.innerHTML;
		alert("125")
		$.ajax({
			url:"viewintro",
			data:{viewname: innerclick},
			type:"post",
			success:function(data){
				$("#lab1").html(data.name);
				$("#lab2").html(data.country);
			}
		})
	}
</script>
</head>
<body>
<div class="div0">
<header class="header1">
<div class="div1">
    <a href="#"><label class="lab0">To-touring</label></a>
    <a href=""><label class="lab1">註冊</label></a>
    <a href="editor"><label class="lab1">登入</label><img class="img2" src="${pageContext.request.contextPath}/images/login.png">
    </a>
    <img class="img1" alt="" src="">
    <a href="editorpackage"><label class="lab2" style="background-color: rgb(255, 119, 51)">製作套裝</label></a>
    <a href="editorviews"><label class="lab2">增加景點</label></a>
    <a href=""><label class="lab2">會員管理</label></a>
    <a href=""><label class="lab2">報表分析</label></a>
    </div>
    </header>
 <div class="div3">
 <div class="div5">
 <c:forEach var="viewcity" items="${view}">
 <h2>${viewcity}</h2>
<c:forEach var="view" items="${Views}">
<c:if test="${viewcity==view.city}">
<div class="div4" >
<div id="${view.name}" class="123" style="height:50px;float:left" draggable="true" ondragstart="dragStart(event)" ondragend="dragEnd(event)">${view.name}</div>
<img src="<c:url value='/getphoto/${view.viewid}'/>" style="height:50px;width:67px;float:right"/>
</div>
</c:if>
</c:forEach>
 </c:forEach>
</div>
<fieldset class="fie1"><legend>請輸入套裝天數及標題</legend>
<form action="Filter1" method="post">
<label>標題:</label><input type="text" name="title" style="width:50%;text-align:center" placeholder="標題"><br>
<label>天數:</label><input type="text"  name="days" style="width:50%;text-align:center" placeholder="天數"><br><br>
<input class="search-txt" type="text" name="country" placeholder="Country">
<input class="search-txt" type="text" name="city" placeholder="City"><br>
<input class="inp1" type="submit">
</form><br><br><br>
 <h2>${packagetitle}</h2> <h4>${day}</h4>
 <c:forEach var="i" begin="1" end="${days}" step="1" varStatus="check">
<div class="div6">
<label class="lab3">第${i}天</label>
<div>
<ul id="${i}" class="div6" style="width:100%;" ondrop='bigdrop(event)' ondragover='allowDrop(event)'></ul>
</div>
</div>
</c:forEach>

 </fieldset>

 <div style="width:35%;height:300px;background-color: green;margin:auto;transform:translate(15%,50%)"> 
 <label id="lab1"></label>
 <label id="lab2"></label>
 </div>

 </div>
</div>
<script type="text/javascript">


</script>
</body>

</html>