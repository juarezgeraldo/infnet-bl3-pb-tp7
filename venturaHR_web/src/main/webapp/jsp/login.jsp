<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/jsp/header.jsp"></c:import>

		<body>

			<c:import url="/jsp/menu.jsp"></c:import>

			<div class="container">

				<c:if test="${not empty mensagem}">
					<div class="alert alert-danger">
						<strong>Problema!</strong> ${mensagem}
					</div>
				</c:if>

				<h2>Autenticação</h2>
				<form action="${pageContext.request.contextPath}/login" class="user" method="post">
					<div class="form-group">
						<label>E-mail:</label>
						<input value="juarez.junior@grupomult.com.br" type="email" class="form-control"
							placeholder="Entre com o seu e-mail" name="email">
					</div>

					<div class="form-group">
						<label>Senha:</label>
						<input value="123" type="password" class="form-control" placeholder="Entre com a sua senha"
							name="senha">
					</div>

					<button type="submit" class="btn btn-default">Acessar</button>
				</form>
			</div>

		</body>

		</html>