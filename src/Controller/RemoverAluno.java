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
 * Servlet implementation class RemoverAluno
 */
@WebServlet("/removeraluno")
public class RemoverAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunoBean aluno = new AlunoBean();
		boolean isEdit = false;
		
		try {
			
			AlunoDao alunoDao = new AlunoDao();
			aluno = alunoDao.buscar(Integer.parseInt(request.getParameter("matricula")));
			isEdit = true;
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NumberFormatException | SQLException e) {
			
			request.setAttribute("mensagem", "<p class=\"alert alert-danger\">Erro ao encontrar aluno</p>");
			
		}	
		
		if(isEdit){
			try {
				
				AlunoDao alunoDao = new AlunoDao();
				alunoDao.deletar(aluno.getMatricula());
				request.setAttribute("mensagem", "<p class=\"alert alert-success\">Aluno Excluido</p>");
				
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NumberFormatException | SQLException e) {
				
				request.setAttribute("mensagem", "<p class=\"alert alert-danger\">Erro ao excluir aluno</p>");
				
			}
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
