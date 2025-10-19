<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm / Sửa điện thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f7f9fc;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 40px;
            margin: 0;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
            text-align: center;
        }
        .form-container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            width: 450px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        td {
            padding: 10px;
            vertical-align: top;
        }
        td:first-child {
            text-align: right;
            width: 35%;
            color: #333;
            font-weight: bold;
        }
        form input[type="text"],
        form input[type="number"],
        form textarea,
        form select {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 14px;
        }
        form input[type="file"] {
            margin-top: 5px;
        }
        .btn-submit {
            background-color: #007bff;
            border: none;
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 15px;
            transition: background-color 0.2s;
        }
        .btn-submit:hover {
            background-color: #0056b3;
        }
        form:errors {
            color: red;
            font-size: 13px;
        }
        .back-link {
            margin-top: 20px;
            text-align: center;
        }
        .back-link a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>Thêm hoặc chỉnh sửa điện thoại</h2>

<div class="form-container">
    <%-- form:form sẽ tự bind thuộc tính với modelAttribute "dienThoai" --%>
    <form:form action="${pageContext.request.contextPath}/add"
               method="post"
               modelAttribute="dienThoai"
               enctype="multipart/form-data">

        <table>
            <tr>
                <td>Mã:</td>
                <td>
                    <form:input path="maDt" />
                    <form:errors path="maDt" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Tên:</td>
                <td>
                    <form:input path="tenDt" />
                    <form:errors path="tenDt" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Năm SX:</td>
                <td>
                    <form:input path="namSanXuat" type="number" />
                    <form:errors path="namSanXuat" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Cấu hình:</td>
                <td>
                    <form:textarea path="cauHinh" rows="3" cols="30" />
                    <form:errors path="cauHinh" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Nhà cung cấp:</td>
                <td>
                    <select name="maNcc">
                        <option value="">--Chọn--</option>
                        <c:forEach var="n" items="${suppliers}">
                            <option value="${n.maNcc}"
                                    <c:if test="${dienThoai.nhaCungCap != null && dienThoai.nhaCungCap.maNcc == n.maNcc}">
                                        selected
                                    </c:if>>
                                    ${n.tenNcc}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Hình ảnh:</td>
                <td><input type="file" name="file" accept=".png,.jpg,.jpeg" /></td>
            </tr>

            <tr>
                <td></td>
                <td style="text-align: right;">
                    <input type="submit" value="💾 Lưu" class="btn-submit" />
                </td>
            </tr>
        </table>
    </form:form>
</div>

<div class="back-link">
    <p><a href="${pageContext.request.contextPath}/manage">← Quay lại danh sách</a></p>
</div>

</body>
</html>
