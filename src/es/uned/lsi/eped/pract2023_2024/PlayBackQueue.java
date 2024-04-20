package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.*;

/** Representación de la cola de reproducción                                 */
public class PlayBackQueue implements PlayBackQueueIF{
	
	private QueueIF<Integer> colaReproduccion;
	//public ListIF<Integer> listaReproduccion;
	
	public PlayBackQueue() {
		colaReproduccion = new Queue<>();
	}
	
	/****************************************/
	/*
	public PlayBackQueue(QueueIF<Integer> cola) {
		this.cola = new Queue<>();
		this.cola = cola;
		
		this.listaReproduccion = new List<>();
	}
	*/
	/****************************************/
	
	/** Devuelve una lista con los identificadores de las canciones contenidas  */
	/** en la cola de reproducción                                              */
	/** @return  -una lista de enteros con los identificadores de las canciones */
	/**          que están en la cola de reproducción, conservando el orden en  */
	/**          el que fueron originalmente introducidos                       */
	public ListIF<Integer> getContent(){
		ListIF<Integer> listaAuxiliar = new List<>();
		QueueIF<Integer> colaReproduccionAux = new Queue<>();
		colaReproduccionAux.clear();
		colaReproduccionAux = colaReproduccion;
		while(!colaReproduccionAux.isEmpty()) {
			//Guarda el primer elemento de la cola en la lista auxiliar
			Integer elemento = colaReproduccion.getFirst();
			listaAuxiliar.insert(listaAuxiliar.size()+1, elemento);
		}
		return listaAuxiliar;
		
		/****************************************/
		/*
		IteratorIF<Integer> iteradorCola;
		iteradorCola = this.cola.iterator();
		int i=0;
		while(iteradorCola.hasNext()) {
			this.listaReproduccion.insert(this.listaReproduccion.get(i), iteradorCola.getNext());
			i++;
		}
		return listaReproduccion;
		*/
		/****************************************/
	}

	/** Devuelve un booleano indicando si la cola de reproducción es vacía o no */
	/** @return  -devuelve un valor booleano que indica si la cola de           */
	/**          reproducción está vacía o no                                   */
	public boolean isEmpty() {
		
		if(colaReproduccion.isEmpty()) {
			return true;
		}else {
			return false;
		}
		/****************************************/
		/*
		boolean isEmpty;
		
		isEmpty = (this.colaReproduccion.size()==0) ? true : false;
		return isEmpty;
		*/
		/****************************************/
	}

	/** Devuelve un entero con el identificador de la primera canción que está  */
	/** en la cola de reproducción                                              */
	/** @pre     -la cola de reproducción no está vacía                         */
	/** @return  -devuelve el identificador de la primera canción en la cola de */
	/**          reproducción                                                   */
	public int getFirstTune() {
		int firstTuneID = 0;
		if(!isEmpty()) {
			firstTuneID = this.colaReproduccion.getFirst();
		}
		return firstTuneID;
	}

	/** Extrae la primera canción que se encuentre en la cola de reproducción   */
	/** @pre     -la cola de reproducción no está vacía                         */
	/** @pos     -elimina de la cola de reproducción el primer identificador    */
	public void extractFirstTune() {
		if(!this.colaReproduccion.isEmpty()) {
			this.colaReproduccion.getFirst();
		}
		
	}

	/** Añade una lista de identificadores de canciones a la cola de            */
	/** reproducción                                                            */
	/** @param   -una lista de enteros con los identificadores de las canciones */
	/**          que se desea añadir a la lista de reproducción                 */
	/** @pre     -todos los elementos de la lista son identificadores de        */
	/**          canciones que existen dentro del repositorio                   */
	/** @pos     -añade todos los identificadores presentes en la lista al      */
	/**          final de la cola de reproducción                               */
	public void addTunes(ListIF<Integer> lT) {
		if(!lT.isEmpty()) {
			int i=1;
			while(lT.iterator().hasNext()) {
				this.colaReproduccion.enqueue(lT.get(i));
				i++;
			}
		}
	}

	/** Vacía el contenido de la cola de reproducción                           */
	/** @pos     -la cola de reproducción queda vacía, sin identificadores      */
	public void clear() {
		if(!this.colaReproduccion.isEmpty()) {
			this.colaReproduccion.clear();
		}
	}
}
