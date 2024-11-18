<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        #new-person{
            background-color: red;
        }
    </style>
</head>
<body>
<%-- ${list } --%>
<a href="<c:url value='/props/personInsert.do'/>">신규등록</a>
<table>
    <thead>
    <tr>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty personList }">
        <c:forEach items="${personList }" var="person">
            <c:choose>
                <c:when test="${person eq newPerson }">
                    <c:set var="idValue" value="id='new-person'"/>
                </c:when>
                <c:otherwise>
                    <c:set var="idValue" value=""/>
                    <!-- 				// flash attribute -->
                </c:otherwise>
            </c:choose>
            <tr ${idValue }>
                <td>
                    -->
                    <c:url value="/props/personDetail.do" var="detailUrl">
                        <c:param name="who" value="${person.id }"/>
                    </c:url>
                    <a href="${detailUrl }">${person.name }</a>
                </td>
                <td>${person.gender }</td>
                <td>${person.age }</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty personList }">
        <tr>
            <td colspan="3">등록된 person 이 없음.</td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>








