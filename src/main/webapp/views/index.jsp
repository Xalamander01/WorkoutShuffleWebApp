<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<h1>This is the index JSP file
<hr>
<h2>Here is a list of all the users
<hr>
<ul>
<c:forEach items="${users}" var="user">
<li> user id: ${user.userId} username: ${user.username} Password: ${user.password} </li>
</c:forEach>
</ul>
</body>
</html>