package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl;

import java.util.Date;
import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Transaction;

public class PersistentStorageTransactionDAO {

    public void logTransaction(Date date, String accountNo, ExpenseType expenseType, double amount){};  //--1

    /***
     * Return all the transactions logged.
     *
     * @return - a list of all the transactions
     */
   // public List<Transaction> getAllTransactionLogs(){return;};  ---2

    /***
     * Return a limited amount of transactions logged.
     *
     * @param limit - number of transactions to be returned
     * @return - a list of requested number of transactions
     */
  //  public List<Transaction> getPaginatedTransactionLogs(int limit){};   ---3
}
