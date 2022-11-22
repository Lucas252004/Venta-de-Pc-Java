package g1.venta.pc;

public class CLIENTE {
    private String nombre;
    private int id;
    private String apellido;
    private String direccion;
    public CLIENTE() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String a) {
        this.apellido = a;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String d) {
        this.direccion = d;
    }
}