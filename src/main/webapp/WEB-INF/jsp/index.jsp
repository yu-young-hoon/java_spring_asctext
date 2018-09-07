<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>asctext</title>
</head>
<body>
    <form method="post">
        <div>
            <h1>입력</h1>
            <textarea name="text"><c:out value="${result.originText}"></c:out></textarea>
        </div>
        <div>
            <h1>출력묶음단위</h1>
            <input name="unit" type="number" value="<c:out value="${result.outUnit}"></c:out>"/>
        </div>
        <input type="submit" value="출력"/>
    </form>
    <div style="background: rgb(240, 240, 240)">
        <h1>몫</h1>
        <div>
            <c:out value="${result.resultText}"/>
        </div>
    </div>
    <div style="background: rgb(240, 240, 240)">
        <h1>나머지</h1>
        <di>
            <c:out value="${result.tailText}"/>
        </div>
    </div>
</body>
</html>