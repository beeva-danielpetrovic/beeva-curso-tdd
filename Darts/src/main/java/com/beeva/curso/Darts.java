package com.beeva.curso;

/**
 * Created by daniel on 17/11/15.
 */
public class Darts {
    private Integer score;
    private Integer turn;
    private Integer leftDarts;
    private Integer beforeScore;
    private boolean finished;

    public Darts() {

        this.score = 501;
        this.turn = 1;
        this.leftDarts = 3;
        this.beforeScore = 0;
        this.finished = false;
    }

    public Integer getScore() {
        return score;
    }

    public void throwDart(Integer value, TYPE_SCORE typeScore) {

        if (this.leftDarts == 3) {
            this.beforeScore = this.score;
        }

        if (typeScore == TYPE_SCORE.SIMPLE) {
            this.score = this.score - value;
        } else if (typeScore == TYPE_SCORE.DOUBLE) {
            this.score = this.score - (2 * value);
        } else {
            this.score = this.score - (3 * value);
        }

        this.leftDarts--;
        if (this.leftDarts == 0) {
            this.turn++;
            this.leftDarts = 3;
        }

        if (this.score == 1) {
            this.score = this.beforeScore;
        } else if (this.score < 0) {
            this.score = this.beforeScore;
        } else if (this.score == 0 && typeScore == TYPE_SCORE.DOUBLE) {
            this.turn = 1;
            this.leftDarts = 3;
            this.finished = true;
        }

    }

    public Integer getTurn() {
        return turn;
    }

    public Integer getLeftDarts() {
        return leftDarts;
    }

    public boolean isFinished() {
        return finished;
    }
}
