package g1.venta.pc;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PC_ARMADA extends PC {
    private String nombreA;
    private int id;
    protected static int cont = 0;
    
    public PC_ARMADA(String tp, GAMMA g, String na) {
        super(tp);
        this.nombreA = na;
        this.id = PC_ARMADA.cont++;
    }
    
    public void verMenuComponentes() { 
        Object [] opcionesM = {"8g", "16g"};
        Object [] opcionesV = {"Evga Geforce 210", "Nvidia 200"}; 
        Object [] opcionesPr = {"Intel I9", "AMD Ryzen 5"};
        Object [] opcionesD = {"500 gb", "1 t"};
        Object [] opcionesMo = {"a320m-k", "B550m"};   
        //OPCIONES MEMORIA
        String opcionM = (String)JOptionPane.showInputDialog(null, "Selecciona que memoria quieres", "Elegir",
                JOptionPane.QUESTION_MESSAGE, null, opcionesM, null);
           
        if (opcionM.equals(opcionesM[0])) {
            COMPONENTE cm = new COMPONENTE("8g", 4000, "memoria");
            agregarComponente(cm);
               
        } else {
            COMPONENTE cm = new COMPONENTE("16g", 8000, "memoria");
            agregarComponente(cm);
        }
        //OPCIONES VIDEO
        String opcionV = (String)JOptionPane.showInputDialog(null, "Selecciona que memoria quieres", "Elegir",
                JOptionPane.QUESTION_MESSAGE, null, opcionesV, null);
        
        if (opcionV.equals(opcionesV[0])) {
            COMPONENTE cv = new COMPONENTE("Evga Geforce 210", 6000, "video");
            agregarComponente(cv);
            
        } else {
            COMPONENTE cv = new COMPONENTE("Nvidia 200", 7000, "video");
            agregarComponente(cv);
        }     
        //OPCIONES PROCESADOR
        String opcionP = (String)JOptionPane.showInputDialog(null, "Selecciona que memoria quieres", "Elegir",
                JOptionPane.QUESTION_MESSAGE, null, opcionesPr, null);
        
        if (opcionP.equals(opcionesPr[0])) {
            COMPONENTE cp = new COMPONENTE("Intel I9", 55000, "procesador");
            agregarComponente(cp);
            
        } else {
            COMPONENTE cp = new COMPONENTE("AMD Ryzen 5", 40000, "procesador");
            agregarComponente(cp);
        } 
        //OPCIONES DISCO
        String opcionD = (String)JOptionPane.showInputDialog(null, "Selecciona que memoria quieres", "Elegir",
                JOptionPane.QUESTION_MESSAGE, null, opcionesD, null);
        
        if (opcionD.equals(opcionesD[0])) {
            COMPONENTE cd = new COMPONENTE("500 gb", 2500, "disco");
            agregarComponente(cd);
            
        } else {
            COMPONENTE cd = new COMPONENTE("1 tb", 5000, "disco");
            agregarComponente(cd);
        }
        //OPCIONES MOTHERBOARD
        String opcionMo = (String)JOptionPane.showInputDialog(null, "Selecciona que memoria quieres", "Elegir",
                JOptionPane.QUESTION_MESSAGE, null, opcionesMo, null);
        
        if (opcionMo.equals(opcionesMo[0])) {
            COMPONENTE cmo = new COMPONENTE("a320m-k", 8000, "motherboard");
            agregarComponente(cmo);
            
        } else {
            COMPONENTE cmo = new COMPONENTE("B550m", 12000, "motherboard");
            agregarComponente(cmo);
        }
        //CREO UNA FUENTE PARA LA PC
        COMPONENTE cf = new COMPONENTE("Sentey", 5500, "fuente");
        agregarComponente(cf);

    }
    
    public void agregarComponente(COMPONENTE c) {
        this.componentes.add(c);
    }
    
    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        PC_ARMADA.cont = cont;
    }

    @Override
    public String getTipo_pc() {
        return tipo_pc;
    }

    @Override
    public void setTipo_pc(String tipo_pc) {
        this.tipo_pc = tipo_pc;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public GAMMA getGamma() {
        return gamma;
    }

    @Override
    public void setGamma(GAMMA gamma) {
        this.gamma = gamma;
    }

    @Override
    public ArrayList<COMPONENTE> getComponentes() {
        return componentes;
    }

    @Override
    public void setComponentes(ArrayList<COMPONENTE> componentes) {
        this.componentes = componentes;
    }  
}