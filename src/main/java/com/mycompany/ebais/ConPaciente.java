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
public class ConPaciente extends Conexion {
    
    public List<Paciente> lista() {
        List<Paciente> listaRetorno = new ArrayList<Paciente>();
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Canton,Distrito, Nombre_Paciente, Cedula FROM paciente ORDER BY Id_Paciente");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Cedula");
                String Canton = rs.getString("Canton");
                String Distrito = rs.getString("Distrito");
                String Nombre_Paciente = rs.getString("Nombre_Paciente");
                
                
                Paciente c = new Paciente(id, Canton, Distrito,Nombre_Paciente);
                listaRetorno.add(c);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return listaRetorno;
    }
    
        public Paciente Buscar(int idParam) {
        Paciente c = null;
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Canton,Distrito, Nombre_Paciente, Cedula FROM Paciente WHERE Id_Paciente=? ORDER BY Id_Paciente");
            stmt.setInt(1, idParam);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String Canton = rs.getString("Canton");
                String Distrito = rs.getString("Distrito");
                String nombre = rs.getString("Nombre_Paciente");
                int Cedula = rs.getInt("Cedula");
                
                c = new Paciente(Cedula, Canton, Distrito, nombre);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return c;
    }
    

    public void insertar(Paciente c) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("INSERT INTO paciente(Canton,Distrito, Nombre_Paciente, Cedula) VALUES (?,?,?,?)");

            stmt.setString(1, c.getCanton());
            stmt.setString(2, c.getDistrito());
            stmt.setString(3, c.getNombre());
            stmt.setInt(4, c.getCedula());

            stmt.execute();

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar cliente: " + ex.getMessage());
        }

    }

    
    public void eliminar(int idCliente) {
    try {
        PreparedStatement stmt = super.getConexion().prepareStatement("DELETE FROM paciente WHERE Id_Paciente = ?");
        stmt.setInt(1, idCliente);
        stmt.execute();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Error al eliminar cliente: " + ex.getMessage());
    }
}
    
    
    
}
