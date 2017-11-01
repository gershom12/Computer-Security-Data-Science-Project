
package com.mycompany.cos720computersecurityass;

import EntityManagers.ConcreteDAO;
import java.util.List;

/**
 *
 * @author gershom
 * 
 */
public class KAnonymity 
{
    
  private ConcreteDAO manager = null; 
  private static int counter = 0;
    
  public KAnonymity ()
  {
    manager = new ConcreteDAO(); 
  } 
  public void anonymize()
  {
      int totalPolicyRevenue;
      int lowerBound = 0;
      int upperBound = 0;
      int lowerBound1 = 0;
      int upperBound1 = 0;
      int upperBound2 = 0;
      int lowerBound2 = 0;
      int lowerBound3 = 0;
      int upperBound3 = 0;
      int lowerBound4 = 0;
      int upperBound4 = 0;
      int sum = 0;
      int total = 0;
      int totalSumInsured = 0;
      int amountPaid = 0;
      int totalAmountPaid = 0;
      int sumInsured = 0;
      int insuranceClaimId = 0;
      int totalInsuranceClaimId = 0;
      int agencyUniqueId = 0;
      int totalAgencyUniqueId;
      int count = 0;
      int counter = 0;
      char asteric = '*';
      String insuredname = null;
      String newinsuredname = "";
      String newinsuredSurname = "";
      String otherPartyName = "";
      String otherPartySurname = "";
      String areaLossOccured = "";
     
    
      
      
      List<CleanInsuranceClaims> claims = manager.getAllClaims();
      //Anonymize the gender
      
      for(int i=0;i<claims.size();i++)
      {
        claims.get(i).genderOfPolicyHolder = "People";
        insuredname = claims.get(i).insuredName;
      }
     
      // This loops devide name into half and assign stars to the other half
      for(int i=0;i<claims.size();i++)
      {
          while(count<(claims.get(i).insuredName).toString().length()/2)
          {
            newinsuredname = newinsuredname + claims.get(i).insuredName.charAt(count);
            count++;
          }
          while(counter<(claims.get(i).insuredName).toString().length()/2)
          {
            newinsuredname = newinsuredname + asteric;
            counter++;
          }
          if((claims.get(i).insuredName).toString().length()%2 != 0)
          {
             newinsuredname = newinsuredname + asteric; 
          }
          count = 0;
          counter = 0;
          claims.get(i).insuredName = newinsuredname; 
          newinsuredname = "";
      }
      
      for(int i=0;i<claims.size();i++)
      {
          while(count<(claims.get(i).insuredSurname).toString().length()/2)
          {
            newinsuredSurname = newinsuredSurname + claims.get(i).insuredSurname.charAt(count);
            count++;
          }
          while(counter<(claims.get(i).insuredSurname).toString().length()/2)
          {
            newinsuredSurname =  newinsuredSurname + asteric; 
            counter++;
          }
          if((claims.get(i).insuredSurname).toString().length()%2 != 0)
          {
             newinsuredname = newinsuredname + asteric; 
          }
          count = 0;
          counter = 0;
          claims.get(i).insuredSurname = newinsuredSurname;
          newinsuredSurname = "";
         
          
      }
      for(int i=0;i<claims.size();i++)
      {
          while(count<(claims.get(i).otherPartyName).toString().length()/2)
          {
            otherPartyName = otherPartyName + claims.get(i).otherPartyName.charAt(count);
            count++;
          }
          while(counter<(claims.get(i).otherPartyName).toString().length()/2)
          {
            otherPartyName =  otherPartyName + asteric; 
            counter++;
          }
          if((claims.get(i).otherPartyName).toString().length()%2 != 0)
          {
             newinsuredname = newinsuredname + asteric; 
          }
          
          count = 0;
          counter = 0;
          claims.get(i).otherPartyName = otherPartyName;
          otherPartyName = "";
         
      }
      for(int i=0;i<claims.size();i++)
      {
        
          while(counter<(claims.get(i).otherPartySurname).toString().length())
          {
            otherPartySurname =  otherPartySurname + asteric; 
            counter++;
           
          }
          if((claims.get(i).otherPartySurname).toString().length()%2 != 0)
          {
             newinsuredname = newinsuredname + asteric; 
          }
          count = 0;
          counter = 0;
          claims.get(i).otherPartySurname = otherPartySurname;
          otherPartySurname = "";
          
      }
      for(int i=0;i<claims.size();i++)
      {
          while(count<3)
          {
            areaLossOccured = areaLossOccured + claims.get(i).areaLossOccured.charAt(count);
            count++;
          }
          while(counter<(claims.get(i).areaLossOccured).toString().length()-1)
          {
            areaLossOccured =  areaLossOccured + asteric; 
            counter++;
           
          }
          
          count = 0;
          counter = 0;
          claims.get(i).areaLossOccured = areaLossOccured;
          areaLossOccured = "";
          
      }
      //Anonimyze the marital status of the policy holder
      // Make marital status an asteric because if you parially encode it it can be easy
      // To guess since almost all the tables have the same values
      
      for(int i=0;i<claims.size();i++)
      {
          claims.get(i).maritalStatusPolicyHolder= "*";
          
          //Round total revenue and totalSum insured
          
          total = Integer.parseInt(claims.get(i).totalPolicyRevenue);
          sum = Math.round((Integer.parseInt(claims.get(i).totalPolicyRevenue)+5)/10)*10;
          sumInsured = Integer.parseInt(claims.get(i).totalSumInsured);
          totalSumInsured = Math.round((Integer.parseInt(claims.get(i).totalSumInsured)+5)/10)*10;
          amountPaid = Integer.parseInt(claims.get(i).amountPaid);
          totalAmountPaid = Math.round((Integer.parseInt(claims.get(i).amountPaid)+5)/10)*10;
          insuranceClaimId = Integer.parseInt(claims.get(i).insuredUniqueId);
          totalInsuranceClaimId = Math.round((Integer.parseInt(claims.get(i).insuredUniqueId)+5)/10)*10;
          agencyUniqueId = Integer.parseInt(claims.get(i).agencyUniqueId);
          totalAgencyUniqueId = Math.round((Integer.parseInt(claims.get(i).agencyUniqueId)+5)/10)*10;
          
          if(sum > total)
          {
            upperBound = sum;
            lowerBound = sum - 10;
          }
          else
          {
            lowerBound = sum;
            upperBound = sum +10;
          }
          if(agencyUniqueId > totalAgencyUniqueId)
          {
            upperBound4 = agencyUniqueId;
            lowerBound4 = agencyUniqueId - 10;
          }
          else
          {
            lowerBound4 = agencyUniqueId;
            upperBound4 = agencyUniqueId +10;
          }
          
          if(sumInsured > totalSumInsured)
          {
            upperBound1 = totalSumInsured;
            lowerBound1 = totalSumInsured -10;
          }
          else
          {
            lowerBound1 = totalSumInsured;
            upperBound1 = totalSumInsured + 10;
          }
          if(totalAmountPaid > amountPaid)
          {
            upperBound2 = totalAmountPaid;
            lowerBound2 = totalAmountPaid - 10;
          }
          else
          {
            lowerBound2 = totalAmountPaid;
            upperBound2 = totalAmountPaid + 10;
          }
          if(insuranceClaimId > totalInsuranceClaimId)
          {
            upperBound3 = insuranceClaimId;
            lowerBound3 = insuranceClaimId - 10;
          }
          else
          {
            lowerBound3 = insuranceClaimId;
            upperBound3 = insuranceClaimId +10;
          }
          claims.get(i).totalPolicyRevenue = "[R"+Integer.toString(lowerBound)+" , R"+Integer.toString(upperBound)+"]";
          claims.get(i).totalSumInsured = "[R"+Integer.toString(lowerBound1)+" , R"+Integer.toString(upperBound1)+"]";
          claims.get(i).amountPaid = "[R"+Integer.toString(lowerBound2)+" , R"+Integer.toString(upperBound2)+"]";
          claims.get(i).insuredUniqueId = Integer.toString(lowerBound3)+ " <="+"InsuredUniqueId"+"<= "+Integer.toString(upperBound3);
          claims.get(i).agencyUniqueId = Integer.toString(lowerBound4)+ " <="+"AgencyUniqueId"+"<= "+Integer.toString(upperBound4);
      }
   
     
      //Using character now
      
      
      // Update to k-anonymity values
      for(int i=0;i<claims.size();i++)
      {
        manager.update(claims.get(i));
      }
      
    }
  
    public void anonimyzer2()
    {
  
      String asteric = "*";
      char asteric2 = '*';
      List<CleanInsuranceClaims> claims = manager.getAllClaims(); 
      String policyHolderArea = "";
      String policyHolderStreet = "";
      int count = 0;
      
      for(int i=0;i<claims.size();i++)
      {
        claims.get(i).policyHolderCity = asteric;
        
      }
      for(int i=0;i<claims.size();i++)
      {
        claims.get(i).policyHolderPostalCode = asteric;
      }
      for(int i=0;i<claims.size();i++)
      {
        while(counter<(claims.get(i).policyHolderProvince).toString().length())
        {
          policyHolderArea =  policyHolderArea + asteric; 
          counter++;
        }
        counter = 0;
        claims.get(i).policyHolderProvince = policyHolderArea;
        policyHolderArea = "";
      }
      for(int i=0;i<claims.size();i++)
      {
         
          while(counter<(claims.get(i).policyHolderArea).toString().length())
          {
            policyHolderArea =  policyHolderArea + asteric; 
            counter++;
          }
          counter = 0;
          claims.get(i).policyHolderArea = policyHolderArea;
          policyHolderArea = "";
          
      }
      for(int i=0;i<claims.size();i++)
      {
          while(counter<claims.get(i).policyHolderStreet.length())
          {
            if(claims.get(i).policyHolderStreet.charAt(counter)== ' ')
            {
                break;
            }
            policyHolderStreet =  policyHolderStreet + asteric;
           
            counter++;
          }
          policyHolderStreet =  policyHolderStreet + " street"; 
          
          claims.get(i).policyHolderStreet = policyHolderStreet;
          policyHolderStreet = "";
          counter = 0;
          
      }
      for(int i=0;i<claims.size();i++)
      {
         
          while(counter<(claims.get(i).postalCodeLossOccured).toString().length())
          {
            policyHolderArea =  policyHolderArea + asteric; 
            counter++;
          }
          counter = 0;
          claims.get(i).postalCodeLossOccured = policyHolderArea;
          policyHolderArea = "";
          
      }
      for(int i=0;i<claims.size();i++)
      {
         
          while(counter<(claims.get(i).provinceLossOccured).toString().length())
          {
            policyHolderArea =  policyHolderArea + asteric; 
            counter++;
          }
          counter = 0;
          claims.get(i).provinceLossOccured = policyHolderArea;
          policyHolderArea = "";
          
      }
      for(int i=0;i<claims.size();i++)
      {
         
		  while(counter<(claims.get(i).claimServiceProvider).toString().length())
		  {
		    policyHolderArea =  policyHolderArea + asteric; 
		    counter++;
		  }
		  counter = 0;
		  claims.get(i).claimServiceProvider = policyHolderArea;
		  policyHolderArea = "";
		  
      }
      for(int i=0;i<claims.size();i++)
      {
	claims.get(i).cityLossOccured = asteric;
	
      }
      
      //Dates
      int temp=0;
      String aste = "****";
      String str = "";
      
      
      for(int i=0;i< claims.size();i++)
      {
	      
		str = claims.get(i).dateOfBirthPOlicyHolder.substring(4);
		claims.get(i).dateOfBirthPOlicyHolder =  aste+str;
		str = "";
		str = claims.get(i).dateOfClaim.substring(4);
		claims.get(i).dateOfClaim =  aste+str;
		
		str = "";
		str = claims.get(i).dateOfLoss.substring(4);
		claims.get(i).dateOfLoss =  aste+str;
		
		str = "";
		str = claims.get(i).policyStartDate.substring(4);
		claims.get(i).policyStartDate =  aste+str;
		
		str = "";
		str = claims.get(i).policyEnddate.substring(4);
		claims.get(i).policyEnddate =  aste+str;
		
	      }
		   
	      // Update to k-anonymity values
	      for(int i=0;i<claims.size();i++)
	      {
		manager.update(claims.get(i));
	      }
		
    }
  
}
