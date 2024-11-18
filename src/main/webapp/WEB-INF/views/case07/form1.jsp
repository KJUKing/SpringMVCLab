<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-18
  Time: 오후 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="person">
    <tr>
        <th>ID</th>
        <td>
            <form:input path="id" cssClass="form-control"/>
            <form:errors path="id" element="span" cssClass="text-danger"/>
        </td>
    </tr>
    <tr>
        <th>NAME</th>
        <td>
            <form:input path="name" cssClass="form-control"/>
            <form:errors path="name" element="span" cssClass="text-danger"/>
    </tr>
    <tr>
        <th>GENDER</th>
        <td>
            <form:input path="gender" cssClass="form-control"/>
            <form:errors path="gender" element="span" cssClass="text-danger"/>
        </td>
    </tr>
    <tr>
        <th>AGE</th>
        <td>
            <form:input type="number" path="age" cssClass="form-control"/>
            <form:errors path="age" element="span" cssClass="text-danger"/>
        </td>
    </tr>
    <tr>
        <th>ADDRESS</th>
        <td>
            <form:textarea path="address"/>
            <form:errors path="address" element="span" cssClass="text-danger"/>
        </td>
    </tr>
  <tr>
      <td colspan="2">
        <button type="submit">전송</button>
      </td>
  </tr>
</form:form>