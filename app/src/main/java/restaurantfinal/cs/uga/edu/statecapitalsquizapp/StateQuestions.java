package restaurantfinal.cs.uga.edu.statecapitalsquizapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import static restaurantfinal.cs.uga.edu.statecapitalsquizapp.DBManager.dbName;

public class StateQuestions {
    List<Question> list = new ArrayList<>();
    DBManager DBHelper;

    public int getLength(){
        return list.size();
    }

    public String getStateQuestion(int i){
        return list.get(i).getState();
    }

    public String getStateChoice(int i, int num){
        return list.get(i).getCapitals(num - 1);
    }

    public String getStateAnswer(int i){
        return list.get(i).getAnswer();
    }

    public void initializeQuiz(Context context){
        DBHelper = new DBManager(context);
        list = DBHelper.getStatesList();
    }
}
