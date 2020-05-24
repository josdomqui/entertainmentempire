package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import aiss.model.Film;
import aiss.model.Lists;


public class MapEERepository implements EERepository{

	Map<String, Lists> listMap;
	Map<String, Film> filmMap;
	private static MapEERepository instance=null;
	private int indexL=0;			// Index to create lists' identifiers.
	private int indexF=0;			// Index to create films' identifiers.
	
	
	public static MapEERepository getInstance() {
		
		if (instance==null) {
			instance = new MapEERepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		listMap = new HashMap<String, Lists>();
		filmMap = new HashMap<String, Film>();
		
		// Crear peliculas
		Film starWars1 = new Film();
		starWars1.setFilmTitle("Star Wars I - La amenaza fantasma");
		starWars1.setSynopsis("Obi-Wan Kenobi es un joven aprendiz caballero Jedi bajo la "
				+ "tutela de Qui-Gon Jinn; Anakin Skywalker, quien después será padre de "
				+ "Luke Skywalker y se convertirá en Darth Vader, solamente es un niño de "
				+ "9 años. Cuando la Federación de Comercio corta todas las rutas al planeta"
				+ " Naboo, Qui-Gon y Obi-Wan son asignados para solucionar el problema.");
		starWars1.setUrl("https://www.themoviedb.org/movie/1893-star-wars-episode-i-the-phantom-menace?language=es-ES");
		addFilm(starWars1);
		
		Film starWars2 = new Film();
		starWars2.setFilmTitle("Star Wars II - El ataque de los clones");
		starWars2.setSynopsis("En el Senado Galáctico reina la inquietud. Varios miles de "
				+ "sistemas solares han declarado su intención de abandonar la República. "
				+ "La reina Amidala regresa al Senado para conseguir un ejército que ayude "
				+ "a los caballeros jedi.");
		starWars2.setUrl("https://www.themoviedb.org/movie/1894-star-wars-episode-ii-attack-of-the-clones?language=es-ES");
		addFilm(starWars2);
		
		Film starWars3 = new Film();
		starWars3.setFilmTitle("Star Wars III - La venganza de los Sith");
		starWars3.setSynopsis("Seducido por el lado oscuro, Anakin Skywalker se rebela "
				+ "contra su mentor, Obi-Wan Kenobi, y se convierte en Darth Vader.");
		starWars3.setUrl("https://www.themoviedb.org/movie/1895-star-wars-episode-iii-revenge-of-the-sith?language=es-ES\"");
		addFilm(starWars3);
		
		Film starWars4 = new Film();
		starWars4.setFilmTitle("Star Wars IV - Una nueva esperanza");
		starWars4.setSynopsis("La nave en la que viaja la princesa Leia es capturada por "
				+ "las tropas imperiales al mando del temible Darth Vader. Antes de ser "
				+ "atrapada, Leia consigue introducir un mensaje en su robot R2-D2, quien "
				+ "acompañado de su inseparable C-3PO logra escapar. Tras aterrizar en el "
				+ "planeta Tattooine son capturados y vendidos al joven Luke Skywalker, "
				+ "quien descubrirá el mensaje oculto que va destinado a Obi Wan Kenobi, "
				+ "maestro Jedi a quien Luke debe encontrar para salvar a la princesa.");
		starWars4.setUrl("https://www.themoviedb.org/movie/11-star-wars?language=es-ES\"");
		addFilm(starWars4);
		
		Film starWars5 = new Film();
		starWars5.setFilmTitle("Star Wars V - El imperio contraataca");
		starWars5.setSynopsis("Aunque la Estrella de la Muerte ha sido destruida, las tropas "
				+ "imperiales han hecho salir a las fuerzas rebeldes de sus bases ocultas y "
				+ "los persiguen a través de la galaxia. Mientras, el grupo de rebeldes de "
				+ "Skywalker se esconde en un planeta helado.");
		starWars5.setUrl("https://www.themoviedb.org/movie/1891-the-empire-strikes-back?language=es-ES\"");
		addFilm(starWars5);
		
		Film starWars6 = new Film();
		starWars6.setFilmTitle("Star Wars VI - El retorno del Jedi");
		starWars6.setSynopsis("Luke Skywalker, ahora un experimentado caballero Jedi, "
				+ "intenta descubrir la identidad de Darth Vader.");
		starWars6.setUrl("https://www.themoviedb.org/movie/1892-return-of-the-jedi?language=es-ES\"");
		addFilm(starWars6);
		
		Film starWars7 = new Film();
		starWars7.setFilmTitle("Star Wars VII - El despertar de la fuerza");
		starWars7.setSynopsis("Treinta años después de haber derrotado al Imperio, una nueva amenaza se cierne"
				+ " sobre la República. El terrible y enigmático guerrero Kylo Ren ha reunido un ejército de"
				+ " leales al Imperio, que se hace llamar la Primera Orden y ataca a la Alianza. La única"
				+ " esperanza para la galaxia es que una recogedora de chatarra, un stromtrooper fugado y un"
				+ " androide llamado BB-8 logren encontrar a tiempo al legendario jedi Luke Skywalker.");
		starWars7.setUrl("https://www.themoviedb.org/movie/140607-star-wars-the-force-awakens?language=es-ES");
		addFilm(starWars7);
		
		Film starWars8 = new Film();
		starWars8.setFilmTitle("Star Wars VIII - Los últimos Jedi");
		starWars8.setSynopsis("La Primera Orden ha acorralado a los últimos miembros de la resistencia. Su "
				+ "última esperanza es que Finn se introduzca en la nave de Snoke y desactive el radar que "
				+ "les permite localizarlos. Mientras él trata, en compañía de una soldado de la Resistencia, "
				+ "de cumplir esta misión imposible, Rey se encuentra lejos, intentando convencer a Luke "
				+ "Skywalker de que la entrene y la convierta en la última jedi.");
		starWars8.setUrl("https://www.themoviedb.org/movie/181808-star-wars-the-last-jedi?language=es-ES");
		addFilm(starWars8);
		
		Film starWars9 = new Film();
		starWars9.setFilmTitle("Star Wars IX - El ascenso de Skywalker");
		starWars9.setSynopsis("La Resistencia sobreviviente se enfrenta a la Primera Orden, y Rey, Finn, Poe"
				+ " y el resto de los héroes encararán nuevos retos y una batalla final con la sabiduría de"
				+ " las generaciones anteriores.");
		starWars9.setUrl("https://www.themoviedb.org/movie/181812-star-wars-the-rise-of-skywalker?language=es-ES");
		addFilm(starWars9);
		
		Film starWarsH = new Film();
		starWarsH.setFilmTitle("Han Solo: Una historia de Star Wars");
		starWarsH.setSynopsis("Precuela de la saga Star Wars, en la que se conocerán los primeros pasos que "
				+ "dio el personaje de Han Solo, desde joven hasta convertirse en el antihéroe que vimos en "
				+ "'Una nueva esperanza', antes de que se encontrase con Luke y Obi-Wan en la cantina de "
				+ "Mos Eisley.");
		starWarsH.setUrl("https://www.themoviedb.org/movie/348350-solo-a-star-wars-story?language=es-ES");
		addFilm(starWarsH);
		
		Film peakyblindersF = new Film();
		peakyblindersF.setFilmTitle("Peaky Blinders");
		peakyblindersF.setSynopsis("La serie está ambientada en el mundo de los gangsters de los años 20, en Birmingham. Un joven a lomos de un "
				+ "hermoso corcel negro recorre las calles de Birmingham (Inglaterra). Estamos en 1919, la Gran Guerra ha terminado, pero aquel "
				+ "individuo posee el don de atemorizar a su paso a cualquier transeúnte. ¿Quién es? ¿Por qué les asusta tanto? Al parecer busca "
				+ "un hechizo, una pócima, que garantice la victoria de su caballo de carreras. Una mujer oriental proveerá al temido muchacho "
				+ "de una mágica especia que hará que el noble animal equino logre su fin.");
		peakyblindersF.setUrl("https://www.themoviedb.org/tv/60574-peaky-blinders?language=es-ES");
		addFilm(peakyblindersF);
		
		Film loboWS = new Film();
		loboWS.setFilmTitle("El Lobo de Wall Street");
		loboWS.setSynopsis("Película basada en hechos reales del corredor de bolsa neoyorquino Jordan Belfort. A mediados de los años 80,"
				+ " Belfort era un joven honrado que perseguía el sueño americano, pero pronto en la agencia de valores aprendió que lo más"
				+ " importante no era hacer ganar a sus clientes, sino ser ambicioso y ganar una buena comisión. Su enorme éxito y fortuna le"
				+ " valió el mote de 'El lobo de Wall Street'. Dinero. Poder. Mujeres. Drogas. Las tentaciones abundaban y el temor a la ley"
				+ " era irrelevante. Jordan y su manada de lobos consideraban que la discreción era una cualidad anticuada; nunca se conformaban"
				+ " con lo que tenían.");
		loboWS.setUrl("https://www.themoviedb.org/movie/106646-the-wolf-of-wall-street?language=es-ES");
		addFilm(loboWS);
		
		// Crear listas
		Lists sw1trilogy = new Lists();
		sw1trilogy.setListTitle("Star Wars - First Trilogy");
		sw1trilogy.setListDescription("A list with the three firsts star wars' films.");
		addList(sw1trilogy);
		
		Lists sw2trilogy = new Lists();
		sw2trilogy.setListTitle("Star Wars - Second Trilogy");
		sw2trilogy.setListDescription("A list with the three seconds star wars' films.");
		addList(sw2trilogy);
		
		Lists sw3trilogy = new Lists();
		sw3trilogy.setListTitle("Star Wars - Third Trilogy");
		sw3trilogy.setListDescription("A list with the three last star wars' films.");
		addList(sw3trilogy);
		
		Lists swcompletesaga = new Lists();
		swcompletesaga.setListTitle("Star Wars - Complete Saga");
		swcompletesaga.setListDescription("A list with the complete star wars' saga.");
		addList(swcompletesaga);
		
		
		// Añadir películas a listas
		addFilm(sw1trilogy.getListId(), starWars1.getFilmId());
		addFilm(sw1trilogy.getListId(), starWars2.getFilmId());
		addFilm(sw1trilogy.getListId(), starWars3.getFilmId());
		
		addFilm(sw2trilogy.getListId(), starWars4.getFilmId());
		addFilm(sw2trilogy.getListId(), starWars5.getFilmId());
		addFilm(sw2trilogy.getListId(), starWars6.getFilmId());
		
		addFilm(sw3trilogy.getListId(), starWars7.getFilmId());
		addFilm(sw3trilogy.getListId(), starWars8.getFilmId());
		addFilm(sw3trilogy.getListId(), starWars9.getFilmId());
		
		addFilm(swcompletesaga.getListId(), starWars1.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars2.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars3.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars4.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars5.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars6.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars7.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars8.getFilmId());
		addFilm(swcompletesaga.getListId(), starWars9.getFilmId());
	}
	
	
	// Lists related operations
	@Override
	public void addList(Lists l) {
		String id = "l" + indexL++;	
		l.setListId(id);
		listMap.put(id,l);
	}
	
	@Override
	public Collection<Lists> getAllLists() {
			return listMap.values();
	}

	@Override
	public Lists getListById(String listId) {
		return listMap.get(listId);
	}
	
	@Override
	public void updateList(Lists l) {
		listMap.put(l.getListId(),l);
	}

	@Override
	public void deleteList(String listId) {	
		listMap.remove(listId);
	}
	
	@Override
	public void addFilm(String listId, String filmId) {
		Lists list = getListById(listId);
		list.addFilm(filmMap.get(filmId));
	}

	@Override
	public Collection<Film> getAllFilms(String listId) {
		return getListById(listId).getFilms();
	}

	@Override
	public void removeFilm(String listId, String filmId) {
		getListById(listId).deleteFilm(filmId);
	}

	
	
	// Film related operations
	@Override
	public Collection<Film> getAllFilms() {
		return filmMap.values();
	}
	
	@Override
	public Collection<Film> getFilmsByTitle(String title) {
		Collection<Film> res = new HashSet<>();
		for (Film f : getAllFilms()) {
			if (f.getFilmTitle().toLowerCase().contains(title)) {
				res.add(f);
			}
		}
		return res;
	}
	
	@Override
	public void addFilm(Film f) {
		String id = "f" + indexF++;
		f.setFilmId(id);
		filmMap.put(id, f);
	}

	@Override
	public Film getFilmById(String filmId) {
		return filmMap.get(filmId);
	}

	@Override
	public void updateFilm(Film f) {
		Film film = filmMap.get(f.getFilmId());
		film.setFilmTitle(f.getFilmTitle());
		film.setSynopsis(f.getSynopsis());
		film.setUrl(f.getUrl());
	}

	@Override
	public void deleteFilm(String filmId) {
		filmMap.remove(filmId);
	}	
}