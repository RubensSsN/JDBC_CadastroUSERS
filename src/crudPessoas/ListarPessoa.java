package crudPessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import normal_package.ConexaoDB;
import pessoa.model.Pessoa;

public class ListarPessoa {
	
		public static List<Pessoa> getPessoas(){

			System.out.println("Você está na aba de listagem de usuários!");
			
		String sql = "SELECT * FROM pessoas";
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConexaoDB.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(rset.getInt("id"));
				pessoa.setNome(rset.getString("nome"));
				pessoa.setIdade(rset.getInt("idade"));
				pessoa.setDataCadastro(rset.getDate("dataCadastro"));
				pessoa.setEndereço(rset.getString("Endereço"));
				
				pessoas.add(pessoa);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!= null) {
					rset.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pessoas;
	}
}
