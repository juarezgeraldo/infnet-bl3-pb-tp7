<%@page import="br.edu.infnet.venturaHR_web.model.domain.Vaga" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html >

		<c:import url="/jsp/header.jsp"></c:import>

		<body>
			<c:import url="/jsp/menu.jsp"></c:import>

			<c:if test="${not empty mensagem_NOK}">
				<div class="alert alert-danger">
					<strong>Problema!</strong> ${mensagem_NOK}
				</div>
			</c:if>

			<div class="container">
				<h2>Cadastro de Vagas</h2>
				<form action="${pageContext.request.contextPath}/vaga-cadastro" method="post" class="vaga">
					<div class="form-group">
						<label>Data início:</label>
						<input type="date" class="form-control" name="dataInicio" value="${vaga.dataInicio}">
					</div>

					<div class="form-group">
						<label>Data final:</label>
						<input type="date" class="form-control" name="dataFinal" value="${vaga.dataFinal}">
					</div>

					<div class="form-group">
						<label>Titulo:</label>
						<input type="text" class="form-control" name="titulo" value="${vaga.titulo}">
					</div>

					<div class="form-group">
						<label>Descrição:</label>
						<input type="text" class="form-control" name="descricao" value="${vaga.descricao}">
					</div>

					<div class="form-group">
						<label>Bairro:</label>
						<input type="text" class="form-control" name="bairro" value="${vaga.bairro}">
					</div>

					<div class="form-group">
						<label>Cidade:</label>
						<input type="text" class="form-control" name="cidade" value="${vaga.cidade}">
					</div>

					<div class="form-group">
						<label>Estado:</label>
						<input type="text" class="form-control" name="estado" value="${vaga.estado}">
					</div>


					<button type="submit" class="btn btn-default">Cadastrar</button>
				</form>
			</div>

		</body>

		</html>