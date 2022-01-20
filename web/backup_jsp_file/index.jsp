<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-12-03
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Html之网页分屏浏览模式</title>
    <style type="text/css">
        <!--
        body{
            font-family: "宋体"; font-size: 9pt; margin-top: 0px; margin-left: 4px; margin-right: 0px}
        A{
            COLOR: black; FONT-SIZE: 13px; FONT-WEIGHT: 400; TEXT-DECORATION: none }
        A:hover { COLOR: white; FONT-SIZE: 13px; FONT-WEIGHT: 400; TEXT-DECORATION: underline }
        a:active     { font: 9pt "宋体"; cursor: hand; color: #000000 }
        --></style>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">

    <%--<style>--%>
        <%--#cdp{animation-name:html_page;animation-duration:1500ms;animation-timing-function:ease-in-out;}--%>
        <%--@keyframes html_page{--%>
            <%--0% {transform-origin: 50% 50%;transform: rotate3d(0, 1, 0, 1440deg) rotateZ(45deg) scale(1);}--%>
            <%--100% {transform: rotate3d(0, 1, 0, 0) rotateZ(0) scale(1);}--%>

        <%--}--%>
        <%--@keyframes mymove{--%>
            <%--0%{--%>
                <%--transform:rotateY(720deg);--%>
            <%--}--%>
            <%--80%{--%>
                <%--transform:rotateY(720deg);--%>
            <%--}--%>
            <%--100%{--%>
                <%--transform:rotateY(0deg);--%>
            <%--}--%>
        <%--}--%>
    <%--</style>--%>
</head>



<body id="cdp" bgcolor="#000000">
<center><font color=#00FF00; face="隶书" size=8>专利辅助工具-逆向撰写</font></center>
<br>
<object type="text/x-scriptlet" width=49%; algin="left"  height=100% data="http://localhost:8080/Show-phrases.jsp">
</object>
<object type="text/x-scriptlet" width=49%; algin="right"  height=100% data="http://localhost:8080/Writing.jsp">
</object>
<br>

<center>
    <SCRIPT LANGUAGE="JavaScript">
        <!-- hide
        document.oncontextmenu=new Function("event.returnValue=false");
        document.onselectstart=new Function("event.returnValue=false");
        function goHist(a)
        {
            history.go(a);
        }
        //-->
    </script>
    <embed src="" autostart="true" loop="true" hidden="true">
    <br>
</center>

</body>
</html>
