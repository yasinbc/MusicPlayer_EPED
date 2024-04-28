package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.*;

/** Representación de un reproductor de música                                */
public class Player implements PlayerIF{
	private final TuneCollectionIF tCollection;
	private final int maxRecentlyPlayed;
	private PlayListManager playListManager;
	private PlayBackQueue playBackQueue;
	private RecentlyPlayed recentlyPlayed;
	
	
	public Player(TuneCollectionIF tCollection, int maxRecentlyPlayed) {
		this.tCollection = tCollection;
		this.maxRecentlyPlayed = maxRecentlyPlayed;
		this.playListManager = new PlayListManager();
		this.playBackQueue = new PlayBackQueue();
		this.recentlyPlayed = new RecentlyPlayed(this.maxRecentlyPlayed);
	}
	
	/** Devuelve los identificadores de todas las listas de reproducción        */
	/** existentes                                                              */
	/** @returns -una lista con los identificadores de todas las listas de      */
	/**          reproducción (no importa el orden)                             */
	public ListIF<String> getPlayListIDs(){
		return this.playListManager.getIDs();
	}

	/** Devuelve el contenido de una lista de reproducción                      */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción de la que se quiere obtener su contenido */
	/** @return  -si en el reproductor existe una lista de reproducción con ese */
	/**          identificador, se devolverá una lista con su contenido         */
	/**          -en caso contrario, se devolverá una lista vacía               */
	public ListIF<Integer> getPlayListContent(String playListID){
		if(!this.playListManager.contains(playListID)) {
			return new List<>();
		}
		return this.playListManager.getPlayList(playListID).getPlayList();
	}

	/** Devuelve los identificadores de las canciones contenidas en la cola de  */
	/** reproducción                                                            */
	/** @return  una lista con los identificadores de las canciones que están   */
	/**          en la cola de reproducción (ha de conservar el orden en el que */
	/**          se introdujeron las canciones)                                 */
	public ListIF<Integer> getPlayBackQueue(){
		return this.playBackQueue.getContent();
	}

	/** Devuelve los identificadores de las últimas canciones reproducidas que  */
	/** están almacenadas en RecentlyPlayed                                     */
	/** @return  una lista con los identificadores de las últimas canciones     */
	/**          reproducidas (en el orden inverso al que se reprodujeron)      */
	public ListIF<Integer> getRecentlyPlayed(){
		return this.recentlyPlayed.getContent();
	}

	/** Crea una nueva lista de reproducción a partir de su identificador       */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          nueva lista de reproducción                                    */
	/** @pos     -si no existe una lista de reproducción con ese identificador, */
	/**          se crea                                                        */
	/**          -en caso contrario, no se hace nada                            */
	public void createPlayList(String playListID) {
		this.playListManager.createPlayList(playListID);
	}

	/** Elimina una lista de reproducción del reproductor a partir de su        */
	/** identificador                                                           */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción a eliminar                               */
	/** @pos     -si existe una lista de reproducción con ese identificador, se */
	/**          elimina                                                        */
	/**          -en caso contrario, no se hace nada                            */
	public void removePlayList(String playListID) {
		this.playListManager.removePlayList(playListID);
	}

	/** Añade una lista de identificadores de canciones del repositorio a una   */
	/** lista de reproducción                                                   */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción a la que se van a añadir las canciones   */
	/**          -una lista de identificadores de canciones contenidas en el    */
	/**          repositorio                                                    */
	/** @pre     -todos los elementos de la lista son identificadores de        */
	/**          canciones que existen dentro del repositorio                   */
	/** @pos     -si existe una lista de reproducción con ese identificador, se */
	/**          añaden a ella los identificadores contenidos en la lista       */
	/**          -en caso contrario, no se hace nada                            */
	public void addListOfTunesToPlayList(String playListID,ListIF<Integer> lT) {
		if(this.playListManager.contains(playListID)) {
			this.playListManager.listaReproduccion.addListOfTunes(lT);
			
			/*
			ListIF<Integer> playList = this.playListManager.getPlayList(playListID).getPlayList();
			IteratorIF<Integer> iterator = playList.iterator();
			while(iterator.hasNext()) {
				
				playListManager.listaReproduccion.addListOfTunes(lT);
				
				int tuneID= lT.get(maxRecentlyPlayed);
				if(!playList.contains(tuneID)) {
					playList.insert(playList.size()+1, tuneID);
					this.playListManager.listaReproduccion.addListOfTunes(lT);
				}
				iterator.getNext();
			}
			*/
		}
	}

	/** Añade los identificadores de todas las canciones del repositorio que    */
	/** cumplan los criterios indicados a una lista de reproducción             */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción a la que se van a añadir las canciones   */
	/**          -una cadena de caracteres con el título de la canción buscada  */
	/**          -una cadena de caracteres con el autor de la canción buscada   */
	/**          -una cadena de caracteres con el género de la canción buscada  */
	/**          -una cadena de caracteres con el álbum al que pertenece la     */
	/**          canción buscada                                                */
	/**          -un entero con el primer año del intervalo en el que se        */
	/**          publicó la canción a buscar                                    */
	/**          -un entero con el último año del intervalo en el que se        */
	/**          publicó la canción a buscar                                    */
	/**          -un entero con la duración mínima de la canción a buscar       */
	/**          -un entero con la duración máxima de la canción a buscar       */
	/** @pos     -si existe una lista de reproducción con ese identificador, se */
	/**          añaden a ella los identificadores de todas las canciones del   */
	/**          repositorio que cumplan todos los criterios indicados          */
	/**          -en caso contrario, no se hace nada                            */
	public void addSearchToPlayList(String playListID,
	                                  String t, String a, String g, String al,
	                                  int min_y, int max_y,
	                                  int min_d, int max_d) {
		ListIF listOfTunes = this.getSearchResultList(t, a, g, al, min_y, max_y, min_d, max_d);
		if(listOfTunes.size()>0) {
			this.addListOfTunesToPlayList(playListID, listOfTunes);
		}
	}

	/** Elimina una canción de una lista de reproducción                        */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción de la que se quiere eliminar la canción  */
	/**          -un entero con el identificador de la canción del repositorio  */
	/**          que se quiere eliminar de dicha lista                          */
	/** @pos     -si existe una lista de reproducción con se identificador, se  */
	/**          elimina de dicha lista todas las apariciones del identificador */
	/**          de la canción del repositorio pasada como parámetro            */
	/**          -en caso contrario, no se hace nada                            */
	public void removeTuneFromPlayList(String playListID,int tuneID) {
		if(this.playListManager.contains(playListID)) {
			this.playListManager.getPlayList(playListID).removeTune(tuneID);
		}
	}

	/** Añade una lista de identificadores de canciones del repositorio a la    */
	/** cola de reproducción                                                    */
	/** @param   -una lista de identificadores de canciones contenidas en el    */
	/**          repositorio
	/** @pre     -todos los elementos de la lista son identificadores de        */
	/**          canciones que existen dentro del repositorio                   */
	/** @pos     se añaden a la cola de reproducción los identificadores de las */
	/**          canciones contenidos en la lista                               */
	public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
		this.playBackQueue.addTunes(lT);
	}

	/** Añade los identificadores de todas las canciones del repositorio que    */
	/** cumplan los criterios indicados a la cola de reproducción               */
	/** @param   -una cadena de caracteres con el título de la canción buscada  */
	/**          -una cadena de caracteres con el autor de la canción buscada   */
	/**          -una cadena de caracteres con el género de la canción buscada  */
	/**          -una cadena de caracteres con el álbum al que pertenece la     */
	/**          canción buscada                                                */
	/**          -un entero con el primer año del intervalo en el que se creó   */
	/**          la canción a buscar                                            */
	/**          -un entero con el último año del intervalo en el que se creó   */
	/**          la canción a buscar                                            */
	/**          -un entero con la duración mínima de la canción a buscar       */
	/**          -un entero con la duración máxima de la canción a buscar       */
	/** @pos     se añaden a la cola de reproducción los identificadores de     */
	/**          todas las canciones del repositorio que cumplan todos los      */
	/**          criterios indicados                                            */
	public void addSearchToPlayBackQueue(String t, String a, String g, String al,
	                                       int min_y, int max_y,
	                                       int min_d, int max_d) {
		ListIF tunesList = this.getSearchResultList(t, a, g, al, min_y, max_y, min_d, max_d);
		if(tunesList.size() > 0) {
			this.playBackQueue.addTunes(tunesList);
		}
	}

	/** Añade el contenido de una lista de reproducción a la cola de            */
	/** reproducción                                                            */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción cuyo contenido se desea añadir a la cola */
	/**          de reproducción                                                */
	/** @pos     -si existe una lista de reproducción con se identificador, se  */
	/**          añade su contenido a la cola de reproducción                   */
	/**          -en caso contrario, no se hace nada                            */
	public void addPlayListToPlayBackQueue(String playListID) {
		if(!this.playListManager.contains(playListID)) {
			return;
		}
		
		ListIF tunesList = this.playListManager.getPlayList(playListID).getPlayList();
		if(tunesList.size() > 0) {
			this.playBackQueue.addTunes(tunesList);
		}
	}

	/** Vacía la cola de reproducción                                           */
	/** @pos     -la cola de reproducción se vacía                              */
	public void clearPlayBackQueue() {
		this.playBackQueue.clear();
	}

	/** Reproduce la siguiente canción en la cola de reproducción               */
	/** @pos     -si la cola de reproducción no es vacía, se elimina de ella el */
	/**          primer elemento, pasando éste a la estructura que almacena las */
	/**          últimas canciones reproducidas, sin sobrepasar su tamaño       */
	/**          máximo                                                         */
	/**          -en caso contrario, no se hace nada                            */
	public void play() {
		int lastTuneID = this.playBackQueue.getFirstTune();
		if(lastTuneID > -1) {
			this.playBackQueue.extractFirstTune();
			this.recentlyPlayed.addTune(lastTuneID);
		}
	}
	
	
	/**********************************************/
	/**             CLASE AUXILIAR 			     **/
	/**********************************************/
	private ListIF<Integer> getSearchResultList(String t, String a, String g, String al, int min_y, int max_y, int min_d, int max_d){
		QueryIF query = new Query(t, a, g, al, min_y, max_y, min_d, max_d);
		ListIF<Integer> listOfTunes = new List<>();
		for(int i=0; i<this.tCollection.size(); i++) {
			TuneIF tune = this.tCollection.getTune(i);
			if(tune.match(query)) {
				listOfTunes.insert(listOfTunes.size()+1, i);
			}
		}
		return listOfTunes;
	}

}
