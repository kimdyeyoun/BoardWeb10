<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 등록</title>
</head>
<body>
    <h1>글 등록</h1>
    <form action="/board/write" method="post">
        <div><input type="text" name="title" placeholder="제목"></div>
        <div><textarea name="ctnt" placeholder="작성"></textarea> </div>
        <div>
            <input type="submit" value="등록">
            <input type="reset" value="초기화">
        </div>
    </form>

</body>
</html>