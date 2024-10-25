//package Servlets.Admin.Servlet;
//
//import DAO.AdmDAO;
//import com.example.servlettrocatine.Model.Adm;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(name = "BuscarAdmPorId", value = "/BuscarAdmPorId")
//    public class BuscarAdmPorId {
//
//
//
//        public  doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            AdmDAO adm = new AdmDAO();
//            adm.buscarAdmPorId(request, response);
//            buscarAdmPorId(request, response);
//        }
//
//        protected void buscarAdmPorId(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//            int id = Integer.parseInt(request.getParameter("id"));
//
//            AdmDAO dao = new AdmDAO();
//            Adm adm = dao.buscarAdmPorId(id);
//
//            if (adm != null) {
//                // Define o tipo de resposta (JSON, nesse caso)
//                response.setContentType("application/json");
//                response.setCharacterEncoding("UTF-8");
//
//                // Cria uma resposta JSON com os dados do administrador
//                String jsonResponse = String.format(
//                        "{\"nome\":\"%s\", \"email\":\"%s\", \"senha\":\"%s\", \"idusuario\":%d}",
//                        adm.getNome(), adm.getEmail(), adm.getSenha(), adm.getId()
//                );
//
//                // Envia a resposta JSON
//                response.getWriter().write(jsonResponse);
//            } else {
//                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Administrador não encontrado");
//
//            }
//        }
//   }
//}
//
//
