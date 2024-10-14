import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

public class NasabahBank extends JFrame {
    private JTextField textFieldNama, textFieldNomorHP;
    private JRadioButton radioButtonLakiLaki, radioButtonPerempuan;
    private JTextArea textAreaOutput;
    private JSlider sliderTransaksi;
    private JPasswordField passwordField, confirmPasswordField;
    private JList<String> accountTypeList;
    private JSpinner birthdateSpinner;

    public NasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Pendaftaran Nasabah Bank");

        // Name input
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 350, 10);
        
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // Phone number input
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(15, 100, 350, 10);
        
        textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 120, 350, 30);

        // Gender selection
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 160, 350, 10);
        
        radioButtonLakiLaki = new JRadioButton("Laki-laki", true);
        radioButtonLakiLaki.setBounds(15, 180, 100, 30);
        
        radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(125, 180, 100, 30);
        
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(radioButtonLakiLaki);
        bgGender.add(radioButtonPerempuan);

        // Account type selection
        JLabel labelAccountType = new JLabel("Jenis Tabungan:");
        labelAccountType.setBounds(15, 220, 350, 10);
        
        String[] accountTypes = {"Tabungan Biasa", "Tabungan Premium", "Tabungan Bisnis", "Tabungan Pelajar"};
        accountTypeList = new JList<>(accountTypes);
        accountTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(accountTypeList);
        listScrollPane.setBounds(15, 235, 350, 80);

        // Transaction frequency slider
        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransaksi.setBounds(15, 320, 350, 10);
        
        sliderTransaksi = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        sliderTransaksi.setBounds(15, 340, 350, 50);
        sliderTransaksi.setMajorTickSpacing(20);
        sliderTransaksi.setMinorTickSpacing(5);
        sliderTransaksi.setPaintTicks(true);
        sliderTransaksi.setPaintLabels(true);

        // Password fields
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 400, 350, 10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(15, 420, 350, 30);
        
        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password:");
        labelConfirmPassword.setBounds(15, 460, 350, 10);
        
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 480, 350, 30);

        // Birthdate spinner
        JLabel labelBirthdate = new JLabel("Tanggal Lahir:");
        labelBirthdate.setBounds(15, 520, 350, 10);
        
        SpinnerDateModel dateModel = new SpinnerDateModel();
        birthdateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(birthdateSpinner, "dd/MM/yyyy");
        birthdateSpinner.setEditor(dateEditor);
        birthdateSpinner.setBounds(15, 540, 150, 30);

        // Submit button
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 590, 100, 40);

        // Output area
        textAreaOutput = new JTextArea("");
        textAreaOutput.setBounds(15, 640, 350, 120);
        textAreaOutput.setEditable(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuResetItem = new JMenuItem("Reset");
        JMenuItem menuExitItem = new JMenuItem("Exit");
        
        menu.add(menuResetItem);
        menu.add(menuExitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        menuResetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        menuExitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add all components to frame
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelNomorHP);
        this.add(textFieldNomorHP);
        this.add(labelGender);
        this.add(radioButtonLakiLaki);
        this.add(radioButtonPerempuan);
        this.add(labelAccountType);
        this.add(listScrollPane);
        this.add(labelTransaksi);
        this.add(sliderTransaksi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelBirthdate);
        this.add(birthdateSpinner);
        this.add(buttonSimpan);
        this.add(textAreaOutput);

        this.setSize(400, 800); // Adjusted size to accommodate components
        this.setLayout(null);
    }

    private void submitForm() {
        StringBuilder output = new StringBuilder();
        String nama = textFieldNama.getText();
        String nomorHP = textFieldNomorHP.getText();
        String gender = radioButtonLakiLaki.isSelected() ? "Laki-laki" : "Perempuan";
        String selectedAccountType = accountTypeList.getSelectedValue();
        int frekuensiTransaksi = sliderTransaksi.getValue();
        boolean passwordsMatch = Arrays.equals(passwordField.getPassword(), confirmPasswordField.getPassword());
        Date birthdate = (Date) birthdateSpinner.getValue();

        textAreaOutput.setText("");
        textAreaOutput.append("Nama: " + nama + "\n");
        textAreaOutput.append("Nomor HP: " + nomorHP + "\n");
        textAreaOutput.append("Jenis Kelamin: " + gender + "\n");
        textAreaOutput.append("Jenis Tabungan: " + (selectedAccountType != null ? selectedAccountType : "Belum dipilih") + "\n");
        textAreaOutput.append("Frekuensi Transaksi: " + frekuensiTransaksi + " kali per bulan\n");
        textAreaOutput.append("Password Match: " + (passwordsMatch ? "Ya" : "Tidak") + "\n");
        textAreaOutput.append("Tanggal Lahir: " + (((JSpinner.DateEditor) birthdateSpinner.getEditor()).getFormat().format(birthdate)) + "\n");
        textAreaOutput.append("==========================\n");
    }

    private void resetForm() {
        textFieldNama.setText("");
        textFieldNomorHP.setText("");
        radioButtonLakiLaki.setSelected(true);
        accountTypeList.clearSelection();
        sliderTransaksi.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        birthdateSpinner.setValue(new Date());
        textAreaOutput.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NasabahBank n = new NasabahBank();
                n.setVisible(true);
            }
        });
    }
}
