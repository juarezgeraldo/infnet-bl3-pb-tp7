<%@page import="br.edu.infnet.venturaHR_web.model.domain.Vaga" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:import url="/jsp/header.jsp"></c:import>

<body>
<c:import url="/jsp/menu.jsp"></c:import>
<div class="container">

    <%--						<a href="${pageContext.request.contextPath}/jsp/vagas/cadastro.jsp">--%>
    <%--							Incluir--%>
    <%--						</a>--%>

<%--    <form action="${pageContext.request.contextPath}/vaga-cadastro" method="GET">--%>
<%--        <button type="submit" class="btn btn-link">Incluir</button>--%>
<%--    </form>--%>
    <hr>

    <c:if test="${not empty lista}">
        <c:if test="${not empty mensagem}">
            <c:if test="${idMensagem == 'sucesso'}">
                <div class="alert alert-success">
                    <strong>Sucesso!</strong> ${mensagem}
                </div>
            </c:if>
            <c:if test="${idMensagem != 'sucesso'}">
                <div class="alert alert-danger">
                    <strong>ERRO!</strong> ${mensagem}
                </div>
            </c:if>
        </c:if>

        <h4>Quantidade de vagas cadastradas: ${lista.size()}!!!</h4>

        <hr>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Título</th>
                <th>Contratação</th>
                <th>PMD Vaga</th>
                <th>Status</th>
                <th>Ação</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="a" items="${lista}">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.titulo}</td>
                    <td>${a.formaContratacao}</td>
                    <td>${a.pmdCalculado}</td>
                    <td style="text-align:center">${a.statusVaga}</td>
                    <td style="text-align:center">
                        <a href="/vagas/${a.id}/excluir">Excluir</a>
                        <form action="${pageContext.request.contextPath}/cadastro-vaga"
                              method="DELETE">
                            <button type="submit" class="btn btn-link">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty lista}">
        <h4>Não há vagas cadastradas!!!</h4>
    </c:if>
</div>
</body>

</html>