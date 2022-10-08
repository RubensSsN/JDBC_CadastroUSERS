package pessoa.model;

import java.util.Date;

public class Pessoa {
	
	private int id;
	private String nome;
	private int idade;
	private Date dataCadastro;
	private String Endereço;

	private String CPF;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public java.sql.Date setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
		return null;
	}
	public String getEndereço() {
		return Endereço;
	}
	public void setEndereço(String endereço) {
		Endereço = endereço;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
}

