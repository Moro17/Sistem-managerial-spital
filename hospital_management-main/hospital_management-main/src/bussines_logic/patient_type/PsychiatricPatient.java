package bussines_logic.patient_type;

import bussines_logic.BasePatient;
import java.util.List;

public class PsychiatricPatient extends BasePatient {
	private boolean voluntarilyAdmitted = false;
	private List<String> therapyTypes = null;

	public PsychiatricPatient(String firstName, String secondName, int age, String sex, String CNP, String address,
			String sectie, String diagnostic, String medicatie, String alergii,
			String observatii/*
								 * , boolean voluntarilyAdmitted, List<String> therapyTypes
								 */) {

		setFirstName(firstName);
		setSecondName(secondName);
		setAge(age);
		setSex(sex);
		setCNP(CNP);
		setAddress(address);
		setSectie(sectie);
		setDiagnostic(diagnostic);
		setMedicatie(medicatie);
		setAlergii(alergii);
		setObservatii(observatii);

		// this.voluntarilyAdmitted = voluntarilyAdmitted;
		// this.therapyTypes = therapyTypes;
	}

	public boolean isVoluntarilyAdmitted() {
		return voluntarilyAdmitted;
	}

	public void setVoluntarilyAdmitted(boolean voluntarilyAdmitted) {
		this.voluntarilyAdmitted = voluntarilyAdmitted;
	}

	public List<String> getTherapyTypes() {
		return therapyTypes;
	}

	public void setTherapyTypes(List<String> therapyTypes) {
		this.therapyTypes = therapyTypes;
	}

	@Override
	public void displayData() {
		String therapies = therapyTypes != null ? String.join(", ", therapyTypes) : "None";
		System.out.println("Psychiatric Patient: " + getFirstName() + " " + getSecondName() + ", Age: " + getAge()
				+ ", Sex: " + getSex() + ", CNP: " + getCNP() + ", Address: " + getAddress()
				+ ", Voluntarily Admitted: " + (voluntarilyAdmitted ? "Yes" : "No") + ", Therapy Types: " + therapies);
	}
}
