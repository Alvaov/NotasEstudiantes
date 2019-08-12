/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allva
 */
public class ArchivoCSV { /*
    Aquí se evidencia el concepto de clases pues esta es un molde
    para todo archivo .csv que se desee cargar
    */
    
    
    public ArchivoCSV (String ruta) {
        this.ruta = ruta;

    }
    
    
    private List<List<String>> records = new ArrayList<List<String>>();
    
    public List ObtenerDatos(){ //Aquí se aprecia un método de la clase para obtener los datos del archivo

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = br.readLine()) != null) {
            String[] values = line.split(",",-1);
            records.add(Arrays.asList(values));
           
            
    }
}       catch (IOException ex) {
            Logger.getLogger(ArchivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        return records;

    }

    private String ruta;
}
        

