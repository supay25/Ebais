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
 * @author moise_oueu1ax
 */
public class ConExpediente extends Conexion {
    
    public List<Expediente> lista() {
        List<Expediente> listaRetorno = new ArrayList<Expediente>();
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT Comentario FROM expediente ORDER BY Id_Expediente");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {   
                String Comentario = rs.getString("Comentario");
                                      
                Expediente e = new Expediente(Comentario);
                listaRetorno.add(e);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return listaRetorno;
    }
    
        public Expediente Buscar(int idParam) {
        Expediente e = null;
        
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT comentario FROM Expediente WHERE ID_Expediente=? ORDER BY Id_Expediente");
            stmt.setInt(1, idParam);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String comentario = rs.getString("comentario");   
                e = new Expediente (comentario);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

        return e;
    }
    

    public void insertar(Expediente c) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("INSERT INTO Expediente(paciente,comentario) VALUES (?,?)");

            stmt.setString(2, c.getComentario());
            stmt.setInt(1, c.getPaciente());
            

            stmt.execute();

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar Expediente: " + ex.getMessage());
        }

    }

    
    public void eliminar(int idConsu) {
        try {
            PreparedStatement stmt = super.getConexion().prepareStatement("DELETE FROM Expediente WHERE Id_Expediente = ?");
            stmt.setInt(1, idConsu);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Expediente: " + ex.getMessage());
        } 
    
    
    }
    
}
