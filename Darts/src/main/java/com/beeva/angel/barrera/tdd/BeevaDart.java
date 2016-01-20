package com.beeva.angel.barrera.tdd;

public class BeevaDart {
	
	private Integer points;
	private Integer pointsBefore;
	private Integer turn;
	private Integer leftDarts;
	

	public BeevaDart() {
		this.points = 501;
		this.pointsBefore = this.points;
		this.turn = 1;
		this.leftDarts = 3;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void throwDart(THROW_TYPE type, Integer point) {
		
		if(THROW_TYPE.SIMPLE == type){
			this.points = (this.points - point);
		}else if (THROW_TYPE.DOUBLE == type){
			this.points = (this.points - (2*point));
		}else{
			this.points = (this.points - (3*point));
		}
		
		this.leftDarts--;
		
		if(this.points==1 || this.points<0){
			this.turn++;
			this.leftDarts = 3;
			this.points = this.pointsBefore;
		}else{
			if(this.points==0&&type.equals(THROW_TYPE.DOUBLE)){
				this.points = 501;
				this.leftDarts = 3;
				this.turn = 1;
			}else if(leftDarts==0){
				this.turn++;
				this.leftDarts = 3;
				this.pointsBefore = this.points;
			}
		}
	}

	public Integer getTurn() {
		return this.turn;
	}

	public Integer getLeftDarts() {
		return this.leftDarts;
	}

}
