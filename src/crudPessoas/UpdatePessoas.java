package crudPessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import normal_package.ConexaoDB;
import pessoa.model.Pessoa;

public class UpdatePessoas extends Pessoa {

		public static void update(){

			Pessoa pessoa = new Pessoa();

			Connection conn = null;
			PreparedStatement pstm = null;

			try {
				conn = ConexaoDB.createConnectionToMySQL();


				//Adicionando os valores
				Scanner input = new Scanner(System.in);

				System.out.println("Informe o campo que deseja alterar");
				System.out.println("1 = Nome, 2 = Idade, 3 = Endereço");
				int escolha = input.nextInt();

				if (escolha == 1) {
					String sql = conn.nativeSQL("UPDATE pessoas SET nome = ? WHERE id = ?");
					pstm = conn.prepareStatement(sql);
					System.out.print("Informe o nome: ");
					String name = input.next();
					pstm.setString(1, name);
					System.out.println("Id que deseja alterar");
					int idvalue = input.nextInt();
					pstm.setInt(2, idvalue);
					pstm.execute();
					System.out.println("O id: "+idvalue+" Foi alterado!");
				}
				if (escolha == 2) {
					String sql = conn.nativeSQL("UPDATE pessoas SET idade = ? WHERE id = ?");
					pstm = conn.prepareStatement(sql);
					System.out.println("Informe a idade: ");
					int idade = input.nextInt();
					pstm.setInt(1, idade);
					System.out.println("Id que deseja alterar");
					int idvalue = input.nextInt();
					pstm.setInt(2, idvalue);
					pstm.execute();
					System.out.println("O id: "+idvalue+" Foi alterado!");
				}
				if (escolha == 3) {
					String sql = conn.nativeSQL("UPDATE pessoas SET Endereço = ? WHERE id = ?");
					pstm = conn.prepareStatement(sql);
					System.out.println("Informe o novo endereço: ");
					String endereco = input.next();
					pstm.setString(1, endereco);
					System.out.println("Id que deseja alterar");
					int idvalue = input.nextInt();
					pstm.setInt(2, idvalue);
					pstm.execute();
					System.out.println("O id: "+idvalue+" Foi alterado!");
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

}
