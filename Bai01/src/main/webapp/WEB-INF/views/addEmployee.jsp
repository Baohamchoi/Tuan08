<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Employee</title>
</head>
<body>
    <div style="display: flex; justify-content: center">
       <h2>ADD NEW EMPLOYEE</h2>
    </div>
    <form:form action="add" method="get">
    <div style="display: flex; flex-direction: column; row-gap: 20px; align-items: center; margin-top: 20px">
            <div>
                <label>First Name: </label>
                <input style="height: 30px; width: 300px" type="text" name="firstName">
            </div>
            <div>
                <label>Last Name: </label>
                <input style="height: 30px; width: 300px" type="text" name="lastName">
            </div>
            <div>
                <button type="submit" style="height: 30px; width: 200px; background-color: green; color: white">Submit create employee</button>
            </div>
    </div> </form:form>
</body>
</html>