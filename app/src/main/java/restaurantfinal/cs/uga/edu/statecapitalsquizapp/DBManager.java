package restaurantfinal.cs.uga.edu.statecapitalsquizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    public static final String dbName = "stateQuestions.db";
    public static final String tableName = "statesTable";
    public static final String id = "id";
    public static final String colOne = "State";
    public static final String colTwo = "ActualCapital";
    public static final String colThree = "CityTwo";
    public static final String colFour = "CityThree";
    public static final String colFive = "Answer";

    public static final String CREATE_STATE_TABLE = "CREATE TABLE "
            + tableName + "(" + id
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + colOne + " TEXT,"
            + colTwo + " TEXT, " + colThree + " TEXT, " + colFour + " TEXT, "
            + colFive + " TEXT);";

    public DBManager(Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS statesTable");
        onCreate(db);
    }

    public void insertQuestions(Question question){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(colOne, question.getState());
        values.put(colTwo, question.getCapitals(0));
        values.put(colThree, question.getCapitals(1));
        values.put(colFour, question.getCapitals(2));
        values.put(colFive, question.getAnswer());
        db.insert(tableName, null, values);
    }

    public List<Question> getStatesList(){
        List<Question> stateArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tableName;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            for(int i = 0; i < 6; i++){
                Question question = new Question();
                String stateText = cursor.getString(cursor.getColumnIndex(colOne));
                question.setState(stateText);

                String capital = cursor.getString(cursor.getColumnIndex(colTwo));
                question.setCapitals(0,capital);

                String capital2 = cursor.getString(cursor.getColumnIndex(colThree));
                question.setCapitals(1,capital2);

                String capital3 = cursor.getString(cursor.getColumnIndex(colFour));
                question.setCapitals(2,capital3);

                String answerText = cursor.getString(cursor.getColumnIndex(colFive));
                question.setAnswer(answerText);

                stateArrayList.add(question);
                cursor.moveToNext();
            }
        }
        return stateArrayList;
    }
}
