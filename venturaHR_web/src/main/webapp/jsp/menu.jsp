<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${user}
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">VenturaHR</a>
        </div>
        <ul class="nav navbar-nav">
            <li>
                <a href="${pageContext.request.contextPath}/jsp/index.jsp">
                    <span class="glyphicon glyphicon-home"></span>
                    Home
                </a>
            </li>
            <c:if test="${not empty usuarioLogado}">
                <c:if test="${usuarioLogado == true}">
                    <c:if test="${user.tipoConta == 'ADMIN'}">
                        <li>
                            <a href="${pageContext.request.contextPath}/jsp/admin/lista.jsp">
                                <span class="glyphicon glyphicon-user"></span>
                                Usuários
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${user.tipoConta == 'EMPRESA'}">
                        <li>
                            <form action="${pageContext.request.contextPath}/vaga-lista" method="GET">
                                <button type="submit" class="btn btn-link">
                                    Vagas publicadas
                                    <span class="glyphicon glyphicon-lock"></span>
                                </button>
                                    <%--									<div action="${pageContext.request.contextPath}/cadastro-vaga" method="GET">--%>
                                    <%--										<a href="${pageContext.request.contextPath}/jsp/empresa/lista.jsp"--%>
                                    <%--											type="submit">--%>
                                    <%--											<span class="glyphicon glyphicon-lock"></span>--%>
                                    <%--											Vagas publicadas--%>
                                    <%--										</a>--%>
                                    <%--									</div>--%>
                        </li>
                        </form>
                    </c:if>
                    <c:if test="${user.tipoConta == 'CANDIDATO'}">
                        <li>
                            <a href="${pageContext.request.contextPath}/jsp/candidato/lista.jsp">
                                <span class="glyphicon glyphicon-lock"></span>
                                Vagas candidatadas
                            </a>
                        </li>
                    </c:if>
                </c:if>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${not empty usuarioLogado}">
                <c:if test="${usuarioLogado == false}">
                    <li>
                        <a href="${pageContext.request.contextPath}/jsp/login.jsp">
                            <span class="glyphicon glyphicon-log-in"></span>
                            Login no VenturaHR
                        </a>
                    </li>
                </c:if>
            </c:if>
            <c:if test="${empty usuarioLogado}">
                <li>
                    <a href="${pageContext.request.contextPath}/jsp/login.jsp">
                        <span class="glyphicon glyphicon-log-in"></span>
                        Login no VenturaHR
                    </a>
                </li>
            </c:if>
            <c:if test="${not empty usuarioLogado}">
                <c:if test="${usuarioLogado == true}">
                    <li action="${pageContext.request.contextPath}/logout" method="GET">
                        <a href="${pageContext.request.contextPath}/jsp/index.jsp">
                            <span class="glyphicon glyphicon-log-out"></span>
                            Finalizar, ${user.nome}!
                        </a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </div>
</nav>