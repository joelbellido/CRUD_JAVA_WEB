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
            <input type="hidden" name="accion" value="INS">

            <fieldset>
                <legend>New Country</legend>

                <div>
                    <label style="width:70px">Id-Country</label>
                    <input type="text" name="idcountry"
                           id="idcountry" maxlength="50"
                           style="width:220px">
                </div>

                <div>
                    <label style="width:70px">Country</label>
                    <input type="text" name="country"
                           id="country" maxlength="50"
                           style="width:220px">
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
