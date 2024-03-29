package bussines_logic.patient_type_factory;
import bussines_logic.patient_type.MaternityPatient;


public class MaternityPatientFactory {

    public MaternityPatient createPatient(String firstName, String secondName, int age, String sex,
                                          String CNP, String address, String sectie, String diagnostic,
                                          String medicatie, String alergii,String observatii) {
        
        return new MaternityPatient(firstName, secondName, age, sex, CNP, address, sectie,
                                    diagnostic, medicatie, alergii, observatii);
    }
}
	