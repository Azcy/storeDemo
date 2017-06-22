<%--
  Created by IntelliJ IDEA.
  User: zcy
  Date: 2017/6/18
  Time: 下午4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <s:form action="login" method="POST" namespace="/content">
        <s:textfield label="用户名" name="user.username"/>
        <s:textfield label="密码" name="user.password"/>
        <s:submit label="提交"/>
    </s:form>
    <form action="login" method="post" >
        <input type="text" name="user.username" />
        <input type="text" name="user.password" />
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
