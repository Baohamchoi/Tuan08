<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <style>
        .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 10px;
        }
        .card {
            border: 1px solid #ddd;
            border-radius: 10px;
            width: 220px;
            padding: 10px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        .card img {
            width: 100%;
            height: 180px;
            object-fit: contain;
        }
        .card h4 {
            margin: 10px 0 5px;
        }
        .card p {
            margin: 5px 0;
            font-size: 14px;
            color: #555;
        }
    </style>
</head>
<body>
<h2 style="text-align:center;">Danh sách sản phẩm điện thoại</h2>
<div class="card-container">
    <c:forEach var="dt" items="${dts}">
        <div class="card">
            <img src="${pageContext.request.contextPath}/uploads/${dt.hinhAnh}" alt="${dt.tenDt}">
            <h4>${dt.tenDt}</h4>
            <p>Năm SX: ${dt.namSanXuat}</p>
            <p>Cấu hình: ${dt.cauHinh}</p>
            <p>Nhà cung cấp: ${dt.nhaCungCap.tenNcc}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
