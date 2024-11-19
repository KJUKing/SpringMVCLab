<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-19
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h4>${message }</h4>
<h4>${uploadDTO }</h4>

<form:form method="post" enctype="multipart/form-data">
    <form:input path="uploader"/>
    <form:errors path="uploader"/>

    <form:input type="file" name="uploadFile"/>
    <form:errors path="uploadFile"/>
    <form:input path="saveNme" readonly="true"/>
    <button type="submit">업로드</button>
</form:form>