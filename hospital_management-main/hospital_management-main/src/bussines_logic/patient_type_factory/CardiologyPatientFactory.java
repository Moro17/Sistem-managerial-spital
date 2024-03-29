package bussines_logic.patient_type_factory;

import bussines_logic.patient_type.CardiologyPatient;

public class CardiologyPatientFactory {

	public CardiologyPatient createPatient(String firstName, String secondName, int age, String sex, String CNP,
			String address, String sectie, String diagnostic, String medicatie, String alergii, String observatii,
			String cardiacCondition, boolean onCardiacMonitor) {

		return new CardiologyPatient(firstName, secondName, age, sex, CNP, address, sectie, diagnostic, medicatie,
				alergii, observatii, cardiacCondition, onCardiacMonitor);
	}
}
