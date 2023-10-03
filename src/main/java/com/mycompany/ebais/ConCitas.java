/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebais;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisd
 */
public class ConCitas extends Conexion{
    public List<Citas> lista() {
        List<Citas> listaRetorno = new ArrayList<Citas>();
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Id_doctor,id_paciente,id_consultorio,fecha FROM Citas ORDER BY idcitas");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {                  
                int doctor = rs.getInt("doctor"); 
                int paciente = rs.getInt("paciente"); 
                int consultorio = rs.getInt("consultorio"); 
                String fecha = rs.getString("fecha");
                Citas c = new Citas(doctor,paciente,consultorio,fecha);
                listaRetorno.add(c);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return listaRetorno;
    }
    
        public Citas Buscar(int idParam) {
        Citas c = null;
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Id_doctor,id_paciente,id_consultorio,fecha FROM Citas WHERE idcitas=? ORDER BY idcitas");
            stmt.setInt(1, idParam);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int doctor = rs.getInt("doctor"); 
                int paciente = rs.getInt("paciente"); 
                int consultorio = rs.getInt("consultorio");      
                String fecha = rs.getString("fecha");
                c = new Citas(doctor, paciente,consultorio,fecha);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return c;
    }
    

    public void insertar(Citas c) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("INSERT INTO citas(Id_doctor,id_paciente,id_consultorio,fecha) VALUES (?,?,?,?)");

            stmt.setInt(1, c.getDoctor());
            stmt.setInt(2, c.getPaciente());
            stmt.setInt(3, c.getConsultorio());
            stmt.setString(4, c.getFecha());

            stmt.execute();

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar cliente: " + ex.getMessage());
        }

    }

    
    public void eliminar(int idCliente) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("DELETE FROM citas WHERE idcitas = ?");
            stmt.setInt(1, idCliente);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar cliente: " + ex.getMessage());
        } 
    }
    
    
    public void pacientesDoc(int idDoctor){
        
        
        try{
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT id_paciente, id_doctor FROM citas WHERE id_doctor=?");
            stmt.setInt(1, idDoctor);
            ResultSet rs = stmt.executeQuery();
            int doctor = 0;
            System.out.println("Id de los Pacientes atendidos: ");
            while (rs.next()) {                  
                int paciente = rs.getInt("id_paciente"); 
                doctor = rs.getInt("id_doctor");
                
                System.out.println(paciente);
                System.out.println("-------------------------");
                
            }
            System.out.println("Id del doctor: " + doctor + "\n");
            rs.close();
            stmt.close();

            
        }catch (SQLException ex){
            
            System.out.println("Error al eliminar cliente: " + ex.getMessage());
            
        }
        
        
    }
        
    
        public void buscaxDia(String fecha){
            
            
            try{
                PreparedStatement stmt = super.getConexion().prepareStatement("SELECT fecha, idcitas FROM citas WHERE fecha=?");
                stmt.setString(1, fecha);
                ResultSet rs = stmt.executeQuery();
                
                
                
                while (rs.next()) {                  
                 String fechaa = rs.getString("fecha");
                 int idcitas = rs.getInt("idcitas");
                    System.out.println("Id de la cita " + idcitas + " de la fecha " + fecha + "\n");
                }
                
                rs.close();
                stmt.close();

                
                
            }catch(SQLException ex){
                System.out.println("Error al eliminar cliente: " + ex.getMessage());
            }
            
            
            
            
            
        }
    
    
        public void buscarxTodo(String fecha){
                
                try{
                    
                PreparedStatement stmt = super.getConexion().prepareStatement("SELECT fecha,id_doctor,id_paciente FROM citas WHERE fecha=?");
                stmt.setString(1, fecha);
                ResultSet rs = stmt.executeQuery();
                
                
                
                while (rs.next()) {                  
                 String fechaa = rs.getString("fecha");
                 int id_doctor = rs.getInt("id_doctor");
                 int id_paciente = rs.getInt("id_paciente");
                 System.out.println("Id del doctor en cuestion " + id_doctor + " atentiendo al paciente " + id_paciente + " en la fecha  " + fechaa +"\n");
                }
                
                rs.close();
                stmt.close();

                    
                    
                }catch(SQLException ex){
                    System.out.println("Error al eliminar cliente: " + ex.getMessage());
                }
            
            
            
            
            
            
        }
            
    
    
    
    
}
