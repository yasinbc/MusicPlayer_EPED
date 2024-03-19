package es.uned.lsi.eped.pract2023_2024;

/** Representación de los criterios de búsqueda                               */
public class Query implements QueryIF{
	public String title = "";
	public String author = "";
	public String gender = "";
	public String album ="";
	public int minYear = 0;
	public int maxYear = 0;
	public int minDuration = 0;
	public int maxDuration = 0;
	
	public Query (String titulo, String autor, String genero, String album, int minYear, int maxYear, int minDuration, int maxDuration) {
		this.title = titulo;
		this.author = autor;
		this.gender = genero;
		this.album = album;
		this.minYear = minYear;
		this.maxYear = maxYear;
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
	}
	
	/** Devuelve el criterio título                                             */
	/** @return  -una cadena de caracteres con el título de la canción buscada  */
	public String getTitle() {
		return this.title;
	}

	/** Devuelve el criterio autor                                              */
	/** @return  -una cadena de caracteres con el autor de la canción buscada   */
	public String getAuthor() {
		return this.author;
	}

	/** Devuelve el criterio género                                             */
	/** @return  -una cadena de caracteres con el género de la canción buscada  */
	public String getGenre() {
		return this.gender;
	}

	/** Devuelve el criterio álbum                                              */
	/** @return  --una cadena de caracteres con el álbum al que pertenece la    */
	/**          canción buscada                                                */
	public String getAlbum() {
		return this.album;
	}

	/** Devuelve el criterio año mínimo                                         */
	/** @return  -un entero con el primer año del intervalo en el que se grabó  */
	/**          la canción a buscar                                            */
	public int getMin_year() {
		return this.minYear;
	}

	/** Devuelve el criterio año máximo                                         */
	/** @return  -un entero con el último año del intervalo en el que se grabó  */
	/**          la canción a buscar                                            */
	public int getMax_year() {
		return this.maxYear;
	}

	/** Devuelve el criterio duración mínima                                    */
	/** @return  -un entero con la duración mínima de la canción a buscar       */
	public int getMin_duration() {
		return this.minDuration;
	}

	/** Devuelve el criterio duración máxima                                    */
	/** @return  -un entero con la duración máxima de la canción a buscar       */
	public int getMax_duration() {
		return this.maxDuration;
	}
	
	
	
	
	/** PRUEBAS, BORRAR AL TERMINAR */
	public static void main(String args[]) {
		Query query = new Query("titulo","autor","genero","album", 1990, 2024, 0, 3);
		Query qry = new Query("Unforgiven III","Metallica","Trashmetal","Death magnethic", 2008, 2024, 1, 4);
		System.out.println("title: "+query.title+",\n"+
						   "author: "+query.author+",\n"+
						   "gender: "+query.gender+",\n"+
						   "album: "+query.album+",\n"+
						   "minYear: "+query.minYear+",\n"+
						   "maxYear: "+query.maxYear+",\n"+
						   "minDuration: "+query.minDuration+",\n"+
						   "maxDuration: "+query.maxDuration+"\n\n");

		System.out.println("title: "+qry.getTitle()+",\n"+
				   "author: "+qry.getAuthor()+",\n"+
				   "gender: "+qry.getGenre()+",\n"+
				   "album: "+qry.getAlbum()+",\n"+
				   "minYear: "+qry.getMin_year()+",\n"+
				   "maxYear: "+qry.getMax_year()+",\n"+
				   "minDuration: "+qry.getMin_duration()+",\n"+
				   "maxDuration: "+qry.getMax_duration()+"\n");
		
	}

}
