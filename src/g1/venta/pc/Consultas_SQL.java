package g1.venta.pc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Consultas_SQL {
    
    //----------------------------------Cliente------------------------------------
    public void registrarPersona(CLIENTE persona) {
        DbConnection conex = new DbConnection();
        
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO cliente VALUES ('" + persona.getId() + "', '"
            + persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getDireccion() + "', '" + 1 + "')");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registro el Cliente",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList <CLIENTE> consultarPersona(int documento) {
        ArrayList <CLIENTE> miCliente = new ArrayList();
        DbConnection conex = new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente where idCliente = ?");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();
            
            if (res.next()) {
                CLIENTE persona = new CLIENTE();
                persona.setId(Integer.parseInt(res.getString("idCliente")));
                persona.setNombre(res.getString("Nombres"));
                persona.setApellido(res.getString("Apellidos"));
                persona.setDireccion(res.getString("Direccion"));
                miCliente.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        
        return miCliente;
    }
    
    public ArrayList <CLIENTE> listaDePersonas() {
        ArrayList <CLIENTE> miCliente = new ArrayList();
        DbConnection conex= new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("CALL listar_clientes");
            ResultSet res = consulta.executeQuery();
            
            while (res.next()) {
                CLIENTE persona = new CLIENTE();
                persona.setId(Integer.parseInt(res.getString("idCliente")));
                persona.setNombre(res.getString("Nombres"));
                persona.setApellido(res.getString("Apellidos"));
                persona.setDireccion(res.getString("Direccion"));
                miCliente.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        
        return miCliente;
    }
    //---------------------------------------EMPLEADO---------------------------------------------
    public void registrarEmpleado(EMPLEADO empleado) {
        DbConnection conex = new DbConnection();
        
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO empleado VALUES ('" + empleado.getId() + "', '"
            + empleado.getNombre() + "', '" + empleado.getSueldo() + "', '" + empleado.getCant_ventas() + "')");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente el Empleado",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registro el Empleado",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList consultarEmpleado(int documento) {
        ArrayList <EMPLEADO> miEmpleado = new ArrayList();
        DbConnection conex = new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM empleado where idEmpleado = ?");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();
            
            if (res.next()) {
                EMPLEADO empleado = new EMPLEADO(1);
                empleado.setId(Integer.parseInt(res.getString("idEmpleado")));
                empleado.setNombre(res.getString("nombre"));
                empleado.setSueldo(Integer.parseInt(res.getString("sueldo")));
                empleado.setCant_ventas(Integer.parseInt(res.getString("cantidad_ventas")));
                miEmpleado.add(empleado);
                
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        
        return miEmpleado;
    }
    
    public ArrayList <EMPLEADO> listaDeEmpleados() {
        ArrayList <EMPLEADO> miEmpleado = new ArrayList();
        DbConnection conex= new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("CALL listar_empleados");
            ResultSet res = consulta.executeQuery();
            
            while (res.next()) {
                EMPLEADO empleado = new EMPLEADO(1);
                empleado.setId(Integer.parseInt(res.getString("idEmpleado")));
                empleado.setNombre(res.getString("nombre"));
                empleado.setSueldo(Integer.parseInt(res.getString("sueldo")));
                empleado.setCant_ventas(Integer.parseInt(res.getString("cantidad_ventas")));
                miEmpleado.add(empleado);
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar el Empleado\n" + e,
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return miEmpleado;
    }
    //---------------------------------------COMPUTADORA---------------------------------------------
    public void registrarComputadora(PC pc) {
        DbConnection conex = new DbConnection();
        
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO computadoras (nombre, tipo, precio) VALUES ('" + pc.getNombre() + "', '"
            + pc.getGamma() + "', '" + pc.getPrecio() +"')");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registro la pc",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList <PC> consultarPC(int documento) {
        ArrayList <PC> miPC = new ArrayList();
        DbConnection conex = new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM computadoras where idComputadoras = ?");
            consulta.setInt(1, documento);
            ResultSet res = consulta.executeQuery();
            
            if (res.next()) {
                PC pc = new PC("Gamer");
                pc.setNombre(res.getString("nombre"));
                pc.setTipo_pc(res.getString("tipo"));
                pc.setPrecio(Integer.parseInt(res.getString("precio")));
                miPC.add(pc);
                
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la pc" + e);
        }
        
        return miPC;
    }
    
    public ArrayList <PC> listaDePC() {
        ArrayList <PC> miPC = new ArrayList();
        DbConnection conex = new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("CALL listar_pc");
            ResultSet res = consulta.executeQuery();
            
            while (res.next()) {
                PC pc = new PC("Escritorio");
                pc.setNombre(res.getString("nombre"));
                pc.setTipo_pc(res.getString("tipo"));
                pc.setPrecio(Integer.parseInt(res.getString("precio")));
                miPC.add(pc);
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n" + e);
        }
        
        return miPC;
    }
    
    public ArrayList <PC> elegirPC(int numeroPC) {
        ArrayList <PC> miPC = new ArrayList();
        DbConnection conex = new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT precio FROM computadoras where idComputadoras = ?");
            consulta.setInt(1, numeroPC);
            ResultSet res = consulta.executeQuery();
            
            if (res.next()) {
                PC pc = new PC("Gamer");
                pc.setNombre(res.getString("nombre"));
                pc.setTipo_pc(res.getString("tipo"));
                pc.setPrecio(Integer.parseInt(res.getString("precio")));
                miPC.add(pc);
                
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la pc" + e);
        }
        
        return miPC;
    }
    
    public void agregarPCVendida(String nombrePC, LocalDate fecha) {
        DbConnection conex = new DbConnection();
        
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO gestion (fecha, producto_vendido) VALUES ( '"+fecha+"' , '" + nombrePC + "')" );
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registro la pc",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    //PARA DESPUES
    public String consultarPcMasVendida() {
        ArrayList <PC> miPC = new ArrayList();
        DbConnection conex = new DbConnection();
        String nombre = "";
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT max(producto_vendido) as producto FROM gestion ");
            ResultSet res = consulta.executeQuery();
            
            while (res.next()) {
                PC pc = new PC("Gamer");
                pc.setNombre(res.getString("producto"));
                miPC.add(pc);
                nombre = pc.getNombre();
                
            }
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la pc" + e);
        }
        
        return nombre;
    }
    
    public void agregarVenta(int idEmpleado){
        DbConnection conex = new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("UPDATE empleado SET cantidad_ventas = cantidad_ventas + 1 WHERE idEmpleado = ?");
            
            consulta.setInt(1, idEmpleado);
            int res = consulta.executeUpdate();
     
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la pc" + e);
        }
    }
    
    public ArrayList consultarFecha(){
        Date fecha = new Date();
        ArrayList<PEDIDO> fechas = new ArrayList();
        DbConnection conex = new DbConnection();
        
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT fecha FROM gestion");
            ResultSet res = consulta.executeQuery();
           
            while (res.next()){
                PEDIDO p = new PEDIDO();
                p.setFecha(res.getDate("fecha"));
                fechas.add(p);
            }
                
            res.close();
            consulta.close();
            conex.desconectar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se pudo consultar la pc" + e);
        }
        
        return fechas;
    }
}