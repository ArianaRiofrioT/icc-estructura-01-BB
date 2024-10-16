import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona.DetallePersona> personas = new ArrayList<>();

        System.out.print("Ingrese cantidad de personas: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            int edad;
            while (true) {
                System.out.print("Edad: ");
                edad = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (edad >= 0) { // Verificar si la edad es negativa
                    break; // Salir del bucle si la edad es válida
                } else {
                    System.out.println("Por favor, ingrese una edad válida (no puede ser negativa).");
                }
            }

            personas.add(new Persona.DetallePersona(nombre, edad));
        }

        Collections.sort(personas); // Ordenar por edad

        System.out.print("Ingrese la edad a buscar: ");
        int edadBuscada = scanner.nextInt();

        int indice = Persona.buscar(personas, edadBuscada); 

        if (indice != -1) {
            System.out.println("Persona encontrada: " + personas.get(indice));
        } else {
            System.out.println("Persona no encontrada");
        }

        scanner.close();
    }
}
