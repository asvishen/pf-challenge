package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pf.Doctor;
import com.pf.DoctorDirectory;
import com.pf.DoctorRelatedSearchUtility;
import com.pf.Speciality;

public class DoctorSearchUtilityTest {
	
	
	DoctorDirectory directory = new DoctorDirectory();

	@Before
	public void setup()
	{
		Doctor d1 = new Doctor(Speciality.CARDIOLOGIST,3.6f,"Tempe");
		directory.addNewDoctor(d1);
		d1 = new Doctor(Speciality.CARDIOLOGIST,4.0f,"Mesa");
		directory.addNewDoctor(d1);
		d1 = new Doctor(Speciality.DERMATOLOGIST,3.0f,"Mesa");
		directory.addNewDoctor(d1);
		d1 = new Doctor(Speciality.GASTROENTROLOGIST,4.5f,"Phoenix");
		directory.addNewDoctor(d1);
		d1 = new Doctor(Speciality.GYNOCOLOGIST,3.6f,"Tempe");
		directory.addNewDoctor(d1);
		d1 = new Doctor(Speciality.ENT,3.6f,"Tempe");
		directory.addNewDoctor(d1);
		d1 = new Doctor(Speciality.CARDIOLOGIST,4.0f,"Tempe");
		directory.addNewDoctor(d1);

		d1 = new Doctor(Speciality.CARDIOLOGIST,1.0f,"Phoenix");

		directory.addNewDoctor(d1);
		
	}
	
	@Test
	public void testSameSpecialityPriorityOrder()
	{
		Doctor d = new Doctor(Speciality.CARDIOLOGIST,3.3f,"Tempe");
		List<Doctor> actual = DoctorRelatedSearchUtility.getRelatedDoctors(d,directory);
		List<Doctor> expected = new ArrayList<Doctor>();
		Doctor d1 = new Doctor(Speciality.CARDIOLOGIST,4.0f,"Tempe");
		expected.add(d1);
		d1 = new Doctor(Speciality.CARDIOLOGIST,3.6f,"Tempe");
		expected.add(d1);
		d1 = new Doctor(Speciality.CARDIOLOGIST,4.0f,"Mesa");
		expected.add(d1);
		d1 = new Doctor(Speciality.CARDIOLOGIST,1.0f,"Phoenix");
		expected.add(d1);
		assertTrue(actual.size() == 4);
		assertEquals(actual,expected);
	}
	@Test
	public void testNoMatches()
	{
		Doctor d = new Doctor(Speciality.ORTHOPEDIC,3.3f,"Tempe");
		List<Doctor> actual = DoctorRelatedSearchUtility.getRelatedDoctors(d,directory);
		List<Doctor> expected = new ArrayList<Doctor>();
		assertTrue(actual.size() == 0);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testSameSpecialityOnlyInSameArea()
	{
		Doctor d = new Doctor(Speciality.ENT,3.3f,"Tempe");
		List<Doctor> actual = DoctorRelatedSearchUtility.getRelatedDoctors(d,directory);
		List<Doctor> expected = new ArrayList<Doctor>();
		Doctor d1 = new Doctor(Speciality.ENT,3.6f,"Tempe");
		expected.add(d1);
		assertTrue(actual.size() == 1);
		assertEquals(actual,expected);
	}
	
	
	
}
