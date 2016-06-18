package first_name_last_name.rsantosh.com.firstnamelastname.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import first_name_last_name.rsantosh.com.firstnamelastname.FirstNameLastName;
import first_name_last_name.rsantosh.com.firstnamelastname.Model.FirstNameLastNameModel;

/**
 * Created by C S Ramachandran on 16-06-2016.
 */
public class DBHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "personal_details";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "personal";
    private static final String PERSONAL_ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";

    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String strCreateTable = "create table " + TABLE_NAME + "(" + PERSONAL_ID + " integer primary key, " + FIRST_NAME + " text, " + LAST_NAME + " text );";
        sqLiteDatabase.execSQL(strCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(String fName, String lName){

        db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(FIRST_NAME,fName);
        values.put(LAST_NAME,lName);

        db.insert(TABLE_NAME,null,values);
        db.close();

    }

    public ArrayList<FirstNameLastNameModel> getData(){

        ArrayList<FirstNameLastNameModel> mArray = new ArrayList<>();

        db = getReadableDatabase();
        String Query = "Select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(Query,null);

        if(cursor.moveToFirst()){

            do {

                int id = cursor.getInt(0);

                String fName = cursor.getString(1);

                String lName = cursor.getString(2);

                FirstNameLastNameModel firstNameLastname = new FirstNameLastNameModel(lName,fName,id);
                mArray.add(firstNameLastname);

            }while (cursor.moveToNext());

        }

        db.close();



        return mArray;
    }

    public void delete(){

        db=getWritableDatabase();
        db.delete(TABLE_NAME,PERSONAL_ID + "=?", new String[]{String.valueOf(8)});


        db.close();
    }


}
