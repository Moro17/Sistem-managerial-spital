package bussines_logic.patient_type;

import bussines_logic.BasePatient;
import java.util.Date;

public class OncologyPatient extends BasePatient {
	private String cancerType;
	private String cancerStage;
	private Date diagnosisDate;

	public OncologyPatient(String firstName, String secondName, int age, String sex, String CNP, String address,
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

	public String getCancerType() {
		return cancerType;
	}

	public void setCancerType(String cancerType) {
		this.cancerType = cancerType;
	}

	public String getCancerStage() {
		return cancerStage;
	}

	public void setCancerStage(String cancerStage) {
		this.cancerStage = cancerStage;
	}

	public Date getDiagnosisDate() {
		return diagnosisDate;
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	@Override
	public void displayData() {
		String diagnosisDateStr = (diagnosisDate != null) ? diagnosisDate.toString() : "N/A";
		System.out.println("Oncology Patient: " + getFirstName() + " " + getSecondName() + ", Age: " + getAge()
				+ ", Sex: " + getSex() + ", CNP: " + getCNP() + ", Address: " + getAddress() + ", Cancer Type: "
				+ cancerType + ", Cancer Stage: " + cancerStage + ", Diagnosis Date: " + diagnosisDateStr);
	}
}
