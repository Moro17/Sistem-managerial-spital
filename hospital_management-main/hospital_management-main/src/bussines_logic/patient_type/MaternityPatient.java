package bussines_logic.patient_type;

import bussines_logic.BasePatient;
import java.util.Date;

public class MaternityPatient extends BasePatient {
	private Date lastMenstrualPeriod;
	private Date estimatedDueDate;
	private boolean highRiskPregnancy;

	public MaternityPatient(String firstName, String secondName, int age, String sex, String CNP, String address,
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

	// Getteri si setteri pentru atributele specifice
	public Date getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}

	public void setLastMenstrualPeriod(Date lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}

	public Date getEstimatedDueDate() {
		return estimatedDueDate;
	}

	public void setEstimatedDueDate(Date estimatedDueDate) {
		this.estimatedDueDate = estimatedDueDate;
	}

	public boolean isHighRiskPregnancy() {
		return highRiskPregnancy;
	}

	public void setHighRiskPregnancy(boolean highRiskPregnancy) {
		this.highRiskPregnancy = highRiskPregnancy;
	}

	@Override
	public void displayData() {
		String lmpStr = (lastMenstrualPeriod != null) ? lastMenstrualPeriod.toString() : "N/A";
		String eddStr = (estimatedDueDate != null) ? estimatedDueDate.toString() : "N/A";
		System.out.println("Maternity Patient: " + getFirstName() + " " + getSecondName() + ", Age: " + getAge()
				+ ", Sex: " + getSex() + ", CNP: " + getCNP() + ", Address: " + getAddress()
				+ ", Last Menstrual Period: " + lmpStr + ", Estimated Due Date: " + eddStr + ", High Risk Pregnancy: "
				+ (highRiskPregnancy ? "Yes" : "No"));
	}
}
