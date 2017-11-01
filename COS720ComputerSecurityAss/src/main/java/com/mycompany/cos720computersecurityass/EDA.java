
package com.mycompany.cos720computersecurityass;

import EntityManagers.ConcreteDAO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gershom
 * This class queries the database and create a csv file with all the data from the database for EDA
 */
public class EDA {
    
  private ConcreteDAO manager = null;
  
  public EDA()
  {
     manager = new ConcreteDAO();    
  }
  public void getAllClaims() throws IOException
  {
       List<CleanInsuranceClaims> list = manager.getAllClaims();
       String csvFile = "/home/gershom/Desktop/Honours/COS720/Assignment/COS720ComputerSecurityAss/src/main/java/com/mycompany/cos720computersecurityass/claims.csv";
       FileWriter writer = new FileWriter(csvFile);
       
     
        CSVUtils.writeLine(writer, Arrays.asList("InsuranceClaimId", "AgencyUniqueId", "AmountPaid", "AreaLossOcurred,"
                + "CityLossOccured, claimServiceProvider, DateOfBirthPOlicyHolder", "DateOfClaim", "DateOfLoss","FraudulentClaimIndicator",
                "FraudulentClaimReason", "GenderOfPolicyHolder", "InsuredName", "InsuredSurname", "InsuredUniqueId" ,"KindOfLoss", 
                "MaritalStatusPolicyHolder", "OtherPartyName", "OtherPartySurname", "PolicyEnddate", "PolicyHolderArea", "PolicyHolderCity",
                "policyHolderPostalCode", "PolicyHolderProvince", "PolicyHolderStreet", "PolicyStartDate", "PostalCodeLossOccured", 
                "ProvinceLossOccured","ProvinceLossOccured","TotalPolicyRevenue", "TotalSumInsured"));
       for(int i=0; i< list.size();i++)
       {
          
          if(list.get(i).insuredUniqueId!=null){ 
            CSVUtils.writeLine(writer, Arrays.asList(list.get(i).insuredUniqueId,list.get(i).agencyUniqueId, list.get(i).amountPaid,
            list.get(i).areaLossOccured,list.get(i).cityLossOccured, list.get(i).claimServiceProvider, list.get(i).dateOfBirthPOlicyHolder,
            list.get(i).dateOfClaim,list.get(i).dateOfLoss,list.get(i).fraudulentClaimIndicator+"",list.get(i).fraudulentClaimReason,list.get(i).genderOfPolicyHolder,
            list.get(i).insuredName,list.get(i).insuredSurname,list.get(i).insuredUniqueId,list.get(i).kindOfLoss, list.get(i).maritalStatusPolicyHolder,
            list.get(i).otherPartyName,list.get(i).otherPartySurname,list.get(i).policyEnddate,list.get(i).policyHolderArea,
            list.get(i).policyHolderCity,list.get(i).policyHolderPostalCode,list.get(i).policyHolderProvince, list.get(i).policyHolderStreet,
            list.get(i).policyStartDate,list.get(i).postalCodeLossOccured,list.get(i).provinceLossOccured,list.get(i).totalPolicyRevenue,list.get(i).totalSumInsured));
          }
       }
        writer.flush();
        writer.close();
  }
 
    
    
}
