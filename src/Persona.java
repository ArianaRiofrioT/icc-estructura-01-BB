import java.util.ArrayList;
import java.util.Collections;

public class Persona {

    public static class DetallePersona implements Comparable<DetallePersona> {
        String nombre;
        int edad;

        public DetallePersona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
        @Override
        public int compareTo(DetallePersona otra) {
            return Integer.compare(this.edad, otra.edad);
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Edad: " + edad;
        }
    }

    public static int buscar(ArrayList<DetallePersona> personas, int edad) {
        int bajo = 0;
        int alto = personas.size() - 1;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;
            int valorCentro = personas.get(centro).edad;

            System.out.println("bajo=" + bajo + " alto=" + alto + " centro=" + centro + " valorCentro=" + valorCentro);

            if (valorCentro == edad) {
                return centro;
            } else if (valorCentro < edad) {
                System.out.println("--> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println("--> IZQUIERDA");
                alto = centro - 1;
            }
        }

        return -1; 
    }
}