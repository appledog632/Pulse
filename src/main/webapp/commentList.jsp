<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Comment List</title>
</head>
<body>
    <h1>Comment List</h1>
    <a href="comment?action=add">Add Comment</a>
    <table border="1">
        <thead>
            <tr>
                <th>Comment ID</th>
                <th>Post ID</th>
                <th>User ID</th>
                <th>Comment Text</th>
                <th>Created At</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="comment" items="${commentList}">
                <tr>
                    <td>${comment.commentId}</td>
                    <td>${comment.postId}</td>
                    <td>${comment.userId}</td>
                    <td>${comment.commentText}</td>
                    <td>${comment.createdAt}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
