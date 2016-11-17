package com.pf;

import java.util.Objects;

public class Doctor {

	private Speciality speciality;
	private float reviewScore;
	private String area;
	private String fName,lName;
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Doctor(Speciality speciality,
			float rating, String area) {

		this.speciality = speciality;
		this.reviewScore = rating;
		this.area = area;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public float getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(float rating) {
		this.reviewScore = rating;
	}
	
	@Override
	public String toString()
	{
		return getSpeciality() + " " + getReviewScore() + " " + getArea();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
	        return true;
	    if (o == null)
	        return false;
	    if (getClass() != o.getClass())
	        return false;
	    Doctor doc = (Doctor) o;
	    return Objects.equals(getSpeciality(), doc.getSpeciality())
	            && getReviewScore() == doc.getReviewScore() && Objects.equals(getArea(),doc.getArea());
	}		
}
	
	

