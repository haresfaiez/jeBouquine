<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Home</h1>
<h2>Search for book</h2>
<form method="POST" action="/search">
    <input type="text" name="ISBN" id="find-book-by-isbn" /><br/>
    <input type="submit" value="search" />
</form>
</body>
</html>