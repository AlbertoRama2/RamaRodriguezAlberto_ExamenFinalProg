package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Exceptions.ElementoIncorrectoException;


public class ListaOrdenada<T> extends ArrayList<T> {

	Comparator<T> comparador;
	
	public ListaOrdenada(Comparator<T> comparador){
		super();
		this.comparador=comparador;
	}

 

	public ListaOrdenada() {
		
	}



	public boolean aniadir(T elemento) {
		if (elemento == null) {
			
				throw new ElementoIncorrectoException("Elemento no válido");
				} else {
			if (super.add(elemento)) {
				reverse();
				return true;
			}
		}
		return false;
	}

	
	
	public boolean borrar(T elemento) {
		if(elemento == null){
			throw new ElementoIncorrectoException("Elemento no válido");
		}
		else{
			if(super.remove(elemento)){
				reverse();
				return true;
			}
		}
		return false;
	}
	

	public void reverse() {
		Collections.sort(this, comparador);
	}

}

