package bussines_logic.patient_type;

import bussines_logic.BasePatient;
import java.util.Date;

public class SurgeryPatient extends BasePatient {
	private String surgeryType;
	private String surgeonName;
	private Date surgeryDate;

	public SurgeryPatient(String firstName, String secondName, int age, String sex, String CNP, String address,
			String sectie, String diagnostic, String medicatie, String alergii, String observatii) {

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

	}

	public String getSurgeryType() {
		return surgeryType;
	}

	public void setSurgeryType(String surgeryType) {
		this.surgeryType = surgeryType;
	}

	public String getSurgeonName() {
		return surgeonName;
	}

	public void setSurgeonName(String surgeonName) {
		this.surgeonName = surgeonName;
	}

	public Date getSurgeryDate() {
		return surgeryDate;
	}

	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}

	@Override
	public void displayData() {
		String surgeryDateStr = (surgeryDate != null) ? surgeryDate.toString() : "N/A";
		System.out.println("Surgery Patient: " + getFirstName() + " " + getSecondName() + ", Age: " + getAge()
				+ ", Sex: " + getSex() + ", CNP: " + getCNP() + ", Address: " + getAddress() + ", Surgery Type: "
				+ surgeryType + ", Surgeon Name: " + surgeonName + ", Surgery Date: " + surgeryDateStr);
	}
}
