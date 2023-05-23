package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lenovo
 */
public class View extends JFrame{
    JLabel lNoHP = new JLabel("No.HP");
    JLabel lnama = new JLabel("Nama");
    JLabel lMasa = new JLabel("Masa Berlaku(Bulan)");
    JLabel lTipe = new JLabel("Tipe Membership");
    JLabel lTanggal = new JLabel("Tanggal");
    
    public JTextField tfNoHP = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfMasa = new JTextField();
    String [] tipe = {"Silver", "Gold", "Platinum"};
    public JComboBox Tipe = new JComboBox(tipe);
    public JTextField tftanggal = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"NO.HP", "Nama", "Masa Berlaku", "Tipe Membership", "Tanggal"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Pendataan Membership Vapestore");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(850,550);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 630, 450);
        
        add(lNoHP);
        lNoHP.setBounds(670, 20, 90, 20);
        add(tfNoHP);
        tfNoHP.setBounds(670, 40, 120, 20);
        
        add(lnama);
        lnama.setBounds(670, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(670, 80, 120, 20);
        
        add(lMasa);
        lMasa.setBounds(670, 100, 150, 20);
        add(tfMasa);
        tfMasa.setBounds(670, 120, 120, 20);
        
        add(lTipe);
        lTipe.setBounds(670, 140, 150, 20);
        add(Tipe);
        Tipe.setBounds(670, 160, 120, 20);
        
        add(lTanggal);
        lTanggal.setBounds(670, 180, 90, 20);
        add(tftanggal);
        tftanggal.setBounds(670, 200, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(670, 230, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(670, 260, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(670, 290, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(670, 320, 90, 20);
    }
    
    public String getNoHP(){
        return tfNoHP.getText();
    }
    
    public String getNama(){
        return tfNama.getText();
    }
    
    public String getMasa(){
        return tfMasa.getText();
    }
    
    public String getTipe(){
        return (String) Tipe.getSelectedItem();
    }
    
    public String getTanggal(){
        return tftanggal.getText();
    }
}
