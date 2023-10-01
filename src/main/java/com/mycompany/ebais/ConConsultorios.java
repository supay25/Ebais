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




    
    public class ConConsultorios extends Conexion{
    public List<Consultorio> lista() {
        List<Consultorio> listaRetorno = new ArrayList<Consultorio>();
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Direccion FROM consultorio ORDER BY Id_Consultorio");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {   
                String direccion = rs.getString("Direccion");
                                      
                Consultorio c = new Consultorio(direccion);
                listaRetorno.add(c);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return listaRetorno;
    }
    
        public Consultorio Buscar(int idParam) {
        Consultorio c = null;
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT direccion FROM consultorio WHERE ID_Consultorio=? ORDER BY Id_Consultorio");
            stmt.setInt(1, idParam);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String direccion = rs.getString("direccion");   
                c = new Consultorio(direccion);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return c;
    }
    

    public void insertar(Consultorio c) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("INSERT INTO Consultorio(direccion) VALUES (?)");

            stmt.setString(1, c.getDireccion());
           
            

            stmt.execute();

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar Consultorio: " + ex.getMessage());
        }

    }

    
    public void eliminar(int idConsu) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("DELETE FROM Consultorio WHERE Id_Consultorio = ?");
            stmt.setInt(1, idConsu);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Consultorio: " + ex.getMessage());
        } 
    }   
}

    

