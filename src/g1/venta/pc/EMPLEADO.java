package g1.venta.pc;
import javax.swing.JOptionPane;

public class EMPLEADO {
    private String nombre;
    private int id;
    private int sueldo;
    private int cant_ventas;
    private int cant_facturado = 0;
    private int comisiones = 0;
    
    public EMPLEADO(int id) {
        this.id = id;
    }
    
    public void datosE() {
        JOptionPane.showMessageDialog(null, "Nombre del empleado: " + this.nombre,
                "Nombre del emmpleado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "ID del empleado: " + this.id,
                "ID del empleado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Sueldo del empleado: " + this.sueldo,
                "Sueldo del empleado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Cantidad de ventas hechas por el empleado: " + this.cant_ventas,
                "Cantidad de vetas del empleado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void agregarVenta(double precioPC){
        this.cant_facturado += precioPC;
    }
    
    public void agregarComision() {
        comisiones += 1000;
    }
    
    public void mostrarFacturado() {
        System.out.println("Total facturado del empleado: " + this.id + " $" + this.cant_facturado);
    }
    
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }  

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(int s) {
        this.sueldo = s;
    }

    public int getCant_ventas() {
        return this.cant_ventas;
    }

    public void setCant_ventas(int cv) {
        this.cant_ventas = cv;
    }
}