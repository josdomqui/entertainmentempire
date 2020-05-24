package aiss.model;

public class Film {
	private String filmId;
	private String filmTitle;
	private String synopsis;
	private String url;


	public Film() {}
	
	public Film(String filmId, String filmTitle, String synopsis, String url) {
		this.filmId = filmId;
		this.filmTitle = filmTitle;
		this.synopsis = synopsis;
		this.url = url;
	}
	
	public Film(String filmTitle, String synopsis, String url) {
		this.filmTitle = filmTitle;
		this.synopsis = synopsis;
		this.url = url;
	}

	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
