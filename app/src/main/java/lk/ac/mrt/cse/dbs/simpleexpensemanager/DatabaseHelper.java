package lk.ac.mrt.cse.dbs.simpleexpensemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper dbhelperInstance = null;

    protected static final String db_name = "200656T.db";
    private static final int db_version = 1;

    public static final String a_TableName = "Accounts";
    public static final String accountNo = "accountNo";
    public static final String bankName = "bankName";
    public static final String accountHolderName = "accountHolderName";
    public static final String balance = "balance";

    public static final String t_TableName = "Transactions";
    public static final String transaction_id = "transaction_id";
    public static final String date = "date";
    public static final String accNo = "accNo";
    public static final String expenseType = "expenseType";
    public static final String amount = "amount";

    public DatabaseHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (dbhelperInstance == null)
            dbhelperInstance = new DatabaseHelper(context);
        return dbhelperInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String A = "CREATE TABLE "+ a_TableName + " (" +
                accountNo + " VARCHAR(50) PRIMARY KEY NOT NULL, " +
                bankName + " VARCHAR(255), " +
                accountHolderName + " VARCHAR(255), " +
                balance + " DECIMAL(10,2))";
        String T = "CREATE TABLE " + t_TableName + " (" +
                 transaction_id + " VARCHAR(50) PRIMARY KEY NOT NULL, " +
                accNo + " VARCHAR(50) NOT NULL, " +
                date + " Date, " +
                amount + " DECIMAL(10,2)," +
                expenseType + " VARCHAR(255)," +
                "FOREIGN KEY (" +accNo+ ") REFERENCES " + a_TableName +"(" + accountNo + "))";

        sqLiteDatabase.execSQL(A);
        sqLiteDatabase.execSQL(T);
        }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + a_TableName);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + t_TableName);
        onCreate(sqLiteDatabase);

    }
}
