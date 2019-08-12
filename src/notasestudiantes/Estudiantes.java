/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;


import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
/**
 *
 * @author allva
 */
public abstract class Estudiantes { /*Aquí se representa abstración porque esta clase
                                     es una representación de estudiantes reales
    
    Hay polimorfismo pues permite
    tratar objetos EstudiantesTipoA y EstudiantesTipoB
    como objetos de un solo tipo Estudiantes
    */
    protected SimpleStringProperty carné;
    protected SimpleStringProperty nombreyApellidos;
    protected SimpleStringProperty correo;
    protected SimpleStringProperty telefono; //Es un atributo de un estudiante, un dato de la clase.
    protected SimpleStringProperty nickname;
    protected SimpleStringProperty tipoDeEstudiante;
    protected SimpleDoubleProperty promExámenes;
    protected SimpleDoubleProperty promQuices;
    protected SimpleDoubleProperty promTareas;
    protected SimpleDoubleProperty proyecto1;
    protected SimpleDoubleProperty proyecto2;
    protected SimpleDoubleProperty proyecto3;
    protected SimpleDoubleProperty notaFinal;
    
    public Estudiantes(List<String> lista){
        this.carné = new SimpleStringProperty (lista.get(0));
        this.nombreyApellidos = new SimpleStringProperty (lista.get(1));
        this.correo = new SimpleStringProperty (lista.get(2));
        this.telefono = new SimpleStringProperty  (lista.get(3));
        this.nickname = new SimpleStringProperty (lista.get(4));
        this.tipoDeEstudiante = new SimpleStringProperty  (lista.get(5));
        this.promExámenes = new SimpleDoubleProperty (Double.parseDouble(lista.get(6)));
        this.promQuices = new SimpleDoubleProperty (Double.parseDouble(lista.get(7)));
        this.promTareas = new SimpleDoubleProperty (Double.parseDouble(lista.get(8)));
        this.proyecto1 = new SimpleDoubleProperty (Double.parseDouble(lista.get(9)));
        this.proyecto2 = new SimpleDoubleProperty (Double.parseDouble(lista.get(10)));
        this.proyecto3 = new SimpleDoubleProperty (Double.parseDouble(lista.get(11)));
        
    }
    public SimpleStringProperty Carné(){
        return carné;
    }
    public SimpleStringProperty NombreApellidos(){
        return nombreyApellidos;
    }
    public SimpleStringProperty Correo(){
        return correo;
    }
    public SimpleStringProperty Telefono(){
        return telefono;
    }
    public SimpleStringProperty Nickname(){
        return nickname;
    }
    public SimpleStringProperty TipoEstudiante(){
        return tipoDeEstudiante;
    }
    public SimpleDoubleProperty PromedioExámenes(){
        return promExámenes;
    }
    public SimpleDoubleProperty PromedioQuices(){
        return promQuices;
    }
    public SimpleDoubleProperty PromedioTareas(){
        return promTareas;
    }
    public SimpleDoubleProperty Proyecto1(){
        return proyecto1;
    }
    public SimpleDoubleProperty Proyecto2(){
        return proyecto2;
    }
    public SimpleDoubleProperty Proyecto3(){
        return proyecto3;
    }
    
    public abstract SimpleDoubleProperty PromedioA();
    public abstract SimpleDoubleProperty PromedioB();
    
    public SimpleDoubleProperty NotaFinal(){
        double notaF = (promExámenes.get() + promQuices.get() + promTareas.get())/3;
        //System.out.println(promA);
        //System.out.println(promedioA);
        notaFinal = new SimpleDoubleProperty(notaF);
        System.out.println(notaFinal);
        return notaFinal;
    };
}
