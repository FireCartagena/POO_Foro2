package todopc;

import java.util.*;
import java.util.ArrayList;

import java.io.IOException;
import javax.swing.JOptionPane;

// Importamos las 3 clases creadas para los equipos
import todopc.Desktop;
import todopc.Laptop;
import todopc.Tablet;

/**
 *
 */
public class TODOPC{
    // Declaramos las variables que almacenaran la cola de equipos
    private static ArrayList<Desktop> desktop = new ArrayList<>();
    private static ArrayList<Laptop> laptop = new ArrayList<>();
    private static ArrayList<Tablet> tablet = new ArrayList<>();
    
    // Declaramos las variables intermediarias
    private static Desktop desk = new Desktop();
    private static Laptop lapt = new Laptop();
    private static Tablet tabl = new Tablet();
    
    // Declaramos las variables que se usaran como valor maximo/minimo para la muestra de equipos
    private static int mostrarMin;
    private static int mostrarMax;
    private static int mostrarRegresar;
    
    // Declaramos de manera global el controlador de entradas
    static Scanner scanner = new Scanner(System.in); // Para hacer uso de la lectura de datos1
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        boolean salir = true;
        
        while(salir){
            limpiarPantalla();
            System.out.print("Bienvenido \n");
            System.out.print("Seleccione una opcion: \n");
            System.out.print("1. Registrar equipo \n");
            System.out.print("2. Ver equipos \n");
            System.out.print("3. Salir \n");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    // Mostramos la pantalla para registrar equipos
                    registrarEquipos();
                    break;
                case 2:
                    // Mostramos el menu para mostrar el detalle de los equipos
                    mostrarEquipos();
                    break;
                case 3:
                    // Salimos del programa
                    salir = false;
                    break;
                default:
                    System.out.print("Opcion no valida, intente de nuevo \n");
                    esperar();
                    break;
            }
        }
    }
    
    /**
     * Menu para registrar los equipos
     */
    public static void registrarEquipos(){
        boolean salir = true;
        int opcion;
        
        while(salir){
            limpiarPantalla();
            
            System.out.print("Seleccione una opcion: \n");
            System.out.print("1. Registrar equipo Desktop \n");
            System.out.print("2. Registrar equipo Laptop \n");
            System.out.print("3. Registrar equipo Tablet \n");
            System.out.print("4. Regresar \n");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    // Registramos un nuevo desktop
                    desk.SetNuevoDesktop();
                    desktop.add(desk);
                    break;
                case 2:
                    // Registramos una nueva laptop
                    lapt.SetNuevoLaptop();
                    laptop.add(lapt);
                    break;
                case 3:
                    // Registramos una nueva tablet
                    tabl.SetNuevoTablet();
                    tablet.add(tabl);
                    break;
                case 4:
                    // Regresamos al menu principal
                    salir = false;
                    break;
                default:
                    System.out.print("Opcion no valida, intente de nuevo \n");
                    esperar();
                    break;
            }
        }
    }
    
    /**
     * Menu para mostrar los equipos
     */
    public static void mostrarEquipos(){
        // Variables para el manejo del menu del tipo de equipo a visualizar
        int opcion;
        boolean salir = true;
        
        // Variables para el manejo de equipo a mostrar
        int mostrarOpcion = 0;
        boolean salirMostrar = true;
        String info = "";
        
        while(salir){
            limpiarPantalla();
            System.out.print("Seleccione una opcion: \n");
            System.out.print("1. Mostrar equipos Desktop \n");
            System.out.print("2. Mostrar equipos Laptop \n");
            System.out.print("3. Mostrar equipos Tablet \n");
            System.out.print("4. Regresar \n");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    salirMostrar = true;
                    while(salirMostrar){
                        // Mostramos el listado de equipos disponibles
                        limpiarPantalla();
                        System.out.print("Seleccione una opcion: \n");
                        mostrarEquiposAuxiliar(desktop);
                        System.out.print(mostrarRegresar+". Regresar \n");
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        
                        // Verificamos selecciono una opcion valida
                        if((opcion>=mostrarMin) && (opcion<= mostrarMax)){
                            // Mostramos la informacion del equipo solicitado
                            mostrarOpcion = opcion - 1;
                            info = desktop.get(mostrarOpcion).GetInfo();
                            JOptionPane.showMessageDialog(null, info);
                        }else if(opcion == mostrarRegresar){
                            // Le indicamos al programa que se debe regresar
                            salirMostrar = false;
                        }else{
                            System.out.print("Opcion no valida, intente de nuevo \n");
                            esperar();
                        }
                    }
                    break;
                case 2:
                    salirMostrar = true;
                    while(salirMostrar){
                        // Mostramos el listado de equipos disponibles
                        limpiarPantalla();
                        mostrarEquiposAuxiliar(laptop);
                        System.out.print(mostrarRegresar+". Regresar \n");
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        
                        // Verificamos selecciono una opcion valida
                        if((opcion>=mostrarMin) && (opcion<= mostrarMax)){
                            // Mostramos la informacion del equipo solicitado
                            mostrarOpcion = opcion - 1;
                            info = laptop.get(mostrarOpcion).GetInfo();
                            JOptionPane.showMessageDialog(null, info);
                        }else if(opcion == mostrarRegresar){
                            // Le indicamos al programa que se debe regresar
                            salirMostrar = false;
                        }else{
                            System.out.print("Opcion no valida, intente de nuevo \n");
                            esperar();
                        }
                    }
                    break;
                case 3:
                    salirMostrar = true;
                    while(salirMostrar){
                        // Mostramos el listado de equipos disponibles
                        limpiarPantalla();
                        mostrarEquiposAuxiliar(tablet);
                        System.out.print(mostrarRegresar+". Regresar \n");
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        
                        // Verificamos selecciono una opcion valida
                        if((opcion>=mostrarMin) && (opcion<= mostrarMax)){
                            mostrarOpcion = opcion - 1;
                            info = tablet.get(mostrarOpcion).GetInfo();
                            JOptionPane.showMessageDialog(null, info);
                        }else if(opcion == mostrarRegresar){
                            // Le indicamos al programa que se debe regresar
                            salirMostrar = false;
                        }else{
                            System.out.print("Opcion no valida, intente de nuevo \n");
                            esperar();
                        }
                    }
                    break;
                case 4:
                    // Le indicamos al programa que se debe regresar
                    salir = false;
                    break;
                default:
                    System.out.print("Opcion no valida, intente de nuevo \n");
                    esperar();
                    break;
            }
        }
    }
    
    /**
     * Mostramos el listado disponible de equipos para mostrar su detalle
     * @param lista 
     */
    public static void mostrarEquiposAuxiliar(ArrayList<?> lista){
        int max = 1;
        
        // Inicializamos todas la variables que se usan para mostrar el detalle
        mostrarMax = 0;
        mostrarMin = 0;
        mostrarRegresar = max;
        
        // Mostramos el listado de equipo para su seleccion
        for(Object elemento: lista){
            System.out.print("Mostrar equipo : "+max+"\n");
            mostrarMax = max;
            max = max + 1;
        }
        mostrarRegresar = max;
    }
    
    /**
     * Limpiamos la pantalla y la preparamos para una nueva muestra de informacion
     */
    public static void limpiarPantalla(){
         try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Ejecutar el comando 'cls' en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Ejecutar el comando 'clear' en Linux o macOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Esperamos que el usuario presione enter para continuar
     */
    public static void esperar(){
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
        System.out.println("Continuando con el programa...");
    }
}
