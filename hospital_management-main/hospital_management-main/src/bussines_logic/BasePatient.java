package bussines_logic;

public abstract class BasePatient implements Patient { // clasa de baza
	protected String firstName = "";
	protected String secondName = "";
	protected int age = 0;
	protected String sex = "";
	protected String CNP = "";
	protected String address = "";
	protected String Diagnostic = "";
	protected String Sectie = "";
	protected String Medicatie = "";
	protected String Alergii = "";
	protected String Observatii = "";

	// Implementarea metodelor comune
	// Setters
	public void setFirstName(String fn) {
		firstName = fn;
	}

	public void setSecondName(String sn) {
		secondName = sn;
	}

	public void setAge(int a) {
		age = a;
	}

	public void setSex(String s) {
		sex = s;
	}

	public void setCNP(String c) {
		CNP = c;
	}

	public void setAddress(String addr) {
		address = addr;
	}

	public void Observatii(String obs) {
		Observatii = obs;
	}

	public void setDiagnostic(String diagnostic) {
		this.Diagnostic = diagnostic;
	}

	public void setSectie(String sectie) {
		this.Sectie = sectie;
	}

	public void setMedicatie(String medicatie) {
		this.Medicatie = medicatie;
	}

	public void setAlergii(String alergii) {
		this.Alergii = alergii;
	}

	public void setObservatii(String observatii) {
		this.Observatii = observatii;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getCNP() {
		return CNP;
	}

	public String getAddress() {
		return address;
	}

	public String getDiagnostic() {
		return Diagnostic;
	}

	public String getSectie() {
		return Sectie;
	}

	public String getMedicatie() {
		return Medicatie;
	}

	public String getAlergii() {
		return Alergii;
	}

	public String getObservatii() {
		return Observatii;
	}

	// Metoda abstracta displayData
	public abstract void displayData();
}
