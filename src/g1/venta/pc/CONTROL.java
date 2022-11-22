package g1.venta.pc;
import java.util.ArrayList;

public class CONTROL {
    private ArrayList <EMPLEADO> empleados = new ArrayList();
  
    public CONTROL() {    
    }
    
    public void agregarEmpleado(EMPLEADO empleado){
        this.empleados.add(empleado);
    }  
}