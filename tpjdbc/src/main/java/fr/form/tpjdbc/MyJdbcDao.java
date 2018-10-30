package fr.form.tpjdbc;

import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MyJdbcDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public void nbRows() {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from book", Integer.class);
		System.out.println(rowCount);
	}

	public void list() {
		List<Book> actors = this.jdbcTemplate.query("select * from book", new BookMapper());
		for (Book b : actors) {
			System.out.println(b.getTitle() + " " + b.getNbPages());
		}
	}

	public void insert() {
		this.jdbcTemplate.update("insert into book (id, title, nb_pages) values (?, ?, ?)", 3, "Tintin", 50);
	}

	public void update() {
		this.jdbcTemplate.update("update book set title = ? where id = ?", "Banjo", 3);

	}

	public void delete() {
		this.jdbcTemplate.update("delete from book where id = ?", 3);

	}

	public List<Book> getLivres() {
		BookRowCallBackHandler handler = new BookRowCallBackHandler();
		this.jdbcTemplate.query("select * from book", handler);

		return handler.getBookList();
	}

	public List<String> getAuthors() {
		BookRowCallBackHandler handler = new BookRowCallBackHandler();
		this.jdbcTemplate.query("select * from book", handler);

		return handler.getAuthorList();
	}

	public List<Book> getAuthors(String auteur) {
		List<Book> livreAuteur = new ArrayList<Book>();
		List<Book> livres = this.getLivres();

		for (Book b : livres) {
			if (b.getAuthor().equals(auteur)) {
				livreAuteur.add(b);
			}
		}
		return livreAuteur;
	}

	public Map getUserInfoByAlll() {
		Map<Object, List<Book>> m = new HashMap<Object, List<Book>>();
		List<Map<String, Object>> result = this.jdbcTemplate
				.queryForList("SELECT *  FROM book where author='Pierre Bordage'");
		m.put("Pierre Bordage", getAuthors("Pierre Bordage"));
		m.put("Tolkien", getAuthors("Tolkien"));
		System.out.println(m);
		return m;
	}

	public char[] mapCsv() {
		Map<Object, List<Book>> map = getUserInfoByAlll();
		String valeurs = new String();
		for (Map.Entry<Object, List<Book>> entry : map.entrySet()) {
			valeurs.concat(entry.getKey() + "," + entry.getValue() + "\b");
		}
		return valeurs.toCharArray();
	}

	
	public void addRows() {
		this.jdbcTemplate.update("insert into book (id, title, nb_pages) values (?, ?, ?)", 4, "Tintin", 50);
		this.jdbcTemplate.update("insert into book (id, title, nb_pages) values (?, ?, ?)", 5, "Tintin", 50);
		this.jdbcTemplate.update("insert into book (id, title, nb_pages) values (?, ?, ?)", 6, "Tintin", 50);
	}
	public void addRowsTest() {
		this.jdbcTemplate.update("insert into book (id, title, nb_pages) values (?, ?, ?)", 4, "Tintin", 50);
		this.jdbcTemplate.update("insert into book (id, title, nb_pages) values (?, ?, ?)", 5, "Tintin", 50);
		this.jdbcTemplate.update("insert into book (id, title, nb_pages) values (?, ?, ?)", 6, "Tintin", 50);
	}
}
