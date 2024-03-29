package bussines_logic.patient_type_factory;

import bussines_logic.patient_type.PsychiatricPatient;

public class PsychiatricPatientFactory {

	public PsychiatricPatient createPatient(String firstName, String secondName, int age, String sex, String CNP,
			String address, String sectie, String diagnostic, String medicatie, String alergii,
			String observatii/*
								 * ,boolean voluntarilyAdmitted, List<String> therapyTypes
								 */) {

		return new PsychiatricPatient(firstName, secondName, age, sex, CNP, address, sectie, diagnostic, medicatie,
				alergii, observatii);
	}
}
