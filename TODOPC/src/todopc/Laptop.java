/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todopc;
import javax.swing.JOptionPane;
import todopc.Computador;

/**
 *
 * @author Javier Cartagena
 */
public class Laptop extends Computador{
    private double tamanioPantalla;
    
    public Laptop(){
        InicializarComputador();
        this.tamanioPantalla = 0.00;
    }
    
    /**
     * Configuramos un nuevo laptop
     */
    public void SetNuevoLaptop(){
        String tam = "";
        boolean validate = true;
        
        SetNuevoComputador();
        validate = true;
        while(validate){
            tam = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla (in)");
            try{
                this.tamanioPantalla = Double.parseDouble(tam);
                validate = false;
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor double valido");
                validate = true;
            }
        }
        JOptionPane.showMessageDialog(null, "Guardado con exito");
    }
    
    /**
     * Enviamos la informacion de laptop y la informacion heredada
     * @return 
     */
    public String GetInfo(){
        String info = "";
        
        info = GetInfoComputador();
        info = info + " \n Tamaño pantalla: "+this.tamanioPantalla+"\" in";
        
        return info;
    }
}
