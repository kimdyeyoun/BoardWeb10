<%@ page import="com.koreait.web_1.model.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.koreait.web_1.model.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("data");
    UserVO loginUser = (UserVO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트</title>
    <style>
        table, th, td {
            border-collapse: initial;
            border: solid 1px #000;
        }
    </style>
</head>
<body>
    <h1>리스트</h1>
    <div>
        <% if(loginUser != null) { %>
        <%=loginUser.getNm()%>(<%=loginUser.getUid()%>)님 환영합니다. <a href="/user/logout">로그아웃</a>
        <a  href="/board/write"><input type="button" value="글쓰기"></a>
        <% } else { %>
        <a href="/user/login">로그인</a>
        <% } %>
    </div>
    <div>
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성시간</th>
            </tr>

            <% for (BoardVO vo : list){ %>
                <tr>
                    <td>
                        <a href="/board/detail?iboard=<%=vo.getIboard()%>">
                        <%=vo.getIboard() %>
                        </a>
                    </td>
                    <td><%=vo.getTitle() %></td>
                    <td><%=vo.getWriterNm() %></td>
                    <td><%=vo.getRdt() %></td>
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>