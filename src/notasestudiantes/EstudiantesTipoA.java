/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author allva
 */
public class EstudiantesTipoA extends Estudiantes { /* Se presenta el concepto de herencia
    pues EstudiantesTipoA es una hija que hereda métodos y variables de su clase padre
    Estudiantes
    */
    
    private double promA; /*Es encapsulamiento pues mantiene oculto 
    este atributo del resto del proyecto, y solo permite que se use
    en esta clase
    */
    private SimpleDoubleProperty promedioA;
    
    public EstudiantesTipoA(List lista) {
        super(lista);
        this.promedioA = new SimpleDoubleProperty(promA);
        
        
}
    
    @Override
    public SimpleDoubleProperty PromedioA(){
        promA = (promExámenes.get() + promQuices.get() + promTareas.get())/3;
        promedioA = new SimpleDoubleProperty(promA);
        return promedioA;
    }

    @Override
    public SimpleDoubleProperty PromedioB() { 
        return null;
    }


}
