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
<script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
</head>
<body>
<div class="div0">
<header class="header1">
<div class="div1">
    <a href="#"><label class="lab0">To-touring</label></a>
    <a href=""><label class="lab1">註冊</label></a>
    <a href=""><label class="lab1">登入</label><img class="img2" src="${pageContext.request.contextPath}/images/login.png">
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
 <form action="Filter1" method="post">
 <div class="div4">
<input class="search-txt" type="text" name="country" placeholder="Country">
<input class="search-txt" type="text" name="city" placeholder="City">
<input class="inp1" type="submit">
</div>
</form>
<c:forEach var="view" items="${Views}">
<div class="div4">
<label>${view.name}</label>
<img src="<c:url value='/getphoto/${view.viewid}'/>" style="height:50px;float:right"/>
</div>
</c:forEach>
</div>
 <fieldset class="fie1"><legend>請輸入套裝天數及標題</legend>
 <form action="join.do">
<label>標題:</label><input type="text" name="title" style="width:50%;text-align:center" placeholder="標題"><br>
<label>天數:</label><input type="text"  name="days" style="width:50%;text-align:center" placeholder="天數"><br>
 <input type="Submit" value="Submit">
</form>
 <h2>${packagetitle}</h2> <h4>${day}</h4>
 <c:forEach var="i" begin="1" end="${days}" step="1" varStatus="check">
<div class="div4">
<label class="lab3">第${i}天</label>
</div>
</c:forEach>

 </fieldset>
 </div>
</div>
</body>
</html>