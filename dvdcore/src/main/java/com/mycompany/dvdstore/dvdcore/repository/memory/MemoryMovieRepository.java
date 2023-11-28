//package com.mycompany.dvdstore.dvdcore.repository.memory;
//
//import java.sql.PreparedStatement;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import com.mycompany.dvdstore.dvdcore.entity.Movie;
//import com.mycompany.dvdstore.dvdcore.repository.MovieRepositoryInterface;
//
//@Repository
//public class MemoryMovieRepository implements MovieRepositoryInterface{
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	public Movie create(Movie movie) {
//		KeyHolder kh = new GeneratedKeyHolder();
//		jdbcTemplate.update(connection -> {
//			PreparedStatement ps = connection.prepareStatement("insert into movie (title,genre,description) values (?,?,?)",
//				    new String[] { "id" });
//			ps.setString(1,movie.getTitle());
//			ps.setString(2,movie.getGenre());
//			ps.setString(3,movie.getDescription());
//			return ps;
//		},kh);
//		movie.setId(Long.parseLong(kh.getKey().toString()));;
//		return movie;
//	}
//	
//	public List<Movie> list() {	 
//		return jdbcTemplate.query("select id,title, genre, description from movie",
//				(rs,rowNum) -> new Movie(Long.parseLong(rs.getString("id")),rs.getString("title"),rs.getString("genre"),rs.getString("description")));
//	}
//	
//	@Override
//	@SuppressWarnings("deprecation")
//	public Movie getById(long id) {
//		return jdbcTemplate.queryForObject("select title, genre, description from movie where id = ?",
//				new Object[] {id},
//				(rs,rowNum) -> new Movie(rs.getString("title"),rs.getString("genre"),rs.getString("description")));
//	}
//
//}
