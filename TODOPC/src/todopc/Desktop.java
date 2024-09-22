package todopc;
import todopc.Computador;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier Cartagena
 */
public class Desktop extends Computador{
    //private Computador computador;
    private String tarjetaGrafica;
    private int tamanioTorre;
    
    public Desktop(){
        InicializarComputador();
        this.tarjetaGrafica = "";
        this.tamanioTorre = 0;
    }
    
    /**
     * Configuramos un nuevo desktop
     */
    public void SetNuevoDesktop(){
        String tar = "";
        String tam = "";
        boolean validate = true;
        
        SetNuevoComputador();
        tar = JOptionPane.showInputDialog("Ingrese el modelo de la tarjeta grafica");
        this.tarjetaGrafica = tar;
        
        validate = true;
        while(validate){
            tam = JOptionPane.showInputDialog("Ingrese el tamaño de la torre (cm)");
            try{
                this.tamanioTorre = Integer.parseInt(tam);
                validate = false;
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor entero valido");
                validate = true;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Guardado con exito");
    }

    /**
     * Enviamos la informacion de desktop y la informacion heredada
     * @return 
     */
    public String GetInfo(){
        String info = "";
        
        info = GetInfoComputador();
        info = info + " \n Tarjeta grafica: "+this.tarjetaGrafica+" \n Tamaño torre:"+this.tamanioTorre+" cm";
        
        return info;
    }
}
