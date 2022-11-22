package g1.venta.pc;
import java.util.ArrayList;

public class PC_HP extends PC {
    private String nombreH;
    private int id;
    protected static int cont = 0;
    
    public PC_HP(String tp, GAMMA g, String nh) {
        super(tp);
        this.nombreH = nh;
        this.id = PC_HP.cont++;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        PC_HP.cont = cont;
    }

    @Override
    public String getTipo_pc() {
        return this.tipo_pc;
    }

    @Override
    public void setTipo_pc(String tipo_pc) {
        this.tipo_pc = tipo_pc;
    }

    @Override
    public int getPrecio() {
        return this.precio;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public GAMMA getGamma() {
        return this.gamma;
    }

    @Override
    public void setGamma(GAMMA gamma) {
        this.gamma = gamma;
    }

    @Override
    public ArrayList <COMPONENTE> getComponentes() {
        return componentes;
    }

    @Override
    public void setComponentes(ArrayList <COMPONENTE> componentes) {
        this.componentes = componentes;
    } 
}