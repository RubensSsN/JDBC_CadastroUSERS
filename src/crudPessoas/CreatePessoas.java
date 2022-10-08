package crudPessoas;

import java.util.Date;
import java.util.Scanner;

import br.com.pessoas.dao.PessoasDAO;
import pessoa.model.Pessoa;
import pessoa.model.ValidaCPF;

public class CreatePessoas {

    public static void getCreate() {

        PessoasDAO pessoasDao = new PessoasDAO();
        Scanner input = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();
        String CPF;

        System.out.println("Informe seu nome: ");
        String nome = input.next();
        pessoa.setNome(nome);

        System.out.println("Informe sua idade: ");
        int idade = input.nextInt();

        if(idade < 0 || idade > 120) {
            throw new RuntimeException("IDADE INVÁLIDA POR FAVOR TENTE NOVAMENTE");
        }else {
            pessoa.setIdade(idade);
        }

        pessoa.setDataCadastro(new Date());

        System.out.println("Informe sua Cidade: ");
        String cidade = input.next();
        pessoa.setEndereço(cidade);

        System.out.println("Informe seu CPF");
        CPF = input.next();
        if(ValidaCPF.isCPF(CPF) == true) {
            pessoa.setCPF(ValidaCPF.imprimeCPF(CPF));
            pessoasDao.save(pessoa);
            System.out.println("Pessoa cadastrada com sucesso!");
        } else {
            throw new RuntimeException("CPF INVÁLIDO POR FAVOR TENTE NOVAMENTE");
        }
    }
}