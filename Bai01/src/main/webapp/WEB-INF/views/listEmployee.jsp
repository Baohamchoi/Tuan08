<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2 style="display: flex; justify-content: center">DANH SÁCH NHÂN VIÊN</h2>
<div style="display: flex; flex-direction: row; justify-content: end; margin-right: 200px; margin-bottom: 20px; column-gap: 20px">
    <form:form action="openFormAdd" method="get">
        <button style="height: 40px; width: 180px; border-radius: 10px">Add new employee</button>
    </form:form>
    <form:form action="find" method="get">
        <input placeholder="Enter employee name ..." type="text" name="keyName" style="width: 400px; height: 32px; border-radius: 4px">
        <button type="submit" style="height: 40px; width: 180px; border-radius: 10px">Find employee</button>
    </form:form>
</div>
<div style="display: flex; justify-content: center">
        <table border="1" style="border: 1px solid black; border-collapse: collapse; width: 600px;">
            <tr style="">
                <th>Number</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Action</th>
            </tr>
            <c:forEach var="em" items="${employees}" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <c:if test="${em.id == idUpdate}">
                        <form:form action="actionUpdate" method="post">
                            <td>
                                <input type="text" name="firstName" value="${em.firstName}">
                            </td>
                            <td><input type="text" name="lastName" value="${em.lastName}"></td>

                            <td style="display: flex; justify-content: center; column-gap: 20px">
                                <input hidden type="text" name="id" value="${em.id}">
                                <button type="submit">Save</button>
                                <a style="color: red; text-decoration-line: none" href="/">Cancel</a>
                            </td>
                        </form:form>
                    </c:if>
                    <c:if test="${em.id != idUpdate}">
                        <td>${em.firstName}</td>
                        <td>${em.lastName}</td>
                            <td style="display: flex; justify-content: center; column-gap: 20px">
                                <a href="update?id=${em.id}">Update</a>
                                <a style="color: red; text-decoration-line: none" href="remove?id=${em.id}">Remove</a>
                            </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
</div>


</body>
</html>