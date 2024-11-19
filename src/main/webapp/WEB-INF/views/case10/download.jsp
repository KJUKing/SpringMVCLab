<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-19
  Time: 오후 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>${message }</h4>
<h4>${uploadDTO }</h4>
<c:url value="/case10/download/${uploadDTO.saveName}" var="downloadUrl" />
<h4><a href="${downloadUrl}">다운로드 </a></h4>
