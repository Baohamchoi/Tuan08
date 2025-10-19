<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Trang chủ - Fango HomePhone</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .header img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .nav {
            display: flex;
            justify-content: center;
            column-gap: 20px;
            margin: 15px 0;
            font-size: 16px;
        }

        .nav a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        .nav a:hover {
            text-decoration: underline;
            color: #0056b3;
        }

        .content {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 100px;
        }

        iframe {
            width: 90%;
            height: 650px;
            border: none;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }

        .footer {
            position: fixed;
            bottom: 0;
            border-top: 1px solid black;
            width: 100%;
            display: flex;
            justify-content: center;
            background: #f5f5f5;
            padding: 5px 0;
        }
    </style>
</head>
<body>

<div class="header">
    <img src="${pageContext.request.contextPath}/images/547ba86f52f717102d6e50bf5db4275ba81c0b6c.png" alt="Banner">
</div>

<div class="nav">
    <a href="${pageContext.request.contextPath}/list" target="mainFrame">Danh sách sản phẩm</a> |
    <a href="${pageContext.request.contextPath}/add" target="mainFrame">Thêm mới sản phẩm</a> |
    <a href="${pageContext.request.contextPath}/manage" target="mainFrame">Chức năng quản lý</a>
</div>

<div class="content">
    <iframe name="mainFrame"
            src="${pageContext.request.contextPath}/list"
            width="100%" height="600px" frameborder="0"></iframe>
</div>

<div class="footer">
    <p>Nguyễn Huỳnh Thế Bảo - 22690761 - DTKTPM18CTT</p>
</div>

</body>
</html>
