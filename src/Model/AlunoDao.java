package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
	
	private Connection conexao ;

	//public AlunoDao(Connection conexao) throws SQLException{
		//this.conexao = conexao;
	//}
	
	public AlunoDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Dao dao = new Dao();
		this.conexao = dao.getConnection();
	}
	public boolean inserir(AlunoBean aluno) throws SQLException {
		
		String sql;
		PreparedStatement comando;
		sql = "insert into aluno (matricula, nome, logadouro, numero, bairro, cidade, uf, email, rg) values (?,?,?,?,?,?,?,?,?) ";
		comando = conexao.prepareStatement(sql);
		comando.setInt(1, aluno.getMatricula());
		comando.setString(2, aluno.getNome());
		comando.setString(3, aluno.getLogadouro());
		comando.setInt(4, aluno.getNumero());
		comando.setString(5, aluno.getBairro());
		comando.setString(6, aluno.getCidade());
		comando.setString(7, aluno.getUf());
		comando.setString(8, aluno.getEmail());
		comando.setString(9, aluno.getRg());
		comando.execute();
		conexao.close();
		return true;
	}

	public boolean alterar(AlunoBean aluno) throws SQLException {
		
		String sql;
		PreparedStatement comando;
		sql = "update aluno set nome = ?, logadouro = ?, numero = ?, bairro = ?, cidade = ?, uf = ?, email = ?, rg = ? where matricula = ?";
		comando = conexao.prepareStatement(sql);
		comando.setInt(9, aluno.getMatricula());
		comando.setString(1, aluno.getNome());
		comando.setString(2, aluno.getLogadouro());
		comando.setInt(3, aluno.getNumero());
		comando.setString(4, aluno.getBairro());
		comando.setString(5, aluno.getCidade());
		comando.setString(6, aluno.getUf());
		comando.setString(7, aluno.getEmail());
		comando.setString(8, aluno.getRg());
		comando.execute();
		conexao.close();
		return true;
	}

	public boolean deletar(int matricula) throws SQLException {
		
		String sql;
		PreparedStatement comando;
		sql = "delete from aluno where matricula = ?";
		comando = conexao.prepareStatement(sql);
		comando.setInt(1, matricula);
		comando.execute();
		conexao.close();
		return true;
	}

	public AlunoBean buscar(int matricula) throws SQLException {
		
		String sql;
		PreparedStatement comando;
		sql = "select * from aluno where matricula = ?";
		comando = conexao.prepareStatement(sql);
		comando.setInt(1, matricula);
		
		ResultSet resultado = comando.executeQuery();
		AlunoBean aluno = new AlunoBean();
		
		if (resultado.next()){
			aluno.setMatricula(resultado.getInt("matricula"));
			aluno.setNome(resultado.getString("nome"));
			aluno.setLogadouro(resultado.getString("logadouro"));
			aluno.setNumero(resultado.getInt("matricula"));
			aluno.setBairro(resultado.getString("bairro"));
			aluno.setCidade(resultado.getString("cidade"));
			aluno.setUf(resultado.getString("uf"));
			aluno.setEmail(resultado.getString("email"));
			aluno.setRg(resultado.getString("rg"));
		}
		
		conexao.close();
		return aluno;
	}

	public List<AlunoBean> listar() throws SQLException {
		
		AlunoBean aluno = new AlunoBean();
		List<AlunoBean> lista = new ArrayList<AlunoBean>();

		String sql;
		PreparedStatement comando;
		sql = "select * from aluno order by nome";
		comando = conexao.prepareStatement(sql);

		ResultSet resultado = comando.executeQuery();
		
		while (resultado.next()){
			aluno = new AlunoBean();
			
			aluno.setMatricula(resultado.getInt("matricula"));
			aluno.setNome(resultado.getString("nome"));
			aluno.setLogadouro(resultado.getString("logadouro"));
			aluno.setNumero(resultado.getInt("matricula"));
			aluno.setBairro(resultado.getString("bairro"));
			aluno.setCidade(resultado.getString("cidade"));
			aluno.setUf(resultado.getString("uf"));
			aluno.setEmail(resultado.getString("email"));
			aluno.setRg(resultado.getString("rg"));
			
			lista.add(aluno);
		}
		conexao.close();
		return lista;
	}

}
