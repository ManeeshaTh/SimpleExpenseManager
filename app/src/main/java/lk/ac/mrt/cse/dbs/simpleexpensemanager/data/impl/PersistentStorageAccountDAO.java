package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.DatabaseHelper;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.exception.InvalidAccountException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;

public class PersistentStorageAccountDAO implements AccountDAO {

    private Context context;

    public PersistentStorageAccountDAO(Context context) {
        this.context = context;
    }

    /***
         * Get a list of account numbers.
         *
         * @return - list of account numbers as String
         */
        public List<String> getAccountNumbersList(){
            ArrayList<String>  accNoList = new ArrayList<>();

            DatabaseHelper dbh = DatabaseHelper.getInstance(context);
            SQLiteDatabase sqldb = dbh.getReadableDatabase();

            //Select Query
            String Query = "SELECT "+ dbh.accNo+" FROM " + dbh.a_TableName+" ORDER BY " + dbh.accNo ;

            //Fill accNoList
            Cursor cursor = sqldb.rawQuery(Query, null);
            while (cursor.moveToNext())
            {
                String accNo = cursor.getString(
                        cursor.getColumnIndexOrThrow(dbh.accNo));
                accNoList.add(accNo);
            }
            cursor.close();

            return accNoList;

        } //--1

        /***
         * Get a list of accounts.
         *
         * @return - list of Account objects.
         */
        public List<Account> getAccountsList(){
            ArrayList<Account>  accList = new ArrayList<>();

            return accList;
        }  //--2

        /***
         * Get the account given the account number.
         *
         * @param accountNo as String
         * @return - the corresponding Account
         * @throws InvalidAccountException - if the account number is invalid
         */
        public Account getAccount(String accountNo) throws InvalidAccountException{
            Account acc = null;

            return acc;
        }  //--3

        /***
         * Add an account to the accounts collection.
         *
         * @param account - the account to be added.
         */
        public void addAccount(Account account){}  //  --4

        /***
         * Remove an account from the accounts collection.
         *
         * @param accountNo - of the account to be removed.
         * @throws InvalidAccountException - if the account number is invalid
         */
        public void removeAccount(String accountNo) throws InvalidAccountException{} //--5

        /***
         * Update the balance of the given account. The type of the expense is specified in order to determine which
         * action to be performed.
         * <p/>
         * The implementation has the flexibility to figure out how the updating operation is committed based on the type
         * of the transaction.
         *
         * @param accountNo   - account number of the respective account
         * @param expenseType - the type of the transaction
         * @param amount      - amount involved
         * @throws InvalidAccountException - if the account number is invalid
         */
        public void updateBalance(String accountNo, ExpenseType expenseType, double amount) throws InvalidAccountException{} //--6



}
