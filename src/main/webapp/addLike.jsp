<!DOCTYPE html>
<html>
<head>
    <title>Add Like</title>
</head>
<body>
    <h1>Add Like</h1>
    <form action="like" method="post">
        <label for="postId">Post ID:</label>
        <input type="number" id="postId" name="postId" required><br>
        <label for="userId">User ID:</label>
        <input type="number" id="userId" name="userId" required><br>
        <button type="submit">Add Like</button>
    </form>
</body>
</html>
