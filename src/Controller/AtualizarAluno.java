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
 * Servlet implementation class AtualizarAluno
 */
@WebServlet("/atualizaraluno")
public class AtualizarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
			AlunoBean aluno = new AlunoBean();
			boolean isEdit = false;
			
			try {
				
				AlunoDao alunoDao = new AlunoDao();
				aluno = alunoDao.buscar(Integer.parseInt(request.getParameter("matricula")));
				
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NumberFormatException | SQLException e) {
				
				request.setAttribute("mensagem", "<p class=\"alert alert-danger\">Erro ao encontrar aluno</p>");
				
			}		
			
			if(request.getParameter("nome") != aluno.getNome()){
				
				aluno.setNome(request.getParameter("nome") );
				isEdit = true;
				
			}
			
			if(request.getParameter("email") != aluno.getEmail()){
				
				aluno.setEmail(request.getParameter("email"));
				isEdit = true;
			}
			
			if(request.getParameter("rg") != aluno.getRg()){
				
				aluno.setRg(request.getParameter("rg"));
				isEdit = true;
			}
			
			if(request.getParameter("logadouro") != aluno.getLogadouro()){
				
				aluno.setLogadouro(request.getParameter("logadouro"));
				isEdit = true;
			}
			
			if(Integer.parseInt(request.getParameter("numero")) != aluno.getNumero()){
				
				aluno.setNumero(Integer.parseInt(request.getParameter("numero")));
				isEdit = true;
			}
			
			if(request.getParameter("bairro") != aluno.getBairro()){
				
				aluno.setBairro(request.getParameter("bairro"));
				isEdit = true;
			}
			
			if(request.getParameter("cidade") != aluno.getCidade()){
				
				aluno.setCidade(request.getParameter("cidade"));
				isEdit = true;
			}
			
			if(request.getParameter("uf") != aluno.getUf()){
				
				aluno.setUf(request.getParameter("uf"));
				isEdit = true;
			}				
		if(isEdit){						
			AlunoDao alunoDao;
			try {
				
				alunoDao = new AlunoDao();
				alunoDao.alterar(aluno);
				
				request.setAttribute("mensagem", "<p class=\"alert alert-success\">Aluno atualizado com sucesso</p>");
		        
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				
				request.setAttribute("mensagem", "<p class=\"alert alert-danger\">Erro ao atualizar aluno</p>" );
				
			} 
		}else{
			
			request.setAttribute("mensagem", "<p class=\"alert alert-warning\">Aluno não atualizado</p>");
			
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
