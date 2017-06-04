package com.jetpoo.game.useful;

import java.util.*;
import com.jetpoo.game.useful.Score;

/**
 * Created by pedromiranda on 04/06/17.
 */
public class ServerUtils {

    private List<Score> scores = new ArrayList<Score>();

    public ServerUtils(){}

    public ServerUtils(List<Score> scores){
        this.scores=scores;
    }
    public List<Score> getList(){
        return scores;
    }
    public void setList(List<Score> scores){
        this.scores=scores;
    }

    public void addScore(Score score){

        if(scores.size() == 0){
            scores.add(score);
        }
        else {
            for (int i = 0; i < scores.size(); i++) {
                if (score.getScore() > scores.get(i).getScore()) {
                    scores.add(i, score);
                    scores.remove(5);
                }
            }
        }

    }
    public void removeScore(Score score){
        scores.remove(score);
    }


}
