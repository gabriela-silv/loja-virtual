package aplication;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
		listaDeProdutos.add(new Produto("mouse", 1, 10));
		int opcao = 0;

		while (opcao != 6) {
			System.out.printf("Olá, seja bem-vindo(a) à Loja Virtual de aparelhos eletrônicos!%nNosso Menu: %n \n"
					+ "1) Listar produtos%n2) Cadastrar um novo produto%n3) Adicionar estoque ao produto%n4) Remover um produto da Loja%n5) Vender um produto"
					+ "%n6) Sair");

			opcao = scan.nextInt();
			scan.nextLine();

			System.out.println("");

			switch (opcao) {

			case 1: {
				int tamanhoProdutos = listaDeProdutos.size();
				int count = 1;
				if (tamanhoProdutos == 0) {
					System.out.println("Nenhum produto cadastrado no sistema!");
				} else {
					for (Produto produto : listaDeProdutos) {
						System.out.println(count + ") " + produto.toString());
						count++;
					}

				}
				System.out.println("");
			}
				break;

			case 2: {
				System.out.println("Digite o nome do novo produto: ");
				String nomeProduto = scan.nextLine();
				System.out.println("Digite o código do produto: ");
				int codigoProduto = scan.nextInt();
				if (listaDeProdutos.size() != 0) {
					for (int i = 0; i < listaDeProdutos.size(); i++) {
						if (listaDeProdutos.get(i).getCodigo() != codigoProduto) {
							Produto novoProduto = new Produto(nomeProduto, codigoProduto, 0);
							listaDeProdutos.add(novoProduto);
							System.out.println(nomeProduto + " cadastrado com sucesso. Código: " + codigoProduto
									+ ", Estoque: " + novoProduto.getQuantidade_estoque());
							break;
						} else {
							System.out.println(
									"Não é possível criar mais de um produto com o mesmo código, tente novamente com outro código.");
						}
					}
				} else {
					Produto novoProduto = new Produto(nomeProduto, codigoProduto, 0);
					listaDeProdutos.add(novoProduto);
					System.out.println(nomeProduto + " cadastrado com sucesso. Código: " + codigoProduto + ", Estoque: "
							+ novoProduto.getQuantidade_estoque());
				}

				System.out.println("");
			}
				break;

			case 3: {
				System.out.println("Digite o código do produto: ");
				int codigoProduto = scan.nextInt();
				Boolean isCodigo = false;
				for (int i = 0; i < listaDeProdutos.size(); i++) {
					if (listaDeProdutos.get(i).getCodigo() == codigoProduto) {
						System.out.println("Quantidade que será adicionada: ");
						int quantidade = scan.nextInt();
						listaDeProdutos.get(i)
								.setQuantidade_estoque(listaDeProdutos.get(i).getQuantidade_estoque() + quantidade);
						System.out.println("Estoque do produto atualizado com sucesso!");
						isCodigo = true;
						break;
					}
				}
				if (isCodigo == false) {
					System.out.println("Nenhum produto cadastrado no sistema com o código Informado!");
				}
				System.out.println("");
			}
				break;

			case 4: {
				System.out.println("Digite o código do produto: ");
				int codigoProduto = scan.nextInt();
				Boolean isCodigo = false;
				for (int i = 0; i < listaDeProdutos.size(); i++) {
					if (listaDeProdutos.get(i).getCodigo() == codigoProduto) {
						if (listaDeProdutos.get(i).getQuantidade_estoque() != 0) {
							System.out.println(
									"O produto informado ainda possui quantidade em estoque, deseja realmente remove-lo? Digite '1' para Sim ou '0' para Não");
							int resposta = scan.nextInt();
							if (resposta == 1) {
								listaDeProdutos.remove(i);
								System.out.println("Produto removido com sucesso!");
							} else {
								System.out.println("Produto mantido no sistema.");
							}
						} else {
							listaDeProdutos.remove(i);
							System.out.println("Produto removido com sucesso!");
						}
						isCodigo = true;
					}
				}
				if (isCodigo == false) {
					System.out.println("Nenhum produto cadastrado no sistema com o código Informado!");
				}
				System.out.println("");
			}
				break;

			case 5: {
				System.out.println("Digite o código do produto: ");
				int codigoProduto = scan.nextInt();
				Boolean isCodigo = false;
				for (int i = 0; i < listaDeProdutos.size(); i++) {
					if (listaDeProdutos.get(i).getCodigo() == codigoProduto) {
						System.out.println(
								"Informe a quantidade que será vendida (Obs: o estoque atual desse produto é de: "
										+ listaDeProdutos.get(i).getQuantidade_estoque() + "), digite a quantidade: ");
						int quantidade = scan.nextInt();

						if ((listaDeProdutos.get(i).getQuantidade_estoque() - quantidade) >= 0) {
							listaDeProdutos.get(i)
									.setQuantidade_estoque(listaDeProdutos.get(i).getQuantidade_estoque() - quantidade);
							System.out.println("Venda efetuada com sucesso!");
						} else {
							System.out.println("A quantidade desejada é insuficiente no estoque!");
						}
						isCodigo = true;
					}
				}
				if (isCodigo == false) {
					System.out.println("Nenhum produto cadastrado no sistema com o código Informado!");
				}
				System.out.println("");
			}
				break;

			case 6: {
				System.out.println("Obrigado por utilizar nosso sistema :) ");
			}
				break;
			}

		}
		scan.close();
	}

}
