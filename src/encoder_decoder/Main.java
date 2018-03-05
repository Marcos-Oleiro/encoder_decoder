package encoder_decoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		// String path = "/home/spellzito/example.csv";
//		String path = "/home/marcos/example.csv";
		String path = "/home/marcos/exemple1.csv";
		// String cover_path = "/home/spellzito/capa_livro.jpeg";
//		String cover_path = "/home/aluno/capa_livro.jpeg";

//		 FileDecoder fd = new FileDecoder(cover_path);
//		 String aux = fd.encodeToBase64();
//		 System.out.println(aux);
//		 fd.encodetoString(aux);

//		 System.out.println(new FileDecoder(path).hashToMD5(cover_path));
//		System.out.println("oi");
		BufferedReader bf = null;
		Path p = Paths.get(path);

		
			bf = Files.newBufferedReader(p);
			Decoder d = new Decoder(bf);
			Book b = new Book();
			b = d.makeABook();
			
			System.out.println("-------------------------------");
			System.out.println("Testando função");
			System.out.println("ID: " + b.getId());
			System.out.println("Títulos : " );
			for (int j = 0; j < b.getTitles().size(); j++){
				System.out.println(b.getTitles().get(j)[0]);
				System.out.println(b.getTitles().get(j)[1]);
			}
			System.out.println("Data de Publicação: " + b.getPublish_date());
			System.out.println("Editora: " + b.getPublishing());
			System.out.println("Autores: ");
			for (int j = 0; j < b.getAuthors().size(); j++){
				System.out.println(b.getAuthors().get(j));
			}
			System.out.println(b.getCover_type());
			System.out.println(b.getCover().length());
			System.out.println("-------------------------------");
			
			
//			 Encoder e = new Encoder(b);
//			 String json = e.makeAJSON();
//			
//			 String path_json = "/home/spellzito/book.json";
//			 Path p1 = Paths.get(path_json);
//			 FileWriter fw = new FileWriter(path_json);
//			 BufferedWriter bw = new BufferedWriter(fw);
//			 bw.write(json);
//			 bw.flush();


	 }
}