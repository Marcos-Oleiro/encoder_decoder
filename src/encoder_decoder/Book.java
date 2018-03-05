package encoder_decoder;

import java.time.LocalDate;
import java.util.ArrayList;


public class Book {
	
	private int id;
	private ArrayList<String[]> titles;
	private LocalDate publish_date;
	private String publishing;
	private ArrayList<String> authors;
	private String cover_type;
	private String cover;
	
	public Book() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String[]> getTitles() {
		return titles;
	}

	public void setTitles(ArrayList<String[]> titles) {
		this.titles = titles;
	}

	public LocalDate getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	public String getCover_type() {
		return cover_type;
	}

	public void setCover_type(String cover_type) {
		this.cover_type = cover_type;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	
	
	
	
	
}
