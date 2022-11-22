package g1.venta.pc;
import java.util.ArrayList;

public class PC {
    protected int id;
    protected String tipo_pc;
    protected int precio;
    protected String nombre;
    protected GAMMA gamma;
    protected ArrayList <COMPONENTE> componentes = new ArrayList();
    
    public PC(String tp) {
        this.tipo_pc = tp;  
    }
    
    public void calcularGamma() {
        
        switch (this.precio) {
            
            case 150000:
                this.gamma = this.gamma.ALTA;
                
                break;
                
            case 90000:
                this.gamma = this.gamma.MEDIA;
                
                break;
                
            case 50000:
                this.gamma = this.gamma.BAJA;
        }       
    }
    
    public int calcularPrecio() {
        
        for (COMPONENTE c: componentes) {
            this.precio += c.getPrecio();
        }
        
        return this.precio;
    }
    
    public void mostrarComponentes() {
        
        for (COMPONENTE c: componentes) {
            c.datosC();
        }
    }

    public String getTipo_pc() {
        return tipo_pc;
    }

    public void setTipo_pc(String tipo_pc) {
        this.tipo_pc = tipo_pc;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GAMMA getGamma() {
        return gamma;
    }

    public void setGamma(GAMMA gamma) {
        this.gamma = gamma;
    }

    public ArrayList <COMPONENTE> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList <COMPONENTE> componentes) {
        this.componentes = componentes;
    } 
}