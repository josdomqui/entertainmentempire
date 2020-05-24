package aiss.model.repository;

import java.util.Collection;

import aiss.model.Lists;
import aiss.model.Film;



public interface EERepository {
	
	// Métodos de tmdb
	public Collection<Film> getAllFilms();						
	public Collection<Film> getFilmsByTitle(String filmTitle);
	public void addFilm(Film f);
	public Film getFilmById(String filmId);								
	public void updateFilm(Film f);
	public void deleteFilm(String filmId);
	
	// Métodos de listas (Drive)
	public void addList(Lists l);
	public Collection<Lists> getAllLists();
	public Lists getListById(String listId);
	public void updateList(Lists l);
	public void deleteList(String listId);
	public void addFilm(String listId, String songId);
	public Collection<Film> getAllFilms(String listId);
	public void removeFilm(String listId, String filmId);
	
	 

}
