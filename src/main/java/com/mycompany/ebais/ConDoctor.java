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
 * @author Jose
 */
public class ConDoctor extends Conexion{
    public List<Doctor> lista() {
        List<Doctor> listaRetorno = new ArrayList<Doctor>();
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Especialidad, nombre FROM doctor ORDER BY Id_Doctor");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {   
                String Especialidad = rs.getString("Especialidad");
                String nombre = rs.getString("nombre");                                        
                Doctor c = new Doctor(Especialidad,nombre);
                listaRetorno.add(c);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return listaRetorno;
    }
    
        public Doctor Buscar(int idParam) {
        Doctor c = null;
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Especialidad, nombre FROM doctor WHERE Id_Doctor=? ORDER BY Id_Doctor");
            stmt.setInt(1, idParam);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String Especialidad = rs.getString("Especialidad");
                String nombre = rs.getString("nombre");             
                c = new Doctor(Especialidad, nombre);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return c;
    }
    

    public void insertar(Doctor c) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("INSERT INTO doctor(Especialidad, nombre) VALUES (?,?)");

            stmt.setString(1, c.getEspecialidad());
            stmt.setString(2, c.getNombre());
            

            stmt.execute();

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar cliente: " + ex.getMessage());
        }

    }

    
    public void eliminar(int idCliente) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("DELETE FROM doctor WHERE Id_Doctor = ?");
            stmt.setInt(1, idCliente);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar cliente: " + ex.getMessage());
        } 
    }   
}
