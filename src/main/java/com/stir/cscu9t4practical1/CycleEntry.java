package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry{
	private String tempo;
	private String terrain;
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String tmp,String trn) {
		super(n, d, m, y, h, min, s, dist);
		this.tempo = tmp;
		this.terrain = trn;
		// TODO Auto-generated constructor stub
	}
	public String getTempo() {
		return this.tempo;
	}
	public String getTerrain() {
		return this.terrain;
	}
	public String getEntry () {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+" \n "+getTempo()+" step/min " +getTerrain();
		   return result;
		  } //getEntry

	
}
