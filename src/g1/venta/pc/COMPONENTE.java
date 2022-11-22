package g1.venta.pc;

public class COMPONENTE {
    private String nombre;
    private int precio;
    private String tipo;
    
    public COMPONENTE(String n, int p, String t) {
        this.nombre = n;
        this.precio = p;
        this.tipo = t;
    }
    
    public int calcularPrecio() {
        
        switch (this.tipo) {
            
            case "memoria":
                this.precio = this.precio + 40;
                
                break;
                
            case "video":
                this.precio = this.precio + 80;
                
                break;
                
            case "procesador":
                this.precio = this.precio + 120;
                
                break;
                
            case "disco":
                this.precio = this.precio + 160;
                
                break;
                
            case "motherboard":
                this.precio = this.precio + 180;
                
                break;
                
            case "fuente":
                this.precio = this.precio + 50;
        }
        
        return this.precio;
    }
    
    public void datosC() {
        System.out.println("Nombre del componente: " + this.nombre);
        System.out.println("Precio del componente: " + this.precio);
        System.out.println("Tipo del componente: " + this.tipo);
        System.out.println("*******************************************");
    }
    
    public int getPrecio() {
        return this.precio;
    }
}