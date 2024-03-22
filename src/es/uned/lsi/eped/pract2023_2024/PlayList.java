package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.*;

/** Representación de una lista de reproducción                               */
public class PlayList implements PlayListIF{
	
	private ListIF<Integer> songIds;
	
	public PlayList() {
		this.songIds = new List<Integer>();
	}

	/** Devuelve la lista de identificadores de canciones de la lista de        */
	/** reproducción                                                            */
	/** @return  -una lista de enteros con los identificadores de las canciones */
	/**          contenidas en la lista de reproducción                         */
	public ListIF<Integer> getPlayList(){
		return this.songIds;
	}

	/** Añade una lista de identificadores de canciones a la lista de           */
	/** reproducción                                                            */
	/** @param   -una lista de enteros con los identificadores de las canciones */
	/**          que se quiere añadir a la lista de reproducción                */
	/** @pre     -todos los elementos de la lista son identificadores de        */
	/**          canciones que existen dentro del repositorio                   */
	/** @pos     -el contenido de la lista recibida como parámetro se concatena */
	/**          al contenido existente en la lista de reproducción             */
	public void addListOfTunes(ListIF<Integer> lT) {
		for(int i=1; i<= lT.size(); i++) {
			songIds.insert(songIds.size()+1, lT.get(i));
		}
	}

	/** Elimina todas las apariciones de un identificador de canción de la      */
	/** lista de reproducción                                                   */
	/** @param   -un entero representando el identificador de la canción que se */
	/**          desea eliminar de la lista de reproducción                     */
	/** @pos     -del contenido de la lista de reproducción se han eliminado    */
	/**          todas las apariciones del identificador recibido como          */
	/**          parámetro. El resto de identificadores conserva su orden       */
	/**          relativo                                                       */
	public void removeTune(int tuneID){
		int pos = 1;
		while(pos<=songIds.size()) {
			if(songIds.get(pos)==tuneID) {
				songIds.remove(pos);
			}else {
				pos++;
			}
		}
	}
	
	public static void main(String [] args ) {
		PlayList playlist = new PlayList();
		playlist.addListOfTunes(playlist.songIds);
	}
}
