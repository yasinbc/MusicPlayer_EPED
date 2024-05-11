package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;

public class PlayBackQueue implements PlayBackQueueIF {

	private Queue<Integer> tuneIDs;

	PlayBackQueue() {
		super();
		tuneIDs = new Queue<>();
	}

	//Devuelve lista con IDs de canciones contenidas en cola de reproduccion
	public ListIF<Integer> getContent() {
		ListIF<Integer> listaIDs = new List<>();
		IteratorIF<Integer> it = tuneIDs.iterator();
		while (it.hasNext()) {
			listaIDs.insert(listaIDs.size() + 1, it.getNext());
		}
		return listaIDs;
	}

	//Devuelve un entero con el identificador de la primera cancion de la cola
	public int getFirstTune() {
		return this.tuneIDs.getFirst();
	}

	//Indica si la cola de reproduccion esta vacia o no
	public boolean isEmpty() {
		return this.tuneIDs.isEmpty();
	}

	//Extrae la primera cancion que se encuentra en la cola de reproduccion
	public void extractFirstTune() {
		this.tuneIDs.dequeue();
	}

	//Añade lista identificadores a la cola de reproduccion
	public void addTunes(ListIF<Integer> lT) {
		IteratorIF<Integer> iteradorLista = lT.iterator();
		while (iteradorLista.hasNext()) {
			this.tuneIDs.enqueue(iteradorLista.getNext());
		}

	}

	//Vacia la cola de reproduccion
	public void clear() {
		this.tuneIDs.clear();
	}
}
