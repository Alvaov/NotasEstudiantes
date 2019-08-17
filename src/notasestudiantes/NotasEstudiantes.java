/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;

/**
 *
 * @author allva
 * Clase principal del proyecto
 * posee el método main.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class NotasEstudiantes extends Application{
       String ruta;

       List<List<String>> listaEstudiantes;
       
    /**
     *
     * @param args
     * Inicializa el código
     */
    public static void main (String[] args){ 

        launch(args);
    }
    
    /**
     *
     * 
     * @see Crea la cantidad de instancias según sea el archivo
     * y clasifica según sea tipo A o B, añadiendo estos objetos
     * a una lista.
     * @return estudiantesObjetos
     */
    public List ListaObjetos(){

       List<Object> estudiantesObjetos = new ArrayList<Object>();
       for (int i = 1; i < listaEstudiantes.size(); i++){

           if (listaEstudiantes.get(i).get(5).equalsIgnoreCase("A")){
               EstudiantesTipoA EstudianteA = new EstudiantesTipoA(listaEstudiantes.get(i));
                estudiantesObjetos.add(EstudianteA);
           }
           else if (listaEstudiantes.get(i).get(5).equalsIgnoreCase("B")) {
              EstudiantesTipoB EstudianteB = new EstudiantesTipoB(listaEstudiantes.get(i)); /*Aquí se crean instancias
                                                                                              de la clase EstudiantesIipoB
              */
              estudiantesObjetos.add(EstudianteB);
           }
      }
       return estudiantesObjetos;
    }

    /*
     *
     * Inicia los componentes de la interfaz interactuando 
     * con las clases como ArchivoCSV, CotronllerEstudiantes,
     * el archivo FXML y con el método ListaOBjetos.
     * Código base tomado de https://youtu.be/FLkOX4Eez6o
     * https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
    */
    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("Estudiantes");
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewEstudiantes.fxml"));
       
       FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    fileChooser.getExtensionFilters().addAll(
         new ExtensionFilter("Text Files", "*.csv")
    );
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    if (selectedFile != null) {
        ruta = selectedFile.getAbsolutePath();
        ArchivoCSV ArchivoEstudiantes = new ArchivoCSV(ruta);
        listaEstudiantes = ArchivoEstudiantes.ObtenerDatos();
    }
       List listaObjetos = ListaObjetos();

       Scene myScene = (new Scene(loader.load()));
       primaryStage.setScene(myScene);

       ControllerEstudiantes controller = loader.getController();
       controller.PasarObjetos(listaObjetos);
       
       primaryStage.show();
    }
}
       
    