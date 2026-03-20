/**
 * @author Nombre y apellidos
 * */
package evaluador;

public class Nodo {

	private Evaluacion dato;
	private Nodo siguiente;

	public Nodo(Evaluacion dato, Nodo siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Evaluacion getDato() {
		return dato;
	}

	public void setDato(Evaluacion dato) {
		this.dato = dato;
	}
}
