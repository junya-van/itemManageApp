<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- ヘッダー --%>
<div class="header">
	<a href="${pageContext.request.contextPath}/LendingListServlet">貸出リスト</a>
	ようこそ<c:out value="${login.name}"/>さん
	<a href="#">ログアウト</a>
</div>