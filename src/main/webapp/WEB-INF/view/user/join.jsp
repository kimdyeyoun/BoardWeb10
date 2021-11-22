<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <% if(msg != null) { %>
    <div class="err"><%=msg%></div>
    <% } %>
    <form action="/user/join" method="post">
        <div>아이디 <input type="text" name="uid" placeholder="아이디"></div>
        <div>비밀번호 <input type="password" name="upd" placeholder="비밀번호"></div>
        <div>이름 <input type="text" name="nm" placeholder="성명"></div>
        <div>
            gender : <label>여자 <input type="radio" name="gender" value="0"></label>
                     <label>남자 <input type="radio" name="gender" value="1"></label>
        </div>
        <div>
            <input type="submit" value="완료">
            <input type="reset" value="초기화">
        </div>
    </form>
</body>
</html>