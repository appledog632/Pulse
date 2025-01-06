<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Like List</title>
</head>
<body>
    <h1>Like List</h1>
    <a href="like?action=add">Add Like</a>
    <table border="1">
        <thead>
            <tr>
                <th>Like ID</th>
                <th>Post ID</th>
                <th>User ID</th>
                <th>Liked At</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="like" items="${likeList}">
                <tr>
                    <td>${like.likeId}</td>
                    <td>${like.postId}</td>
                    <td>${like.userId}</td>
                    <td>${like.likedAt}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
