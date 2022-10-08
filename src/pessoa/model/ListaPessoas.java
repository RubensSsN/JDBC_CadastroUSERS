package pessoa.model;

import crudPessoas.ListarPessoa;
import pessoa.model.Pessoa;

public class ListaPessoas {

    public static void listaPessoas() {

        for(Pessoa c : ListarPessoa.getPessoas()) {
            System.out.println("Nome: "+c.getNome() + " || Idade: "+c.getIdade() + " || Enderoço: "+c.getEndereço());
        }

    }

}
