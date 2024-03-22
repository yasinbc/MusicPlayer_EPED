package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.*;

/** Representación del gestor de listas de reproducción                       */
public class PlayListManager implements PlayListManagerIF{
	
	private ListIF<PlayListIF> playlists;
	
	public PlayListManager() {
		this.playlists = new List<PlayListIF>();
	}

	/** Comprueba si existe una lista de reproducción dado su identificador     */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos saber si existe o no        */
	/** @return  -un valor booleano indicando si existe o no una lista de       */
	/**          reproducción asociada al identificador recibido como parámetro */
	public boolean contains(String playListID) {
		for(int i=1; i<=playlists.size(); i++) {
			if(playlists.get(i).getPlayList().equals(playListID)) {
				return true;
			}
		}
		return false;
	}

	/** Devuelve la lista de reproducción asociada a un identificador           */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos recuperar                   */
	/** @pre     -existe una lista de reproducción asociada al identificador    */
	/**          que se recibe como parámetro                                   */
	/** @return  -la lista de reproducción asociada al identificador recibido   */
	/**          como parámetro                                                 */
	public PlayListIF getPlayList(String playListID) {
		for(int i=1; i<=playlists.size(); i++) {
            if (playlists.get(i).getPlayList().equals(playListID)) {
				return playlists.get(i);
			}
		}
		return null;
	}

	/** Devuelve una lista con todos los identificadores de las listas de       */
	/** reproducción existentes                                                 */
	/** @return  -una lista de cadenas de caracteres (todas no vacías) que son  */
	/**          los identificadores de todas las listas de reproducción        */
	/**          existentes                                                     */
	public ListIF<String> getIDs(){
		ListIF<String> ids = new List<>();
		for(int i=1; i<=playlists.size(); i++) {
			ids.insert(ids.size() + 1, playlists.get(i).getPlayListID());
		}
		return ids;
	}

	/** Crea una nueva lista de reproducción vacía y la asocia a un nuevo       */
	/** identificador                                                           */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos crear                       */
	/** @pre     -no existe ninguna lista de reproducción asociada al           */
	/**          identificador recibido como parámetro                          */
	public void createPlayList(String playListID) {
		if(!contains(playListID)) {
			playlists.insert(playlists.size()+1, new PlayList(playListID));
		}
	}

	/** Elimina una lista de reproducción asociada a un identificador           */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos eliminar                    */
	/** @pre     -existe una lista de reproducción asociada al identificador    */
	/**          recibido como parámetro                                        */
	public void removePlayList(String playListID) {
		for (int i = 1; i <= playlists.size(); i++) {
			if (playlists.get(i).getPlayList().equals(playListID)) {
				playlists.remove(i);
	            break;
	        }
		}
	}
}
