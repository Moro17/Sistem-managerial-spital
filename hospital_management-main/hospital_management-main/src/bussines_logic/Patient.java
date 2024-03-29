package bussines_logic;

public interface Patient {

	// Setters
	void setFirstName(String firstName);

	void setSecondName(String secondName);

	void setAge(int age);

	void setSex(String sex);

	void setCNP(String CNP);

	void setAddress(String address);

	// Getters
	String getFirstName();

	String getSecondName();

	int getAge();

	String getSex();

	String getCNP();

	String getAddress();

	// Metoda pentru afisarea datelor
	void displayData();
}
