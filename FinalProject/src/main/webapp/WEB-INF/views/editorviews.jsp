<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html class="html -webkit-">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/Project3.css'  type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+TC:700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<div class="div0">
<header class="header1">
<div class="div1">
    <a href="${pageContext.request.contextPath}/"><label class="lab0">To-touring</label></a>
    <a href=""><label class="lab1">註冊</label></a>
    <a href="editor"><label class="lab1">登入</label><img class="img2" src="${pageContext.request.contextPath}/images/login.png">
    </a>
    <img class="img1" alt="" src="">
    <a href="editorpackage"><label class="lab2">製作套裝</label></a>
    <a href="editorviews"><label class="lab2" style="background-color: rgb(255, 119, 51)">增加景點</label></a>
    <a href=""><label class="lab2">會員管理</label></a>
    <a href=""><label class="lab2">報表分析</label></a>
    </div>
    </header>
  <form:form method='POST' modelAttribute="SceneryBean" enctype="multipart/form-data" >
  <div class="div5"> 
  <div class="div4">
  <div class="div4" style="margin-top:6%;">
  <img id="blah"width="100%" height="100%" style="border: 2px solid rgb(0, 0, 0)" alt="PICTURE" />
  </div>
  <br><span class="spn1">景點照片:</span>
  <form:input type="file" class="inp1" id="imgInp" path="viewImage" accept="image/x-png,image/gif,image/jpeg" style="width:40%;height:50px;margin-top:10px"  onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"/><br>
  <span class="spn1">景點介紹:</span><br>
  <form:textarea path="introduction" style="width:40%;height:50%;margin-left:30px;border: 2px solid rgb(0, 0, 0);padding:5px" placeholder='景點介紹...' />
  </div><br>
 <span class="spn1">景點名稱:</span><form:input type="text" class="inp1" path="name" placeholder='景點名稱'/><br>
 <span class="spn1">景點國家:</span><form:input type="text" class="inp1" path="country" placeholder='景點國家'/><br>
 <span class="spn1">景點城市:</span><form:input type="text" class="inp1" path="city" placeholder='景點城市'/><br>
 <span class="spn1">景點地址:</span><form:input type="text" class="inp1" path="address" placeholder='景點地址'/><br>
 <span class="spn1">是否要買票:</span><span style="font-size:20px">&nbsp;&nbsp;是</span><form:radiobutton class="inp2" name="needticket" path="needticket" value="1"/>
                                     <span style="font-size:20px">&nbsp;&nbsp;否</span><form:radiobutton class="inp2" name="needticket" path="needticket" value="0"/><br>
 <span class="spn1">景點門票:</span><form:input type="text" class="inp1" path="price" placeholder='景點價格'/><br>
<input type="submit" class="inp3" value="ENTER">
 </div>
 </form:form>
</div>
</body>
</html>