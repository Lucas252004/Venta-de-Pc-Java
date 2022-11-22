package g1.venta.pc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class PRINCIPAL {
    Consultas_SQL consulta;
    //Creamos una PC_ARMADA (Los valores especificados en los parametros seran modificados a lo largo del programa)
    //Por lo tanto estos valores no afectaran al flujo del mismo
    PC_ARMADA pcA = new PC_ARMADA("Gamer", GAMMA.ALTA, "PCA1");
    //Creamos un objeto de tipo control;
    CONTROL c1 = new CONTROL();
    double precio = 0.0; //En esta variable se guarda el total facturado por el ultimo cybermonday
    // CLASE EJECUTABLE
    public static void main(String[] args) {
        //LE PREGUNTAMOS AL EMPLEADO SU NUMERO DE ID
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID del Empleado",
            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
        //SE CREA UN NUEVO EMPLEADO CON EL ID INGRESADO
        EMPLEADO e1 = new EMPLEADO(id);
        PRINCIPAL miPrincipal = new PRINCIPAL();
        //LLAMAMOS AL METODO verMenu(e1) PARA DESPLEGAR EL MENU PRINCIPAL
        miPrincipal.verMenu(e1);
    }
    
    private void verMenu(EMPLEADO e1) {
        Object [] opcion = {"Cliente", "Empleado", "Pedido", "PC-HP","Organizacion"}; 
        String opciones = (String)JOptionPane.showInputDialog(null, "Selecciona lo que desea gestionar", "Elegir",
                JOptionPane.QUESTION_MESSAGE,null, opcion, null);
        String textoMenu = "Menú Principal\n\n";
        // Se hace un switch con las opciones principales del menu cada opcion llama a un metodo en particular
        switch(opciones) {
            //OPCION CLIENTE
            case "Cliente":
                Object [] opcionC = {"Registrar", "Consultar", "Ver Lista", "Salir"}; 
                String opcionesC = (String)JOptionPane.showInputDialog(null, "Selecciona lo que desea gestionar", "Elegir",
                        JOptionPane.QUESTION_MESSAGE, null, opcionC, null);
                
                switch(opcionesC) {
                    
                    case "Registrar":
                        textoMenu += "1. Registrar Cliente\n";
                        registrarPersona();
                        verMenu(e1);
                        
                        break;
                        
                    case "Consultar":
                        textoMenu += "2. Consultar Cliente\n";
                        int doc = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID del Cliente",
                                "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
                        buscarPersona(doc);
                        verMenu(e1);
                        
                        break;
                        
                    case "Ver Lista":
                        textoMenu += "3. Ver Lista de Clientes\n";
                        obtenerRegistros();
                        verMenu(e1);
                        
                        break;
                        
                    case "Salir":
                       textoMenu += "11. Salir.\n\n"; 
                       System.exit(0);
                       
                       break;
                       
                    default:
                    JOptionPane.showMessageDialog(null, "Ingrese un " + "numero valido",
                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    verMenu(e1);
                }          
               
                break;
            //OPCION EMPLEADO    
            case "Empleado":
                Object [] opcionE = {"Registrar", "Consultar", "Ver Lista", "Salir"}; 
                String opcionesE = (String)JOptionPane.showInputDialog(null, "Selecciona lo que desea gestionar", "Elegir",
                        JOptionPane.QUESTION_MESSAGE, null, opcionE, null);
                
                switch(opcionesE) {
                    
                    case "Registrar":
                        textoMenu += "4. Registrar Empleado\n";
                        registrarEmpleado();
                        verMenu(e1);
                        
                        break;
                        
                    case "Consultar":
                        textoMenu += "5. Consultar Empleado\n";
                        int doc1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID del Empleado",
                                "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
                        buscarEmpleado(doc1);
                        verMenu(e1);
                        
                        break;
                        
                    case "Ver Lista":
                        textoMenu += "6. Ver Lista de Empleados\n";
                        obtenerEmpleados();
                        verMenu(e1);
                        
                        break;
                        
                    case "Salir":
                       textoMenu += "11. Salir.\n\n"; 
                       System.exit(0);
                       
                       break;
                       
                    default:
                    JOptionPane.showMessageDialog(null, "Ingrese un " + "numero valido",
                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    verMenu(e1);
                }
                
                break;
            //OPCION PEDIDO    
            case "Pedido":
                String [] TIPO = {"Armada","HP"}; 
                int Opcion = JOptionPane.showOptionDialog(null, "¿Que tipo de PC quieres?", "Elegir",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, TIPO, null);
                // Se analiza si la PC sera armada o una PC HP
                if(TIPO[Opcion] == "Armada") {
                    // Le mostramos al usuario un menu para elegir los componentes
                    pcA.verMenuComponentes();
                    // Mostramos los componentes elegidos
                    pcA.mostrarComponentes();
                    // Guardamos el valor total de la pc en una variable y lo mostramos
                    int total = pcA.calcularPrecio();
                    System.out.println("*********TOTAL DE LA PC ARMADA " + total + "**********************");
                    // Ingresa el numero de id del cliente para aplicar el descuento si existe el mismo
                    int doc = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID del Cliente",
                            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
                    int descuento = buscarPersona(doc);
                    // Ingresamos el id del empleado que gestiono el pedido
                    int id_empleado_pedido = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID del Empleado",
                            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
                    // Se ingresa la fecha del pedido
                    String fecha = (JOptionPane.showInputDialog(null, "Ingrese la fecha del pedido",
                            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));       
                    LocalDate fecha_pedido = LocalDate.parse(fecha);
                    System.out.println("**************DESCUENTO APLICADO***************");
                    System.out.println(descuento);
                    // Creamos una clase pedido para guardar la pc
                    PEDIDO p1 = new PEDIDO();
                    double precio_final = p1.aplicarDescuento(descuento, total);
                    System.out.println("***********PRECIO FINAL FINAL FINAL " + precio_final+"******************************");
                    p1.agregarPC(pcA);
                    // Agregamos la venta y la comision a la base de datos
                    e1.agregarVenta(precio_final);
                    consulta.agregarVenta(e1.getId());
                    e1.agregarComision();
                    
                } else if (TIPO[Opcion] == "HP") {
                    // Mostramos todas las pc de la base de datos
                    obtenerPC();
                    // El empleado ingresa los datos de la pc que eligio el usuario
                    int nombrePC = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID de la pc elegida",
                            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
                    String nombre = (JOptionPane.showInputDialog(null, "Ingrese el nombre" + " de la pc elegida",
                            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));                    
                    int doc = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID del Cliente",
                            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
                    int descuento = buscarPersona(doc);
                    String fecha = (JOptionPane.showInputDialog(null, "Ingrese la fecha del pedido",
                            "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));       
                    LocalDate fecha_pedido = LocalDate.parse(fecha);
                    // Se realiza el descuento
                    System.out.println("**************DESCUENTO APLICADO***************");
                    System.out.println(descuento);
                    this.precio = PcElegida(nombrePC, descuento,e1);
                    //INSERTO LA PC VENDIDA A LA BASE DE DATOS
                    consulta.agregarPCVendida(nombre, fecha_pedido);
                    consulta.agregarVenta(e1.getId());
                    // Se llama al metodo buscarFecha 
                    buscarFecha(this.precio);
                }
                verMenu(e1);
                break;
            // OPCION PC-HP
            case "PC-HP":
                Object [] opcionPc = {"Registrar","Consultar","Ver Lista","PC mas vendida","Salir"}; 
                String opcionesPc = (String)JOptionPane.showInputDialog(null, "Selecciona lo que desea gestionar", "Elegir",
                        JOptionPane.QUESTION_MESSAGE, null, opcionPc, null);
                
                switch(opcionesPc) {
                    
                    case "Registrar":
                       textoMenu += "7. Registrar PC-HP\n"; 
                       registrarPC();
                       verMenu(e1);
                       
                       break;
                       
                    case "Consultar":
                        textoMenu += "8. Consultar PC-HP\n";
                        int doc2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero" + " de ID de la pc",
                                "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
                        buscarPC(doc2);
                        verMenu(e1);
                        
                        break;
                        
                    case "Ver Lista":
                        textoMenu += "9. Ver Lista de PC-HP\n";
                        obtenerPC();
                        verMenu(e1);

                        break;
                        
                    case "Salir":
                        textoMenu += "11. Salir.\n\n";
                        System.exit(0);
                        
                        break;
                    default:
                    JOptionPane.showMessageDialog(null, "Ingrese un " + "numero valido",
                            "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    verMenu(e1);
                }
            //OPCION ORGANIZACION                        
            case "Organizacion":
                Object [] opcionO = {"PC mas vendida","Total Facturado por Empleado","CyberMonday","Comisiones"}; 
                String opcionesO = (String)JOptionPane.showInputDialog(null, "Selecciona lo que desea gestionar", "Elegir",
                        JOptionPane.QUESTION_MESSAGE, null, opcionO, null);
                switch(opcionesO){
                    case "PC mas vendida":
                        textoMenu += "10. PC mas vendida\n";
                        buscarPCMasVendida(); 
                        verMenu(e1);
                        break;
                    case "Total Facturado por Empleado":
                        e1.mostrarFacturado();
                        verMenu(e1);
                        break;
                    case "CyberMonday":
                        buscarFecha(precio);
                        verMenu(e1);
                        break;
                    case "Comisiones":
                        System.out.println(calcularComisiones());
                        verMenu(e1);
                        break;
                        
                
                }
                
                break;
        }
    }
    // METODOS DE LA CLASE PRINCIPAL RELACIONADOS CON CLIENTE
    //-----------------------------------------Cliente------------------------------------
    private void registrarPersona() {
        // Se crea un objeto de tipo Consultas_SQL y de tipo CLIENTE
        consulta = new Consultas_SQL();
        CLIENTE miPersona = new CLIENTE();
        
        String mensajeIngreso = "Ingrese\n\n";
        String datosSolicitados[] = {"Nombre : ", "Apellido: ", "Id: ", "Direccion: "};
        
        String datosPersona[] = new String[4];
        // Se ingresa los datos del cliente a crear
        for (int i = 0; i < datosSolicitados.length; i++) {//solicita el ingreso del dato y se almacena en el arreglo de datosPersona
            datosPersona[i] = JOptionPane.showInputDialog(null, mensajeIngreso + datosSolicitados[i],
                "Datos Persona", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datosSolicitados[i] + datosPersona[i]);
        }
        // Se modifica los datos del cliente correspondientes
        miPersona.setNombre(datosPersona[0]);
        miPersona.setApellido(datosPersona[1]);
        miPersona.setId(Integer.parseInt(datosPersona[2]));
        miPersona.setDireccion(datosPersona[3]);
        // Se agrega el cliente a la base de datos
        consulta.registrarPersona(miPersona);
    }
    
    private void obtenerRegistros() {
        // Se crea un objeto de tipo Consultas_SQL y de tipo CLIENTE
        consulta = new Consultas_SQL();
        CLIENTE cliente;
        // Almacena en un array todos los clientes que estan en la base de datos
        ArrayList <CLIENTE> listaDePersonas = consulta.listaDePersonas();
        
        if(listaDePersonas.size() > 0) {
            int numeroPersona = 0;
            // Muestra toda la informacion de los clientes 
            for(int i = 0; i < listaDePersonas.size(); i++){
                numeroPersona++;
                cliente = listaDePersonas.get(i);
                System.out.println("****************Persona " + numeroPersona + "**********************");
                System.out.println("Id Persona: " + cliente.getId());
                System.out.println("Nombre Persona: " + cliente.getNombre());
                System.out.println("Apellido Cliente: " + cliente.getApellido());
                System.out.println("Direccion Cliente: " + cliente.getDireccion());
                System.out.println("*************************************************\n");
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Actualmente no " + "existen registros de personas",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
    private int buscarPersona(int documento) {
        //Se utiliza la variable descuento para que si el cliente existe se le aplique un 5% en el pedido
        int descuento = 0; 
        consulta = new Consultas_SQL();
        CLIENTE cliente;
        ArrayList <CLIENTE> personasEncontrada = consulta.consultarPersona(documento);
        
        if(personasEncontrada.size() > 0) {
            // Muestra los datos del cliente
            for(int i = 0; i < personasEncontrada.size(); i++){
                cliente = personasEncontrada.get(i); 
                System.out.println("****************Persona**********************");
                System.out.println("Id Persona: " + cliente.getId());
                System.out.println("Nombre Persona: " + cliente.getNombre());
                System.out.println("Apellido Cliente: " + cliente.getApellido());
                System.out.println("Direccion Cliente: " + cliente.getDireccion());
                System.out.println("*************************************************\n");
            }
            descuento += 5;
            
        } else {
            JOptionPane.showMessageDialog(null,"La id ingresada " + "no corresponde a ninguna persona",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
        // Devuelve el descuento correspondiente
        return descuento;
    }
    // METODOS DE LA CLASE PRINCIPAL RELACIONADOS CON EMPLEADO
    //--------------------------------Empleado-----------------------------
    private void registrarEmpleado() {
        // Se crea un objeto de tipo Consultas_SQL y de tipo EMPLEADO
        consulta = new Consultas_SQL();
        EMPLEADO miEmpleado = new EMPLEADO(1);
        
        String mensajeIngreso = "Ingrese\n\n";
        String datosSolicitados[] = {"Nombre : ", "Sueldo: ", "Id: ", "Cantidad de ventas: "};
        
        String datosEmpleado[] = new String[4];
        
        for (int i = 0; i < datosSolicitados.length; i++) {//solicita el ingreso del dato y se almacena en el arreglo de datosPersona
            datosEmpleado[i] = JOptionPane.showInputDialog(null, mensajeIngreso + datosSolicitados[i],
                "Datos Persona", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datosSolicitados[i] + datosEmpleado[i]);
        }
        // Modifica los datos del empleado
        miEmpleado.setNombre(datosEmpleado[0]);
        miEmpleado.setSueldo(Integer.parseInt(datosEmpleado[1]));
        miEmpleado.setId(Integer.parseInt(datosEmpleado[2]));
        miEmpleado.setCant_ventas(Integer.parseInt(datosEmpleado[3]));
        // Lo guarda en la base de datos
        consulta.registrarEmpleado(miEmpleado);
    }
    
    private void obtenerEmpleados() {
        consulta = new Consultas_SQL();
        EMPLEADO empleado;
        
        ArrayList <EMPLEADO> listaDeEmpleados = consulta.listaDeEmpleados();
        
        if(listaDeEmpleados.size() > 0) {
            int numeroPersona = 0;
            
            for(int i = 0; i < listaDeEmpleados.size(); i++){
                numeroPersona++;
                empleado = listaDeEmpleados.get(i);
                System.out.println("****************Persona " + numeroPersona + "**********************");
                System.out.println("Id Persona: " + empleado.getId());
                System.out.println("Nombre Persona: " + empleado.getNombre());
                System.out.println("Sueldo Empleado: " + empleado.getSueldo());
                System.out.println("Cantidad de ventas del Empleado: " + empleado.getCant_ventas());
                System.out.println("*************************************************\n");
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Actualmente no " + "existen registros de personas",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
    private int buscarEmpleado(int documento) {
        consulta = new Consultas_SQL();
        EMPLEADO empleado;
        ArrayList <EMPLEADO> empleadoEncontrado = consulta.consultarEmpleado(documento);
        int id_empleado = 0;
        //id_empleado = consulta.consultarEmpleado(documento);
        if(empleadoEncontrado.size() > 0) {
            
            for(int i = 0; i < empleadoEncontrado.size(); i++){
                empleado = empleadoEncontrado.get(i); 
                System.out.println("****************Persona**********************");
                System.out.println("Id Persona: " + empleado.getId());
                System.out.println("Nombre Persona: " + empleado.getNombre());
                System.out.println("Sueldo Empleado: " + empleado.getSueldo());
                System.out.println("Cantidad de ventas del Empleado: " + empleado.getCant_ventas());
                System.out.println("*************************************************\n");
                id_empleado = empleado.getId();
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"La id ingresada " + "no corresponde a ninguna persona",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
        return id_empleado;
    }
    // METODOS DE LA CLASE PRINCIPAL RELACIONADOS CON COMPUTADORAS
    //-----------------------------------------Computadoras------------------------------------
    private void registrarPC() {
        consulta = new Consultas_SQL();
        PC miPC = new PC("G");
        miPC.calcularGamma();
        String gammaString="";
        
        if(miPC.getGamma() == GAMMA.BAJA) {
            gammaString="BAJA";
            
        } else if(miPC.getGamma()==GAMMA.MEDIA) {
            gammaString="MEDIA";
            
        } else {
            gammaString="ALTA";
        }
        String mensajeIngreso = "Ingrese\n\n"; 
        String datosSolicitados[] = {"Nombre : ", "Precio: ", "Tipo: "};
        String datosPC[] = new String[3];
        
        for (int i = 0; i < datosSolicitados.length-1; i++) {//solicita el ingreso del dato y se almacena en el arreglo de datosPersona
            datosPC[i] = JOptionPane.showInputDialog(null, mensajeIngreso + datosSolicitados[i],
                    "Datos PC", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(datosSolicitados[i] + datosPC[i]);
        }
        datosPC[2]=gammaString;
        miPC.setNombre(datosPC[0]);
        miPC.setPrecio(Integer.parseInt(datosPC[1]));
        miPC.setTipo_pc(datosPC[2]);
        
        consulta.registrarComputadora(miPC);
    }
    private void obtenerPC() {
        consulta = new Consultas_SQL();
        PC pc;
        ArrayList <PC> listaDePC = consulta.listaDePC();
        
        if(listaDePC.size() > 0) {
            int numeroPC = 0;
            
            for(int i = 0; i < listaDePC.size(); i++){
                numeroPC++;
                pc = listaDePC.get(i);
                System.out.println("****************PC**********************");
                System.out.println("Nombre PC: " + pc.getNombre());
                System.out.println("Tipo PC: " + pc.getTipo_pc());
                System.out.println("Precio PC: " + pc.getPrecio());
                System.out.println("*************************************************\n");
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Actualmente no " + "existen registros de pc",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
    private void buscarPC(int documento) {
        consulta = new Consultas_SQL();
        PC pc;
        ArrayList <PC> PCEncontrada = consulta.consultarPC(documento);
        
        if(PCEncontrada.size() > 0) {
            // Busca la Pc de la base de datos que corresponda con el id ingresado almacenado en la varible documento
            for(int i = 0; i < PCEncontrada.size(); i++){
                pc = PCEncontrada.get(i); 
                System.out.println("****************PC**********************");
                System.out.println("Nombre PC: " + pc.getNombre());
                System.out.println("Tipo PC: " + pc.getTipo_pc());
                System.out.println("Precio PC: " + pc.getPrecio());
                System.out.println("*************************************************\n");
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"La id ingresada " + "no corresponde a ninguna pc",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private double PcElegida(int nombrePC, int descuento,EMPLEADO empleado){
        consulta = new Consultas_SQL();
        PC pc;
        ArrayList <PC> PCEncontrada = consulta.consultarPC(nombrePC);
        double precio = 0.0;
        if(PCEncontrada.size() > 0) {
            
            for(int i = 0; i < PCEncontrada.size(); i++){
                pc = PCEncontrada.get(i); 
                int precio_final = pc.getPrecio(); //obtiene el precio de la pc de la base de datos
                String nombre = pc.getNombre(); //obtiene el nombre de la pc de la base de datos
                System.out.println("*********TOTAL DE LA PC HP " + precio_final + "**********************");
                PEDIDO p1 = new PEDIDO(); //Crea un pedido
                precio = p1.aplicarDescuento(descuento, precio_final); //precio con descuento aplicado
                System.out.println("*********TOTAL DE LA PC HP CON DESCUENTO: " + precio);
                p1.agregarPC(pc);
                empleado.agregarVenta(precio);
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"La id ingresada " + "no corresponde a ninguna pc",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
        return precio;
    }
    
    private void buscarPCMasVendida(){
        consulta = new Consultas_SQL();
        PC pc;
        // Consulta a la base de datos la pc mas vendida
        String nombre = consulta.consultarPcMasVendida();
        // Muestra la pc mas vendida
        System.out.println(nombre);
    }
    
    
    private int calcularComisiones(){
        consulta = new Consultas_SQL();
        EMPLEADO empleado;
        // variable para guardar las comisiones
        int total_comisiones = 0;
        ArrayList <EMPLEADO> listaDeEmpleados = consulta.listaDeEmpleados();
        
        if(listaDeEmpleados.size() > 0) {
            int numeroPersona = 0;
            
            for(int i = 0; i < listaDeEmpleados.size(); i++){
                numeroPersona++;
                empleado = listaDeEmpleados.get(i);
                System.out.println("****************Persona " + numeroPersona + "**********************");
                // Obtengo la cantidad de ventas que hizo el empleado para calcular sus comisiones
                System.out.println("Cantidad de ventas del Empleado: " + empleado.getCant_ventas());
                total_comisiones += 1000 * empleado.getCant_ventas();
                System.out.println("*************************************************\n");
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Actualmente no " + "existen registros de personas",
                    "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE); 
        }
        return total_comisiones;
    }
    private double buscarFecha(double precio){
        // Metodo utilizado para guardar lo facturado en el ultimo cybermonday
        consulta = new Consultas_SQL();
        double total = 0;
        CONTROL c = new CONTROL();
        // Fechas relacionadas con el ultimo cybermonday
        Date fecha_antes = new Date(121, 10, 1);
        Date fecha_despues = new Date(121, 10, 3);
        ArrayList <PEDIDO> fechas = consulta.consultarFecha();
        for(PEDIDO p: fechas){        
            // Si la fecha del peido esta entre las dos fechas del cybermonday, acumula el precio de la pc en un variable
            if(p.getFecha().compareTo(fecha_antes) > 0 && p.getFecha().compareTo(fecha_despues) <0) {
                total += precio;
            }
        }
        // Muestra lo que se facturo en total
        JOptionPane.showMessageDialog(null, "Total facturado en el Cybermonday: " + total);
        return total;
    }
}