package com.mycompany.cos720computersecurityass;

import EntityManagers.ConcreteDAO;
import com.mycompany.cos720computersecurityass.CleanInsuranceClaims;
import java.io.IOException;

/**
 *
 * @author gershom
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

        CleanInsuranceClaims claim = null;
        ConcreteDAO manager = null;
        KAnonymity anonymizer = null;
        int count = 0;
        boolean flag=true;
        EDA eda = new EDA();

        claim = new CleanInsuranceClaims();
        manager = new ConcreteDAO();
        anonymizer = new KAnonymity();
       
        //insert();

        
                
        //Anonymization
        anonymizer.anonymize();
       // anonymizer.anonimyzer2();

         //eda.getAllClaims();
        
        //claim.wrongDateFormat();
        
    }
   

}
