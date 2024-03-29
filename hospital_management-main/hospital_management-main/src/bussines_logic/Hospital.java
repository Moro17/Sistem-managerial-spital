package bussines_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import bussines_logic.exceptions.*;

public class Hospital {
	private List<BasePatient> patientsList = new ArrayList<BasePatient>();

	public void addPatient(BasePatient patient) throws DuplicateCNPException { // functie ce adauga un obiect de tip
																				// BasePatient in Lista
		for (BasePatient existingPatient : patientsList) {
			if (existingPatient.getCNP().equals(patient.getCNP())) {
				throw new DuplicateCNPException("A patient with this CNP already exists.");
			}
		}
		patientsList.add(patient);
	}

	public void displayPatientData() { // Functie pentru debug
		for (BasePatient i : patientsList)

			// Printing the elements of ArrayList
			System.out.print(i.getFirstName());
	}

	public BasePatient searchByCnp(String CNP) throws CNPNotFoundException // (cautare liniara)
	{
		for (BasePatient i : patientsList)
			if (i.getCNP().equals(CNP))
				return i;
		throw new CNPNotFoundException("No patient found with CNP: " + CNP);
	}

	public List<BasePatient> getPatientsAlphabetically() { // de implementat
		List<BasePatient> sortedPatients = new ArrayList<>(patientsList);
		Collections.sort(sortedPatients, new Comparator<Patient>() {
			@Override
			public int compare(Patient p1, Patient p2) {
				int firstNameCompare = p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
				if (firstNameCompare != 0) {
					return firstNameCompare;
				}
				return p1.getSecondName().compareToIgnoreCase(p2.getSecondName());
			}
		});
		return sortedPatients;
	}

}