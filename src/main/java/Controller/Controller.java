package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.DAO;

@WebServlet({ "/Controller", "/main", "/reserva", "/formulario", "/next", "/form" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	Cliente cliente;

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();

		if (action.equals("/main")) {

			response.sendRedirect("index.html");

		} else if (action.equals("/formulario")) {

			response.sendRedirect("form-dados-Pessoais.html");

		} else if (action.equals("/form-check")) {

		} else if (action.equals("/next") || action.equals("/reserva")) {
			
			if (action.equals("/next")) {
				
				cliente = new Cliente();
				cliente.setNome(request.getParameter("firstname"));
				cliente.setApelido(request.getParameter("lastname"));
				cliente.setNumeroDeBI(request.getParameter("BI"));
				cliente.setContacto(request.getParameter("number"));
				cliente.setNacionalidade(request.getParameter("nacionalidade"));
				cliente.setGenero(request.getParameter("gender"));
				cliente.setEmail(request.getParameter("email"));
				cliente.setId(dao.gerarId(dao.pegarIds()));
				
				
				
				response.sendRedirect("form-check.jsp");
				
			} else {
				cliente.setDataCheckin(request.getParameter("dataCheckin"));
				cliente.setDataCheckout(request.getParameter("dataCheckout"));
				cliente.setNrQuarto(103);
				
				dao.salvarReserva(cliente);
				dao.mudarStatus(cliente.getNrQuarto());
			

				System.out.println("reserva efectuada com sucesso salvo");
				response.sendRedirect("index.html");

			}

		}
	}

}
