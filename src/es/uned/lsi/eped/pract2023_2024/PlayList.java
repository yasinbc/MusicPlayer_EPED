package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayList implements PlayListIF {

	private ListIF<Integer> listaTuneIDs;


	public PlayList() {
		listaTuneIDs = new List<>();
	}

	////Devuelve lista IDs de canciones de la lista de reproducción
	public ListIF<Integer> getPlayList() {
		return listaTuneIDs;
	}

	//Añade lista IDs de canciones a la lista de reproducción
	public void addListOfTunes(ListIF<Integer> lT) {
		IteratorIF<Integer> iterador = lT.iterator();
		while (iterador.hasNext()) {
			listaTuneIDs.insert(listaTuneIDs.size() + 1, iterador.getNext());
		}
	}

	//Elimina todas las apariciones de un ID de canción de la lista de reproducción
	public void removeTune(int tuneID) {
		IteratorIF<Integer> it = listaTuneIDs.iterator();
		int index = 1;
		while (it.hasNext()) {
			Integer TuneIDActual = it.getNext();
			if (TuneIDActual.equals(tuneID)) {
				listaTuneIDs.remove(index);
			}else {				
				index++;
			}
		}
	}

}
