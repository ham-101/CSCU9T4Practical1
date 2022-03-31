package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry  {
	private int repetitions;
	private int recovery;
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist,int r,int rec) {
		super(n, d, m, y, h, min, s, dist);
		
		// TODO Auto-generated constructor stub
	}
	public int getRepetitions() {
		return this.repetitions ;
	}
	public int getRecovery() {
		return this.recovery;
	}
	public String getEntry () {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n"+getRepetitions()+""+getRecovery()+"";
		   return result;
		  } //getEntry
	
}
