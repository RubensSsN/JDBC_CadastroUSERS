package br.com.pessoa.aplicacao;

import crudPessoas.CreatePessoas;
import crudPessoas.DeletePessoa;
import pessoa.model.ListaPessoas;
import crudPessoas.UpdatePessoas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner choose = new Scanner(System.in);

		System.out.println("Bem vindo ao cadastro de pessoas!");

		try {
			int escolha;
			do {
				//Escolher opção
				System.out.println("Escolha uma opção");
				System.out.println("1 = Cadastrar pessoa || 2 = Listar || 3 = Atualizar Cadastro || 4 = Deletar Cadastro 0 = Sair");
				escolha = choose.nextInt();
				switch (escolha) {
					case 1:
						CreatePessoas.getCreate();
						break;

					case 2:
						ListaPessoas.listaPessoas();
						break;

					case 3:
						UpdatePessoas.update();
						break;

					case 4:
						DeletePessoa.getDelete();
						break;

					case 0:
						System.out.println("Saindo do programa... Até a próxima!");
						break;

					default:
						System.out.println("Opção Inválida");
				}

			} while (escolha != 0);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		choose.close();
	}
}