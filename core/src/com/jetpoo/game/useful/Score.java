package com.jetpoo.game.useful;

import java.util.*;

/**
 * Created by pedromiranda on 04/06/17.
 */


public class Score {

    private int score;
    private String name;


    public Score(){
        score=0;
        name="";
    }

    public Score(int score,String name){
        this.name=name;
        this.score=score;

    }

    public void setScore(int score){
        this.score=score;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }


}
