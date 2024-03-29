package bussines_logic.patient_type;

import bussines_logic.BasePatient;
import java.util.Date;

public class CardiologyPatient extends BasePatient {
	private String cardiacCondition;
	private Date lastEKGDate;
	private boolean onCardiacMonitor;

	public CardiologyPatient(String firstName, String secondName, int age, String sex, String CNP, String address,
			String sectie, String diagnostic, String medicatie, String alergii, String observatii,
			String cardiacCondition, boolean onCardiacMonitor) {

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

		this.cardiacCondition = cardiacCondition;

		this.onCardiacMonitor = onCardiacMonitor;
	}

	public String getCardiacCondition() {
		return cardiacCondition;
	}

	public void setCardiacCondition(String cardiacCondition) {
		this.cardiacCondition = cardiacCondition;
	}


	public boolean isOnCardiacMonitor() {
		return onCardiacMonitor;
	}

	public void setOnCardiacMonitor(boolean onCardiacMonitor) {
		this.onCardiacMonitor = onCardiacMonitor;
	}

	@Override
	public void displayData() { // debug
		String lastEKGStr = (lastEKGDate != null) ? lastEKGDate.toString() : "N/A";
		System.out.println("Cardiology Patient: " + getFirstName() + " " + getSecondName() + ", Age: " + getAge()
				+ ", Sex: " + getSex() + ", CNP: " + getCNP() + ", Address: " + getAddress() + ", Cardiac Condition: "
				+ cardiacCondition + ", Last EKG Date: " + lastEKGStr + ", On Cardiac Monitor: "
				+ (onCardiacMonitor ? "Yes" : "No"));
	}
}
