package servlets;

import dao.DaoCountryImpl;
import dto.Country;
import model.DaoCountry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletContries", urlPatterns = {"/Contries"})
public class ServletNotas extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");

        String accion = request.getParameter("accion");
        DaoCountry daoCountry = new DaoCountryImpl();

        if (accion == null) {
            request.getSession().setAttribute("msg",
                    "Solicitud no recibida.");
            response.sendRedirect("mensaje.jsp");

        } else if (accion.equals("QRY")) {

            List<Country> list = daoCountry.query();// aqui sde malograggggggggggggggggggggggg


            request.getSession().setAttribute("query", list);// ver q sale



            response.sendRedirect("view/ContriesQry.jsp");

        } else if (accion.equals("INS")) {
            String idcountry = request.getParameter("idcountry");
            String country = request.getParameter("country");



            Country paises = new Country();
            paises.setCountry_id(idcountry);
            paises.setCountry_name(country);



            String result = daoCountry.insert(paises);

            if (result == null) {
                List<Country> list = daoCountry.query();

                request.getSession().setAttribute("query", list);
                response.sendRedirect("view/ContriesQry.jsp");
            } else {
                request.getSession().setAttribute("msg", result);
                response.sendRedirect("mensaje.jsp");
            }

        } else if (accion.equals("DEL")) {
            String country_id = request.getParameter("country_id");

            String result = daoCountry.delete(country_id);

            if (result == null) {
                List<Country> list = daoCountry.query();

                request.getSession().setAttribute("query", list);
                response.sendRedirect("view/ContriesQry.jsp");
            } else {
                request.getSession().setAttribute("msg", result);
                response.sendRedirect("mensaje.jsp");
            }

        } else if (accion.equals("GET")) {
            String country_id = request.getParameter("country_id");

            Country paises = daoCountry.get(country_id);

            request.getSession().setAttribute("paises", paises);
            response.sendRedirect("view/ContriesUpd.jsp");

        } else if (accion.equals("UPD")) {
            String country_id = request.getParameter("country_id");
            String country_name = request.getParameter("country_name ");
            String region_id = request.getParameter("region_id");


            Country paises = new Country();
            paises.setCountry_id(country_id);
            paises.setCountry_name(country_name);
            paises.setRegion_id(Integer.valueOf(region_id));

            String result = daoCountry.update(paises);

            if (result == null) {
                List<Country> list = daoCountry.query();

                request.getSession().setAttribute("query", list);
                response.sendRedirect("view/ContriesQry.jsp");
            } else {
                request.getSession().setAttribute("msg", result);
                response.sendRedirect("mensaje.jsp");
            }
        }
     else {
            request.getSession().setAttribute("msg",
                    "Solicitud no reconocida.");
            response.sendRedirect("mensaje.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="doGet y doPost">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
