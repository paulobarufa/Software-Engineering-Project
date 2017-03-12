/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managequiz;

import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class Topic {
    
    //constructors
    public Topic(){
        this.name = "Create new topic";
        this.questions = new ArrayList<Question>();
    }
    
    public Topic(String name, ArrayList<Question> questions){
        this.name = name;
        this.questions = questions;
    }
    
    //methods
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    
    //instance variables
    ArrayList<Question> questions;
    String name;

    void add(Question question) {
        this.questions.add(question);
    }

    @Override
    public String toString() {
        return "Topic{" + "questions=" + questions + ", name=" + name + '}';
    }
    
    
}
