package bussines_logic.patient_type_factory;

import bussines_logic.patient_type.OncologyPatient;

public class OncologyPatientFactory {

	public OncologyPatient createPatient(String firstName, String secondName, int age, String sex, String CNP,
			String address, String sectie, String diagnostic, String medicatie, String alergii,
			String observatii/*
								 * , String cancerType, String cancerStage, Date diagnosisDate
								 */) {

		return new OncologyPatient(firstName, secondName, age, sex, CNP, address, sectie, diagnostic, medicatie,
				alergii, observatii);
	}
}
