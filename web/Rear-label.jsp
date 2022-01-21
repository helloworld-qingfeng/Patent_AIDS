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
    <title>专利辅助工具</title>
    <style>

        *{
            margin: 0px;
            padding: 0px;
        }


        body{
            background-color:#F0ECD6;
            /*background-image:url(img/22.jpg);*/
            background-position:top;
            background-repeat:repeat-x;
            background-size:150px 80px;
        }


        .Reference-mark{
            margin: 50px;
            text-align:center;
            margin-top: -20px;
            /*border: 1px solid;*/
        }


        .master{
            margin: 0px;
            padding: 0px;
            height: 90%;
            width: 100%;
            /*border: 1px solid;*/
        }

        .l1{
            float: left;
            margin:30px;
            /*border: 1px solid;*/
        }

        .l2{
            float: right;
            margin:auto;
            /*border: 1px solid saddlebrown;*/
            /*height: 10%;*/
            width: 100%;
            margin-top: 65px;
        }



        .ls{
            width: 70%;
            height: 30%;
            margin: auto;
            /*border: 1px solid;*/
            display: flex;
        }



        /*.textarea1{*/
        /*!*float:right;*!*/
        /*margin-left: 20%;*/
        /*}*/

        /*.textarea2{*/
        /*!*float:left;*!*/
        /*margin-right: 20%;*/
        /*}*/



        .ls div{
            text-align: center;
            width:48%;
            /*border: 1px solid;*/
        }


        from textarea{
            /*border: 5px solid skyblue;*/
        }


        .submit{
            display: flex;
            align-items: center;
            flex: 1;
            justify-content: center;
            /*margin-top: -100px;*/
            /*border: 1px solid;*/
            /*height: 60%;*/
        }



        textarea{
            border:4px solid white;
        }

        .input_sub {
            width: 75px;
            height: 50px;
            background: skyblue;
            font-size: 20px;
            /*去掉submit按钮默认边框*/
            border: 0px;
            /*改成右浮动也是可以的*/
            float: left;
            color: white; /*搜索的字体颜色为白色*/
            cursor: pointer; /*鼠标变为小手*/
            border-radius: 10px;
        }

        .input_sub_clear{
            width: 75px;
            height: 50px;
            background: red;
            font-size: 20px;
            /*去掉submit按钮默认边框*/
            border: 0px;
            /*改成右浮动也是可以的*/
            float: left;
            color: white; /*搜索的字体颜色为白色*/
            cursor: pointer; /*鼠标变为小手*/
            border-radius: 10px;
        }

        /*分隔符*/
        body,ul,h3 {margin:0px; padding:0px;}
        li {list-style-type:none;}
        body{
            font-size:12px;
            color:#333;
            font-family: Simsun;
            line-height:15px;
        }
        a{text-decoration:none;color:#004285;border:none;}
        a:hover{text-decoration:none;color:#C33;}
        #menu {
            width:300px;
            margin:50px auto;
            padding:10px;
            border:#EEE 1px solid;
        }
        #menu h3 {
            font-size:12px;
        }
        #menu ul {
            background:url("img/ul-bg.gif") repeat-y 5px 0px; overflow:hidden;
        }
        #menu ul li {
            padding:5px 0 2px 15px;
            background:url("img/tree-ul-li.gif") no-repeat 5px -32px;
        }
        #menu ul li ul {display:none;}
        #menu ul li em {
            cursor:pointer;
            display:inline-block;
            width:15px;
            float:left;
            height:15px;
            margin-left:-14px;
            background:url("img/tree-ul-li.gif") no-repeat -32px 2px;
        }
        #menu ul li em.off {
            background-position: -17px -18px;
        }
        #menu ul li#end {
            background-color:#FFF;
        }
        #menu ul.off {
            display:block;
        }

    </style>
</head>

<body>
<div class="master">

    <%--<div class="l1">--%>
        <%--<div id="menu" style="float:left;margin-top: -35px">--%>
            <%--<h3>专利辅助工具功能介绍<font style="color: red">(初次使用强烈建议阅读)-在此声明：数据仅内存处理，不进行任何（保存）操作，请放心！</font></h3>--%>
            <%--<ul>--%>
                <%--<li><em></em><a href='javascript:void(0);'>(1)自动【生成】标号序列，无需手动(两种模式)</a>--%>
                    <%--<ul>--%>
                        <%--<li><a href='javascript:void(0);'>同特性[排序]，分类生成序列</a></li>--%>
                        <%--<li><a href='javascript:void(0);'>排序无规律，自然数递增</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>

                <%--<li><a href='javascript:void(0);'>(2)标号【事先去重】，防止叠堆标号</a>--%>
                <%--</li>--%>

                <%--<li><em></em><a href='javascript:void(0);'>(3)权利要求书【专利主题出现标号现象】清除</a>--%>
                    <%--<ul>--%>
                        <%--<li><a href='javascript:void(0);'>--%>
                            <%--<a href="/img/范例.jpg">--%>
                                <%--主权的主题名称和序号之间--%>
                                <%--<font style="color:green;">必须</font>--%>
                                <%--采用"."进行分隔--%>
                                <%--<font style="color:red;">(点击我前往查看案例)</font>--%>
                            <%--</a>--%>
                        <%--</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>

                <%--<li><a href='javascript:void(0);'>(4)具体实施例【专利主题标号】清除</a>--%>
                <%--</li>--%>

                <%--<li><a href='javascript:void(0);'>(5)逆向序列撰写、权要查错开发ing.....</a>--%>
                <%--</li>--%>

                <%--<li><em></em><a href='javascript:void(0);'><font color="red">初次使用必读</font></a>--%>
                    <%--<ul>--%>
                        <%--<li> <a href='javascript:void(0);'>(1)标号词组必须有</a></li>--%>
                        <%--<li ><a href='javascript:void(0);'>(2)词组按照两种模式中任意一项操作</a></li>--%>
                        <%--<li ><a href='javascript:void(0);'>(3)具体实施例、权利要求书【不需要都有】，有其一即可</a></li>--%>
                        <%--<li ><a href='javascript:void(0);'><font color="#fa8072">(4)ctrl+a全选，剪切、复制<font></a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<script type="text/javascript">--%>
        <%--(function(e){--%>
            <%--for(var _obj=document.getElementById(e.id).getElementsByTagName(e.tag),i=-1,em;em=_obj[++i];){--%>
                <%--em.onclick = function(){ //onmouseover--%>
                    <%--var ul = this.nextSibling;--%>
                    <%--if(!ul){return false;}--%>
                    <%--ul = ul.nextSibling; if(!ul){return false;}--%>
                    <%--if(e.tag != 'a'){ ul = ul.nextSibling; if(!ul){return false;} } //a 标签控制 隐藏或删除该行--%>
                    <%--for(var _li=this.parentNode.parentNode.childNodes,n=-1,li;li=_li[++n];){--%>
                        <%--if(li.tagName=="LI"){--%>
                            <%--for(var _ul=li.childNodes,t=-1,$ul;$ul=_ul[++t];){--%>
                                <%--switch($ul.tagName){--%>
                                    <%--case "UL":--%>
                                        <%--$ul.className = $ul!=ul?"" : ul.className?"":"off";--%>
                                        <%--break;--%>
                                    <%--case "EM":--%>
                                        <%--$ul.className = $ul!=this?"" : this.className?"":"off";--%>
                                        <%--break;--%>
                                <%--}--%>
                            <%--}--%>
                        <%--}--%>
                    <%--}--%>
                <%--}--%>
            <%--}--%>
        <%--})({id:'menu',tag:'em'});--%>
    <%--</script>--%>
        <a href="${pageContext.request.contextPath}/Rear-label-show.jsp" style="margin: 10px;"><font color="red">初次使用，图解说明！！</font></a>
    <div class="l2">
        <form action="/replace_Read-label" method="post">

            <%--如果为空,显示常态的  附图标记框--%>
            <c:if test="${empty cizu }">
                <div class="Reference-mark">
          <textarea name="Reference-mark" rows="8" cols="130" style="" placeholder="第①种方式：(有序)）
挡板、挡板扣、挡板轴、按压层、凸起、弧形部（回车另起一行）
气缸、气缸套、气缸轴

---------------------------------

第②种方式：（无序）
挡板、挡板扣、滑铲扣、滑铲轴、挡板轴、按压层、凸起、弧形部、滑铲"></textarea>
                </div>
            </c:if>

            <%--如果  不为空, 显示常态的  附图标记框--%>
            <c:if test="${not empty cizu }">
                <div class="Reference-mark">
                    <textarea name="Reference-mark" rows="8" cols="130" style="" >${cizu}</textarea>
                    <font size="4px" color="green">🏂</font>
                </div>
            </c:if>

            <%--选择序列--%>
            <div style="text-align: center; margin-top: -50px">
                <label><input name="Fruit" type="radio" value="Youxu" checked class="filed"/><font color="red">有序</font></label>
                <label><input name="Fruit" type="radio" value="WuXu" class="filed"/><font color="red">无序</font></label>
            </div>





            <%--权利要求书和说明书的替换  --%>
            <div class="ls">

                <%--如果为空--%>
                <c:if test="${empty claims }">

                    <div class="textarea1">
             <textarea name="right-claiming-document" rows="30" cols="55"  placeholder="请粘贴权利要求书内容

(无论说明书实施例有没有内容，不影响权利要求书的自动标号)
❤❤❤"></textarea>
                    </div>

                </c:if>

                <%--如果不为空--%>
                <c:if test="${not empty claims }">
                    <div>
                        <textarea name="right-claiming-document" rows="30" cols="55"  >${claims}</textarea>
                        <font size="4px" color="green">🏂</font>

                            <%--查看error是否为空--%>
                        <c:if test="${not empty error }">
                            <br>
                            <font color="red">主权的主题名称和序号之间采用"."进行分隔，否则无法实现主题标号清除!!!</font>
                        </c:if>

                    </div>
                </c:if>


                <div class="submit">
                    <input type="submit" value="替换" class="input_sub" style="">
                </div>


                <%--如果为空--%>
                <c:if test="${empty instructions }">

                    <div class="textarea2">
                    <textarea name="Replace-document" rows="30" cols="55"  placeholder="请粘贴说明书实施例内容

(无论权利要求书有没有内容，不影响说明书实施例的自动标号)
❤❤❤"></textarea>
                    </div>

                </c:if>

                <%--如果不为空--%>
                <c:if test="${not empty instructions }">
                    <div>
                        <textarea name="Replace-document" rows="30" cols="55" >${instructions}</textarea>
                        <font size="4px" color="green">🏂</font>
                    </div>
                </c:if>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/Rear-label.jsp" class="l3">
            <div class="submit" style="color: red">
                <input type="submit" value="重置" class="input_sub_clear" style="">
            </div>
        </form>
    </div>
</div>

<%--<div style="float: right;margin-top: -90px">--%>
    <%--<font size="3px">Bug/建议找<font size="10px">⇰</font></font><img src="img/++.png" style="width: 170px;height:170px">--%>
<%--</div>--%>
</body>

</html>
