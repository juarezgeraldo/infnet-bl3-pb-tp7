<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<c:import url="/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/jsp/menu.jsp"></c:import>
			<div class="container">
				<h2>Cadastro de Usuários</h2>
				<c:if test="${not empty user}">
					<form action="/usuario/incluir" method="POST">

						<div class="form-group">
							<label>Nome:</label>
							<input type="text" class="form-control" placeholder="Entre com o nome do usuário"
								name="nome">
						</div>

						<div class="form-group">
							<label>E-mail:</label>
							<input type="email" class="form-control" name="email">
						</div>

						<div class="form-group">
							<label>senha:</label>
							<input type="password" class="form-control" name="senha">
						</div>

						<c:if test="${not empty user}">
							<c:if test="${user.admin}">
								<div class="form-group">
									<div class="radio">
										<label>O usuário é administrador?</label>
										<label> <input type="radio" name="admin" checked="checked" value="true">Sim</label>
										<label> <input type="radio" name="admin" value="false"> Não</label>
									</div>
								</div>
							</c:if>
						</c:if>
						<c:if test="${not empty user}">
							<div class="form-group">
								<label>Usuário responsável pelo cadastro:</label>
								<span>${user.id}</span>
								<span>${user.nome}</span>
								<span>${user.email}</span>
								<span>${user.admin}</span>
							</div>
						</c:if>

						<button type="submit" class="btn btn-default">Cadastrar</button>
					</form>
				</c:if>
				<c:if test="${empty user}">
					<form action="/usuario/incl" method="POST">

						<div class="form-group">
							<label>Nome:</label>
							<input type="text" class="form-control" placeholder="Entre com o nome do usuário"
								name="nome">
						</div>

						<div class="form-group">
							<label>E-mail:</label>
							<input type="email" class="form-control" name="email">
						</div>

						<div class="form-group">
							<label>senha:</label>
							<input type="password" class="form-control" name="senha">
						</div>

						<c:if test="${not empty user}">
							<c:if test="${user.admin}">
								<div class="form-group">
									<div class="radio">
										<label>O usuário é administrador?</label>
										<label> <input type="radio" name="admin" checked="checked">Sim</label>
										<label> <input type="radio" name="admin"> Não</label>
									</div>
								</div>
							</c:if>
						</c:if>
						<c:if test="${not empty user}">
							<div class="form-group">
								<label>Usuário responsável pelo cadastro:</label>
								<span>${user.id}</span>
								<span>${user.nome}</span>
								<span>${user.email}</span>
								<span>${user.admin}</span>
							</div>
						</c:if>

						<button type="submit" class="btn btn-default">Cadastrar</button>
					</form>
				</c:if>
			</div>

		</body>

		</html>