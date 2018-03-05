package encoder_decoder;


import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Decoder {
	
	private BufferedReader bf;

	public Decoder(BufferedReader bf) {
		this.bf = bf;
	}
	
	
	public Book makeABook (){
		String s;
		Book b = new Book();
		int i;
//		System.out.println("oi");
		
		try {
			s = this.bf.readLine();
			ArrayList<String[]>  t = new ArrayList(); 
			String[] aux = s.split("\",");

			
			// Setar a ID do livro
			if ( Integer.parseInt(aux[0].split("\"")[1]) < 1 ) {
				System.out.println("A ID do livro tem que ser um número positivo.");
				System.exit(0);
			}
			else {
				b.setId(Integer.parseInt(aux[0].split("\"")[1]));
			}
			
			
			// Saber qual a quantidade de títulos que o documento tem
			int number_of_titles = 0;
			
			if (Integer.parseInt(aux[1].split("\"")[1]) < 0) {
				System.out.println("A quantidade de títulos deve ser maior que 0");
				System.exit(0);
			}else {
				number_of_titles = Integer.parseInt(aux[1].split("\"")[1]);				
			}
			
			
			// For para percorrer os campos do arquivo e setando os titulos contidos nele no objeto livro
			for ( i = 2 ; i <= (1 + 2*number_of_titles); i++ ){
				
				String[] title_array = new String[2];
				if ( i % 2 == 0){
					if ( ( aux[i].split("\"")[1].isEmpty() ) || (aux[i+1].split("\"")[1]).isEmpty() ) {
						System.out.println("Os nomes dos idiomas e títulos não podem ser vazios.");
						System.exit(0);
					}
					else {
						title_array[0] = aux[i].split("\"")[1];	
						title_array[1] = aux[i+1].split("\"")[1];						
						t.add(title_array);						
						b.setTitles(t);
					}
				}
			}
			
			
			
			// Data de publicação
			
			int index_publishing_date = 1 + 2*number_of_titles + 1;
			
			String aux_data = aux[index_publishing_date].split("\"")[1];
			
			int year = Integer.parseInt(aux_data.split("-")[0]);
			int month = Integer.parseInt(aux_data.split("-")[1]);
			int day = Integer.parseInt(aux_data.split("-")[2]);
			int current_year = Integer.parseInt(LocalDate.now().toString().split("-")[0]);
			
			if ((year > current_year)) {
				System.out.println("Valor do Ano inválido");
				 System.exit(0);
			}
			else {

			}
			if ((month < 1) || (month > 12)) {
				System.out.println("Valor do Mês inválido");
				System.exit(0);

			}
			else {
				if ( (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
					if ( (day < 0) || (day > 31)) {
						System.out.println("Valor do dia está inválido");
						System.exit(0);

					}
				}
				else {
					if (month == 2) {
						if ( (day < 0) || (day > 29)) {
							System.out.println("Valor do dia está inválido");
							System.exit(0);

						}
					}else {
						if ( (day < 0) || (day > 30)) {
							System.out.println("Valor do dia está inválido");
							System.exit(0);
						}
						
					}
				}
			}
			
			
			b.setPublish_date(LocalDate.of(year,month,day));
			
			// Editora
			
			int index_publishing = index_publishing_date + 1;
			
			if ( aux[index_publishing].split("\"")[1].isEmpty()) { 
				System.out.println("O nome da editora não pode ser vazio");
				System.exit(0);
			}
			else {
				b.setPublishing(aux[index_publishing].split("\"")[1]);
			}
				
			
			// Autores
			
			ArrayList<String> authors = new ArrayList();
			int index_of_number_author = index_publishing + 1;
			int number_of_authors = 0 ;
			
			if (Integer.parseInt(aux[index_of_number_author].split("\"")[1]) < 1) {
				System.out.println("A quantidade de autores tem que ser maior que 0");
				System.exit(0);
			}
			else {
				number_of_authors = Integer.parseInt(aux[index_of_number_author].split("\"")[1]);
			}
			

			int aux_int = number_of_authors +index_of_number_author + 1;
			
			for (i = index_of_number_author + 1; i < aux_int; i++) {
				
				if (aux[i].split("\"")[1].isEmpty()) {
					System.out.println("O nome do autor não pode ser vazio;");
				}
				else {
					
					authors.add(aux[i].split("\"")[1]);
				}
			}
			
			b.setAuthors(authors);
			
			// Formato da capa
			
			int index_of_cover_format = index_of_number_author + number_of_authors + 1;
			int index_of_cover= index_of_cover_format + 1;
			b.setCover_type(aux[index_of_cover_format].split("\"")[1]);
			b.setCover(aux[index_of_cover].split("\"")[1]);
			
			return b;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
