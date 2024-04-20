package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.*;

/** Representación del gestor de listas de reproducción                       */
public class PlayListManager implements PlayListManagerIF{
		
	//public TuneCollection repository;
	//private ListIF<String, PlayListIF> playList2;
	private ListIF<String> playlist;
	public PlayList listaReproduccion;
	//public String playListID;
	
	public PlayListManager() {
		this.playlist = new List<>();
		this.listaReproduccion = new PlayList();
	}
	

	/** Comprueba si existe una lista de reproducción dado su identificador     */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos saber si existe o no        */
	/** @return  -un valor booleano indicando si existe o no una lista de       */
	/**          reproducción asociada al identificador recibido como parámetro */
	public boolean contains(String playListID) {
		IteratorIF<String> iterador = this.playlist.iterator();
		while(iterador.hasNext()) {
			if(this.playlist.contains(playListID)) {
				return true;
			}
			iterador.getNext();
		}
		return false;
		
		/*********************************************/
		/*
		if(!this.playlist.isEmpty()) {
			while(this.playlist.iterator().hasNext()) {
				if(this.playlist.equals(playListID)) {
					return true;
					//return this.playlist.equals(playListID);
				}
			}
		}
		return false;
		*/
		/*********************************************/
	}
	

	/** Devuelve la lista de reproducción asociada a un identificador           */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos recuperar                   */
	/** @pre     -existe una lista de reproducción asociada al identificador    */
	/**          que se recibe como parámetro                                   */
	/** @return  -la lista de reproducción asociada al identificador recibido   */
	/**          como parámetro                                                 */
	public PlayListIF getPlayList(String playListID) {
		IteratorIF<String> iterator = this.playlist.iterator();
		//PlayList listaReproduccion = new PlayList();
		
		while(iterator.hasNext()) {
			if(this.playlist.contains(playListID)) {
				return this.playlist.getIDs();
			}
			iterator.getNext();
			PlayList pl = new PlayList();
			pl.getPlayList();
		}
		return this.listaReproduccion;
	}	
	/*************************************************************/
	/*
		if(!this.playlist.isEmpty()) {
			this.playlist.
		}
		
		for(int i=1; i<=playlist.size(); i++) {
            if (playlist.get(i).getPlayList().equals(playListID)) {
				return playlist.get(i);
			}
		}
		return null;
	}
	*/
	/*************************************************************/

	/** Devuelve una lista con todos los identificadores de las listas de       */
	/** reproducción existentes                                                 */
	/** @return  -una lista de cadenas de caracteres (todas no vacías) que son  */
	/**          los identificadores de todas las listas de reproducción        */
	/**          existentes                                                     */
	public ListIF<String> getIDs(){
		IteratorIF<String> iterator = this.playlist.iterator();
		ListIF<String> playListIDs = new List<>();
		int i=0;
		String cadena;
		while(iterator.hasNext()) {
			cadena = String.valueOf(i);
			playListIDs.insert(i+1, cadena);
		}
		
		
		return playListIDs;
		
		/******************************************/
		/*
		ListIF<String> ids = new List<>();
		for(int i=1; i<=playlist.size(); i++) {
			ids.insert(i, Integer.toString(i)+", ");
		}
		return ids;
		*/
		/******************************************/
	}

	/** Crea una nueva lista de reproducción vacía y la asocia a un nuevo       */
	/** identificador                                                           */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos crear                       */
	/** @pre     -no existe ninguna lista de reproducción asociada al           */
	/**          identificador recibido como parámetro                          */
	public void createPlayList(String playListID) {
		//ListIF<String> playList = new List<>();
		if(!this.playlist.contains(playListID)) {
			playlist.insert(playlist.size()+1, playListID);
		}
		
		/****************************************************/
		/*
		if(String.)
		if(!contains(playListID)) {
			playlist.insert(playlist.size()+1, new PlayListIF(playListID));
		}
		*/
		/****************************************************/
	}

	/** Elimina una lista de reproducción asociada a un identificador           */
	/** @param   -una cadena de caracteres no vacía con el identificador de la  */
	/**          lista de reproducción que queremos eliminar                    */
	/** @pre     -existe una lista de reproducción asociada al identificador    */
	/**          recibido como parámetro                                        */
	public void removePlayList(String playListID) {
		if(this.playlist.contains(playListID)) {
			playlist.clear();
		}
		
		/*********************************************************/
		/*
		for (int i = 1; i <= playlist.size(); i++) {
			if (playlist.get(i).getPlayList().equals(playListID)) {
				playlist.remove(i);
	            break;
	        }
		}
		*/
		/*********************************************************/
	}
	
	/** MÉTODO MAIN DE PRUEBA, BORRAR LUEGO */
	public static void main(String [] args) {
		PlayListManager plm = new PlayListManager();
		
		
		plm.getIDs();
	}
}
