/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebais;

/**
 *
 * @author moise_oueu1ax
 */
public class Citas {
    
    
    private int doctor;
    private int paciente;
    private int consultorio;
    

    public Citas() {
    }

    public Citas(int doctor, int paciente, int consultorio) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.consultorio = consultorio;
    }

    public int getDoctor() {
        return doctor;
    }

    public int getPaciente() {
        return paciente;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
    
    
    
}
