package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.*;

/** Representación del almacén de las últimas canciones reproducidas          */
public class RecentlyPlayed implements RecentlyPlayedIF{
	
	private ListIF<Integer> recentlyPlayed;
	
	public RecentlyPlayed() {
		this.recentlyPlayed  = new List<>();
	}
	
	/** Devuelve los identificadores de las últimas canciones reproducidas en   */
	/** el orden inverso al que fueron reproducidas                             */
	/** @return  una lista con los identificadores de las últimas canciones     */
	/**          reproducidas (en el orden inverso al que se reprodujeron)      */
	public ListIF<Integer> getContent(){
		StackIF<Integer> pila = new Stack<>();
		//IteratorIF<Integer> iterador = pila.iterator();
		ListIF<Integer> listaInvertida = new List<>();
		if(recentlyPlayed.size()>0) {
			int i=0;
			while(this.recentlyPlayed.iterator().hasNext()) {
				pila.push(this.recentlyPlayed.get(i));
				recentlyPlayed.iterator().getNext();
			}
			int j=0;
			while(pila.iterator().hasNext()) {
				listaInvertida.insert(j, pila.getTop());
				pila.pop();
			}
		}
		return listaInvertida;
	}

	/** Añade la última canción reproducida                                     */
	/** @param   -un entero con el identificador de la última canción           */
	/**          reproducida                                                    */
	/** @pos     -se añade el identificador a la estructura que almacena las    */
	/**          últimas canciones reproducidas, garantizándose que no se       */
	/**          almacenan más canciones que las marcadas por el valor máximo   */
	/**          permitido indicado en el constructor                           */
	public void addTune(int tuneID) {
		this.recentlyPlayed.insert(this.recentlyPlayed.size(), tuneID); 
	}
}
