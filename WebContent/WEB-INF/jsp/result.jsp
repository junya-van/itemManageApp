<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 結果画面メイン部 --%>
<div class="msg">
	<c:out value="${resultMsg}"/>
</div>

<div class="result-link">
	<a href="${pageContext.request.contextPath}/MainServlet">アイテムリスト画面へ</a>
</div>
