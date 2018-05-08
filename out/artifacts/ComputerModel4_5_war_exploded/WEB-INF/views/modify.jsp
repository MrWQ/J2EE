<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改</title>
</head>
<body>
<!--
    1. WHY 使用 form 标签呢 ?
    可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显
    2. 注意:
    可以通过 modelAttribute 属性指定绑定的模型属性,
    若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean
    如果该属性值也不存在，则会发生错误。
-->

<center>

    <!--
    这个action写成了绝对路径,是因为如果是相对路径,新建的时候没有问题,
    而修改的时候会有问题会变成student/student就无法映射了
-->
    <form:form action="${pageContext.request.contextPath}/computer"
               method="POST" modelAttribute="computer">
        <br/>

        <h1>修改学生信息：编号${requestScope.computer.id}</h1>
        <form:hidden path="id"/>
        <input type="hidden" name="_method" value="PUT"/>
        <br/>
        <br/>
        <br/>name：
        <form:input path="name"/>
        <br/>
        <br/>rand：
        <form:input path="brand"/>
        <br/>
        <br/>
        cpu：
        <form:input path="cpu"/>
        <br/>
        <br/>gpu：
        <form:input path="gpu"/>
        <br/>
        <br/>ssd：
        <form:input path="ssd"/>
        <br/>
        <br/>hdd：
        <form:input path="hdd"/>
        <br/>
        <br/> memory：
        <form:input path="memory"/>
        <br/>
        <br/>price：
        <form:input path="price"/>
        <br/>
        <br/>
        <br/>
        <input type="submit" value="确认"/>
    </form:form>

</center>
</body>
</html>