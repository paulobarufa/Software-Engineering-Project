package managequiz;

/**
 *
 * @author paulo
 */

public class Question {

    
    //constructor
    public Question(){
        this.question = "";
        this.answer = "";
        this.incorrect1 = "";
        this.incorrect2 = "";
        this.incorrect3 = "";
    }
    
    public Question(
            String question,
            String answer,
            String incorrect1,
            String incorrect2,
            String incorrect3){
        this.question = question;
        this.answer = answer;
        this.incorrect1 = incorrect1;
        this.incorrect2 = incorrect2;
        this.incorrect3 = incorrect3;
    }
    
    //methods
    public String getQuestion(){
        return question;
    }
    
    public String getAnswer(){
        return answer;
    }
    
    public String getIncorrect1(){
        return incorrect1;
    }
    
    public String getIncorrect2(){
        return incorrect2;
    }
    
    public String getIncorrect3(){
        return incorrect3;
    }
    
    //instance variables
    public String question;
    public String answer;
    public String incorrect1;
    public String incorrect2;
    public String incorrect3;
    
}
