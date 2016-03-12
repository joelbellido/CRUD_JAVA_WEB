<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>com</title>
        <link href="../css/main.css" type="text/css" rel="stylesheet">
        <link href="../css/table.css" type="text/css" rel="stylesheet">
        <link href="../css/a.css" type="text/css" rel="stylesheet">

        <script src="../js/jquery-1.7.2.js" type="text/javascript"></script>
        <script src="../js/contry.js" type="text/javascript"></script>
    </head>
    <body>
        <div style="width:580px;margin:auto">
            <table class="clasico">
                <caption>
                    <a href="#" onclick="ins()">
                        <img src="../images/ins.png" 
                             align="top" title="Nuevo"/></a>&nbsp;&nbsp;
                    COUNTRY
                </caption>
                <thead>
                    <tr>
                        <td>ID COUNTRY</td>
                        <td>NAME COUNTRY</td>
                        <td>ID REGION</td>
                        <td style="width:20px">&nbsp;</td>
                        <td style="width:20px">&nbsp;</td>
                    </tr>
                </thead>

                <tfoot>
                    <tr>
                        <td colspan="7">
                            &iexcl;GRUPO JAVEROS
                        </td>
                    </tr>
                </tfoot>

                <tbody>

                    <c:forEach  var="n" items="${query}">
                        <tr>

                            <td style="text-align:center">${n.country_id}</td>
                            <td style="text-align:center">${n.country_name}</td>
                            <td style="text-align:center">${n.region_id}</td>

                            <th>
                                <a href="#" 
                                   onclick="upd('${n.country_id}')">
                                    <img src="../images/upd.png" 
                                         title="Actualizar"></a>
                            </th>
                            <th>
                                <a href="#" 
                                   onclick="del('${n.country_id}')">
                                    <img src="../images/del.png" 
                                         title="Retirar"></a>
                            </th>



                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

