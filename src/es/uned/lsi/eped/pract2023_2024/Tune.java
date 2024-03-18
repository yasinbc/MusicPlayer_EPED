package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;

/** Representación de una canción                                             */
public class Tune {
	public Query query;
	
	public String title;
	public String author;
	public String gender;
	public String album;
	
	public int year;
	public int duration;
	
	/*
	public int minYear;
	public int maxYear;
	public int minDuration;
	public int maxDuration;
	*/
	
	public Tune(Query query){
		this.query = query;
	}
	
	public Tune(String title, String author, String gender, String album, int year, int duration) {
		this.title = title;
		this.author = author;
		this.gender = gender;
		this.album = album;
		this.year = year;
		this.duration = duration;
	}
	
	/** Dado un objeto QueryIF conteniendo unos criterios de búsqueda, devuelve */
	/** un valor de verdad indicando si la canción los cumple o no los cumple   */
	/** @param   -un objeto QueryIF con unos criterios de búsqueda              */
	/** @return  -si la canción cumple TODOS los criterios, devolverá verdadero */
	/**          -si la canción incumple algún criterio, devolverá falso        */
	/****************************************************************************/
	/** Constructor de la clase que implementa TuneIF 							*/
	/** @param -una cadena de caracteres con el título de la canción 			*/
	/** -una cadena de caracteres con el autor de la canción 					*/
	/** -una cadena de caracteres con el género de la canción 					*/
	/** -una cadena de caracteres con el álbum al que pertenece 				*/
	/** -un entero con el año de publicación de la canción 						*/
	/** -un entero con la duración en segundos de la canción 					*/
	/** @pre -t != "" && a != "" && g != "" && al != "" && y > 0 && d > 0 		*/
	public boolean match(Query query){
		/*
		title       = null;
		author      = null;
		gender      = null;
		album       = null;
		minYear     = 0;
		maxYear     = 0;
		minDuration = 0;
		maxDuration = 0;
		*/
		
		//Criterio de titulo
		//title = this.query.getTitle();
		if(!this.title.equals("")) {
			System.out.println("Contiene título");
			if(!this.title.equalsIgnoreCase(query.getTitle())) {
				System.out.println("No es el título");
				return false;
			}
		}
		
		//Criterio de autor
		//author = this.query.getAuthor();
		if(!this.author.equals("")) {
			System.out.println("Contiene autor");
			if(!this.author.equalsIgnoreCase(query.getAuthor())) {
				System.out.println("No es el autor");
				return false;
			}
		}
		
		//Criterio de genero
		//gender = this.query.getGenre();
		if(!this.gender.equals("")){
			System.out.println("Contiene género");
			if(!this.gender.equalsIgnoreCase(query.getGenre())){
				System.out.println("No es el género");
				return false;
			}
		}
		
		//Criterio de album
		//album = this.query.getAlbum();
		if(!this.album.equals("")){
			System.out.println("Contiene album");
			if(!this.album.equalsIgnoreCase(query.getAlbum())) {
				System.out.println("No es el album");
				return false;
			}
		}
		
		
		
		//Criterio del año 
		//minYear = this.query.getMin_year();
		if(this.year != -1) {
			System.out.println("Contiene año mínimo");
			if(!(this.year > 0)) {
				System.out.println("Has introducido el año en 0 o  negativo");
				return false;
			}else if(!(query.getMin_year() <= this.year && this.year <= query.getMax_year())) {
				System.out.println("Año fuera de rango");
				return false;
			}
		}
		
		//Criterio de año MÁXIMO
		//maxYear = this.query.getMax_year();
		if(this.duration != -1) {
			System.out.println("Contiene año MÁXIMO");
			if(!(this.duration > 0)) {
				System.out.println("Has introducido la duración en 0 o negativo");
				return false;
			}else if(!(query.getMin_duration() <= this.duration && this.duration <= query.getMax_duration())) {
				System.out.println("Duración fuera de rango");
				return false;
			}
		}
		
		/*
		//Criterio de duración mínima
		//minDuration = this.query.getMin_duration();
		if(this.query.getMin_duration() != -1) {
			System.out.println("Contiene duración mínima");
			if(this.query.getMin_duration() < this.minDuration) {
				System.out.println("Duración mínima fuera de rango");
				return false;
			}
		}
		
		//Criterio de duración MÁXIMA
		//maxDuration = this.query.getMax_duration();
		if(this.query.getMax_duration() != -1) {
			System.out.println("Contiene duración MÁXIMA");
			if(this.query.getMax_duration() > this.maxDuration) {
				System.out.println("Duración MÁXIMA fuera de rango");
				return false;
			}
		}
		*/
		
		System.out.println("\nla consulta es cierta en su totalidad\n");
		return true;
	}
	
	/** Introduce un una cancion nueva al sistema. */
	/** @param -título, autor, género, álbum, año y duración en segundos. */
	private void newSong(String title, String author, String gender, int year, int duration) {
		
		
		
		if(duration > 0) {
			//Crea la cancion
		}else {
			System.out.println("Introduce un valor positivo");
		}
	}
	
	/** PRUEBAS, BORRAR AL TERMINAR */
	public static void main(String args[]) {
		Query q = new Query("Enter sadman","Metallica","Trashmetal","Master of puppets", 1990, 2024, 0, 3);
		Tune t = new Tune("Enter sadman","Metallica","Trashmetal","Master of puppets", 1995, 2);
		t.match(q);
	}
}
