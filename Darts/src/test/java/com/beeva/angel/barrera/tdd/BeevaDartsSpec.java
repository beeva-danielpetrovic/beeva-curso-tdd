package com.beeva.angel.barrera.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BeevaDartsSpec {
	
	private BeevaDart beevaDart;
	
	@Before
	public void setUp(){
		beevaDart = new BeevaDart();
	}

	@Test
	public void initGamePuntuationIs501(){
		assertThat(beevaDart.getPoints(), is(501));
	}
	
	@Test
	public void throwOneDartSinglePoint(){
		beevaDart.throwDart(THROW_TYPE.SIMPLE, 20);
		assertThat(beevaDart.getPoints(), is(481));
	}
	
	@Test
	public void throwOneDartDoublePoint(){
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 10);
		assertThat(beevaDart.getPoints(), is(481));
	}
	
	@Test
	public void throwOneDartTriplePoint(){
		beevaDart.throwDart(THROW_TYPE.TRIPLE, 15);
		assertThat(beevaDart.getPoints(), is(456));
	}
	
	@Test
	public void initGameIsOnTurnOne(){
		assertThat(beevaDart.getTurn(), is(1)); ;
	}
	
	@Test
	public void initGameHasThreeDarts(){
		assertThat(beevaDart.getLeftDarts(), is(3));
	}
	
	@Test 
	public void initGameIsInTurnOneAndHasThreeDarts(){
		assertThat(beevaDart.getTurn(), is(1));
		assertThat(beevaDart.getLeftDarts(), is(3));
	}
	
	@Test
	public void throwThreeDartsCheckTurnAndDarts(){
		beevaDart.throwDart(THROW_TYPE.SIMPLE, 10);
		assertThat(beevaDart.getTurn(), is(1));
		assertThat(beevaDart.getLeftDarts(), is(2));
		assertThat(beevaDart.getPoints(), is(491));
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 15);
		assertThat(beevaDart.getTurn(), is(1));
		assertThat(beevaDart.getLeftDarts(), is(1));
		assertThat(beevaDart.getPoints(), is(461));
		beevaDart.throwDart(THROW_TYPE.SIMPLE, 1);
		
		assertThat(beevaDart.getPoints(), is(460));
		assertThat(beevaDart.getTurn(), is(2));
		assertThat(beevaDart.getLeftDarts(), is(3));
	}
	
	@Test
	public void whenPointsIsOneIncrementTurnAndResetDarts(){
		
		Integer initPoints = beevaDart.getPoints();
		
		beevaDart.throwDart(THROW_TYPE.SIMPLE, 490);
		assertThat(beevaDart.getTurn(), is(1));
		assertThat(beevaDart.getLeftDarts(), is(2));
		assertThat(beevaDart.getPoints(), is(11));
		
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 5);
		assertThat(beevaDart.getTurn(), is(2));
		assertThat(beevaDart.getPoints(), is(initPoints));
	}
	
	@Test
	public void whenNegativePointsIncrementTurnAndResetDarts(){
		
		Integer initPoints = beevaDart.getPoints();
		
		beevaDart.throwDart(THROW_TYPE.SIMPLE, 490);
		assertThat(beevaDart.getTurn(), is(1));
		assertThat(beevaDart.getLeftDarts(), is(2));
		assertThat(beevaDart.getPoints(), is(11));
		
		beevaDart.throwDart(THROW_TYPE.TRIPLE, 5);
		assertThat(beevaDart.getTurn(), is(2));
		assertThat(beevaDart.getPoints(), is(initPoints));
	}
	
	@Test
	public void whenPointsIsZeroWithDoublePointIncrementTurnAndResertDarts(){
		
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 50);
		assertThat(beevaDart.getPoints(), is(401));
		assertThat(beevaDart.getLeftDarts(), is(2));
		assertThat(beevaDart.getTurn(), is(1));
		
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 50);
		assertThat(beevaDart.getPoints(), is(301));
		assertThat(beevaDart.getLeftDarts(), is(1));
		assertThat(beevaDart.getTurn(), is(1));
		
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 50);
		assertThat(beevaDart.getPoints(), is(201));
		assertThat(beevaDart.getLeftDarts(), is(3));
		assertThat(beevaDart.getTurn(), is(2));
		
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 50);
		assertThat(beevaDart.getPoints(), is(101));
		assertThat(beevaDart.getLeftDarts(), is(2));
		assertThat(beevaDart.getTurn(), is(2));
		
		beevaDart.throwDart(THROW_TYPE.SIMPLE, 99);
		assertThat(beevaDart.getPoints(), is(2));
		assertThat(beevaDart.getLeftDarts(), is(1));
		assertThat(beevaDart.getTurn(), is(2));
		
		beevaDart.throwDart(THROW_TYPE.DOUBLE, 1);
		assertThat(beevaDart.getPoints(), is(501));
		assertThat(beevaDart.getLeftDarts(), is(3));
		assertThat(beevaDart.getTurn(), is(1));
		
	}
}
