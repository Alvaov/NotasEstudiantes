/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;

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
public class Prueba {
        public List ObtenerDatos(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
            for (int i= 0; i < 50; i++){
             System.out.println(values);   
            }
            
    }
}       catch (IOException ex) {
            Logger.getLogger(ArchivoCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(records);
        return records;

    }  

}
