<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>No title at all</title>
</head>
<body>
	<header>
	<h1>Bem vindo ao cadastro de frases</h1>
	</header>
	<main>
	<div>
		<form method="post" action= ${pageContext.request.contextPath}/demo>
			Frase: <input type="text" name="phrase" /> <input type="submit"
				value="Salvar" />
		</form>
	</div>
	<div>
		<c:forEach var="phrase" items="${phrases}">
			<ul>
				<li>${phrase}</li>
			</ul>
		</c:forEach>
	</div>
	</main>
	<footer>
	<h3>Seu IP: ${ip}</h3>
	</footer>
</body>
</html>