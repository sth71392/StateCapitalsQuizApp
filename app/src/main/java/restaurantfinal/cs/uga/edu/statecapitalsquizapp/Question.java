package restaurantfinal.cs.uga.edu.statecapitalsquizapp;

public class Question {

    public String state;
    public String[] capitals = new String[3];
    public String answer;

    public Question (){

    }

    public Question(String state, String[] capitals, String answer){
        this.state = state;
        this.capitals[0] = capitals[0];
        this.capitals[1] = capitals[1];
        this.capitals[2] = capitals[2];
        this.answer = answer;

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCapitals (int index){
        return capitals[index];
    }

    public void setCapitals (int index, String capitals){
        this.capitals[index] = capitals;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer (String answer){
        this.answer = answer;
    }


}
