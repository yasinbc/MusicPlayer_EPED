package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.Stack;

public class RecentlyPlayed implements RecentlyPlayedIF {

	Queue<Integer> identificadores;
	int maximo;

	RecentlyPlayed(int maximo) {
		this.maximo = maximo;
		this.identificadores = new Queue<>();
	}

	//Devuelve IDs de las últimas canciones reproducidas en orden inverso al reproducido
	public ListIF<Integer> getContent() {
		List<Integer> identificadores = new List<>();
		IteratorIF<Integer> iterador = this.identificadores.iterator();

		while (iterador.hasNext()) {
			identificadores.insert(1, iterador.getNext());
		}
		return identificadores;
	}

	//Añade la última canción reproducida
	public void addTune(int tuneID) {
		this.identificadores.enqueue(tuneID);
		if (this.identificadores.size() >= this.maximo) {
			this.identificadores.dequeue();
		}
	}
}
