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
 * /*Aquí se representa abstración porque esta clase
    *es una representación de estudiantes reales
    
    Hay polimorfismo pues permite
    tratar objetos EstudiantesTipoA y EstudiantesTipoB
    como objetos de un solo tipo Estudiantes
    */
public abstract class Estudiantes { 
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

    /**
     *
     */
    protected SimpleDoubleProperty notaFinal;
    
    /**
     *
     * @param lista
     * Recibe una lista de Strings
     * y asigna los respectivos índices
     * a los atributos correspondientes
     * base de código tomada de https://docs.oracle.com/javafx/2/api/javafx/beans/property/SimpleStringProperty.html
     * https://docs.oracle.com/javafx/2/api/javafx/beans/property/SimpleDoubleProperty.html
     * https://docs.oracle.com/javase/7/docs/api/java/lang/Double.html
     */
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
        double examenes = Double.parseDouble(lista.get(6));
        double quices = Double.parseDouble(lista.get(7));
        double tareas = Double.parseDouble(lista.get(8));
        double proyecto1valor = Double.parseDouble(lista.get(9));
        double proyecto2valor = Double.parseDouble(lista.get(10));
        double proyecto3valor = Double.parseDouble(lista.get(11));
        
        
    }
    
    /**
     *
     * @return carné
     * Se obtiene el atributo carné del estudiante
     */
    public SimpleStringProperty Carné(){
        return carné;
    }
    /**
     *
     * @return nombreyApellidos
     * Se obtiene el atributo que contiene el nombre
     * y apellido del estudiante
     */
    public SimpleStringProperty NombreApellidos(){
        return nombreyApellidos;
    }
        /**
     *
     * @return correo
     * Se obtiene el atributo correo del estudiante
     */
    public SimpleStringProperty Correo(){
        return correo;
    }
        /**
     *
     * @return telefono
     * Se obtiene el atributo telefono del estudiante
     */
    public SimpleStringProperty Telefono(){
        return telefono;
    }
        /**
     *
     * @return Nickname
     * Se obtiene el atributo Nickname del estudiante
     */
    public SimpleStringProperty Nickname(){
        return nickname;
    }
        /**
     *
     * @return TipoEstudiante
     * Se obtiene el atributo del tipo de estudiante
     */
    public SimpleStringProperty TipoEstudiante(){
        return tipoDeEstudiante;
    }
        /**
     *
     * @return promExámenes
     * Se obtiene el atributo promedio de exámenes
     * del estudiante
     */
    public SimpleDoubleProperty PromedioExámenes(){
        return promExámenes;
    }
        /**
     *
     * @return promQuices
     * Se obtiene el atributo promedio de quices
     * del estudiante
     */
    public SimpleDoubleProperty PromedioQuices(){
        return promQuices;
    }
        /**
     *
     * @return promTareas
     * Se obtiene el atributo promedio de tareas
     * del estudiante
     */
    public SimpleDoubleProperty PromedioTareas(){
        return promTareas;
    }
        /**
     *
     * @return proyecto1
     * Se obtiene el atributo con la nota del proyecto 1
     * del estudiante
     */
    public SimpleDoubleProperty Proyecto1(){
        return proyecto1;
    }
        /**
     *
     * @return proyecto2
     * Se obtiene el atributo con la nota del proyecto 2
     * del estudiante
     */
    public SimpleDoubleProperty Proyecto2(){
        return proyecto2;
    }
        /**
     *
     * @return proyecto3
     * Se obtiene el atributo con la nota del proyecto 3
     * del estudiante
     */
    public SimpleDoubleProperty Proyecto3(){
        return proyecto3;
    }
    
    /**
     *
     * @return el promedio tipo A
     * exámenes,quices y tareas para estudiantesTipoA
     * estudiantesTipoB tienen retorno nulo.
     */
    public abstract SimpleDoubleProperty PromedioA();

    /**
     * @return el promedio tipo B
     * proyectos para estudiantesTipoB, para
     * estudiantesTipoA tienen retorno nulo.
     */
    public abstract SimpleDoubleProperty PromedioB();
    
    /**
     *
     * @return notaFinal
     * Toma los valores de los atributos numéricos
     * y obtiene la nota final realizando promedio entre 
     * estos datos
     * Ejemplo de sobrecarga pues existen dos métodos llamados NotaFinal,
     * con diferencia en sus argumentos, por lo que Java los reconoce por los argumentos
     * que se envíen
     */
    public SimpleDoubleProperty NotaFinal(){ //Sobrecarga mismo método NotaFinal sin argumentos
        double notaF = (proyecto1.get() + proyecto2.get()+ proyecto3.get() + promExámenes.get() + promQuices.get() + promTareas.get())/6;
        notaFinal = new SimpleDoubleProperty(notaF);
        return notaFinal;
    }
    
    /**
     *
     * @param examenes
     * @param quices
     * @param tareas
     * @param proyecto1valor
     * @param proyecto2valor
     * @param proyecto3valor
     * @return valorFinal
     * recibe los valores numéricos de los rubros cuantitativos
     * calcula el promedio y lo asigna a un SimpleDoubleProperty
     * Ejemplo de sobrecarga pues existen dos métodos llamados NotaFinal,
     * con diferencia en sus argumentos, por lo que Java los reconoce por los argumentos
     * que se envíen
     */
    public SimpleDoubleProperty NotaFinal(double examenes, double quices, double tareas,
            double proyecto1valor, double proyecto2valor, double proyecto3valor){ //Sobrecarga mismo método NotaFinal con argumentos
        
        double valor = (examenes + quices + tareas + proyecto1valor + proyecto2valor + proyecto3valor)/6;
        SimpleDoubleProperty valorFinal = new SimpleDoubleProperty(valor);
        return valorFinal;
    }
}
