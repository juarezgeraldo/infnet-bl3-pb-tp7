<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>
		<c:import url="/jsp/header.jsp"></c:import>
		<body>
			<c:import url="/jsp/menu.jsp"></c:import>
			<c:if test="${not empty mensagem_OK}">
				<div class="alert alert-success">
					<strong>Problema!</strong> ${mensagem_OK}
				</div>
			</c:if>
			<c:if test="${not empty mensagem_NOK}">
				<div class="alert alert-danger">
					<strong>Problema!</strong> ${mensagem_NOK}
				</div>
			</c:if>


			<c:if test="${empty user}">
				<div class="container">
					<h3>Sistema de Recursos Humanos VenturaHR</h3>
					<h4>
						<span>VenturaSoft é uma HRTech que atua no segmento de recolocação de profissionais de
							TI.</span><br />
						<span>Devido às peculiaridades desse mercado, os requisitos para contratação têm um dinamismo
							vertiginoso, </span><br />
						<span>pois as tecnologias e as “stacks” adotadas pelas empresas estão em constante
							evolução.</span>
					</h4>
					<h4>O software VenturaHR foi desenvolvido para atender estas expectativas.</h4>
					<h4>
						<spam>As empresas, clientes da VenturaSoft, publicam suas vagas disponíveis através do software
							e
						</spam><br />
						<spam>os candidatos se registram, pesquisam as vagas de seu interesse e se candidatam a estas
							vagas.
						</spam>
					</h4>
					<br /><br />
					<p> <a href="${pageContext.request.contextPath}/jsp/empresa/cadastro.jsp">Se você for uma empresa e
							ainda
							não é cliente, clique aqui</a> </p>
					<p> <a href="${pageContext.request.contextPath}/jsp/candidato/cadastro.jsp">Se você for um candidato
							e ainda
							não é cadastrado, clique aqui</a> </p>
				</div>
			</c:if>
			<c:if test="${not empty user}">
				<div class="container">
					<h3>Bem vindo <span>${user.nome}</span></h3> <br />
					<h4>Selecione uma das opções do menu para executar suas tarefas.</h4>
				</div>
			</c:if>

		</body>

		</html>