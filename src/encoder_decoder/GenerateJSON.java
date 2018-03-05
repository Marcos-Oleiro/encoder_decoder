package encoder_decoder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean validate = false;
		int i;
		Scanner scan = new Scanner(System.in);
//		String[] titles = new String[2];
		ArrayList<String[]> titles_list = new ArrayList();
		ArrayList<String> authors_list = new ArrayList();
		int id_book = 0;
		int number_of_titles = 0;

		while (!validate) {
			System.out.print("Informe o ID do livro: ");
			id_book = Integer.parseInt(scan.nextLine());
			if (id_book > 0) {
				validate = true;
			} else {
				System.out.println("Valor de ID deve ser positivo");
			}
		}
		validate = false;

		while (!validate) {

			System.out.print("Informe o número de títulos: ");
			number_of_titles = Integer.parseInt(scan.nextLine());
			if (number_of_titles > 0) {
				validate = true;
			} else {
				System.out.println("O número de títulos deve ser positivo");
			}
		}
		validate = false;
		
		for (i = 0; i < number_of_titles; i++) {
			String[] titles = new String[2];
			while (!validate){
				System.out.print("Informe o idioma do título: ");
				titles[0] = scan.nextLine();
					if (!titles[0].isEmpty()) {
						validate = true;
						System.out.println(titles[0]);
					}
					else {
						System.out.println("O nome do idioma não ser ser vazio");
					}
			}
			validate = false;
			while (!validate) {
				System.out.print("Informe o título: ");
				titles[1] = scan.nextLine();
					if (!titles[1].isEmpty()) {
						System.out.println(titles[1]);
						validate = true;
						titles_list.add(titles);
					}
					else {
						System.out.print("O título do livro não ser ser vazio");
					}
			}
			validate = false;
		}
		
		
		validate = false;
		
		int year = 0, month = 0, day = 0;
		while (!validate) {
			
			System.out.print("Informe a data de publicação (yyyy-mm-dd)");
			String aux = scan.nextLine();
			year = Integer.parseInt(aux.split("-")[0]);
			month = Integer.parseInt(aux.split("-")[1]);
			day = Integer.parseInt(aux.split("-")[2]);
			int current_year = Integer.parseInt(LocalDate.now().toString().split("-")[0]);
			
			if ((year > current_year)) {
				System.out.println("Valor do Ano inválido");
				// System.exit(0);
			}
			else {
				validate = true;
			}
			if ((month < 1) || (month > 12)) {
				System.out.println("Valor do Mês inválido");
				validate = false;
			}
			else {
				if ( (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
					if ( (day < 0) || (day > 31)) {
						System.out.println("Valor do dia está inválido");
						validate = false;
					}
				}
				else {
					if (month ==2) {
						if ( (day < 0) || (day > 29)) {
							System.out.println("Valor do dia está inválido");
							validate = false;
						}
					}else {
						if ( (day < 0) || (day > 30)) {
							System.out.println("Valor do dia está inválido");
							validate = false;
						}
						
					}
				}
			}
			
		}
		
		validate = false;
		
		LocalDate publish_date = LocalDate.of(year, month, day);
		String publishing = null;
		
		while (!validate) {			
			System.out.print("Informe a editora: ");
			publishing = scan.nextLine();
			if ( !publishing.isEmpty() ) {
				validate = true;
			}
			else {
				System.out.println("O nome da editora não pode ser vazio.");
			}
		}
		
		validate = false;
		int number_of_authors = 0; 
		
		while (!validate) {
			System.out.print("Informe a quantidade de autores: ");
			number_of_authors = Integer.parseInt(scan.nextLine());
			if (number_of_authors > 0) {
				validate = true;
			} else {
				System.out.println("O número de autores deve ser positivo");
			}
		}
		
		
		for ( i = 0 ; i < number_of_authors ; i++) {
			
			validate = false;
			while (!validate) {				
				System.out.print("Informe o nome do autor: ");
				String a = scan.nextLine();
				if  (!a.isEmpty()) {
					validate = true; 
					authors_list.add(a);
				}else {
					System.out.println("O nome do autor não pode estar vazio.");
				}
			}
		}
		
		System.out.println("Informe a extensão do arquivo da capa: ");
		String cover_type = scan.nextLine();
		
		System.out.println("Informe o caminho do arquivo da capa: ");
		String path_cover = scan.nextLine();
		FileDecoder fd = new FileDecoder();
		fd.setPath(path_cover);
		String cover_64 = fd.encodeToBase64();
//		/home/marcos/capa_livro.jpeg
		Book b1 = new Book();
		b1.setId(id_book);
		b1.setAuthors(authors_list);
		b1.setCover(cover_64);
		b1.setCover_type(cover_type);
		b1.setPublish_date(publish_date);
		b1.setPublishing(publishing);
		b1.setTitles(titles_list);
		
		Encoder e = new Encoder(b1);
		String json = e.makeAJSON();
	
//		 String path_json = "/home/spellzito/book.json";
		 String path_json = "/home/marcos/book.json";
		 Path p1 = Paths.get(path_json);
		 FileWriter fw;
		 try {
		 fw = new FileWriter(path_json);
		 BufferedWriter bw = new BufferedWriter(fw);
		 bw.write(json);
		 bw.flush();
		 } catch (IOException e1) {
		 // TODO Auto-generated catch block
		 e1.printStackTrace();
		 }
	}

}
