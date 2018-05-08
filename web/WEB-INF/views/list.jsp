<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>电脑管理系统</title>

    <!--
	SpringMVC 处理静态资源:
	1. 为什么会有这样的问题:
	优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
	若将 DispatcherServlet 请求映射配置为 /, 
	则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理, 
	因找不到对应处理器将导致错误。
	<%--2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>--%>
-->
    <script type="application/javascript" src="../scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            });
        });
    </script>


</head>

<body  >
<center>
    <!-- 删除的提交方式 -->
    <form action=""  method="POST">
    <input type="hidden" name="_method" value="DELETE" >
    </form>

    <h1>
        新增电脑,请点击这里---><a href="computer"> 新增一台电脑</a>
    </h1>

    <c:if test="${empty requestScope.computers}">
        没有任何学生信息
    </c:if>

    <!-- 大括号之内的表达式随便空格,而双引号和表达式之间不能有任何的空格 -->
    <c:if test="${!empty requestScope.computers}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>brand</th>
                <th>cpu</th>
                <th>gpu</th>
                <th>ssd</th>
                <th>hdd</th>
                <th>memory</th>
                <th>price</th>
                <th>optime</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${requestScope.computers}" var="computer">
                <tr>
                    <td>${computer.id }</td>
                    <td>${computer.name }</td>
                    <td>${computer.brand}</td>
                    <td>${computer.cpu}</td>
                    <td>${computer.gpu}</td>
                    <td>${computer.ssd}</td>
                    <td>${computer.hdd}</td>
                    <td>${computer.memory}</td>
                    <td>${computer.price}</td>
                    <td>${computer.optime}</td>
                    <td><a href="computer/${computer.id}">修改</a></td>
                    <td>
                        <a  href="computer/computer/${computer.id}">删除</a>
                            <%--<form:form action="computer/${computer.id}"--%>
                                       <%--method="POST" modelAttribute="computer">--%>
                                <%--<input type="submit" value="shanchu">--%>
                            <%--<form:hidden path="id"/>--%>
                            <%--<input type="hidden" name="_method" value="DELETE"/>--%>
                            <%--</form:form>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br/>

</center>


</body>

</html>