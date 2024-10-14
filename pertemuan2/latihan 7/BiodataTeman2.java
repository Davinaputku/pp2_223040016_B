import java.awt.event.*;
import javax.swing.*;

public class BiodataTeman2 extends JFrame {
    public BiodataTeman2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 350, 10);
        
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);
        
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(15, 100, 350, 10);
        
        JTextField textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 120, 350, 30);
        
        JLabel labelJenisKelamin = new JLabel("JenisKelamin:");
        labelJenisKelamin.setBounds(15, 160, 350, 10);
        
        JRadioButton radioButtonLakiLaki = new JRadioButton("Laki-Laki");
        radioButtonLakiLaki.setBounds(15, 180, 100, 30);
        
        JRadioButton radioButtonPerempuan = new JRadioButton("Perempuan", true);
        radioButtonPerempuan.setBounds(115, 180, 100, 30);
        
        ButtonGroup bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(radioButtonLakiLaki);
        bgJenisKelamin.add(radioButtonPerempuan);
        
        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 220, 200, 30);
        
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 260, 100, 40);
        
        JTextArea textAreaOutput = new JTextArea("");
        textAreaOutput.setBounds(15, 310, 350, 100);
        
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String jenisKelamin = radioButtonPerempuan.isSelected() ? "Perempuan" : "Laki-Laki";
                String wna = checkBoxWNA.isSelected() ? "Ya" : "Bukan";
                
                String JenisKelamin = "";
                if (radioButtonLakiLaki.isSelected()) {
                    jenisKelamin = radioButtonLakiLaki.getText();
                }
                if (radioButtonPerempuan.isSelected()) {
                    jenisKelamin= radioButtonPerempuan.getText();
                }
            }
        });
        
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelNomorHP);
        this.add(textFieldNomorHP);
        this.add(labelJenisKelamin);
        this.add(radioButtonLakiLaki);
        this.add(radioButtonPerempuan);
        this.add(checkBoxWNA);
        this.add(buttonSimpan);
        this.add(textAreaOutput);
        
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BiodataTeman2().setVisible(true);
            }
        });
    }
}