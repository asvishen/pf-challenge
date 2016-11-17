package com.pf;

import java.util.Comparator;

public class DoctorRatingComparator implements Comparator<Doctor>
{

	
	@Override
	public int compare(Doctor o1, Doctor o2) {
		if(o2.getReviewScore()-o1.getReviewScore() > 0) return 1;
		else return -1;
	}
	
}
