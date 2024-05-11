package es.uned.lsi.eped.pract2023_2024;

public class Tune implements TuneIF {
	private int year;
	private int duration;
	private String title;
	private String author;
	private String genre;
	private String album;

	public Tune(String title, String author, String genre, String album, int year,
			int duration) throws IllegalArgumentException {

		if (title.isEmpty()
				|| author.isEmpty()
				|| genre.isEmpty()
				|| album.isEmpty()
				|| year <= 0
				|| duration <= 0)

			throw new IllegalArgumentException();

		this.year = year;
		this.duration = duration;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.album = album;
	}

	//Dado un objeto QueryIF conteniendo unos criterios de búsqueda, devuelve */
	//un valor de verdad indicando si la canción los cumple o no los cumple
	public boolean match(QueryIF q) {
		return matchTitle(q)
				&& matchAuthor(q)
				&& matchGenre(q)
				&& matchAlbum(q)
				&& matchYear(q)
				&& matchDuration(q);
	}

	private boolean matchTitle(QueryIF query) {
		return query.getTitle().isEmpty() || query.getTitle().equalsIgnoreCase(title);
	}

	private boolean matchAuthor(QueryIF query) {
		return query.getAuthor().isEmpty() || query.getAuthor().equalsIgnoreCase(author);
	}

	private boolean matchGenre(QueryIF query) {
		return query.getGenre().isEmpty() || query.getGenre().equalsIgnoreCase(genre);
	}

	private boolean matchAlbum(QueryIF query) {
		return query.getAlbum().isEmpty() || query.getAlbum().equalsIgnoreCase(album);
	}

	private boolean matchYear(QueryIF query) {
		int year_min = query.getMin_year();
		int year_max = query.getMax_year();
		if (year_min == -1 ) year_min = Integer.MIN_VALUE;
		if (year_max == -1 ) year_max = Integer.MAX_VALUE;
		
		return (year >= year_min && year <= year_max);
	}

	private boolean matchDuration(QueryIF query) {
		int min_duration = query.getMin_duration();
		int max_duration = query.getMax_duration();
		if (min_duration == -1 ) min_duration = Integer.MIN_VALUE;
		if (max_duration == -1 ) max_duration = Integer.MAX_VALUE;
		
		return (duration >= min_duration && duration <= max_duration); 
	}

}
