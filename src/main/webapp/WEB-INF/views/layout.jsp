
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Tiles에 의해 페이지 모듈화된 응답</h4>
<main>
    <tiles:insertAttribute name="content"/>
</main>
</body>
</html>
