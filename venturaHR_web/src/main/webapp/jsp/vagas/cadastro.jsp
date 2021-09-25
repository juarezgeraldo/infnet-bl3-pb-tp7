<%@page import="br.edu.infnet.venturaHR_web.model.domain.Vaga" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

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
    <form action="${pageContext.request.contextPath}/vaga-inclui" method="post" class="vaga">
        <div class="vaga mt-4">

            <div class="form-group">
                <div class="row ajusteRow">
                    <div class="col-md-6">
                        <label>Titulo:</label>
                        <input type="text" class="form-control" name="titulo" value="${vaga.titulo}">
                    </div>
                    <div class="col-md-6">
                        <label>Descrição:</label>
                        <input type="text" class="form-control" name="descricao" value="${vaga.descricao}">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="row ajusteRow">
                    <div class="col-md-4">
                        <label>Forma Contratação:</label>
                        <select class="form-control" name="formaContratacao" required>
                            <option></option>
                            <c:forEach var="forma" items="${formaContratacao}">
                                <option value="${forma}">${forma}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row ajusteRow">
                    <div class="col-md-4">
                        <label>Bairro:</label>
                        <input type="text" class="form-control" name="bairro" value="${vaga.bairro}">
                    </div>
                    <div class="col-md-4">
                        <label>Cidade:</label>
                        <input type="text" class="form-control" name="cidade" value="${vaga.cidade}">
                    </div>
                    <div class="col-md-2">
                        <label>Estado:</label>
                        <input type="text" class="form-control" name="estado" value="${vaga.estado}">
                    </div>
                </div>
            </div>

            <script type="text/javascript">
                var i = 0;

                function add() {
                    var clone = document.getElementById('criterio').cloneNode(true); // "deep" clone
                    clone.id = "criterio" + ++i;
                    // or clone.id = ""; if the divs don't need an ID
                    document.getElementById('criterio').parentNode.appendChild(clone);
                }

                function remove() {
                    var toDelete = document.getElementById('criterio' + i);
                    toDelete.remove();
                    i--;
                }
            </script>

            <div class="row ajusteRow">
                <div id="criterios">
                    <h4>Critérios</h4>
                    <div id="criterio">
                        <div class="row ajusteRow">
                            <div class="col-md-4">
                                <%--                            <div class="col-sm-10 mb-3 mb-sm-0">--%>
                                <input class="form-control" name="criteriosVaga.descricao" type="text"
                                       placeholder="Descriçao Critério"/>
                                <%--                            </div>--%>
                            </div>
                            <div class="col-md-4">
                                <%--                            <div class="col-sm-5 mb-3 mb-sm-0">--%>
                                <select class="form-control" name="criteriosVaga.pmd">
                                    <option value="">Selecione - PMD</option>
                                    <option value="DESEJAVEL">Desejável</option>
                                    <option value="DIFERENCIAL">Diferencial</option>
                                    <option value="RELEVANTE">Relevante</option>
                                    <option value="MUITO_RELEVANTE">Muito Relevante</option>
                                    <option value="OBRIGATORIO">Obrigatório</option>
                                </select>
                                <%--                            </div>--%>
                            </div>
                            <div class="col-md-2">
                                <%--                            <div class="col-sm-5 mb-3 mb-sm-0">--%>
                                <input class="form-control" name="criteriosVaga.peso" type="number"
                                       placeholder="Peso"/>
                                <%--                            </div>--%>
                            </div>
                        </div>
                        <hr style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid rgba(0, 0, 0, 0.1);"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <input class="btn btn-success" type="button" id="addrows" name="addrows"
                       value="+" onclick="add();">
                <input class="btn btn-danger" type="button" id="removerows" name="removerows"
                       value="-" onclick="remove();">
            </div>
        </div>
        <br/><br/>
        <button type="submit" class="btn btn-default">Cadastrar</button>
    </form>
</div>

</body>

</html>