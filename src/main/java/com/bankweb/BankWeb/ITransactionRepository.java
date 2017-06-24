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
import java.util.List;
import org.springframework.data.jpa.repository.Query;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
 
public interface ITransactionRepository extends CrudRepository<Transactions, Long> {
    @Query("SELECT t FROM Transactions t WHERE t.accountnumber = :accNo")
    public List<Transactions>findByAccNo(@Param("accNo") int accNo);
 
    //List<transactions> findByYearLessThan(int accNo);
   // List<Transactions>findCurrentBalance(int accNo);
    @Query("SELECT t FROM Transactions t WHERE t.accountnumber = :accNo ORDER BY t.accountnumber desc")
    public List<Transactions> findLastFrequencyByAccNo(@Param("accNo")int accNo);

    
 
}

