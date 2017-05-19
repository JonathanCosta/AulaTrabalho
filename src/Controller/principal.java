package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.AlunoBean;
import Model.AlunoDao;



public class principal {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
	
		List<AlunoBean> listaAlunos = new ArrayList<AlunoBean>();
		
			AlunoDao alunoDao = new AlunoDao();
			listaAlunos = alunoDao.listar(0, 0);
			
			for (AlunoBean aluno : listaAlunos){
				
				System.out.println(aluno.getBairro());
				
			}
		
		
		
	}
public static void inserir() {
	AlunoBean aluno = new AlunoBean();
	aluno.setMatricula(21);
	aluno.setNome("Jonathan");
	aluno.setLogadouro("Paulo Marcio");
	aluno.setNumero(175);
	aluno.setBairro("Eymard");
	aluno.setCidade("Belo Horizonte");
	aluno.setUf("MG");
	aluno.setEmail("teste@hotmail.com");
	aluno.setRg("14785341");
	
	AlunoDao dao;
	
	try {
		dao = new AlunoDao();
		dao.inserir(aluno);
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

