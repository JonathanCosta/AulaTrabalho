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
 * Servlet implementation class AdicionarAluno
 */
@WebServlet("/adicionaraluno")
public class AdicionarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		AlunoBean aluno = new AlunoBean(
				Integer.parseInt(request.getParameter("matricula")),
				request.getParameter("nome"),
				request.getParameter("email"),
				request.getParameter("rg"),
				request.getParameter("logadouro"),
				Integer.parseInt(request.getParameter("numero")),
				request.getParameter("bairro"),
				request.getParameter("cidade"),
				request.getParameter("uf")
				);
			
		try {
			
			AlunoDao alunoDao = new AlunoDao();
			alunoDao.inserir(aluno);
			request.setAttribute("mensagem", "<p class=\"alert alert-success\" role=\"alert\">Aluno cadastrado com sucesso</p>" );
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		//	e.printStackTrace();
			request.setAttribute("mensagem", "<p class=\"alert alert-danger\" role=\"alert\">"+e.getMessage()+"</p>" );
			
		} 
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
