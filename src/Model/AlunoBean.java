package Model;


public class AlunoBean {

	int matricula,numero;
	String nome,logadouro,bairro,cidade,uf,email,rg;
	
	
	
	public AlunoBean() {
		
	}
	public AlunoBean(int matricula, String nome, String email, String rg, String logadouro, int numero, String bairro,
			String cidade, String uf) {
		
		this.matricula = matricula;
		this.numero = numero;
		this.nome = nome;
		this.logadouro = logadouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.rg = rg;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogadouro() {
		return logadouro;
	}
	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDadosHtml(){
		
		return  "Matricula: "+ this.matricula+"<br>" +
				"Nome: "+ this.nome+"<br>" +
				"Email: "+ this.email+"<br>" +
				"Rg: "+ this.rg+"<br>" +
				"Cidade: "+ this.cidade+"<br>" +
				"Bairro: "+ this.bairro+"<br>" +
				"Logadouro: "+ this.logadouro+"<br>" +
				"Numero: "+ this.numero+"<br>" +
				"UF: "+ this.uf+"<br>";
		
	}
	
	
}
