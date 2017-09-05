package myPackage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cria")
public class Cria extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 }
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
	 DAO dao = new DAO();
	 Notas nota = new Notas();
	 nota.setNome(request.getParameter("nome"));
	 nota.setText(request.getParameter("text"));

	 dao.adiciona(nota);
	 response.sendRedirect("jsp-index.jsp");
	 dao.close();
 }
}