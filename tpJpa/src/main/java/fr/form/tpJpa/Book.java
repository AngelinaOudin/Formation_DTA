package fr.form.tpJpa;

public class Book {
	private String title;
	private int id;
	private int nbPages;
	private String author;

	public Book(String title, int nbPage, String author) {
		this.title = title;
		this.nbPages = nbPage;
		this.author = author;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return title + " " +nbPages+ " "+ author;
	}
}
