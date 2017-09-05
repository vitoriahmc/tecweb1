package myPackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lista")
public class Lista extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void service(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
DAO dao = new DAO();
List<Notas> nota = dao.getLista();
PrintWriter out = response.getWriter();
out.println("<html><body><table border='1'>");
out.println("<tr><td>ID</td><td>Nome</td>" +
 "<td>Nota</td></tr>");
for (Notas notas : nota) {
 out.println("<tr><td>" + notas.getId() + "</td>");
 out.println("<td>" + notas.getNome() + "</td>");
 out.println("<td>" + notas.getText() + "</td></tr>");
}
out.println("</table></body></html>");

dao.close();
 }
}