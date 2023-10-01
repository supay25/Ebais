/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author moise_oueu1ax
 */
public class Conexion {
    
    private static Connection conectar = null;
    private static String url = "jdbc:mysql://localhost:3306/chiquitinas?serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static String usuario = "root";
    private static String password = "Ygcoti63";

    public Conexion() {
    }
    
       private Connection conectarBBDD() throws SQLException {
        conectar = DriverManager.getConnection(url, usuario, password);
        System.out.println("Conexión Exitosa " + conectar);
        return conectar;
    }
     
       public Connection getConexion() throws SQLException{
            
            if(conectar==null)
                conectarBBDD();
            return conectar;
            
        }

    
    
    
}
