<%@ page import="com.koreait.web_1.model.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% BoardVO vo = (BoardVO) request.getAttribute("data"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>디테일</title>
</head>
<body>
    <h1>디테일</h1>
    <div>번호 : <%=vo.getIboard()%></div>
    <div>제목 : <%=vo.getTitle()%></div>
    <div>내용 : <%=vo.getCtnt()%></div>
    <div>작성자 : <%=vo.getWriterNm()%></div>
    <div>작성시간 : <%=vo.getRdt()%></div>

</body>
</html>