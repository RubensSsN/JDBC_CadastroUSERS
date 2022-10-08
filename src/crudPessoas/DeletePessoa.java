package crudPessoas;

import normal_package.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeletePessoa {
    public static void getDelete() {

        String sql = "DELETE FROM pessoas WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoDB.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            Scanner input = new Scanner(System.in);

            System.out.println("Informe o id da pessoa a ser deletada!");

            int idpessoa = input.nextInt();
            pstm.setInt(1, idpessoa);
            System.out.println("ID: "+idpessoa + " Excluido com Sucesso!");
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
    }
}
