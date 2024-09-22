/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todopc;
import javax.swing.JOptionPane;
import todopc.Equipo;

/**
 *
 * @author Javier Cartagena
 */
public class Tablet extends Computador{
    private double tamanioPantalla;
    private String tipoPantalla;
    private int tamanioMemoria;
    private String sistemaOperativo;
    
    public Tablet(){
        InicializarEquipo();
        this.tamanioPantalla = 0.00;
        this.tipoPantalla = "";
        this.tamanioMemoria = 0;
        this.sistemaOperativo = "";
    }
    
    /**
     * Configuramos un nuevo tablet
     */
    public void SetNuevoTablet(){
        String tam = "";
        String tip = "";
        String tme = "";
        String sop = "";
        boolean validate = true;
        
        SetNuevoEquipo();
        validate = true;
        while(validate){
            tam = JOptionPane.showInputDialog("Ingrese el tamaño diagonal de la pantalla (In)");
            try{
                this.tamanioPantalla = Double.parseDouble(tam);
                validate = false;
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor double valido");
                validate = true;
            }
        }
        
        tip = JOptionPane.showInputDialog("Ingrese el tipo de pantalla Capacitiva/Resistiva");
        this.tipoPantalla = tip;
        
        validate = true;
        while(validate){
            tme = JOptionPane.showInputDialog("Ingrese el tamaño de la memoria NAND (GB)");
            try{
                this.tamanioMemoria = Integer.parseInt(tme);
                validate = false;
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entero valido.");
                validate = true;
            }
        }
        validate = true;
        
        sop = JOptionPane.showInputDialog("Ingrese el sistema Operativo");
        this.sistemaOperativo = sop;
        
        JOptionPane.showMessageDialog(null, "Guardado con exito");
    }
    
    /**
     * Enviamos la informacion de tablet y la informacion heredada
     * @return 
     */
    public String GetInfo(){
        String info = "";
        
        info = GetInfoEquipo();
        info = info + " \n Tamaño pantalla: "+this.tamanioPantalla+"\" in \n Tipo de pantalla: "+this.tipoPantalla+" \n Tamaño de memoria NAND:"+this.tamanioMemoria+" GB \n Sistema Operativo:"+this.sistemaOperativo;
        
        return info;
    }
    
}
