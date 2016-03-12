
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link rel="stylesheet" href="../css/main.css">
        <link rel="stylesheet" href="../css/form.css">
        <link rel="stylesheet" href="../css/a.css">

        <script src="../js/jquery-1.7.2.js" type="text/javascript"></script>
        <script type="text/javascript" src="../js/contry.js"></script>
    </head>
    <body>
        <form class="clasico" action="../Notas" method="post"
              onsubmit="return valida()" style="width:330px">
            <input type="hidden" name="accion" value="UPD">
            <input type="hidden" name="idalumno" value="${notas.idalumno}">

            <fieldset>
                <legend>Actualizar datos de Alumno</legend>

                <div>
                    <label style="width:70px">Alumno</label>
                    <input type="text" name="alumno" 
                           value="${notas.alumno}"
                           id="alumno" maxlength="50"
                           style="width:220px">
                </div>

                <div>
                    <label style="width:70px">Notas</label>
                    <select name="nota1" style="margin-right:20px">
                        <c:forEach var="x" begin="0" end="20">
                            <c:choose>
                                <c:when test="${notas.nota1 == x}">
                                    <option value="${x}" selected>${x}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${x}">${x}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <select name="nota2" style="margin-right:20px">
                        <c:forEach var="x" begin="0" end="20">
                            <c:choose>
                                <c:when test="${notas.nota2 == x}">
                                    <option value="${x}" selected>${x}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${x}">${x}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <select name="nota3">
                        <c:forEach var="x" begin="0" end="20">
                            <c:choose>
                                <c:when test="${notas.nota3 == x}">
                                    <option value="${x}" selected>${x}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${x}">${x}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <label style="width:70px">Comentario</label>
                    <textarea 
                        name="comentario" rows="6" cols="40"
                        style="width:220px">${notas.comentario}</textarea>
                </div>

                <div class="center">
                    <input type="submit" value="Enviar Datos"
                           class="submit">
                </div>
            </fieldset>
        </form>

        <p style="text-align:center">
            <a class="clasico" href="ContriesQry.jsp">Cancelar</a>
        </p>
    </body>
</html>
