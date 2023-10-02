/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ebais;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moise_oueu1ax
 */
public class EBAIS {

    public static void main(String[] args) {
        
        
        ConDoctor cp1 = new ConDoctor();
        Doctor d = new Doctor();
        
        Paciente p = new Paciente();
        d.setEspecialidad("Ontologia");
        d.setNombre("Jose");
        
        
        cp1.insertar(d);
        List<Doctor> listaRetornoo = cp1.lista();
        for (Doctor pa : listaRetornoo){
            System.out.print(pa.getEspecialidad());
        }
        
       
        
        
    }
}
