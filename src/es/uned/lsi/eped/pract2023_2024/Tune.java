package es.uned.lsi.eped.pract2023_2024;

/** Representación de una canción                                             */
public class Tune implements TuneIF{
	public Query query;
	
	public String title;
	public String author;
	public String gender;
	public String album;
	public int year;
	public int duration;
	
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
	public boolean match(QueryIF q){
		/*
		//Criterio de titulo
		if(!this.title.equals("")) {
			System.out.println("Contiene título");
			if(!this.title.equalsIgnoreCase(q.getTitle())) {
				System.out.println("No es el título");
				return false;
			}
		}
		
		//Criterio de autor
		if(!this.author.equals("")) {
			System.out.println("Contiene autor");
			if(!this.author.equalsIgnoreCase(q.getAuthor())) {
				System.out.println("No es el autor");
				return false;
			}
		}
		
		//Criterio de genero
		if(!this.gender.equals("")){
			System.out.println("Contiene género");
			if(!this.gender.equalsIgnoreCase(q.getGenre())){
				System.out.println("No es el género");
				return false;
			}
		}
		
		//Criterio de album
		if(!this.album.equals("")){
			System.out.println("Contiene album");
			if(!this.album.equalsIgnoreCase(q.getAlbum())) {
				System.out.println("No es el album");
				return false;
			}
		}
		
		
		
		//Criterio del año 
		if(this.year != -1) {
			System.out.println("Contiene año mínimo");
			if(!(this.year > 0)) {
				System.out.println("Has introducido el año en 0 o  negativo");
				return false;
			}else if(!(q.getMin_year() <= this.year && this.year <= q.getMax_year())) {
				System.out.println("Año fuera de rango");
				return false;
			}
		}
		
		//Criterio de año MÁXIMO
		if(this.duration != -1) {
			System.out.println("Contiene año MÁXIMO");
			if(!(this.duration > 0)) {
				System.out.println("Has introducido la duración en 0 o negativo");
				return false;
			}else if(!(q.getMin_duration() <= this.duration && this.duration <= q.getMax_duration())) {
				System.out.println("Duración fuera de rango");
				return false;
			}
		}
		
		System.out.println("\nla consulta es cierta en su totalidad\n");
		return true;
		*/
		
		
		/** CONDICION LARGA */
		if(
			(q.getTitle().isEmpty()  || q.getTitle().equalsIgnoreCase(this.getTitle()) )     &&
			(q.getAuthor().isEmpty() || q.getAuthor().equalsIgnoreCase(this.getAuthor() )  ) &&
			(q.getGenre().isEmpty()  || q.getGenre().equalsIgnoreCase(this.getGenre() ) )    &&
			(q.getAlbum().isEmpty()  || q.getAlbum().equalsIgnoreCase(this.getAlbum() ) )    &&
			(q.getMin_year()==-1     || q.getMin_year()     >=this.getYear() )               &&
			(q.getMax_year()==-1     || q.getMax_year()     <=this.getYear() )               &&
			(q.getMin_duration()==-1 || q.getMin_duration() <=this.getDuration() )           &&
			(q.getMax_duration()==-1 || q.getMax_duration() >=this.getDuration() ) ){
				return true;
		}else{
			return false;
		}
		/** CONDICION LARGA */
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getYear(){
		return year;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public String getGenre() {
		return gender;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	
	/** PRUEBAS, BORRAR AL TERMINAR */
	public static void main(String args[]) {
		Query q = new Query("Enter sadman","Metallica","Trashmetal","Master of puppets", 1990, 2024, 0, 3);
		Tune t = new Tune("Enter sadman","Metallica","Trashmetal","Master of puppets", 1995, 2);
		t.match(q);
	}
}
