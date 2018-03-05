package encoder_decoder;

public class Encoder {
	
	
	private Book b;

	public Encoder(Book b) {
		this.b = b;
	}
	
	
	public String makeAJSON (){
		
		String json = "";
		String begin = "{ \n \"livro\" : {\n ";
		String content = "";
		String end = "\n} \n }";
		String aux;
		
		// imprimir o código do livro
		
		aux = "\"codigo\":" + Integer.toString(this.b.getId()) + ", \n";
		
		content = content + aux;
		
		// imprimir os títulos
		
		
		content += "\"titulo\":[";
		
		
		int number_of_titles = this.b.getTitles().size();
//		System.out.println(number_of_titles);
		int i;
		aux = "";
		for ( i = 0 ; i < number_of_titles ; i++ ) {
			aux = "";
			aux = "{\"linguagem\": \"" + this.b.getTitles().get(i)[0] + "\" , \"valor\" :\"" +this.b.getTitles().get(i)[1] + "\"}";
			
			if ( i != (number_of_titles -1) ) aux +=", \n"; 
//			System.out.println(aux);
			content += aux;
		}
		content += "], \n";
		
		
		
		// imprimir a data de publicação
		
		aux = "";
		
		aux = "\"publicacao\": " +"\"" + this.b.getPublish_date() + "\",\n" ;
		
		content += aux;
		
		// imprimir a editora
		
		aux = "";
		
		aux = "\"editora\": " +"\"" + this.b.getPublishing() + "\",\n" ;
		
		content += aux;
		
		// imprimir os autores
		
		aux = "";
		
		int number_of_authors = this.b.getAuthors().size();
		
		aux = "\"autores\":[";
		content += aux;
		aux = "";
		
		for ( i = 0 ; i < number_of_authors; i++ ) {
			aux += "\"" + this.b.getAuthors().get(i) + "\"";
			if ( i != (number_of_authors - 1) ) aux +=", "; 
		}
		
		content += aux;
		content += "],\n";
		
		
		// imprimir capa
		
		aux = "\"capa\":[{" + "\"formato\" : \"" + this.b.getCover_type() + "\" , \"valor\" : \"" + this.b.getCover() + "\"}]";
		
		
		
		content += aux;

		
		json = begin + content + end;
		
		return json;

		
	}
	
	

}
