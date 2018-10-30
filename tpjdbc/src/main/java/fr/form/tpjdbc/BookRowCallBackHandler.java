package fr.form.tpjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class BookRowCallBackHandler implements RowCallbackHandler {

	private List<Book> books;
	private List<String> authors;
    
    public BookRowCallBackHandler() {
        books = new ArrayList<Book>();
        authors = new ArrayList<String>();
    }
    public void processRow(ResultSet rs) throws SQLException {
        books.add(new Book(rs.getString("title"), rs.getInt("nb_pages"), rs.getString("author")));
        authors.add(rs.getString("author"));
    }
     
    public List<Book> getBookList() {   return books;  } 
    public List<String> getAuthorList() {   return authors;  } 
}
