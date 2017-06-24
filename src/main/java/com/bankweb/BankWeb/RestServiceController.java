/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankweb.BankWeb;

/**
 *
 * @author tim
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
public class RestServiceController {
 
    @Autowired
    private ITransactionRepository repo;
   
    private Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    String currentDate = format.format(date);
    
 
    static final Logger logger = LogManager.getLogger(RestServiceController.class.getName());
     
    // CREATE
    @RequestMapping("/transactions/deposit")
    @ResponseBody
    public String depositAction(int accountnumber, int amount) {
        Transactions trans = new Transactions(accountnumber, amount);
        String response = "";
        logger.info("Account number "+ accountnumber + "amount "+ amount);
       
        try {
            //read current balance first
            String currentBalance = readCurrentBalance(accountnumber);
            //read last deposit date
            String lastDepositDate = lastDepositDate(accountnumber);
            //read frequency count
            int frequency = depoFrequency(accountnumber);
            int finalBalance = amount + Integer.parseInt(currentBalance);
            //read last deposited amount
            int lastDepositedAmount = lastAmountDeposited(accountnumber);
            //check for maximum daily transaction
            logger.info("Current date "+ currentDate);
            
            //check last withdrawn amount
            int lastWithdrawnAmount = lastWithdrawnAmount(accountnumber); 
            //check last withdrawn date
             String lastwithdrawDate = lastWithrawDate(accountnumber);
             //check last withdraw frequency
             int withdrawfrequency = withdrawFrequency(accountnumber);
            if(lastDepositDate.equals(currentDate) && lastDepositedAmount >=150000){
              return response = "Maximum daily deposit reached. $150000 Thank you"; 
              //check for max deposit per trnsaction
            }else if(amount> 40000){
              return response = "Deposits of more than $40000 are not allowed. Thank you";
              //check daily frequency
              
            }else if(frequency>=4&&lastDepositDate.equals(currentDate) ){
               return response = "Maximum deposit frequency reached. Four times daily. Thank you"; 
            }else
            trans.setBalance(finalBalance);
            trans.setDeposited(amount);
            trans.setDatedeposited(currentDate);
            trans.setDailydepofrequency(frequency + 1);
            trans.setAccountnumber(accountnumber);
            trans.setWithdrawn(lastWithdrawnAmount);
            trans.setDatewithdrawn(lastwithdrawDate);
            trans.setDailywithdrawalfrequency(withdrawfrequency);
            repo.save(trans);
         response="Deposit of "+ amount + "was successfully done";   
        
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        return response;
    }
    
    @RequestMapping("/transactions/withdraw")
    @ResponseBody
    public String withdrawAction(int accountnumber, int amount) {
        Transactions trans = new Transactions(accountnumber, amount);
        String response = "";
        try {
            //read current balance first
            String currentBalance = readCurrentBalance(accountnumber);
            //read last withdraw date
            String lastwithdrawDate = lastWithrawDate(accountnumber);
            //read withdraw frequency count
            int frequency = withdrawFrequency(accountnumber);
            int finalBalance = Integer.parseInt(currentBalance)-amount;
            //read last withdrawn amount
            int lastWithdrawnAmount = lastWithdrawnAmount(accountnumber);
            //check for maximum daily transaction
            logger.info("Frequency====> "+ frequency);
            //ckeck last deposit date
            String lastDepositDate = lastDepositDate(accountnumber);
            //check last deposit amount
             int lastDepositedAmount = lastAmountDeposited(accountnumber);
             //check last deposit frequency
             int frequencyDeposit = depoFrequency(accountnumber);
             
            if(lastwithdrawDate.equals(currentDate) && lastWithdrawnAmount >=50000){
              return response = "Maximum permissible daily withdraw reached. $50000 Thank you"; 
              //check for max deposit per trnsaction
            }else if(amount> 20000){
              return response = "Withdrawals of more than $20000 are not allowed. Thank you";
              //check daily frequency
              
            }else if(frequency>=3 && lastwithdrawDate.equals(currentDate)){
               return response = "Maximum withdraw frequency reached. Three times daily. Thank you"; 
            }else
            trans.setBalance(finalBalance);
            trans.setWithdrawn(amount);
            trans.setDatewithdrawn(currentDate);
            trans.setDailywithdrawalfrequency(frequency + 1);
            trans.setAccountnumber(accountnumber);
            trans.setDeposited(lastDepositedAmount);
            trans.setDatedeposited(lastDepositDate);
            trans.setDailydepofrequency(frequencyDeposit);
            repo.save(trans);
         response="Withdrawal of "+ amount + "was successfully done";   
        
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        return response;
    }
    
    //READ LAST DEPOSIT DATE
    
    public String lastDepositDate(int accNo){
        String date = "";
        int i = 0;
       List<Transactions> trans = null;
        try {
            trans = repo.findByAccNo(accNo);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
         for(i=0;i<trans.size();i++){
             date = trans.get(i).getDatedeposited();
         }
         return date;
    }
    
      //READ LAST WITHDRAW DATE
    
    public String lastWithrawDate(int accNo){
       String date = "";
       int i =0;
       List<Transactions> trans = null;
        try {
            trans = repo.findByAccNo(accNo);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        
        for(i=0;i<trans.size();i++){
             date = trans.get(i).getDatewithdrawn();
         }
         return date;
    }
    //READ DEPOSIT FREQUENCY COUNT
    public int depoFrequency(int accNo){
        int freq=0;
       List<Transactions> trans = null;
        try {
            trans = repo.findLastFrequencyByAccNo(accNo);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        //logger.info("id >>>>>>>>>>>>>>>>>> "+trans.lastIndexOf(trans));
        int i = 0;
        for(i=0;i<trans.size(); i++){
         //logger.info("id >>>>>>>>>>>>>>>>>> "+trans.get(i).getId() );  
         freq = trans.get(i).getDailydepofrequency();
        }
         return freq;  
        
    }
    
     //READ WITHDRAW FREQUENCY COUNT
    public int withdrawFrequency(int accNo){
        int freq=0;
        int i = 0;
       List<Transactions> trans = null;
        try {
            trans = repo.findLastFrequencyByAccNo(accNo);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        
        
        for(i=0;i<trans.size(); i++){
         
         freq = trans.get(i).getDailywithdrawalfrequency();
        }
         return freq;  
        
    }
    //READ last deposited amount
    public int lastAmountDeposited(int accNo){
        int i = 0;
        int amount = 0;
        List<Transactions> trans = null;
        try {
            trans = repo.findByAccNo(accNo);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        for(i=0;i<trans.size(); i++){
         
         amount = trans.get(i).getDeposited();
        }
         return amount;  
        
    }
    
     //READ last deposited amount
    public int lastWithdrawnAmount(int accNo){
        int i = 0;
        int amount = 0;
        List<Transactions> trans = null;
        try {
            trans = repo.findByAccNo(accNo);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            
        }
        for(i=0;i<trans.size(); i++){
         
         amount = trans.get(i).getWithdrawn();
        }
         return amount;  
        
    }
    
    //READ last amount 
   @RequestMapping("/transactions/balance")
    @ResponseBody
    public String readCurrentBalance(int accountnumber) {
        int i = 0;
        int accNo = accountnumber;
        int amount = 0;
        List<Transactions> trans = null;
        try {
            trans = repo.findByAccNo(accNo);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
            for(i=0;i<trans.size(); i++){
         
          amount = trans.get(i).getBalance();
           }
            return String.valueOf(amount);
        
    }
    
  
 
    //READ Account statement
    @RequestMapping("/transactions/statement")
    public List<Transactions> getStatement(@RequestParam(value = "accountnumber") int accountnumber) {
        List<Transactions> trans = repo.findByAccNo(accountnumber);
        return trans;
    }
}
