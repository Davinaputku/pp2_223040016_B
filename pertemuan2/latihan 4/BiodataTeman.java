import java.awt.event.*;
import javax.swing.*;

public class BiodataTeman extends JFrame {
    public BiodataTeman() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Input Nama:");
        labelNama.setBounds(50, 20, 100, 30);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(150, 20, 150, 30);

        JLabel labelTelepon = new JLabel("Input Nomor Telepon:");
        labelTelepon.setBounds(50, 60, 150, 30);

        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(200, 60, 150, 30);

        JButton button = new JButton("Tambah Biodata");
        button.setBounds(150, 100, 150, 40);

        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(50, 160, 300, 200);
        txtOutput.setEditable(false); 
        txtOutput.setLineWrap(true); 
        txtOutput.setWrapStyleWord(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String telepon = textFieldTelepon.getText();

                if (nama.isEmpty() || telepon.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nama atau Nomor Telepon tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                textFieldNama.setText("");
                textFieldTelepon.setText("");
            }
        });

        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelTelepon);
        this.add(textFieldTelepon);
        this.add(button);
        this.add(txtOutput);

        this.setSize(400, 450);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataTeman b = new BiodataTeman();
                b.setVisible(true);
            }
        });
    }
}
