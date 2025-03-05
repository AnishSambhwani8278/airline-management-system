import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame {

    JLabel text;
    JLabel username;
    JLabel nationality;
    JLabel aadhar;
    JLabel address;
    JLabel phone;
    JLabel gender;

    JTextField usernameField;
    JTextField nationalityField;
    JTextField aadharField;
    JTextField addressField;
    JTextField phoneField;

    JRadioButton male;
    JRadioButton female;

    ButtonGroup genderButtons;

    JButton submit;

    CustomerDetails(String name){
        super(name);
        setSize(900,550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        text = new JLabel("Add Passenger Details");
        text.setFont(new Font("Arial",Font.BOLD,20));
        text.setBounds(330,10,250,100);
        add(text);

        username = new JLabel("Name:");
        username.setFont(new Font("Arial",Font.PLAIN,15));
        username.setBounds(230,70,250,100);
        add(username);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial",Font.PLAIN,15));
        usernameField.setBounds(330,108,300,20);
        add(usernameField);

        nationality = new JLabel("Nationality:");
        nationality.setFont(new Font("Arial",Font.PLAIN,15));
        nationality.setBounds(230,110,250,100);
        add(nationality);

        nationalityField = new JTextField();
        nationalityField.setFont(new Font("Arial",Font.PLAIN,15));
        nationalityField.setBounds(330,148,300,20);
        add(nationalityField);

        aadhar = new JLabel("Aadhar:");
        aadhar.setFont(new Font("Arial",Font.PLAIN,15));
        aadhar.setBounds(230,150,250,100);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Arial",Font.PLAIN,15));
        aadharField.setBounds(330,188,300,20);
        add(aadharField);

        address = new JLabel("Address:");
        address.setFont(new Font("Arial",Font.PLAIN,15));
        address.setBounds(230,190,250,100);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Arial",Font.PLAIN,15));
        addressField.setBounds(330,228,300,20);
        add(addressField);

        phone = new JLabel("Phone:");
        phone.setFont(new Font("Arial",Font.PLAIN,15));
        phone.setBounds(230,230,250,100);
        add(phone);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial",Font.PLAIN,15));
        phoneField.setBounds(330,268,300,20);
        add(phoneField);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial",Font.PLAIN,15));
        gender.setBounds(230,270,250,100);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial",Font.PLAIN,13));
        male.setBounds(330,308,60,25);
        male.setFocusable(false);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial",Font.PLAIN,13));
        female.setBounds(390,308,80,25);
        female.setFocusable(false);
        add(female);

        genderButtons = new ButtonGroup();
        genderButtons.add(female);
        genderButtons.add(male);

        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setFont(new Font("Arial",Font.BOLD,15));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(380,420,100,30);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String nationality = nationalityField.getText();
                String aadhar = aadharField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String gender = null;
                if(male.isSelected()){
                    gender = male.getText();
                }
                else{
                    gender = female.getText();
                }

                try{
                    Conn c = new Conn();
                    String query = "insert into passengers values('" + username + "', '" + nationality + "', '" + aadhar + "', '" + address + "', '" + phone + "', '" + gender + "')";
                    c.stmt.execute(query);
                    JOptionPane.showMessageDialog(null,"Details added successfully!");
                    dispose();
                }
                catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        add(submit);
        setVisible(true);
    }
}