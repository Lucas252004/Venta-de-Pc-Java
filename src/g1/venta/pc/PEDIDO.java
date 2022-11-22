package g1.venta.pc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PEDIDO {
    protected Date fecha;
    protected int total;
    protected CLIENTE cliente;
    protected EMPLEADO empleado;
    protected ArrayList<PC> computadoras = new ArrayList();
    protected static int descuento = 5;
    
    public PEDIDO() {
      //  this.empleado = e;
    }
    
    public void agregarPC(PC p) {
        this.computadoras.add(p);
    }
    
    public void mostrarPcs() {
        for(PC p: computadoras) {
            p.mostrarComponentes();
        }
    }
    
    public double aplicarDescuento(double descuento, double precioPC){
        if(descuento != 0){
            descuento = precioPC * 0.05;
            precioPC = precioPC - descuento;
            
        }
        return precioPC;
    }
    
    public int calcularTotal() {
        for(PC p: computadoras) {
            this.total += p.calcularPrecio();
        }
        
        return this.total;
    }
    
    /*public double calcularImpuestos() {
        double precio = 0;
        precio = this.total * 1.06;
        return precio;
    }*/
    
    /*public void consultarCliente() {
        cliente.mostrarDatos();
    }*/

    public Date getFecha() {
        return this.fecha;
    }

    public int getTotal() {
        return this.total;
    }

    public CLIENTE getCliente() {
        return this.cliente;
    }

    public EMPLEADO getEmpleado() {
        return this.empleado;
    }

    public static int getDescuento() {
        return descuento;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<PC> getComputadoras() {
        return computadoras;
    }
    
}