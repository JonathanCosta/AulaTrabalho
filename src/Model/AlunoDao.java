package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

	private Connection _conexao;
	private int _numPag = 1;
	private int _totalRows = 0;
	private String _sqlListar = "select * from aluno";

	// public AlunoDao(Connection conexao) throws SQLException{
	// this._conexao = conexao;
	// }

	public AlunoDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Dao dao = new Dao();
		this._conexao = dao.getConnection();
	}

	public boolean alterar(AlunoBean aluno) throws SQLException {

		String sql;
		PreparedStatement comando;
		sql = "update aluno set nome = ?, logadouro = ?, numero = ?, bairro = ?, cidade = ?, uf = ?, email = ?, rg = ? where matricula = ?";
		comando = this._conexao.prepareStatement(sql);
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

		return true;
	}

	public AlunoBean buscar(int matricula) throws SQLException {

		String sql;
		PreparedStatement comando;
		sql = "select * from aluno where matricula = ?";
		comando = this._conexao.prepareStatement(sql);
		comando.setInt(1, matricula);

		ResultSet resultado = comando.executeQuery();
		AlunoBean aluno = new AlunoBean();

		if (resultado.next()) {
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

		return aluno;
	}

	public void contar() throws SQLException {

		String sql;

		PreparedStatement comando;

		sql = "select count(*) as qtd from aluno";
		comando = this._conexao.prepareStatement(sql);

		ResultSet resultado = comando.executeQuery();

		if (resultado.next()) {

			this._totalRows = resultado.getInt("qtd");

		}

	}

	public boolean deletar(int matricula) throws SQLException {

		String sql;
		PreparedStatement comando;
		sql = "delete from aluno where matricula = ?";
		comando = this._conexao.prepareStatement(sql);
		comando.setInt(1, matricula);
		comando.execute();

		return true;
	}

	public void fecharConexao() throws SQLException {
		this._conexao.close();
	}

	public int getNumPag() {
		return _numPag;
	}
	public String getToString() {
		return this._sqlListar;
	}
	
	public boolean inserir(AlunoBean aluno) throws SQLException {

		String sql;
		PreparedStatement comando;
		sql = "insert into aluno (matricula, nome, logadouro, numero, bairro, cidade, uf, email, rg) values (?,?,?,?,?,?,?,?,?) ";
		comando = this._conexao.prepareStatement(sql);
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

		return true;
	}

	public List<AlunoBean> listar(int numPag, int qtdRows) throws SQLException {

		AlunoBean aluno = new AlunoBean();
		List<AlunoBean> lista = new ArrayList<AlunoBean>();

		String sql;

		PreparedStatement comando;

		sql = this._sqlListar + " order by nome  limit ?,?";

		comando = this._conexao.prepareStatement(sql);
		comando.setInt(1, numPag);
		comando.setInt(2, qtdRows);
		ResultSet resultado = comando.executeQuery();

		while (resultado.next()) {
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

		this.verificarNumPaginas(qtdRows);
		return lista;
	}

	private void verificarNumPaginas(int qtdRows) throws SQLException {
		this.contar();
		if (this._totalRows % qtdRows == 0)
			this._numPag = this._totalRows / qtdRows;
		else
			this._numPag = (this._totalRows / qtdRows) + 1;

	}

	public void setFiltro(String nome, String email, int matricula) {

		String sql = "";

		if (nome != null) {
			sql = sql+ " where nome like %" + nome + "%";
		}

		if (sql != "" && email != null) {
			sql = sql+" and email like %" + email + "%";
		} else if (email != null) {
			sql = sql+ " where email like %" + email + "%";
		}

		if (sql != "" && matricula < 0) {
			sql = sql+ " and matricula =" + matricula;
		} else if (matricula < 0) {
			sql= sql+ " where matricula =" + matricula;
		}

		this._sqlListar = this._sqlListar+sql;
	}
}
