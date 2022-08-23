package br.atividade.testes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class Principal {

	
	public static void styleInput() {
		System.out.printf("> ");
	}
	
	
	/*
	 *Autor: Felype Rangel e Peterson
	 *
	 */
	
	/*			BREVES COMENTARIOS
	 * 
	 * Foi usado uma biblioteca externa: MultiMap 
	 * Qualquer duvida é só perguntar
	 */

	 
	// DECLARAÇÃO DAS VARIAVEIS E VETORES

	Integer assentosAtuais = null;

	// CONSTANTES
	final static int faixaEtaria[] = { 12, 16, 0 };

	@SuppressWarnings("null")
	public static void main(String[] args) {
		int assentos[] = { 3, 4, 2 };

		Scanner scanner = new Scanner(System.in);
		Filmes filmes = new Filmes();
		List<String> nomeUsuario = new ArrayList<>();
		List<Integer> idadeUsuario = new ArrayList<>();
		String[] filmesEmCartaz = new String[2];
		ListMultimap<Integer, String> multimapNomeEFilme = ArrayListMultimap.create();
		
		//CONTAR INDICE 
		int contador = 0;
		
		//ADICIONANDO CONDIÇÃO P/ INICIALIZAR OU PARAR LOOP
		boolean loop = true;
		while (loop) {
			//ENTRADA DE DADOS
			System.out.println("Bem vindo ao nosso cinema");
			System.out.println("Digite o seu nome");
			styleInput();
			nomeUsuario.add(scanner.next());
			System.out.println("Digite sua idade");
			styleInput();
			idadeUsuario.add(scanner.nextInt());
			
			//EXIBIÇÃO DOS FILMES EM CARTAZ
			filmesEmCartaz = new String[] { "Batman [Faixa Etaria 12]", "Os Vingadores [Faixa Etaria 16]",
					"Porto seguro [Faixa Etaria L]" };
			filmes.imprimirFilmesEmCartaz(filmesEmCartaz);
			
			//ESCOLHA DO FILME
			System.out.println("Escolha o filme:");
			styleInput();
			int escolhaFilme = scanner.nextInt();
			
			//AJUSTE DOS INDICES
			int defineIndiceFilme = escolhaFilme - 1;
			
			//DECLARAÇÃO
			boolean assentosIgualAZero = false;

			switch (escolhaFilme) {
			default:
				System.out.println("Digite um numero válido!");
				break;
			case 1:
				if (corresponderUsuario(idadeUsuario.get(contador), faixaEtaria[defineIndiceFilme])) {

					assentosIgualAZero = conteAssentos(assentos, defineIndiceFilme, escolhaFilme);
					if (assentosIgualAZero) {
						imprimirSemAssentos();
					} else {
						imprimirReserva(assentos, defineIndiceFilme, filmesEmCartaz, escolhaFilme);
						multimapNomeEFilme.put(defineIndiceFilme, nomeUsuario.get(contador));
					} 

				} else {
					imprimirIdadeInsuficiente();
				}
				contador++;
				break;

			case 2:
				if (corresponderUsuario(idadeUsuario.get(contador), faixaEtaria[defineIndiceFilme])) {

					assentosIgualAZero = conteAssentos(assentos, defineIndiceFilme, escolhaFilme);
					if (assentosIgualAZero) {
						imprimirSemAssentos();
					} else {
						imprimirReserva(assentos, defineIndiceFilme, filmesEmCartaz, escolhaFilme);
						multimapNomeEFilme.put(defineIndiceFilme, nomeUsuario.get(contador));
					}
				} else {
					imprimirIdadeInsuficiente();
				}
				contador++;
				break;
			case 3:
				if (corresponderUsuario(idadeUsuario.get(contador), faixaEtaria[defineIndiceFilme])) {

					assentosIgualAZero = conteAssentos(assentos, defineIndiceFilme, escolhaFilme);
					if (assentosIgualAZero) {
						imprimirSemAssentos();
					} else {
						imprimirReserva(assentos, defineIndiceFilme, filmesEmCartaz, escolhaFilme);
						multimapNomeEFilme.put(defineIndiceFilme, nomeUsuario.get(contador));
					}
				} else {
					imprimirIdadeInsuficiente();
				}
				contador++;
				break;
			}

			System.out.println("Gostaria de sair do programa? [s/n]");
			char escolha = scanner.next().charAt(0);
			if (escolha == 's' || escolha == 's') {
				loop = false;
			} 
		}

		System.out.println("Saída: ");
		for (int i = 0; i < filmesEmCartaz.length; i++) {
			System.out.println(filmesEmCartaz[i]);
			System.out.println(multimapNomeEFilme.get(i));

		}

		System.out.println("--------------------------");
		System.out.println("Gostaria de salvar no Bloco de notas? [s/n]");
		char escolhaBloco = scanner.next().charAt(0);

		if (escolhaBloco == 's' || escolhaBloco == 'S') {
			try {
				FileWriter arq;
				arq = new FileWriter("C:\\Users\\Felype\\Desktop\\agendamentoSalas.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.println("**********AGENDAMENTOS REGISTRADOS************\n");
				for (int i = 0; i < filmesEmCartaz.length; i++) {
					gravarArq.println(filmesEmCartaz[i]);
					gravarArq.println(multimapNomeEFilme.get(i));
				}
				gravarArq.println("");
				gravarArq.println("*********************************************");
				gravarArq.println("*Criado por Felype Rangel e Peterson Machado*");
				gravarArq.println("*********************************************");
				gravarArq.println("*************PER ASPERA AD ASTRA*************");
				gravarArq.println("*********************************************");

				arq.close();
				System.out.println("Gravado com sucesso ;)");
				Runtime.getRuntime().exec("notepad C:\\Users\\Felype\\Desktop\\agendamentoSalas.txt"); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			System.out.println("Para agilizar, o bloco de notas será aberto.");
			scanner.close();
		} else {
			System.out.println("Programa encerrado");

		}
	}
		
						

	
							//MÉTODOS
	public static boolean conteAssentos(int[] assentos, int defineIndiceFilme,
			int escolhaFilme) {
		int assentosAtuais = assentos[escolhaFilme - 1];
		boolean assentosIgualOuMenorQueZero = assentosAtuais <= 0;

		return assentosIgualOuMenorQueZero;
	}

	public static void imprimirSemAssentos() {
		System.out.println("Infelizmente, os assentos estão indisponiveis. Escolha outro filme em cartaz.");
	}

	public static void imprimirReserva(int[] assentos, int defineIndiceFilme, String[] filmesEmCartaz,
			int escolhaFilme) {
		int assentosAtuais = assentos[escolhaFilme - 1] -= 1;
		System.out.printf(
				"Parabéns, o filme escolhido foi %s. Seu assento foi reservado. %nO numero dos assentos atuais são: %d \n",
				filmesEmCartaz[defineIndiceFilme], assentosAtuais);
	}

	public static void imprimirIdadeInsuficiente() {
		System.out.println("Você não tem idade suficiente p/ assistir esse filme!");
	}

	public static boolean corresponderUsuario(Integer idadeUsuario, int faixaEtaria) {
		boolean resultado = false;
		boolean seCorresponderIdadeEFaixaEtaria = idadeUsuario > faixaEtaria || idadeUsuario.equals(faixaEtaria);
		if (seCorresponderIdadeEFaixaEtaria) {
			resultado = true;

		}
		return resultado;
	}
}
