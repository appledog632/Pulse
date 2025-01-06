<!DOCTYPE html>
<html>
<head>
    <title>Add Post</title>
</head>
<body>
    <h1>Add Post</h1>
    <form action="post" method="post">
        <label for="userId">User ID:</label>
        <input type="number" id="userId" name="userId" required><br>
        <label for="imageUrl">Image URL:</label>
        <input type="text" id="imageUrl" name="imageUrl" required><br>
        <label for="caption">Caption:</label>
        <textarea id="caption" name="caption" required></textarea><br>
        <button type="submit">Add Post</button>
    </form>
</body>
</html>
