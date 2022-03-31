package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{
private String Where;
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist,String wr) {
		super(n, d, m, y, h, min, s, dist);
		this.Where = wr;
		// TODO Auto-generated constructor stub
	}
	public String getWhere() {
		return this.Where;
	}
	public String getEntry () {
		   String result = getName()+" swam " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+" \n "+getWhere();
		   return result;
		  } //getEntry

}
