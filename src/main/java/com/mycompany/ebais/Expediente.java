/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebais;

/**
 *
 * @author moise_oueu1ax
 */
public class Expediente {
    
    private String comentario;
    private int paciente;

    public Expediente() {
    }

    public Expediente(String comentario) {
        this.comentario = comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setPaciente(int  paciente) {
        this.paciente = paciente;
    }

    public int getPaciente() {
        return paciente;
    }
    
    
    
}
