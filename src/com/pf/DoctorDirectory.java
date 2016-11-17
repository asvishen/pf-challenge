package com.pf;

import java.util.ArrayList;
import java.util.List;

public class DoctorDirectory {
	
	private List<Doctor> doctors;
	
	public DoctorDirectory() {
		doctors = new ArrayList<Doctor>();
	}
	
	public void addNewDoctor(Doctor doctor)
	{
		doctors.add(doctor);
	}
	
	public List<Doctor> getAllDoctors()
	{
		return doctors;
	}
	
	public void removeDoctor(Doctor doctor)
	{
		doctors.remove(doctor);
	}
	
	public void clearList()
	{
		doctors.clear();
	}
}


