package todopc;

import javax.swing.JOptionPane;

/**
 * 
 */
public class Equipo {
    private String fabricante;
    private String modelo;
    private String microprocesador;
    
    public Equipo(){
        this.fabricante = "";
        this.modelo = "";
        this.microprocesador = "";
    }
    
    public Equipo(String fab, String mod, String mic){
        this.fabricante = fab;
        this.modelo = mod;
        this.microprocesador = mic;
    }
    
    /**
     * Inicializamos el equipo
     */
    public void InicializarEquipo(){
        this.fabricante = "";
        this.modelo = "";
        this.microprocesador = "";
    }
    
    /**
     * Solicitamos la informacion para configurar el equipo
     */
    public void SetNuevoEquipo(){
        boolean validate = true;
        String fab = "";
        String mod = "";
        String mic = "";
        
        validate = true;
        while(validate){
            fab = JOptionPane.showInputDialog("Ingrese el nombre del fabricante");
            if(!fab.equals("")){
                this.fabricante = fab;
                validate = false;
            }else{
                JOptionPane.showMessageDialog(null, "El valor no puede estar en blanco.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                validate = true;
            }
        }
        
        validate = true;
        while(validate){
            mod = JOptionPane.showInputDialog("Ingrese el nombre del modelo");
            if(!mod.equals("")){
                this.modelo = mod;
                validate = false;
            }else{
                JOptionPane.showMessageDialog(null, "El valor no puede estar en blanco.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                validate = true;
            }
        }
        
        validate = true;
        while(validate){
            mic = JOptionPane.showInputDialog("Ingrese el tipo de procesador");
            if(!mic.equals("")){
                this.microprocesador = mic;
                validate = false;
            }else{
                JOptionPane.showMessageDialog(null, "El valor no puede estar en blanco.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                validate = true;
            }
        }
        
    }
    
    /**
     * Retornamos un string con la informacion del equipo
     * @return 
     */
    public String GetInfoEquipo(){
        String info = "";
        
        info = "Fabricante:"+this.fabricante+" \n Modelo:"+this.modelo+" \n Microprocesador:"+this.microprocesador;
        
        return info;
    }
}
