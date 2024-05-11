package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Player implements PlayerIF {

	private TuneCollection repository;
	private int maxRecentlyPlayed;
	private PlayListManager playListManager;
	private RecentlyPlayed recentlyPlayed;
	private PlayBackQueue playBackQueue;

	public Player(TuneCollection tCollection, int maxRecentlyPlayed) {
		this.repository = tCollection;
		this.maxRecentlyPlayed = maxRecentlyPlayed;
		this.playListManager = new PlayListManager();
		this.recentlyPlayed = new RecentlyPlayed(maxRecentlyPlayed);
		this.playBackQueue = new PlayBackQueue();
	}

	//Devuelve los IDs de todas las listas de reproduccion que existen
	public ListIF<String> getPlayListIDs() {
		ListIF<String> playListIDs = playListManager.getIDs();
		if (playListIDs == null) {
			playListIDs = new List<String>();
		}
		return playListIDs;
	}

	//Devuelve el contenido de una lista de reproduccion
	public ListIF<Integer> getPlayListContent(String playListID) {
		PlayListIF playListContent = playListManager.getPlayList(playListID);
		if (playListContent == null) {
			return new List<Integer>();
		}
		return playListContent.getPlayList();
	}

	//Devuelve los IDs contenidos en una cola de reproduccion
	public ListIF<Integer> getPlayBackQueue() {
		return this.playBackQueue.getContent();
	}

	//Devuelve los IDs de las últimas canciones reproducidas almacenadas en RecentlyPlayed
	public ListIF<Integer> getRecentlyPlayed() {
		return this.recentlyPlayed.getContent();
	}

	//Crea una lista de reproduccion apartir de sus IDs
	public void createPlayList(String playListID) {
		this.playListManager.createPlayList(playListID);
	}

	//Elimina una lista de reproducción a partir de su ID
	public void removePlayList(String playListID) {
		this.playListManager.removePlayList(playListID);

	}

	//Añade lista de IDs de canciones del repositorio a unalista de reproducción
	public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT) {
		this.playListManager.getPlayList(playListID).addListOfTunes(lT);
	}

	//Añade los IDs de todas las canciones del repositorio que
	// cumplan los criterios indicados a una lista de reproducción
	public void addSearchToPlayList(String playListID, String title, String author,
			String genre, String album, int min_year, int max_year, int min_duration,
			int max_duration) {
		ListIF<Integer> listaIDs = new List<>();
		QueryIF query = new Query(title, author, genre, album, min_year, max_year,
				min_duration, max_duration);

		for (int i = 0; i < repository.size(); i++) {
			Tune tune = repository.getTune(i);
			if (tune.match(query)) {
				listaIDs.insert(listaIDs.size() + 1, i);
			}
		}
		playListManager.getPlayList(playListID).addListOfTunes(listaIDs);
	}

	//Elimina una canción de una lista de reproducción
	public void removeTuneFromPlayList(String playListID, int tuneID) {
		PlayList playList = (PlayList) playListManager.getPlayList(playListID);
		playList.removeTune(tuneID);

	}

	//Añade lista IDs de canciones del repositorio a la cola de reproducción
	public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
		playBackQueue.addTunes(lT);
	}

	//Añade IDs de todas las canciones del repositorio que
	//cumplan los criterios indicados a la cola de reproducción
	public void addSearchToPlayBackQueue(String title, String author, String genre,
			String album, int min_year, int max_year, int min_duration,
			int max_duration) {
		ListIF<Integer> listaIDs = new List<Integer>();
		QueryIF query = new Query(title, author, genre, album, min_year, max_year,
				min_duration, max_duration);

		for (int i = 0; i < repository.size(); i++) {
			Tune tune = repository.getTune(i);
			if (tune.match(query)) {
				listaIDs.insert(listaIDs.size() + 1, i);
			}
		}
		playBackQueue.addTunes(listaIDs);
	}

	//Añade el contenido de una lista de reproducción a la cola de reproducción
	public void addPlayListToPlayBackQueue(String playListID) {
		playBackQueue.addTunes(playListManager.getPlayList(playListID).getPlayList());
	}

	//Vacia la cola de reproduccion
	public void clearPlayBackQueue() {
		playBackQueue.clear();

	}

	//Reproduce la siguiente cancion de la cola de reproduccion
	public void play() {
		if (!playBackQueue.isEmpty()) {
			recentlyPlayed.addTune(playBackQueue.getFirstTune());
			playBackQueue.extractFirstTune();
		}
	}

}
