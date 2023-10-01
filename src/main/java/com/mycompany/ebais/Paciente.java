/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebais;

/**
 *
 * @author moise_oueu1ax
 */
public class Paciente extends Persona {
    
    private int cedula;
    private String canton;
    private String distrito;

    public Paciente() {
    }

    public Paciente(String nombre) {
        super(nombre);
    }

    public Paciente(int cedula, String canton, String distrito, String nombre) {
        super(nombre);
        this.cedula = cedula;
        this.canton = canton;
        this.distrito = distrito;
    }

    public int getCedula() {
        return cedula;
    }

    public String getCanton() {
        return canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    
    
    
}
