package aiss.model;

import java.util.ArrayList;
import java.util.List;

import aiss.model.Film;

public class Lists {
	
	private String listId;
	private String listTitle;
	private String listDescription;
	private List<Film> films;
	
	public Lists() {};
	
	public Lists(String listTitle) {
		this.listTitle = listTitle;
	}
	
	public Lists(String listId, String listTitle, String listDescription) {
		this.listId = listId;
		this.listTitle = listTitle;
		this.listDescription = listDescription;
	}
	
	public Lists(String listTitle, String listDescription) {
		this.listDescription = listDescription;
		this.listTitle = listTitle;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	public String getListDescription() {
		return listDescription;
	}

	public void setListDescription(String listDescription) {
		this.listDescription = listDescription;
	}
	
	public List<Film> getFilms() {
		return films;
	}
	
	public Film getFilm(String filmId) {
		if (films==null)
			return null;
		
		Film film =null;
		for(Film f: films)
			if (f.getFilmId().equals(filmId))
			{
				film=f;
				break;
			}
		
		return film;
	}
	
	public void addFilm(Film f) {
		if (films==null)
			films = new ArrayList<Film>();
		films.add(f);
	}
	
	public void deleteFilm(Film f) {
		films.remove(f);
	}
	
	public void deleteFilm(String filmId) {
		Film f = getFilm(filmId);
		if (f!=null)
			films.remove(f);
	}
	
	
	
	
	

}
