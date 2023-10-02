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
        ConExpediente ex = new ConExpediente();
        
        Paciente p = new Paciente();
        d.setEspecialidad("Ontologia");
        d.setNombre("Jose");
        
        
        cp1.insertar(d);
        List<Doctor> listaRetornoo = cp1.lista();
        //for (Doctor pa : listaRetornoo){
          //  System.out.print(pa.getEspecialidad());
        //}
        Expediente e = new Expediente();
        e.setComentario("Le falta drogas");
        e.setPaciente(5);
        ex.insertar(e);
      /* Consultorio con = new Consultorio();
       con.setDireccion("Condominio Rio de Oro");
       
       ConConsultorios concon = new ConConsultorios();
       concon.insertar(con);
       
       List<Consultorio> listaRetornoCon = concon.lista();
       for (Consultorio pa : listaRetornoCon){
            System.out.print(pa.getDireccion());
        }*/
       Citas ci = new Citas();
       ConCitas conci = new ConCitas();
       ci.setConsultorio(1);
       ci.setPaciente(1);
       ci.setDoctor(1);
       conci.insertar(ci);
      
    }
}
