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
		int pag = 1;
		int matricula=0,offset = 0,rows = 4;
		//String nome = request.getParameter("nome"),email = request.getParameter("email");

		
		if(request.getParameter("pag") != null)
			pag = Integer.parseInt(request.getParameter("pag"));
		
		if(request.getParameter("rows") != null)
			rows = Integer.parseInt(request.getParameter("rows"));
			
		
		if(request.getParameter("matricula") != null)
			matricula = Integer.parseInt(request.getParameter("matricula"));
		
		if(pag<=0)pag = 1;



		if(rows<=4)rows = 4;

		if(pag>1){
			offset = rows*(pag-1);
		}		

		//request.setAttribute("formAction", "obtertodosalunos?pag="+pag);
		
		try {

			AlunoDao alunoDao = new AlunoDao();
			
			alunoDao.setFiltro("ala",null,matricula);
			
			
			listaAlunos = alunoDao.listar(offset, rows);
			request.setAttribute("numPag", alunoDao.getNumPag());
			request.setAttribute("rowsAtual", rows);
			request.setAttribute("paginaAtual", pag);
			request.setAttribute("mensagem", alunoDao.getToString());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NumberFormatException | SQLException e) {

			request.setAttribute("mensagem", "<p class=\"alert alert-danger\">Erro ao buscar alunos</p>");

		}

		request.setAttribute("alunos", listaAlunos);
		request.getRequestDispatcher("/listaaluno.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
		
		
	}
}
