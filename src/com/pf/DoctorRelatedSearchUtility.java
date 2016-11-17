package com.pf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorRelatedSearchUtility {
	
	public static List<Doctor> getRelatedDoctors(Doctor doctor, DoctorDirectory dir)
	{
		List<Doctor> relevantDoctors = new ArrayList<Doctor>();
		addRelatedDoctors(doctor,relevantDoctors,dir);
		return relevantDoctors;
	}

	private static void addRelatedDoctors(Doctor doctor, List<Doctor> relevantDoctors,DoctorDirectory dir)
	{
		List<Doctor> similarDocsInArea = new ArrayList<Doctor>();
		List<Doctor> oneSimilar = new ArrayList<Doctor>();
		
		for(Doctor doc: dir.getAllDoctors())
		{
			if(doc.getArea().equals(doctor.getArea()) && doctor.getSpeciality().equals(doc.getSpeciality()))
			{
				similarDocsInArea.add(doc);
			}
			else if(doc.getSpeciality().equals(doctor.getSpeciality()))
			{
				oneSimilar.add(doc);
			}
		}
		
		DoctorRatingComparator comparator = new DoctorRatingComparator();
		Collections.sort(similarDocsInArea,comparator);
		Collections.sort(oneSimilar,comparator);
		relevantDoctors.addAll(similarDocsInArea);
		relevantDoctors.addAll(oneSimilar);
	}

}
