/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ebais;

/**
 *
 * @author moise_oueu1ax
 */
public class Doctor extends Persona {
    
    private String especialidad;

    public Doctor() {
    }

    public Doctor(String nombre) {
        super(nombre);
    }

    public Doctor(String especialidad, String nombre) {
        super(nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
    
    
}
