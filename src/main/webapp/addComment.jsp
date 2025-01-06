<!DOCTYPE html>
<html>
<head>
    <title>Add Comment</title>
</head>
<body>
    <h1>Add Comment</h1>
    <form action="comment" method="post">
        <label for="postId">Post ID:</label>
        <input type="number" id="postId" name="postId" required><br>
        <label for="userId">User ID:</label>
        <input type="number" id="userId" name="userId" required><br>
        <label for="commentText">Comment:</label>
        <textarea id="commentText" name="commentText" required></textarea><br>
        <button type="submit">Add Comment</button>
    </form>
</body>
</html>
