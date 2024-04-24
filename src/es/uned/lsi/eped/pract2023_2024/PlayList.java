package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.*;

/** Representación de una lista de reproducción                               */
public class PlayList implements PlayListIF{
	
	private ListIF<Integer> listaReproduccion;
	
	public PlayList() {
		listaReproduccion = new List<Integer>();
	}

	/** Devuelve la lista de identificadores de canciones de la lista de        */
	/** reproducción                                                            */
	/** @return  -una lista de enteros con los identificadores de las canciones */
	/**          contenidas en la lista de reproducción                         */
	public ListIF<Integer> getPlayList(){
		
		ListIF<Integer> listaAuxiliar = new List<>();
		listaAuxiliar.clear();
		IteratorIF<Integer> iterator = listaReproduccion.iterator();
		while(iterator.hasNext()) {
			Integer numero = iterator.getNext();
			listaAuxiliar.insert(listaAuxiliar.size()+1, numero);
		}
		return listaAuxiliar;
		
		/***************************************/
		/*
		ListIF<Integer> playListID = new List<>();
		int i=0;
		while(this.playList.iterator().hasNext()) {
			playListID.insert(i, this.playList.get(i));
		}
		return playListID;
		*/
		/***************************************/
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
		IteratorIF<Integer> iterator = lT.iterator();
		while(iterator.hasNext()) {
			Integer numero = iterator.getNext();
			listaReproduccion.insert(listaReproduccion.size()+1, numero);
		}
		
		/***************************************/
		/*if(!lT.isEmpty()) {
			int i=0;
			while(lT.iterator().hasNext()) {
				this.playList.insert(this.playList.size()+1+i, lT.get(i));
			}
		}
		*/
		/***************************************/
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
		
		IteratorIF<Integer> iterator = listaReproduccion.iterator();
		int posicion;
		posicion = 1;
		while(iterator.hasNext()) {
			Integer numero = iterator.getNext();
			if(numero == tuneID) {
				listaReproduccion.remove(posicion);
			}else {
				posicion++;
			}
		}
		
		/***************************************/
		/*
		int pos = 0;
		while(this.playList.iterator().hasNext()) {
			if(this.playList.contains(tuneID)) {
				this.playList.remove(tuneID);
			}
		}
		*/
		/***************************************/
	}
	/** METODO DE PRUEBA, BORRAR AL FINAL */
	public static void main(String [] args ) {
		String pathSongs = args[0];
//		TuneCollection tuneCollection = new TuneCollection(pathSongs);
		PlayList playList = new PlayList();
		
		System.out.println(playList.getPlayList());
	}
}
