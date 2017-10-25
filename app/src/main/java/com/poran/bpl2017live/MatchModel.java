package com.poran.bpl2017live;

/**
 * Created by poran on 9/27/2017.
 */

public class MatchModel {
    public String title, team1, team2;
    public String team1_score, team2_score, team1_inning1, team1_inning2, team2_inning1, team2_inning2;


    public MatchModel() {
        this.title = "";
        this.team1 = "";
        this.team2 = "";
        this.team1_score = "";
        this.team2_score = "";

        this.team1_inning1 = "";
        this.team1_inning2 = "";
        this.team2_inning1 = "";
        this.team2_inning2 = "";
    }

    public MatchModel(String title, String team1, String team2, String team1_inning1, String team1_inning2,
                      String team2_inning1, String team2_inning2) {
        this.title = title;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_inning1 = team1_inning1;
        this.team1_inning2 = team1_inning2;
        this.team2_inning1 = team2_inning1;
        this.team2_inning2 = team2_inning2;
    }
}
