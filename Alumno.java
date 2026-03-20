/**
 * @author Nombre y apellidos
 * */

package evaluador;

public class Alumno {

	private String nombre;
	private int matricula;
	private Lista expediente;

	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		expediente = new Lista();
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public boolean nuevaEvaluacion(Evaluacion evaluacion) {
        Iterador it = expediente.getIterador();
        while (it.hasNext()) {
            Evaluacion existente = it.next();
            if (existente.mismaEvaluacion(evaluacion)) {
                if (existente.getNota() == evaluacion.getNota()) {
                    return true;
                } else {
                    System.out.println("Calificación previamente insertada con nota: " + existente.getNota());
                    return false;
                }
            }
        }
        expediente.insertar(evaluacion);
        return true;
    }

	public boolean estaAprobado(String nombreAsig) {
        Boolean exito = false;
        Iterador it = this.expediente.getIterador();
        while (it.hasNext()&& !exito){
            Evaluacion elemento = it.next();
            if (elemento.getNombreAsignatura().equals(nombreAsig) && elemento.getNota() >= 5.0){
                exito = true;
            }
        }
		return exito;
	}

	public Lista asignaturasAprobadas() {
        Lista resultado = new Lista();
        Iterador it = expediente.getIterador();
        while (it.hasNext()){
            Evaluacion elemento = it.next();
            if(estaAprobado(elemento.getNombreAsignatura())){
                resultado.insertar(elemento);
            }
        }
        if (resultado.getNumElementos() == 0) resultado = null;

		return resultado;

	}

    public double mediaAprobadas() {
        double suma = 0.0;
        Lista media = asignaturasAprobadas();
        if (media.vacia()) {
            return 0.0;
        }

        Iterador iterador = media.getIterador();
        while (iterador.hasNext()){
            Evaluacion elemento = iterador.next();
            suma += elemento.getNota();
        }
        return suma / media.getNumElementos();
    }

	public int getNumAprobadas() {
        Lista resultado = asignaturasAprobadas();
		return resultado.getNumElementos();
	}

	public void mostrar() {
        System.out.println(this.nombre+ ". Matricula: "+ this.matricula);
        Iterador iterador = expediente.getIterador();
        while (iterador.hasNext()){
            Evaluacion elemento= iterador.next();
            System.out.printf("%s(%s): %0.2d",elemento.getNombreAsignatura(), elemento.getConvocatoria(), elemento.getNota());
        }
	}

}


