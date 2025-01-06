<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post List</title>
</head>
<body>
    <h1>Post List</h1>
    <a href="post?action=add">Add Post</a>
    <table border="1">
        <thead>
            <tr>
                <th>Post ID</th>
                <th>User ID</th>
                <th>Image URL</th>
                <th>Caption</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${postList}">
                <tr>
                    <td>${post.postId}</td>
                    <td>${post.userId}</td>
                    <td>${post.imageUrl}</td>
                    <td>${post.caption}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
