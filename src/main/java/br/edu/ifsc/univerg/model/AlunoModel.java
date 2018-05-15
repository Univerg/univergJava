package br.edu.ifsc.univerg.model;

public class AlunoModel {
	private String nome;
	private String cpf;
	private String rg;
	private String fone;
	private String cep;
	private String nascimento;
	private String endereco;
	private String cidade;
	private String email;
	private Long id_turma;
	private String login;
	private String senha;
	private String matricula;
	public AlunoModel(String nome, String cpf, String rg, String fone, String cep, String nascimento, String endereco,
			String cidade, String email, Long id_turma, String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.fone = fone;
		this.cep = cep;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.email = email;
		this.id_turma = id_turma;
		this.login = login;
		this.senha = senha;
	}
	
	public AlunoModel(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
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
	public Long getId_turma() {
		return id_turma;
	}
	public void setId_turma(Long id_turma) {
		this.id_turma = id_turma;
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
