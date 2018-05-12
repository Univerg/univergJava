package br.edu.ifsc.univerg.model;

public class ProfessorModel {
	private String nome;
	private String cpf;
	private String rg;
	private String fone;
	private String cep;
	private String nascimento;
	private String endereco;
	private String cidade;
	private String email;
	private String especializacao;
	private String login;
	private String senha;
	private String matricula;
	public ProfessorModel(String nome, String cpf, String rg, String fone, String cep, String nascimento,
			String endereco, String cidade, String email, String especializacao, String login,
			String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.fone = fone;
		this.cep = cep;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.email = email;
		this.especializacao = especializacao;
		this.login = login;
		this.senha = senha;
	}
	
	public ProfessorModel(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public ProfessorModel(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEspecializacao() {
		return especializacao;
	}
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
