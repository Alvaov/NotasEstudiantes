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
public class EstudiantesTipoB extends Estudiantes { /*
    Es un ejemplo de polimorfismo debido a que 
    */
    
    double promB;
    SimpleDoubleProperty promedioB;
    
    public EstudiantesTipoB(List lista) {
        super(lista);
    }
 
    @Override
    public SimpleDoubleProperty PromedioB(){ /* Esto es sobreescritura
                                                ya que modifica el método 
                                                creado en la clase padre
        */
        promB =(proyecto1.get() + proyecto2.get() + proyecto3.get())/3;
        promedioB = new SimpleDoubleProperty(promB);
        return promedioB;
    }

    @Override
    public SimpleDoubleProperty PromedioA() {
        return null;
    }

}
