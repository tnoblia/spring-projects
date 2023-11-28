package com.mycompany.dvdstore.dvdcore.repository.file;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Repository;
//
//import com.mycompany.dvdstore.dvdcore.entity.Movie;
//import com.mycompany.dvdstore.dvdcore.repository.MovieRepositoryInterface;
//
////@Repository
//public class FileMovieRepository implements MovieRepositoryInterface {
//	
//	@Value("${fichier.path}")
//	private File fichier;
//
//	public Movie create(Movie movie) {
//		FileWriter writer;
//		try{
//			 long lastId=this.list().stream().map(Movie::getId).max(Long::compare).orElse(0L);
//			 movie.setId(lastId+1);
//		     writer=new FileWriter(fichier,true);
//		     writer.write(movie.getId()+";"+movie.getTitle()+";"+movie.getGenre()+";"+movie.getDescription()+"\n");
//		     writer.close();
//		}
//		catch (IOException e){
//		     e.printStackTrace();
//		}
//		System.out.println("A new movie with the title : "+movie.getTitle()+" from the genre "+movie.getGenre()+" has been created in the csv file");
//		return movie;
//	
//	}
//	
//	public List<Movie> list() {
//		 
//	    List<Movie> movies=new ArrayList<>();
//	 
//	    try(BufferedReader br = new BufferedReader(new FileReader(fichier))) {
//	        for(String line; (line = br.readLine()) != null; ) {
//	            final Movie movie=new Movie();
//	            final String[] titreEtGenre = line.split("\\;");
//	            Long id = Long.parseLong(titreEtGenre[0]);
//	            movie.setId(id);
//	            movie.setTitle(titreEtGenre[1]);
//	            movie.setGenre(titreEtGenre[2]);
//	            movie.setDescription(titreEtGenre[3]);
//	            movies.add(movie);
//	        }
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	    return movies;
//	}
//	
//	public File getFichier() {
//		return fichier;
//	}
//
//	public void setFichier(File fichier) {
//		this.fichier = fichier;
//	}
//	
//	public Movie getById(long movieId) {
//	    final Movie movie = new Movie();
//	    movie.setId(movieId);
//	    try(BufferedReader br = new BufferedReader(new FileReader(fichier))) {
//	        for(String line; (line = br.readLine()) != null; ) {
//	 
//	            final String[] allProperties = line.split("\\;");
//	            final long nextMovieId=Long.parseLong(allProperties[0]);
//	            if (nextMovieId==movieId) {
//	                movie.setTitle(allProperties[1]);
//	                movie.setGenre(allProperties[2]);
//	                movie.setDescription(allProperties[3]);
//	                return movie;
//	            }
//	        }
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    } catch (NumberFormatException e) {
//	        System.err.println("A movie from the file does not have a proper id");
//	        e.printStackTrace();
//	    }
//	    movie.setTitle("UNKNOWN");
//	    movie.setGenre("UNKNOWN");
//	    movie.setDescription("UNKNOWN");
//	    return movie;
//	}
//
//}
