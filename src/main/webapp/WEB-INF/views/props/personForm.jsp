<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h4>등록 폼</h4>

<form:form method="post" modelAttribute="person">
    <form:input path="id" placeholder="id" />
    <form:errors path="id"/>
    <form:input path="name" placeholder="이름"/>
    <form:errors path="name"/>
    <form:radiobutton path="gender" value="M"/>남
    <form:radiobutton path="gender" value="F" checked="true" />여
    <form:errors path="gender"/>
    <form:input type="number" path="age" placeholder="나이" />
    <form:errors path="age"/>
    <form:textarea path="address" placeholder="주소"  ></form:textarea>
    <form:errors path="address"/>
    <button type="submit">전송</button>
</form:form>
