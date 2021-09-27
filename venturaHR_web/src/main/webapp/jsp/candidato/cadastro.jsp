<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="pt-BR">

		<c:import url="/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/jsp/menu.jsp"></c:import>

			<c:if test="${not empty mensagem_NOK}">
				<div class="alert alert-danger">
					<strong>Problema!</strong> ${mensagem_NOK}
				</div>
			</c:if>

			<div class="container">
				<h2>Cadastro de Candidato</h2>
				<form action="${pageContext.request.contextPath}/cadastro-candidato" method="post" class="user">
					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" placeholder="Entre com o nome do candidato" name="nome" value="${usuario.nome}">
					</div>

					<div class="form-group">
						<label>E-mail:</label>
						<input type="email" class="form-control" name="email" value="${usuario.email}">
					</div>

					<div class="form-group">
						<label>Senha:</label>
						<input type="password" class="form-control" name="senha" value="${usuario.senha}">
					</div>

					<div class="form-group">
						<label>CPF:</label>
						<input type="text" name="cpf" class="form-control" value="${usuario.cpf}">
					</div>

					<div class="form-group">
						<label>Telefone:</label>
						<input type="text" class="form-control" name="telefone" value="${usuario.telefone}">
					</div>

					<button type="submit" class="btn btn-default">Cadastrar</button>
				</form>
			</div>

		</body>

		</html>

