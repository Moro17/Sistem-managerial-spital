package bussines_logic.patient_type_factory;

import bussines_logic.patient_type.SurgeryPatient;

public class SurgeryPatientFactory {

	public SurgeryPatient createPatient(String firstName, String secondName, int age, String sex, String CNP,
			String address, String sectie, String diagnostic, String medicatie, String alergii,
			String observatii/*
								 * , String surgeryType, String surgeonName, Date surgeryDate
								 */) {

		return new SurgeryPatient(firstName, secondName, age, sex, CNP, address, sectie, diagnostic, medicatie, alergii,
				observatii);
	}
}
