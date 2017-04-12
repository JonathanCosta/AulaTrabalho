package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AlunoBean;
import Model.AlunoDao;

/**
 * Servlet implementation class ObterTodosAlunos
 */
@WebServlet("/obtertodosalunos")
public class ObterTodosAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<AlunoBean> listaAlunos = new ArrayList<AlunoBean>();
		
		try {
			
			AlunoDao alunoDao = new AlunoDao();
			listaAlunos = alunoDao.listar();
			request.setAttribute("mensagem", " ");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NumberFormatException | SQLException e) {
			
			request.setAttribute("mensagem", "<p class=\"alert alert-danger\">Erro ao buscar alunos</p>");
			
		}
				
		request.setAttribute("alunos", listaAlunos);
		request.getRequestDispatcher("/listaaluno.jsp").forward(request, response);
	
	}

}
