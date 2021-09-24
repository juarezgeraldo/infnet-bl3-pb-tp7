<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<c:import url="/jsp/header.jsp"></c:import>
<table class="table table-borderless">

    <body>

    <c:import url="/jsp/menu.jsp"></c:import>

    <div class="container">

        <c:if test="${not empty mensagem}">
            <div class="alert alert-danger">
                <strong>Problema!</strong> ${mensagem}
            </div>
        </c:if>

        <tr>
            <td>
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
    </td>
    <td>
        <div class="container">
            <h3>Sistema de Recursos Humanos VenturaHR</h3>
            <h4>
						<span>VenturaSoft é uma HRTech que atua no segmento de recolocação de profissionais de
							TI.</span><br/>
                <span>Devido às peculiaridades desse mercado, os requisitos para contratação têm um dinamismo
							vertiginoso, </span><br/>
                <span>pois as tecnologias e as “stacks” adotadas pelas empresas estão em constante
							evolução.</span>
            </h4>
            <h4>O software VenturaHR foi desenvolvido para atender estas expectativas.</h4>
            <h4>
                <spam>As empresas, clientes da VenturaSoft, publicam suas vagas disponíveis através do
                    software
                    e
                </spam>
                <br/>
                <spam>os candidatos se registram, pesquisam as vagas de seu interesse e se candidatam a
                    estas
                    vagas.
                </spam>
            </h4>
            <br/><br/>
            <p><a href="${pageContext.request.contextPath}/jsp/empresa/cadastro.jsp">Se você for uma empresa
                e
                ainda
                não é cliente, clique aqui</a></p>
            <p><a href="${pageContext.request.contextPath}/jsp/candidato/cadastro.jsp">Se você for um
                candidato
                e ainda
                não é cadastrado, clique aqui</a></p>
        </div>
    </td>
    </tr>
    </tbody>
</table>

</html>