package pertemuan6;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class manajemenDataMhs extends JFrame {
    private JTextField txtNim, txtNama;
    private JTextArea txtAlamat;
    private JRadioButton rbLaki, rbPerempuan;
    private JComboBox<String> cmbJurusan;
    private JList<String> listHobi;
    private JCheckBox cbOrganisasi;
    private JSpinner spinnerUsia;
    private JSlider sliderSemester;
    private JTable tableMahasiswa;
    private DefaultTableModel tableModel;

    public manajemenDataMhs() {
        setTitle("Sistem Manajemen Data Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Setup MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(e -> System.exit(0));
        
        JMenuItem menuAbout = new JMenuItem("About");
        menuAbout.addActionListener(e -> JOptionPane.showMessageDialog(this, 
            "Sistem Manajemen Data Mahasiswa v1.0", "About", JOptionPane.INFORMATION_MESSAGE));
        
        menuFile.add(menuExit);
        menuHelp.add(menuAbout);
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel input
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Input NIM dan Nama
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("NIM:"), gbc);
        txtNim = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(txtNim, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Nama:"), gbc);
        txtNama = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(txtNama, gbc);

        // TextArea untuk Alamat
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Alamat:"), gbc);
        txtAlamat = new JTextArea(3, 15);
        JScrollPane scrollAlamat = new JScrollPane(txtAlamat);
        gbc.gridx = 1;
        inputPanel.add(scrollAlamat, gbc);

        // Radio Button Jenis Kelamin
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Jenis Kelamin:"), gbc);
        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(rbLaki);
        bgJenisKelamin.add(rbPerempuan);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(rbLaki);
        radioPanel.add(rbPerempuan);
        gbc.gridx = 1;
        inputPanel.add(radioPanel, gbc);

        // ComboBox Jurusan
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Jurusan:"), gbc);
        String[] jurusan = {"Teknik Informatika", "Teknik Industri", "Teknik Lingkungan"};
        cmbJurusan = new JComboBox<>(jurusan);
        gbc.gridx = 1;
        inputPanel.add(cmbJurusan, gbc);

        // List Hobi
        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Hobi:"), gbc);
        String[] hobi = {"Membaca", "Menulis", "Menyanyi", "Olahraga"};
        listHobi = new JList<>(hobi);
        listHobi.setVisibleRowCount(3);
        JScrollPane scrollHobi = new JScrollPane(listHobi);
        gbc.gridx = 1;
        inputPanel.add(scrollHobi, gbc);

        // Checkbox Organisasi
        gbc.gridx = 0; gbc.gridy = 6;
        inputPanel.add(new JLabel("Status:"), gbc);
        cbOrganisasi = new JCheckBox("Aktif Organisasi");
        gbc.gridx = 1;
        inputPanel.add(cbOrganisasi, gbc);

        // Spinner Usia
        gbc.gridx = 0; gbc.gridy = 7;
        inputPanel.add(new JLabel("Usia:"), gbc);
        spinnerUsia = new JSpinner(new SpinnerNumberModel(18, 17, 50, 1));
        gbc.gridx = 1;
        inputPanel.add(spinnerUsia, gbc);

        // Slider Semester
        gbc.gridx = 0; gbc.gridy = 8;
        inputPanel.add(new JLabel("Semester:"), gbc);
        sliderSemester = new JSlider(JSlider.HORIZONTAL, 1, 8, 1);
        sliderSemester.setMajorTickSpacing(1);
        sliderSemester.setPaintTicks(true);
        sliderSemester.setPaintLabels(true);
        gbc.gridx = 1;
        inputPanel.add(sliderSemester, gbc);

        // Button Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        gbc.gridx = 1; gbc.gridy = 9;
        inputPanel.add(btnSimpan, gbc);

        // Table
        String[] columns = {"NIM", "Nama", "Jurusan", "Jenis Kelamin", "Usia", "Semester", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        tableMahasiswa = new JTable(tableModel);
        JScrollPane scrollTable = new JScrollPane(tableMahasiswa);

        // Add panels to frame
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollTable, BorderLayout.CENTER);
        add(mainPanel);

        // Action listener untuk button simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    saveData();
                    clearForm();
                }
            }
        });
    }

    private boolean validateInput() {
        if (txtNim.getText().trim().isEmpty() || 
            txtNama.getText().trim().isEmpty() || 
            (!rbLaki.isSelected() && !rbPerempuan.isSelected())) {
            JOptionPane.showMessageDialog(this, 
                "Mohon lengkapi data NIM, Nama, dan Jenis Kelamin!", 
                "Validasi Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void saveData() {
        Vector<String> row = new Vector<>();
        row.add(txtNim.getText().trim());
        row.add(txtNama.getText().trim());
        row.add(cmbJurusan.getSelectedItem().toString());
        row.add(rbLaki.isSelected() ? "Laki-laki" : "Perempuan");
        row.add(spinnerUsia.getValue().toString());
        row.add(String.valueOf(sliderSemester.getValue()));
        row.add(cbOrganisasi.isSelected() ? "Aktif" : "Tidak Aktif");
        tableModel.addRow(row);
    }

    private void clearForm() {
        txtNim.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        rbLaki.setSelected(false);
        rbPerempuan.setSelected(false);
        cmbJurusan.setSelectedIndex(0);
        listHobi.clearSelection();
        cbOrganisasi.setSelected(false);
        spinnerUsia.setValue(18);
        sliderSemester.setValue(1);
        txtNim.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            manajemenDataMhs frame = new manajemenDataMhs();
            frame.setVisible(true);
        });
    }
}