package todopc;
import javax.swing.JOptionPane;
import todopc.Equipo; // Importamos la clase equipo para utilizarla

/**
 *
 */
public class Computador extends Equipo{
    private int memoria;
    private int discoDuro;
    
    public Computador(){
        this.InicializarEquipo();
        this.memoria = 0;
        this.discoDuro = 0;
    }
    
    /**
     * Inicializamos las variables de computador y las heredadas
     */
    public void InicializarComputador(){
        this.InicializarEquipo();
        this.memoria = 0;
        this.discoDuro = 0;
    }
    
    /**
     * Configuramos un nuevo computador
     */
    public void SetNuevoComputador(){
        String mem = "";
        String cap = "";
        boolean validate = true;
        
        this.SetNuevoEquipo();
        
        validate = true;
        while(validate){
            mem = JOptionPane.showInputDialog("Ingrese la cantidad de memoria ram (GB)");
            if(!mem.equals("")){
                try{
                    this.memoria = Integer.parseInt(mem);
                    validate = false;
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor entero valido");
                    validate = true;
                }
            }else{
                JOptionPane.showMessageDialog(null, "El valor no puede estar en blanco.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                validate = true;
            }
        }
        
        validate = true;
        while(validate){
            cap = JOptionPane.showInputDialog("Ingrese la capacidad de disco duro (GB)");
            if(!cap.equals("")){
                try{
                    this.discoDuro = Integer.parseInt(cap);
                    validate = false;
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor entero valido.");
                    validate = true;
                }
            }else{
                JOptionPane.showMessageDialog(null, "El valor no puede estar en blanco.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                validate = true;
            }
        }
    }
    
    /**
     * Enviamos la informacion de computador y la informacion heredada
     * @return 
     */
    public String GetInfoComputador(){
        String info = "";
        
        info = this.GetInfoEquipo();
        info = info + "\n Memoria:"+this.memoria+" GB \n Capacidad de disco duro: "+this.discoDuro+" GB";
        
        return info;
    }
}
