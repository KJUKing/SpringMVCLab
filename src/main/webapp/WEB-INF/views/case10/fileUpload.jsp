<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h4>${message }</h4>
<h4>${uploadDTO }</h4>

<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadDTO">
    <form:input path="uploader" />
    <form:errors path="uploader" />
    <input type="file" name="uploadFile" />
    <form:errors path="uploadFile" />
    <form:input path="saveName" readonly="true"/>
    <button type="submit">업로드</button>
</form:form>