<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022-01-19
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="l1">
    <div id="menu" style="float:left;margin-top: -35px">
        <h3>专利辅助工具功能介绍<font style="color: red">(初次使用强烈建议阅读)-在此声明：数据仅内存处理，不进行任何（保存）操作，请放心！</font></h3>
        <ul>
            <li><em></em><a href='javascript:void(0);'>(1)自动【生成】标号序列，无需手动(两种模式)</a>
                <ul>
                    <li><a href='javascript:void(0);'>同特性[排序]，分类生成序列</a></li>
                    <li><a href='javascript:void(0);'>排序无规律，自然数递增</a></li>
                </ul>
            </li>

            <li><a href='javascript:void(0);'>(2)标号【事先去重】，防止叠堆标号</a>
            </li>

            <li><em></em><a href='javascript:void(0);'>(3)权利要求书【专利主题出现标号现象】清除</a>
                <ul>
                    <li><a href='javascript:void(0);'>
                        <a href="/img/范例.jpg">
                            主权的主题名称和序号之间
                            <font style="color:green;">必须</font>
                            采用"."进行分隔
                            <font style="color:red;">(点击我前往查看案例)</font>
                        </a>
                    </a></li>
                </ul>
            </li>

            <li><a href='javascript:void(0);'>(4)具体实施例【专利主题标号】清除</a>
            </li>

            <li><a href='javascript:void(0);'>(5)逆向序列撰写、权要查错开发ing.....</a>
            </li>

            <li><em></em><a href='javascript:void(0);'><font color="red">初次使用必读</font></a>
                <ul>
                    <li> <a href='javascript:void(0);'>(1)标号词组必须有</a></li>
                    <li ><a href='javascript:void(0);'>(2)词组按照两种模式中任意一项操作</a></li>
                    <li ><a href='javascript:void(0);'>(3)具体实施例、权利要求书【不需要都有】，有其一即可</a></li>
                    <li ><a href='javascript:void(0);'><font color="#fa8072">(4)ctrl+a全选，剪切、复制<font></a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<script type="text/javascript">
    (function(e){
        for(var _obj=document.getElementById(e.id).getElementsByTagName(e.tag),i=-1,em;em=_obj[++i];){
            em.onclick = function(){ //onmouseover
                var ul = this.nextSibling;
                if(!ul){return false;}
                ul = ul.nextSibling; if(!ul){return false;}
                if(e.tag != 'a'){ ul = ul.nextSibling; if(!ul){return false;} } //a 标签控制 隐藏或删除该行
                for(var _li=this.parentNode.parentNode.childNodes,n=-1,li;li=_li[++n];){
                    if(li.tagName=="LI"){
                        for(var _ul=li.childNodes,t=-1,$ul;$ul=_ul[++t];){
                            switch($ul.tagName){
                                case "UL":
                                    $ul.className = $ul!=ul?"" : ul.className?"":"off";
                                    break;
                                case "EM":
                                    $ul.className = $ul!=this?"" : this.className?"":"off";
                                    break;
                            }
                        }
                    }
                }
            }
        }
    })({id:'menu',tag:'em'});
</script>

</body>
</html>
