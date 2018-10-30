package fr.form.tpjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

final class BookMapper implements RowMapper<Book> {
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b = new Book();
		b.setTitle(rs.getString("title"));
		b.setNbPages(rs.getInt("nb_pages"));
		return b;
	}
}
