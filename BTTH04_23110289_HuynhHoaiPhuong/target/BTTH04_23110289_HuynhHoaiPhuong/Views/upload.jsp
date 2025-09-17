<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload Image</title>
</head>
<body>
<h2>Upload User Image</h2>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="text" name="username" placeholder="Username" required><br><br>
    <input type="file" name="imageFile" accept="image/*" required><br><br>
    <button type="submit">Upload</button>
</form>
</body>
</html>
