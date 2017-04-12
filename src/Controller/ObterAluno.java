package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AlunoBean;
import Model.AlunoDao;

/**
 * Servlet implementation class ObterAluno
 */
@WebServlet("/detalhesaluno")
public class ObterAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AlunoBean aluno = new AlunoBean();
		
		try {
			
			AlunoDao alunoDao = new AlunoDao();
			aluno = alunoDao.buscar(Integer.parseInt(request.getParameter("matricula")));

			request.setAttribute("mensagem", "");
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NumberFormatException | SQLException e) {
			
			request.setAttribute("mensagem", "<p class=\"alert alert-danger\"><span>Erro ao encontrar aluno</span></p>");
			
		}
		
		request.setAttribute("aluno", aluno);
		request.getRequestDispatcher("/aluno.jsp").forward(request, response);

	}

}
