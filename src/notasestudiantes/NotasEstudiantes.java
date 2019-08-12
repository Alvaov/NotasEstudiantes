/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;

/**
 *
 * @author allva
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class NotasEstudiantes extends Application{
       String ruta;
       //ArchivoCSV ArchivoEstudiantes = new ArchivoCSV("Data.csv");
       List<List<String>> listaEstudiantes;//= ArchivoEstudiantes.ObtenerDatos();
       
    public static void main (String[] args){ 

        launch(args);
    }
    
    public List ListaObjetos(){
  //      System.out.println("algoentró");
       List<Object> estudiantesObjetos = new ArrayList<Object>();
       for (int i = 1; i < listaEstudiantes.size(); i++){

           if (listaEstudiantes.get(i).get(5).equalsIgnoreCase("A")){
//System.out.println("algo");
               EstudiantesTipoA EstudianteA = new EstudiantesTipoA(listaEstudiantes.get(i));
                estudiantesObjetos.add(EstudianteA);
           }
           else if (listaEstudiantes.get(i).get(5).equalsIgnoreCase("B")) {
//System.out.println("algoB");
              EstudiantesTipoB EstudianteB = new EstudiantesTipoB(listaEstudiantes.get(i)); /*Aquí se crean instancias
                                                                                              de la clase EstudiantesIipoB
              */
              estudiantesObjetos.add(EstudianteB);
           }
           else{
               //System.out.println(listaEstudiantes.get(i).get(5));
           }
      }
    //   System.out.println(estudiantesObjetos);
       return estudiantesObjetos;
    }

    
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
        ruta = selectedFile.getName();
        ArchivoCSV ArchivoEstudiantes = new ArchivoCSV(ruta);
        listaEstudiantes = ArchivoEstudiantes.ObtenerDatos();
    }
       System.out.println(listaEstudiantes);
       List listaObjetos = ListaObjetos();
       Scene myScene = (new Scene(loader.load()));
       primaryStage.setScene(myScene);

       ControllerEstudiantes controller = loader.getController();
       controller.PasarObjetos(listaObjetos);
       
       primaryStage.show();
    }
}
       
    