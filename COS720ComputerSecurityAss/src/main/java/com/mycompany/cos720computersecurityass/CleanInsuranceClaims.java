
package com.mycompany.cos720computersecurityass;

import EntityManagers.ConcreteDAO;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.fluttercode.datafactory.impl.DataFactory;
import java.util.*;
import static javax.script.ScriptEngine.FILENAME;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gershom12
 */
 @Entity
public class CleanInsuranceClaims {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InsuranceClaimId;
    static DataFactory df = new DataFactory();
    static int count=0;
    static int count1=0;
    static int count2=0;
    static int count3=0;
    static int count4=0;
    private static final String FILENAME = "/home/gershom/Desktop/Honours/COS720/Assignment/COS720ComputerSecurityAss/src/main/java/com/mycompany/cos720computersecurityass/streets.txt";
    private static final String FILENAME1="/home/gershom/Desktop/Honours/COS720/Assignment/COS720ComputerSecurityAss/src/main/java/com/mycompany/cos720computersecurityass/Provinces.txt";
    private static final String FILENAME2="/home/gershom/Desktop/Honours/COS720/Assignment/COS720ComputerSecurityAss/src/main/java/com/mycompany/cos720computersecurityass/postalCodes.txt";
    private static final String FILENAME3="/home/gershom/Desktop/Honours/COS720/Assignment/COS720ComputerSecurityAss/src/main/java/com/mycompany/cos720computersecurityass/PlostalCodeLossOccurred.txt";
    private static final String FILENAME4="/home/gershom/Desktop/Honours/COS720/Assignment/COS720ComputerSecurityAss/src/main/java/com/mycompany/cos720computersecurityass/provinceLossOccured.txt";
    private static String streets[]=new String[119626];
    private static String provinces[]=new String[119626];
    private static String postalCode[]=new String[119626];
    private static String PostalCodeLossOccured[]=new String[119626];
    private static String ProvinceLossOccured[]=new String[119626];
    
    
    
    
    // Required fields
    
    protected boolean fraudulentClaimIndicator;
    protected String fraudulentClaimReason;
    protected String dateOfLoss;
    protected String dateOfClaim;
    protected String agencyUniqueId;
    protected String insuredUniqueId;
    protected String insuredName;
    protected String insuredSurname;
    protected String genderOfPolicyHolder;
    protected String kindOfLoss;
    protected String policyHolderStreet;
    protected String policyHolderProvince;
    protected String policyHolderCity;
    protected String policyHolderArea;
    protected String policyHolderPostalCode;
    protected String provinceLossOccured;
    protected String cityLossOccured;
    protected String areaLossOccured;
    protected String postalCodeLossOccured;
    protected String maritalStatusPolicyHolder;
    protected String dateOfBirthPOlicyHolder;
    protected String totalSumInsured;
    protected String totalPolicyRevenue;
    protected String amountPaid;
    protected String policyStartDate;
    protected String policyEnddate;
    protected String otherPartyName;
    protected String otherPartySurname;
    protected String claimServiceProvider;
    

    public CleanInsuranceClaims()
    {
        insuredUniqueId = null;
    }
   
    public String insuredName(){
        
        String name = df.getFirstName();
        return name;
    }
    public String insuredSurname(){
        
        String surname = df.getLastName();
        return surname;
    }
    public boolean fradulentClaimIndicator()
    {
        Random randomno = new Random();
        return randomno.nextBoolean();
    }
    public  String fraudulentClaimReason()
    {
        String fraudulentClaimReason = null; 
        String[] Reasons = {"Insured handed vehicle to third party for sale across the border. Reported his vehicle stolen a few days later","My car was legally parked as it backed into another vehicle.","I had been learning to drive with power steering. I turned the wheel to what I thought was enough and found myself in a different direction going the opposite way." ,"Fraudulent vehicle claim where driver reported vehicle stolen and was found driving vehicle","Multiple insurance policies and claimed from more than one company for the same items at the same time."};
        fraudulentClaimReason = df.getItem(Reasons,80,"Multiple insurance policies and claimed from more than one company for the same items at the same time.");
       
	return fraudulentClaimReason;
    }
    public String dateOfLoss()
    {
        GregorianCalendar gc = new GregorianCalendar();
        String date;
	int year = randBetween(2000, 2017);
	    
	gc.set(gc.YEAR, year);
	int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	gc.set(gc.DAY_OF_YEAR, dayOfYear);
	date=gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
        return date;
    }
    public  int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    public String dateOfClaim()
    {
        GregorianCalendar gc = new GregorianCalendar();
        String date;
	int year = randBetween(2000, 2017);
	gc.set(gc.YEAR, year);
	int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	gc.set(gc.DAY_OF_YEAR, dayOfYear);
	date=gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
        return date;
    }
    public String AgencyId(){
        
        int maximum=1;
        int minimum=100000;
        int randomNum=0;
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum =  minimum + i;
        return Integer.toString(randomNum);
    }
    public String InsuredUniqueId(){
       
        int maximum=1;
        int minimum=100000;
        int randomNum=0;
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum =  minimum + i;
        return Integer.toString(randomNum);
    }
    public String genderOfPolicyHolder(){
        
        String gender=null; 
        String[] values = {"Male","Female"};
        gender= df.getItem(values,80,"Male");
       
	return gender; 
    }
    public String KindOfLoss()
    {
        String Loss=null; 
        String[] values = {"Theft","Fire","collapsed building","water intrusion through roofs","liability from industrial accidents"};
        Loss= df.getItem(values,80,"Fire");
       
	return Loss; 
    }
    public String getStreet()
    {
        
        String currentStreet = streets[count];
        count++;
        return currentStreet;
    }
    public void PolicyHolderStreet(){
        
          BufferedReader br = null;
          FileReader fr = null;
          try {

                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);

                String sCurrentLine;

                br = new BufferedReader(new FileReader(FILENAME));
                int count=0;
                while ((sCurrentLine = br.readLine()) != null) {
                     
                        streets[count]=sCurrentLine;
                        count++;
                }
               

            } catch (IOException e) {

                    e.printStackTrace();

            } finally {

                    try {
                           if (br != null)
                               br.close();

                            if (fr != null)
                               fr.close();

                    } catch (IOException ex) {

                            ex.printStackTrace();
                    }

            }
    }
    public String getPolicyHolderProvince()
    {
        String currentProvince = provinces[count1];
        count1++;
        return currentProvince;
    }
    public String PolicyHolderProvince(){
	
          BufferedReader br = null;
          FileReader fr = null;

          try {

                fr = new FileReader(FILENAME1);
                br = new BufferedReader(fr);

                String sCurrentLine;

                br = new BufferedReader(new FileReader(FILENAME1));
                int count=0;
                while ((sCurrentLine = br.readLine()) != null) {
                       
                        if(count==100050)
                        {
                            break;
                        }
                        
                        provinces[count]=sCurrentLine;
                        count++;
                }
               

            } catch (IOException e) {

                    e.printStackTrace();

            } finally {

                    try {
                           if (br != null)
                               br.close();

                            if (fr != null)
                               fr.close();

                    } catch (IOException ex) {

                            ex.printStackTrace();
                    }

            }
          
          return null;
    }
    public String PolicyHolderCity(){
	
        String city = df.getCity();
        return city;
    
    }
     public String PolicyHolderArea(){
	
        String area = df.getAddress();
        return area;
    }
     public String getPostalCode(){
         
        String currentPostal = postalCode[count2];
        count2++;
        return currentPostal;
     }
     public String PolicyHolderPostalCode(){
     
          BufferedReader br = null;
          FileReader fr = null;

          try {

                fr = new FileReader(FILENAME2);
                br = new BufferedReader(fr);

                String sCurrentLine;

                br = new BufferedReader(new FileReader(FILENAME2));
                int count=0;
                while ((sCurrentLine = br.readLine()) != null) {
                       
                    
                    postalCode[count]=sCurrentLine;
                    count++;
                }
               

            } catch (IOException e) {

                    e.printStackTrace();

            } finally {

                    try {
                           if (br != null)
                               br.close();

                            if (fr != null)
                               fr.close();

                    } catch (IOException ex) {

                            ex.printStackTrace();
                    }

            }
          
          return null;
        
    }
    public String getProvinceLossOccured()
    {
        String currentProvinceLossOccured = ProvinceLossOccured[count3];
        count3++;
        return currentProvinceLossOccured;
        
    }
    public String ProvinceLossOccured(){
	
          BufferedReader br = null;
          FileReader fr = null;

          try {

                fr = new FileReader(FILENAME4);
                br = new BufferedReader(fr);

                String sCurrentLine;

                br = new BufferedReader(new FileReader(FILENAME4));
                int count=0;
                while ((sCurrentLine = br.readLine()) != null) {
                       
                        if(count==100050)
                        {
                            break;
                        }
                        ProvinceLossOccured[count]=sCurrentLine;
                        count++;
                }
               

            } catch (IOException e) {

                    e.printStackTrace();

            } finally {

                    try {
                           if (br != null)
                               br.close();

                            if (fr != null)
                               fr.close();

                    } catch (IOException ex) {

                            ex.printStackTrace();
                    }

            }
          
          return null;
    }
    public String CityLossOccured(){
        
        String city = df.getCity();
        return city;
    }
     public String AreaLossOccured(){
	
        String area = df.getAddress();
        return area;
    }
    public String getPostalCodeLossOccured()
    {
        String currentPostalCodeLossOccured = PostalCodeLossOccured[count4];
        count4++;
        return currentPostalCodeLossOccured;
        
        
    }
    public String PostalCodeLossOccurred(){
         
	  BufferedReader br = null;
          FileReader fr = null;

          try {

                fr = new FileReader(FILENAME3);
                br = new BufferedReader(fr);

                String sCurrentLine;

                br = new BufferedReader(new FileReader(FILENAME3));
                int count=0;
                while ((sCurrentLine = br.readLine()) != null) {
                       
                       
                    PostalCodeLossOccured[count]=sCurrentLine; 
                    count++;
                }
               

            } catch (IOException e) {

                    e.printStackTrace();

            } finally {

                    try {
                           if (br != null)
                               br.close();

                            if (fr != null)
                               fr.close();

                    } catch (IOException ex) {

                            ex.printStackTrace();
                    }

            }
          
          return null;
        
        
    }
     public String MaritalStatusPolicyHolder(){
         
        String maritalStatus=null; 
        String[] values = {"Married","Single","Divorced","Widowed","Separated"};
        for (int i = 0; i < 100; i++) {          
            maritalStatus= df.getItem(values,80,"Married");
        }
	return maritalStatus;
        
    }
    public String DateOfBirthOfPolicyHolder(){
        
	GregorianCalendar gc = new GregorianCalendar();
        String date;
	int year = randBetween(1930, 1998);
	    
	gc.set(gc.YEAR, year);
	int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	gc.set(gc.DAY_OF_YEAR, dayOfYear);
	date=gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
        return date;
    }
    public String sumInsured()
    {
        int maximum = 1000000;
        int minimum = 10000;
        int randomNum = 0;
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum =  minimum + i;
        if(randomNum < 0 )
        {
            randomNum=randomNum*-1;
        }
        return Integer.toString(randomNum);
    }
    public String totalPoliciesRevenue()
    {
        int maximum = 3000000;
        int minimum = 10000;
        int randomNum = 0;
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum =  minimum + i;
        if(randomNum < 0)
        {
            randomNum = randomNum*-1;
        }
        return Integer.toString(randomNum);
    }
    public String amountPaid()
    {
        int maximum = 3000000;
        int minimum = 10000;
        int randomNum = 0;
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum =  minimum + i;
        
        if(randomNum<0)
        {
            randomNum = randomNum*-1;
        }
        return Integer.toString(randomNum);
    }
    public String otherPartyName()
    {
        String name = df.getFirstName();
        return name;
    }
    public String otherPartySurname()
    {
        String name = df.getLastName();
        return name;
    }
    public String policyStartDate()
    {
        GregorianCalendar gc = new GregorianCalendar();
        String date;
	int year = randBetween(1998, 2005);
	    
	gc.set(gc.YEAR, year);
	int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	gc.set(gc.DAY_OF_YEAR, dayOfYear);
	date=gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
        return date;
    }
    public String policyEndDate()
    {
        GregorianCalendar gc = new GregorianCalendar();
        String date;
	int year = randBetween(2007, 2017);
	    
	gc.set(gc.YEAR, year);
	int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	gc.set(gc.DAY_OF_YEAR, dayOfYear);
	date=gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
        return date;
    }
    public String claimServiceProvider(){
        String claimServiceProvider=df.getBusinessName();
        return claimServiceProvider;
    }
    public void insertEmptyRecord()
    {
       
        ConcreteDAO manager =  new ConcreteDAO();
        CleanInsuranceClaims claim = new CleanInsuranceClaims();
        
        // Insert empty records
        manager.add(claim);
        
    }
    public void insertDuplicateRecord(CleanInsuranceClaims mClaim)
    {
        InsuranceClaimId++;
        ConcreteDAO manager =  new ConcreteDAO();
        List<CleanInsuranceClaims> claims = manager.getAllClaims();
        CleanInsuranceClaims claim =  new CleanInsuranceClaims();
       
     
       
        claim.agencyUniqueId = mClaim.agencyUniqueId;
        claim.amountPaid = mClaim.amountPaid;
        claim.areaLossOccured = mClaim.areaLossOccured;
        claim.cityLossOccured = mClaim.cityLossOccured;
        claim.claimServiceProvider = mClaim.claimServiceProvider;
        claim.dateOfBirthPOlicyHolder =  mClaim.dateOfBirthPOlicyHolder;
        claim.dateOfClaim = mClaim.dateOfClaim;
        claim.dateOfLoss =  mClaim.dateOfLoss;
        claim.fraudulentClaimIndicator = mClaim.fraudulentClaimIndicator;
        claim.fraudulentClaimReason = mClaim.fraudulentClaimReason;
        claim.genderOfPolicyHolder = mClaim.genderOfPolicyHolder;
        claim.insuredName = mClaim.insuredName;
        claim.insuredSurname = mClaim.insuredSurname;
        claim.insuredUniqueId = mClaim.insuredUniqueId;
        claim.kindOfLoss = mClaim.kindOfLoss;
        claim.maritalStatusPolicyHolder = mClaim.maritalStatusPolicyHolder;
        claim.otherPartyName = mClaim.otherPartyName;
        claim.otherPartySurname =  mClaim.otherPartySurname;
        claim.policyEnddate = mClaim.policyEnddate;
        claim.policyHolderArea = mClaim.policyHolderArea;
        claim.policyHolderCity = mClaim.policyHolderCity;
        claim.policyHolderPostalCode = mClaim.policyHolderPostalCode;
        claim.policyHolderProvince = mClaim.policyHolderProvince;
        claim.policyHolderStreet = mClaim.policyHolderStreet;
        claim.policyStartDate = mClaim.policyStartDate;
        claim.postalCodeLossOccured = mClaim.postalCodeLossOccured;
        claim.provinceLossOccured = mClaim.provinceLossOccured;
        claim.totalPolicyRevenue = mClaim.totalPolicyRevenue;
        claim.totalSumInsured = mClaim.totalSumInsured;
        manager.add(claim);
        
    }
    public void wrongDateFormat()
    {
        ConcreteDAO manager =  new ConcreteDAO();
        CleanInsuranceClaims claim =  new CleanInsuranceClaims();
        String month = null; 
        String month1 = null;
        String dateOfLoss;
     
        int year = 0;
      
        int day = 0;
       
        int maximum = 31;
        int minimum = 0;
       
        
         
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        day =  minimum + i;
        
        if(day < 0)
        {
            day = day*-1;
        }
        year = randBetween(2000, 2017);
       
        String[] values = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        month = df.getItem(values,30,"September");
       
        dateOfLoss = day+" "+month+" "+year;
       
        claim.fraudulentClaimIndicator = claim.fradulentClaimIndicator();
        claim.fraudulentClaimReason = claim.fraudulentClaimReason();
        claim.dateOfLoss = dateOfLoss;
        claim.dateOfClaim = claim.dateOfClaim();
        claim.agencyUniqueId = claim.AgencyId();
        claim.insuredUniqueId = claim.InsuredUniqueId();
        claim.insuredName = claim.insuredName();
        claim.insuredSurname = claim.insuredSurname();
        claim.genderOfPolicyHolder = claim.genderOfPolicyHolder();
        claim.kindOfLoss = claim.KindOfLoss();
        claim.policyHolderStreet = claim.getStreet();
        claim.policyHolderProvince = claim.getPolicyHolderProvince();
        claim.policyHolderCity = claim.PolicyHolderCity();
        claim.policyHolderArea = claim.PolicyHolderArea();
        claim.policyHolderPostalCode = claim.getPostalCode();
        claim.provinceLossOccured = claim.getProvinceLossOccured();
        claim.cityLossOccured = claim.CityLossOccured();
        claim.areaLossOccured = claim.AreaLossOccured();
        claim.postalCodeLossOccured = claim.getPostalCodeLossOccured();
        claim.maritalStatusPolicyHolder = claim.MaritalStatusPolicyHolder();
        claim.dateOfBirthPOlicyHolder = claim.DateOfBirthOfPolicyHolder();
        claim.totalSumInsured = claim.sumInsured();
        claim.totalPolicyRevenue = claim.totalPoliciesRevenue();
        claim.amountPaid = claim.amountPaid();
        claim.policyStartDate = claim.policyStartDate();
        claim.policyEnddate = claim.policyEndDate();
        claim.otherPartyName = claim.otherPartyName();
        claim.otherPartySurname = claim.otherPartySurname();
        claim.claimServiceProvider = claim.claimServiceProvider();
        manager.add(claim);
    }
    public void insertInvalidCharacters(CleanInsuranceClaims mClaim)
    {
        ConcreteDAO manager =  new ConcreteDAO();
        List<CleanInsuranceClaims> claims = manager.getAllClaims();
        CleanInsuranceClaims claim =  new CleanInsuranceClaims();
       
     
       
        claim.agencyUniqueId = mClaim.agencyUniqueId;
        claim.amountPaid = mClaim.amountPaid;
        claim.areaLossOccured = "@#$!~!@#$$%$"+mClaim.areaLossOccured+"**&?$%^%$%^";
        claim.cityLossOccured = "//```$%#$"+mClaim.cityLossOccured+"&%%$%%";
        claim.claimServiceProvider = "@#$!~!@#$$%$"+mClaim.claimServiceProvider;
        claim.dateOfBirthPOlicyHolder =  mClaim.dateOfBirthPOlicyHolder;
        claim.dateOfClaim = mClaim.dateOfClaim+"%^$#@#$";
        claim.dateOfLoss =  "$$$$$$$$$$"+mClaim.dateOfLoss+"#######";
        claim.fraudulentClaimIndicator = mClaim.fraudulentClaimIndicator;
        claim.fraudulentClaimReason = "&&$%^#$$$$$$$$$$"+mClaim.fraudulentClaimReason+"-**-**";
        claim.genderOfPolicyHolder = mClaim.genderOfPolicyHolder;
        claim.insuredName = "#$%#@#$%"+mClaim.insuredName;
        claim.insuredSurname = mClaim.insuredSurname+"%^$#@#$";
        claim.insuredUniqueId = mClaim.insuredUniqueId;
        claim.kindOfLoss = mClaim.kindOfLoss+"\"@#$!~!@#$$%$\"";
        claim.maritalStatusPolicyHolder = mClaim.maritalStatusPolicyHolder;
        claim.otherPartyName = mClaim.otherPartyName;
        claim.otherPartySurname =  "&&$%^#$$$$$$$$$$"+mClaim.otherPartySurname;
        claim.policyEnddate = mClaim.policyEnddate;
        claim.policyHolderArea = mClaim.policyHolderArea+"%^$#@#$";
        claim.policyHolderCity = "&&$%^#$$$$$$$$$$"+mClaim.policyHolderCity;
        claim.policyHolderPostalCode = mClaim.policyHolderPostalCode+"%^$#@#$";
        claim.policyHolderProvince = "#######"+mClaim.policyHolderProvince+"%$#@#!&&";
        claim.policyHolderStreet = mClaim.policyHolderStreet;
        claim.policyStartDate = mClaim.policyStartDate+"%^$#@#$";
        claim.postalCodeLossOccured = "&&$%^#$$$$$"+mClaim.postalCodeLossOccured;
        claim.provinceLossOccured = mClaim.provinceLossOccured;
        claim.totalPolicyRevenue = mClaim.totalPolicyRevenue;
        claim.totalSumInsured = mClaim.totalSumInsured+"%^$#@#$";
        manager.add(claim);
        
        
    }
    
}
