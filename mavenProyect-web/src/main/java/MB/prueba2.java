/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MB;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camilo
 */
@Named(value = "prueba2")
@RequestScoped
public class prueba2 {

    String nombre;
    String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String enviar(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Nombre: "+getPass());
        return null;
    }
    
    public prueba2() {
    }
    
}
