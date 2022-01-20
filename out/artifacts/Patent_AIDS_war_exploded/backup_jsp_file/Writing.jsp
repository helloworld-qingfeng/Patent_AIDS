<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/1/19
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>
    var fso, ctf;
    fso = new ActiveXObject("Scripting.FileSystemObject");
    ctf = fso.CreateTextFile("c://test.txt", true);
    ctf.WriteLine("this is a test") ;
    ctf.WriteBlankLines(3) ;
    ctf.Write ("test string...");
    ctf.Close();
    </script>

</head>
<body>
<div class="Reference-mark" style="width: 90%;height: 90%;margin: 0 auto;">
<div style="margin:0 auto;text-align: center">
    <textarea name="Reference-mark" rows="60" cols="120" style="font-size:25px" placeholder="1.一种，其特征在于：
2.根据权利要求1所述的一种，其特征在于：
3.根据权利要求1所述的一种，其特征在于：
4.根据权利要求1所述的一种，其特征在于：
5.根据权利要求1所述的一种，其特征在于：
6.根据权利要求1所述的一种，其特征在于：
7.根据权利要求1所述的一种，其特征在于：
8.根据权利要求1所述的一种，其特征在于：
9.根据权利要求1所述的一种，其特征在于："></textarea>
</div>
</div>
</body>
</html>
