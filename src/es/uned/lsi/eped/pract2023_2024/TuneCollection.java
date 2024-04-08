package es.uned.lsi.eped.pract2023_2024;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

/** Representación del repositorio de canciones                               */
public class TuneCollection implements TuneCollectionIF{

	private Tune[] collection;
	
	//recibe el path del fichero de canciones.
	public TuneCollection(String fileTunes) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(new 
				FileInputStream(fileTunes), "UTF-8"));
		String line;
		//1ª linea tiene el nombre de los campos, se lee y se ignora.
		line = in.readLine();
		ListIF<Tune> L = new List<Tune>();
		while((line = in.readLine())!=null) {
			 StringTokenizer st = new StringTokenizer(line,"\t");
                         Tune T = new Tune(st.nextToken(),
                                           st.nextToken(),
                                           st.nextToken(),
                                           st.nextToken(),
                                           Integer.valueOf(st.nextToken()),
                                           Integer.valueOf(st.nextToken()));
			 L.insert(1, T);
		} 
		in.close();
		collection = new Tune[L.size()];
		int cont = L.size()-1;
		IteratorIF<Tune> iteratorL = L.iterator();
		while(iteratorL.hasNext()){
			Tune T = iteratorL.getNext();
			collection[cont] = T;
			cont--;
		}
	}
	
	/** Devuelve el tamaño de la colección de canciones                         */
	/** @return  -devuelve un entero con el número de canciones almacenadas     */
	public int size(){
		return collection.length;
	}
	
	/** Devuelve una canción a partir de su identificador                       */
	/** @param   -un entero con el identificador de la canción a recuperar      */
	/** @pre     0<=ID<this.size()                                              */
	/** @return  -un objeto TuneIF con la canción con el identificador recibido */
	//pre-cond: 0<=ID<this.size().
	public Tune getTune(int ID){
		/*
		if(0<=ID && ID<this.size()) {
			return collection[ID];
		}else {
			return collection[0];
		}
		*/
		return collection[ID];
	}
}
