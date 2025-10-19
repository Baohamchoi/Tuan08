<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý điện thoại</title>
    <style>
        table {
            width: 90%;
            margin: 0 auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        a.btn {
            padding: 5px 10px;
            border-radius: 5px;
            color: white;
            text-decoration: none;
        }
        .btn-edit { background-color: #007bff; }
        .btn-delete { background-color: #dc3545; }
    </style>
</head>
<body>
<h2 style="text-align:center;">Quản lý sản phẩm điện thoại</h2>
<table>
    <thead>
    <tr>
        <th>Mã ĐT</th>
        <th>Tên ĐT</th>
        <th>Năm SX</th>
        <th>Cấu hình</th>
        <th>Nhà cung cấp</th>
        <th>Hình ảnh</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dt" items="${dts}">
        <tr>
            <td>${dt.maDt}</td>
            <td>${dt.tenDt}</td>
            <td>${dt.namSanXuat}</td>
            <td>${dt.cauHinh}</td>
            <td>${dt.nhaCungCap.tenNcc}</td>
            <td>
                <img src="${pageContext.request.contextPath}/uploads/${dt.hinhAnh}" width="70" height="70" alt="ảnh">
            </td>
            <td>
                <a href="/edit?id=${dt.maDt}" class="btn btn-edit">Sửa</a>
                <a href="${pageContext.request.contextPath}/delete?id=${dt.maDt}" class="btn btn-delete"
                   onclick="return confirm('Bạn có chắc muốn xóa điện thoại này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
