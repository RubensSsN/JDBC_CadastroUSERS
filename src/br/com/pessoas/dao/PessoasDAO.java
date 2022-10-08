package br.com.pessoas.dao;

import java.sql.Connection;
import java.sql.Date;

import normal_package.ConexaoDB;
import pessoa.model.Pessoa;

public class PessoasDAO {

	public void save(Pessoa pessoa) {
		
		String sql = "INSERT INTO pessoas(nome, idade, dataCadastro, Endereço, CPF) VALUES(?, ?, ?, ?, ?)";
		
		Connection conn = null;
		java.sql.PreparedStatement pstm = null;
		try {
			//Criar uma conexão com o banco de dados
			conn = ConexaoDB.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setDate(3, new Date(pessoa.getDataCadastro().getTime()));
			pstm.setString(4, pessoa.getEndereço());
			pstm.setString(5, pessoa.getCPF());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
