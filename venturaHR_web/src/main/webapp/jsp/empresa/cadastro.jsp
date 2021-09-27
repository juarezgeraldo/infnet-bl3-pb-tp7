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
				<h2>Cadastro de Empresa</h2>
				<form action="${pageContext.request.contextPath}/cadastro-empresa" method="post" class="user">
					<div class="form-group">
						<label>Nome Usuário:</label>
						<input type="text" class="form-control" placeholder="Entre com o nome do usuário da Empresa" name="nome" value="${usuario.nome}">
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
						<label>CNPJ:</label>
						<input type="text" class="form-control" name="cnpj" value="${usuario.cnpj}">
					</div>

					<div class="form-group">
						<label>Razão Social:</label>
						<input type="text" class="form-control" name="razaoSocial" value="${usuario.razaoSocial}">
					</div>

					<button type="submit" class="btn btn-default">Cadastrar</button>
				</form>
			</div>

		</body>

		</html>