package com.beeva.curso;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by daniel on 17/11/15.
 */
public class DartsTest {

    private Darts darts;

    @Before
    public void setUp() {

        darts = new Darts();
    }

    @Test
    public void gameInitialScore501() {

        assertThat(darts.getScore(), is(501));
    }

    @Test
    public void simpleThrow() {

        darts.throwDart(18, TYPE_SCORE.SIMPLE);
        assertThat(darts.getScore(), is(483));
    }

    @Test
    public void doubleThrow() {

        darts.throwDart(20, TYPE_SCORE.DOUBLE);
        assertThat(darts.getScore(), is(461));
    }

    @Test
    public void tripleThrow() {

        darts.throwDart(19, TYPE_SCORE.TRIPLE);
        assertThat(darts.getScore(), is(444));
    }

    @Test
    public void initTurnIsOneAndHasThreeThrows() {

        assertThat(darts.getTurn(), is(1));
        assertThat(darts.getLeftDarts(), is(3));
    }

    @Test
    public void changeTurnWhenThrowThreeDarts() {

        darts.throwDart(20, TYPE_SCORE.SIMPLE);
        assertThat(darts.getTurn(), is(1));
        assertThat(darts.getLeftDarts(), is(2));

        darts.throwDart(20, TYPE_SCORE.DOUBLE);
        assertThat(darts.getTurn(), is(1));
        assertThat(darts.getLeftDarts(), is(1));

        darts.throwDart(20, TYPE_SCORE.TRIPLE);
        assertThat(darts.getTurn(), is(2));
        assertThat(darts.getLeftDarts(), is(3));
    }

    @Test
    public void theLastScoreIsOneThenPastTurnAndLeftBeforeTurnScore() {

        for (int i = 0; i < 6; i++) {

            darts.throwDart(20, TYPE_SCORE.TRIPLE);

        }
        //Nos quedan 141
        darts.throwDart(20, TYPE_SCORE.TRIPLE);
        darts.throwDart(20, TYPE_SCORE.TRIPLE);
        darts.throwDart(20, TYPE_SCORE.SIMPLE);

        assertThat(darts.getScore(), is(141));
        assertThat(darts.getTurn(), is(4));
        assertThat(darts.getLeftDarts(), is(3));
    }

    @Test
    public void theLastScoreIsNegativeThenPastTheTurnAndLeftBeforeTurnScore() {

        for (int i = 0; i < 9; i++) {

            darts.throwDart(20, TYPE_SCORE.TRIPLE);

        }

        //Nos hemos pasado -39

        assertThat(darts.getScore(), is(141));
        assertThat(darts.getTurn(), is(4));
        assertThat(darts.getLeftDarts(), is(3));
    }

    @Test
    public void theGameFinishedTheLastThrowWasDoubleAndScoreIsZero() {

        for (int i = 0; i < 6; i++) {

            darts.throwDart(20, TYPE_SCORE.TRIPLE);

        }

        darts.throwDart(20, TYPE_SCORE.TRIPLE);
        darts.throwDart(19, TYPE_SCORE.TRIPLE);
        darts.throwDart(12, TYPE_SCORE.DOUBLE);

        assertThat(darts.getScore(), is(0));
        assertThat(darts.getTurn(), is(1));
        assertThat(darts.getLeftDarts(), is(3));
        assertThat(darts.isFinished(), is(true));
    }

}
