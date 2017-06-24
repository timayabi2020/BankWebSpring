/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankweb.BankWeb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author tim
 */
@Entity
@Table(name = "transactions", catalog = "bankweb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountnumber")
    private int accountnumber;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "withdrawn")
    private Integer withdrawn;
    @Size(max = 50)
    @Column(name = "datewithdrawn")
    private String datewithdrawn;
    @Size(max = 50)
    @Column(name = "datedeposited")
    private String datedeposited;
    @Column(name = "deposited")
    private Integer deposited;
    @Column(name = "dailydepofrequency")
    private Integer dailydepofrequency;
    @Column(name = "dailywithdrawalfrequency")
    private Integer dailywithdrawalfrequency;

    public Transactions() {
    }

    public Transactions(Integer id) {
        this.id = id;
    }

    public Transactions(Integer id, int accountnumber) {
        this.id = id;
        this.accountnumber = accountnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(Integer withdrawn) {
        this.withdrawn = withdrawn;
    }

    public String getDatewithdrawn() {
        return datewithdrawn;
    }

    public void setDatewithdrawn(String datewithdrawn) {
        this.datewithdrawn = datewithdrawn;
    }

    public String getDatedeposited() {
        return datedeposited;
    }

    public void setDatedeposited(String datedeposited) {
        this.datedeposited = datedeposited;
    }

    public Integer getDeposited() {
        return deposited;
    }

    public void setDeposited(Integer deposited) {
        this.deposited = deposited;
    }

    public Integer getDailydepofrequency() {
        return dailydepofrequency;
    }

    public void setDailydepofrequency(Integer dailydepofrequency) {
        this.dailydepofrequency = dailydepofrequency;
    }

    public Integer getDailywithdrawalfrequency() {
        return dailywithdrawalfrequency;
    }

    public void setDailywithdrawalfrequency(Integer dailywithdrawalfrequency) {
        this.dailywithdrawalfrequency = dailywithdrawalfrequency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bankweb.BankWeb.Transactions[ id=" + id + " ]";
    }
    
}
