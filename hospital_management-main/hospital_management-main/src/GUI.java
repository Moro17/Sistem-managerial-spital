import javax.swing.*;
import bussines_logic.*;
import bussines_logic.patient_type_factory.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import bussines_logic.exceptions.CNPNotFoundException;
import bussines_logic.exceptions.DuplicateCNPException;
import bussines_logic.exceptions.InvalidFieldException;
import bussines_logic.patient_type.CardiologyPatient;


public class GUI extends JFrame {
	// const si var
	private static final long serialVersionUID = 1L;
	private Hospital hospital;
	private static int patientCounter = 0;
	private JTextArea searchResultsArea;
	// form fields
	private JTextField textField_Nume;
	private JTextField textField_Prenume;
	private JTextField textField_CNP;
	private JTextField textField_2;// age
	private JTextField textField_Adresa;
	private JTextField textField_Diagnostic;
	private JTextField textField_Medicatie;
	private JTextField textField_Alergii;
	private JTextField textField_ConditieCardiaca;
	private JTextField textField_Observatii;

	public GUI() {
		// cod auto-generat de windows builder
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hospital Management System");
		setSize(1000, 800);
		getContentPane().setLayout(new GridBagLayout());

		hospital = new Hospital();

		// setupSearchPanel(searchPanel);

		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel detailsPanel = new JPanel();
		setupDetailsPanel(detailsPanel);
		tabbedPane.addTab("AddPatient", null, detailsPanel, "First Panel");

		GridBagLayout gbl_detailsPanel = new GridBagLayout();
		gbl_detailsPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_detailsPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_detailsPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_detailsPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		detailsPanel.setLayout(gbl_detailsPanel);

		JLabel lblInformatiiPersonale = new JLabel("Informatii personale");
		GridBagConstraints gbc_lblInformatiiPersonale = new GridBagConstraints();
		gbc_lblInformatiiPersonale.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformatiiPersonale.gridx = 0;
		gbc_lblInformatiiPersonale.gridy = 0;
		detailsPanel.add(lblInformatiiPersonale, gbc_lblInformatiiPersonale);

		JLabel lblNume = new JLabel("Nume");
		GridBagConstraints gbc_lblNume = new GridBagConstraints();
		gbc_lblNume.anchor = GridBagConstraints.EAST;
		gbc_lblNume.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume.gridx = 1;
		gbc_lblNume.gridy = 1;
		detailsPanel.add(lblNume, gbc_lblNume);

		textField_Nume = new JTextField();
		textField_Nume.setColumns(10);
		GridBagConstraints gbc_textField_Nume = new GridBagConstraints();
		gbc_textField_Nume.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Nume.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Nume.gridx = 2;
		gbc_textField_Nume.gridy = 1;
		detailsPanel.add(textField_Nume, gbc_textField_Nume);

		JLabel lblNume_3 = new JLabel("Prenume");
		GridBagConstraints gbc_lblNume_3 = new GridBagConstraints();
		gbc_lblNume_3.anchor = GridBagConstraints.EAST;
		gbc_lblNume_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_3.gridx = 3;
		gbc_lblNume_3.gridy = 1;
		detailsPanel.add(lblNume_3, gbc_lblNume_3);

		textField_Prenume = new JTextField();
		GridBagConstraints gbc_textField_Prenume = new GridBagConstraints();
		gbc_textField_Prenume.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Prenume.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Prenume.gridx = 5;
		gbc_textField_Prenume.gridy = 1;
		detailsPanel.add(textField_Prenume, gbc_textField_Prenume);
		textField_Prenume.setColumns(10);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 2;
		detailsPanel.add(label, gbc_label);

		JLabel lblNume_1 = new JLabel("Adresa");
		GridBagConstraints gbc_lblNume_1 = new GridBagConstraints();
		gbc_lblNume_1.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNume_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_1.gridx = 1;
		gbc_lblNume_1.gridy = 3;
		detailsPanel.add(lblNume_1, gbc_lblNume_1);

		textField_Adresa = new JTextField();
		textField_Adresa.setColumns(10);
		GridBagConstraints gbc_textField_Adresa = new GridBagConstraints();
		gbc_textField_Adresa.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Adresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Adresa.gridx = 2;
		gbc_textField_Adresa.gridy = 3;
		detailsPanel.add(textField_Adresa, gbc_textField_Adresa);

		JLabel lblNume_4 = new JLabel("CNP");
		GridBagConstraints gbc_lblNume_4 = new GridBagConstraints();
		gbc_lblNume_4.anchor = GridBagConstraints.EAST;
		gbc_lblNume_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_4.gridx = 3;
		gbc_lblNume_4.gridy = 3;
		detailsPanel.add(lblNume_4, gbc_lblNume_4);

		textField_CNP = new JTextField();
		textField_CNP.setColumns(10);
		GridBagConstraints gbc_textField_CNP = new GridBagConstraints();
		gbc_textField_CNP.insets = new Insets(0, 0, 5, 5);
		gbc_textField_CNP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_CNP.gridx = 5;
		gbc_textField_CNP.gridy = 3;
		detailsPanel.add(textField_CNP, gbc_textField_CNP);

		JLabel lblNume_2 = new JLabel("Sex");
		GridBagConstraints gbc_lblNume_2 = new GridBagConstraints();
		gbc_lblNume_2.anchor = GridBagConstraints.EAST;
		gbc_lblNume_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_2.gridx = 1;
		gbc_lblNume_2.gridy = 4;
		detailsPanel.add(lblNume_2, gbc_lblNume_2);

		JComboBox comboBox_Sex = new JComboBox();
		comboBox_Sex.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));
		GridBagConstraints gbc_comboBox_Sex = new GridBagConstraints();
		gbc_comboBox_Sex.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Sex.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Sex.gridx = 2;
		gbc_comboBox_Sex.gridy = 4;
		detailsPanel.add(comboBox_Sex, gbc_comboBox_Sex);

		JLabel lblNume_5 = new JLabel("Age");
		GridBagConstraints gbc_lblNume_5 = new GridBagConstraints();
		gbc_lblNume_5.anchor = GridBagConstraints.EAST;
		gbc_lblNume_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_5.gridx = 3;
		gbc_lblNume_5.gridy = 4;
		detailsPanel.add(lblNume_5, gbc_lblNume_5);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 4;
		detailsPanel.add(textField_2, gbc_textField_2);

		JLabel lblInformatiiPersonale_1 = new JLabel("Informatii personale");
		GridBagConstraints gbc_lblInformatiiPersonale_1 = new GridBagConstraints();
		gbc_lblInformatiiPersonale_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformatiiPersonale_1.gridx = 0;
		gbc_lblInformatiiPersonale_1.gridy = 5;
		detailsPanel.add(lblInformatiiPersonale_1, gbc_lblInformatiiPersonale_1);

		JLabel lblNume_2_1 = new JLabel("Sectie");
		GridBagConstraints gbc_lblNume_2_1 = new GridBagConstraints();
		gbc_lblNume_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNume_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_2_1.gridx = 1;
		gbc_lblNume_2_1.gridy = 6;
		detailsPanel.add(lblNume_2_1, gbc_lblNume_2_1);

		JLabel lblNume_2_2 = new JLabel("Diagnostic");
		GridBagConstraints gbc_lblNume_2_2 = new GridBagConstraints();
		gbc_lblNume_2_2.anchor = GridBagConstraints.EAST;
		gbc_lblNume_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_2_2.gridx = 1;
		gbc_lblNume_2_2.gridy = 7;
		detailsPanel.add(lblNume_2_2, gbc_lblNume_2_2);

		textField_Diagnostic = new JTextField();
		textField_Diagnostic.setColumns(10);
		GridBagConstraints gbc_textField_Diagnostic = new GridBagConstraints();
		gbc_textField_Diagnostic.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Diagnostic.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Diagnostic.gridx = 2;
		gbc_textField_Diagnostic.gridy = 7;
		detailsPanel.add(textField_Diagnostic, gbc_textField_Diagnostic);

		JLabel lblConditieCardiaca = new JLabel("Conditie Cardiaca");
		GridBagConstraints gbc_lblConditieCardiaca = new GridBagConstraints();
		gbc_lblConditieCardiaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblConditieCardiaca.gridx = 3;
		gbc_lblConditieCardiaca.gridy = 7;
		detailsPanel.add(lblConditieCardiaca, gbc_lblConditieCardiaca);

		textField_ConditieCardiaca = new JTextField();
		GridBagConstraints gbc_textField_ConditieCardiaca = new GridBagConstraints();
		gbc_textField_ConditieCardiaca.insets = new Insets(0, 0, 5, 5);
		gbc_textField_ConditieCardiaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_ConditieCardiaca.gridx = 5;
		gbc_textField_ConditieCardiaca.gridy = 7;
		detailsPanel.add(textField_ConditieCardiaca, gbc_textField_ConditieCardiaca);
		textField_ConditieCardiaca.setColumns(10);

		JLabel lblNume_2_3 = new JLabel("Medicatie");
		GridBagConstraints gbc_lblNume_2_3 = new GridBagConstraints();
		gbc_lblNume_2_3.anchor = GridBagConstraints.EAST;
		gbc_lblNume_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_2_3.gridx = 1;
		gbc_lblNume_2_3.gridy = 8;
		detailsPanel.add(lblNume_2_3, gbc_lblNume_2_3);

		textField_Medicatie = new JTextField();
		textField_Medicatie.setColumns(10);
		GridBagConstraints gbc_textField_Medicatie = new GridBagConstraints();
		gbc_textField_Medicatie.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Medicatie.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Medicatie.gridx = 2;
		gbc_textField_Medicatie.gridy = 8;
		detailsPanel.add(textField_Medicatie, gbc_textField_Medicatie);

		JLabel lblMonitorCardiac = new JLabel("Monitor Cardiac");
		GridBagConstraints gbc_lblMonitorCardiac = new GridBagConstraints();
		gbc_lblMonitorCardiac.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitorCardiac.gridx = 3;
		gbc_lblMonitorCardiac.gridy = 8;
		detailsPanel.add(lblMonitorCardiac, gbc_lblMonitorCardiac);

		JComboBox comboBox_Monitor = new JComboBox();
		comboBox_Monitor.setModel(new DefaultComboBoxModel(new String[] { "NU", "DA" }));
		GridBagConstraints gbc_comboBox_Monitor = new GridBagConstraints();
		gbc_comboBox_Monitor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Monitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Monitor.gridx = 5;
		gbc_comboBox_Monitor.gridy = 8;
		detailsPanel.add(comboBox_Monitor, gbc_comboBox_Monitor);

		JComboBox comboBox_Sectii = new JComboBox();
		comboBox_Sectii.addItemListener(new ItemListener() { // la schimbarea sectiei din meniu vor aparea field-uri
																// suplimentare aferente
			public void itemStateChanged(ItemEvent arg0) {
				String selectedOption = (String) comboBox_Sectii.getSelectedItem();
				System.out.println(selectedOption);

				lblConditieCardiaca.setVisible("Cardiology".equals(selectedOption)); // verificam pentru fiecare field
																						// daca sectia aleasa de
																						// utilizator este cea
																						// corespunzatoare lui si o
																						// afisam
				textField_ConditieCardiaca.setVisible("Cardiology".equals(selectedOption));
				lblMonitorCardiac.setVisible("Cardiology".equals(selectedOption));
				comboBox_Monitor.setVisible("Cardiology".equals(selectedOption));
			}
		});

		comboBox_Sectii.setModel(new DefaultComboBoxModel(
				new String[] { "Cardiology", "Maternity", "Oncology", "Psychiatry", "Surgery" }));
		GridBagConstraints gbc_comboBox_Sectii = new GridBagConstraints();
		gbc_comboBox_Sectii.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Sectii.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Sectii.gridx = 2;
		gbc_comboBox_Sectii.gridy = 6;
		detailsPanel.add(comboBox_Sectii, gbc_comboBox_Sectii);

		JLabel lblNume_2_4 = new JLabel("Alergii");
		GridBagConstraints gbc_lblNume_2_4 = new GridBagConstraints();
		gbc_lblNume_2_4.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNume_2_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNume_2_4.gridx = 1;
		gbc_lblNume_2_4.gridy = 9;
		detailsPanel.add(lblNume_2_4, gbc_lblNume_2_4);

		textField_Alergii = new JTextField();
		textField_Alergii.setColumns(10);
		GridBagConstraints gbc_textField_Alergii = new GridBagConstraints();
		gbc_textField_Alergii.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Alergii.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Alergii.gridx = 2;
		gbc_textField_Alergii.gridy = 9;
		detailsPanel.add(textField_Alergii, gbc_textField_Alergii);

		JLabel lblObservatii = new JLabel("Observatii");
		GridBagConstraints gbc_lblObservatii = new GridBagConstraints();
		gbc_lblObservatii.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservatii.gridx = 1;
		gbc_lblObservatii.gridy = 11;
		detailsPanel.add(lblObservatii, gbc_lblObservatii);

		textField_Observatii = new JTextField();
		GridBagConstraints gbc_textArea_Observatii = new GridBagConstraints();
		gbc_textArea_Observatii.gridwidth = 3;
		gbc_textArea_Observatii.insets = new Insets(0, 0, 0, 5);
		gbc_textArea_Observatii.fill = GridBagConstraints.BOTH;
		gbc_textArea_Observatii.gridx = 1;
		gbc_textArea_Observatii.gridy = 12;
		detailsPanel.add(textField_Observatii, gbc_textArea_Observatii);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // butonul de submit centralizeaza datele din form si construieste
														// un obiect de tip Pacient corespunzator selectiei
				try {
					// Validate input fields
					validateInputFields();

					String firstName = textField_Nume.getText();
					String secondName = textField_Prenume.getText();
					int age = Integer.parseInt(textField_2.getText());
					String CNP = textField_CNP.getText();
					String address = textField_Adresa.getText();
					String sex = (String) comboBox_Sex.getSelectedItem();
					String sectie = (String) comboBox_Sectii.getSelectedItem();
					String diagnostic = textField_Diagnostic.getText();
					String medicatie = textField_Medicatie.getText();
					String alergii = textField_Alergii.getText();
					String conditieC = textField_ConditieCardiaca.getText();
					String Obs = textField_Observatii.getText();

					if (textField_Alergii.getText().trim().isEmpty()) {
						alergii = " - ";
						textField_Alergii.setText(alergii);
					}
					if (textField_ConditieCardiaca.getText().trim().isEmpty()) {
						conditieC = " - ";
						textField_ConditieCardiaca.setText(conditieC);
					}

					if ("Cardiology".equals((String) comboBox_Sectii.getSelectedItem())) {
						boolean onCardiacMonitor = "DA".equals((String) comboBox_Monitor.getSelectedItem());
						String cardiacCondition = textField_ConditieCardiaca.getText(); // Factory pentru pacienti
																						// cardio
						CardiologyPatientFactory fact = new CardiologyPatientFactory();

						hospital.addPatient(fact.createPatient(firstName, secondName, age, sex, CNP, address, sectie,
								diagnostic, medicatie, alergii, Obs, cardiacCondition, onCardiacMonitor));
					} else if ("Maternity".equals(sectie)) {
						MaternityPatientFactory fact = new MaternityPatientFactory();
						hospital.addPatient(fact.createPatient(firstName, secondName, age, sex, CNP, address, sectie,
								diagnostic, medicatie, alergii, Obs));

					} else if ("Oncology".equals(sectie)) {

						OncologyPatientFactory fact = new OncologyPatientFactory();
						hospital.addPatient(fact.createPatient(firstName, secondName, age, sex, CNP, address, sectie,
								diagnostic, medicatie, alergii, Obs));
					} else if ("Psychiatry".equals(sectie)) {

						PsychiatricPatientFactory fact = new PsychiatricPatientFactory();
						hospital.addPatient(fact.createPatient(firstName, secondName, age, sex, CNP, address, sectie,
								diagnostic, medicatie, alergii, Obs));
					} else if ("Surgery".equals(sectie)) {

						SurgeryPatientFactory fact = new SurgeryPatientFactory();
						hospital.addPatient(fact.createPatient(firstName, secondName, age, sex, CNP, address, sectie,
								diagnostic, medicatie, alergii, Obs));
					}
					//afisareconsola pacient nou introdus
					patientCounter++; 
					System.out.println("Pacient introdus " + patientCounter + "\n");
		
				} catch (InvalidFieldException ex) {
					// Show error message dialog
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
				} catch (DuplicateCNPException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Duplicate CNP", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid age.", "Input Error",
							JOptionPane.ERROR_MESSAGE);// e format int si nu vrem sa accepte input string
				}

			}

			private void validateInputFields() throws InvalidFieldException {
				if (textField_Nume.getText().trim().isEmpty()) {
					throw new InvalidFieldException("Completati nume pacient.");
				}
				if (textField_Prenume.getText().trim().isEmpty()) {
					throw new InvalidFieldException("Completati prenume pacient.");
				}
				if (textField_CNP.getText().trim().isEmpty()) {
					throw new InvalidFieldException("Completati CNP pacient.");
				}
				if (textField_Adresa.getText().trim().isEmpty()) {
					throw new InvalidFieldException("Completati adresa pacient.");
				}
				if (textField_2.getText().trim().isEmpty()) {
					throw new InvalidFieldException("Completati varsta pacient.");
				}
				if (textField_Diagnostic.getText().trim().isEmpty()) {
					throw new InvalidFieldException("Completati diagnostic pacient.");
				}
				if (textField_Medicatie.getText().trim().isEmpty()) {
					throw new InvalidFieldException("Completati medicatie pacient.");
				}
			
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 5;
		gbc_btnSubmit.gridy = 12;
		detailsPanel.add(btnSubmit, gbc_btnSubmit);

		JPanel searchPanel = new JPanel(new BorderLayout());
		searchPanel.add(createSearchBarPanel(), BorderLayout.NORTH);
		setupSearchPanel(searchPanel);

		tabbedPane.addTab("SearchPatient", null, searchPanel, "Search Panel");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		getContentPane().add(tabbedPane, gbc);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void setupDetailsPanel(JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.anchor = GridBagConstraints.WEST;
	}

	private JPanel createSearchBarPanel() {

		JPanel searchPanel = new JPanel(new FlowLayout());
		JTextField searchBar = new JTextField(20);
		JButton searchButton = new JButton("Search");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		JButton refreshButton = new JButton("Refresh"); // scrie in textArea pacienti din array-ul din obiectul Hospital

		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				fillSearchResultsArea(); // functie smechera
			}
		});

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String searchText = searchBar.getText().trim();
					if (searchText.isEmpty()) {
						throw new InvalidFieldException("Search field cannot be empty.");
					}

					openNewWindow(hospital, searchBar);// deschide o fereastra noua cu informatiile despre un pacient

				} catch (InvalidFieldException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Search Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		searchPanel.add(searchBar);
		searchPanel.add(searchButton);
		searchPanel.add(refreshButton);
		return searchPanel;
	}

	private static void openNewWindow(Hospital hospital, JTextField searchBar) { // functie pentru deschiderea noii
																					
		JFrame newFrame = new JFrame("Patient Details");
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);

		newFrame.setLayout(new java.awt.BorderLayout());
		newFrame.add(scrollPane, java.awt.BorderLayout.CENTER);
		newFrame.setSize(400, 300);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.setVisible(true);

		try {
			BasePatient patient = hospital.searchByCnp(searchBar.getText());
			textArea.setText("");
			if (patient instanceof CardiologyPatient) {
				textArea.append(patient.getFirstName() + " " + patient.getSecondName() + "\n");
				textArea.append("CNP: " + patient.getCNP() + "\n");
				textArea.append("Adresa: " + patient.getAddress() + "\n");
				textArea.append("Varsta: " + patient.getAge() + "\n");
				textArea.append("Sex: " + patient.getSex() + "\n");
				textArea.append("Diagnostic: " + patient.getDiagnostic() + "\n");
				textArea.append("Sectie: " + patient.getSectie() + "\n");
				textArea.append("Medicatie: " + patient.getMedicatie() + "\n");
				textArea.append("Alergii: " + patient.getAlergii() + "\n");
				CardiologyPatient cardiologyPatient = (CardiologyPatient) patient;
				textArea.append("Conditie Cardiaca: " + cardiologyPatient.getCardiacCondition() + "\n");
				textArea.append("On Cardiac Monitor: " + (cardiologyPatient.isOnCardiacMonitor() ? "Yes" : "No") + "\n");
				textArea.append("Observatii: " + patient.getObservatii() + "\n");
			} else {
				textArea.append(patient.getFirstName() + " " + patient.getSecondName() + "\n"); // aici scriem datele in
																								// textArea declarat in
																								// aceasta functie
				textArea.append("CNP: " + patient.getCNP() + "\n");
				textArea.append("Adresa: " + patient.getAddress() + "\n");
				textArea.append("Varsta: " + patient.getAge() + "\n");
				textArea.append("Sex: " + patient.getSex() + "\n");
				textArea.append("Diagnostic: " + patient.getDiagnostic() + "\n");
				textArea.append("Sectie: " + patient.getSectie() + "\n");
				textArea.append("Medicatie: " + patient.getMedicatie() + "\n");
				textArea.append("Alergii: " + patient.getAlergii() + "\n");
				textArea.append("Observatii: " + patient.getObservatii() + "\n");
			}
		} catch (CNPNotFoundException ex) {
			if (newFrame != null) {
				newFrame.dispose(); // inchide fereastra daca nu gaseste cnp
			}
			JOptionPane.showMessageDialog(null, ex.getMessage(), "CNP Not Found", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void setupSearchPanel(JPanel searchPanel) {
		searchResultsArea = new JTextArea(20, 50);
		searchResultsArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(searchResultsArea);
		searchPanel.add(scrollPane, BorderLayout.CENTER);
		fillSearchResultsArea();
	}

	private void fillSearchResultsArea() { // afisam alfabetic pacientii introdusi in tabul de search
		List<BasePatient> sortedPatients = hospital.getPatientsAlphabetically();

		searchResultsArea.setText("");
		for (BasePatient patient : sortedPatients) {
			searchResultsArea.append(
					patient.getFirstName() + " " + patient.getSecondName() + " : " + "\t" + patient.getSectie() + "\n");

		}
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});
	}
}
