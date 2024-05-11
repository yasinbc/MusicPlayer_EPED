package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayListManager implements PlayListManagerIF {
	
	ListIF<PlayListID> PlayListIDs;
	
	PlayListManager(){
		PlayListIDs = new List<>();
	}

	//Comprueba si existe una lista de reproducción dado su ID
	public boolean contains(String PlayListID) {
		IteratorIF<PlayListID> iterador = PlayListIDs.iterator();
		while( iterador.hasNext()) {
			if ( PlayListID == iterador.getNext().getId()) {
				return true;
			}
		}
		return false;
	}

	//Devuelve la lista de reproducción asociada a un ID
	public PlayListIF getPlayList(String PlayListID) {
		PlayList listaReproduccion = null;
		IteratorIF<PlayListID> iterador = PlayListIDs.iterator();
		while( iterador.hasNext()) {
			PlayListID listaReproductorID = iterador.getNext();
			if ( PlayListID.equals(listaReproductorID.getId())) {
				listaReproduccion = listaReproductorID.getPlayList();
			}
		}
		return listaReproduccion;
	}

	//Devuelve lista con todos los IDs de las listas de reproducción existentes
	public ListIF<String> getIDs() {
		ListIF<String> IDs = new List<>();
		IteratorIF<PlayListID> iterador = PlayListIDs.iterator();
		while( iterador.hasNext()) {
			IDs.insert(IDs.size()+1, iterador.getNext().getId());
		}
		return !IDs.isEmpty()? IDs : null;
	}

	//Crea una nueva lista de reproducción vacía y la asocia a un nuevo ID
	public void createPlayList(String PlayListID) {
		this.PlayListIDs.insert(this.PlayListIDs.size()+1, new PlayListID(PlayListID));
	}

	//Elimina una lista de reproducción asociada a un ID
	public void removePlayList(String PlayListID) {
		int index = 1;
		IteratorIF<PlayListID> iterador = this.PlayListIDs.iterator();
		while(iterador.hasNext()) {
			PlayListID listaReproduccion = iterador.getNext();
			if (listaReproduccion.getId().equals(PlayListID)) {
				this.PlayListIDs.remove(index);
			}else {
				index ++;
			}
		}

	}

	class PlayListID {
		String identificador;
		PlayList playList;

		public PlayListID(String identificador) {
			this.identificador = identificador;
			this.playList = new PlayList();
		}

		public String getId() {
			return identificador;
		}

		public PlayList getPlayList() {
			return playList;
		}

	}
}
