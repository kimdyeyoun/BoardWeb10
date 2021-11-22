<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String errMsg = (String)request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <style>
    </style>
    <link rel="stylesheet" href="resource/css/bootstrap.css">
</head>
<body>
<div id = "container" >
    <h1>로그인</h1>
    <% if (errMsg != null){ %>
    <div><%=errMsg%></div>
    <% } %>
    <div>
        <form action="/user/login" method="post">
            <div><input type = "text" name = "uid" placeholder="user id"></div>
            <div><input type = "password" name = "upd" placeholder="user passwored"></div>
            <div>
                <input type="submit" value="login">
            </div>
            <div>
                <a href="/user/join">join</a>
            </div>
        </form>
    </div>
    </div>
</div>
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="resource/js/bootstrap.js"></script>
</body>
</html>