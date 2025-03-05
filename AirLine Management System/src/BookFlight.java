import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame {

    JLabel text, aadhar, username, nationality, address, gender, usernameFetch, nationalityFetch, addressFetch, genderFetch, source, destination, flightName, flightCode, flightNameFetch, flightCodeFetch, date;
    JTextField aadharField;
    JButton fetchButton, getFlight, bookButton;
    Choice sourceChoice, destinationChoice;
    JDateChooser dateChooser;

    BookFlight(String name){
        super(name);
        setSize(900,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        text = new JLabel("Book Flight");
        text.setFont(new Font("Arial",Font.BOLD,20));
        text.setBounds(360,10,250,100);
        add(text);

        aadhar = new JLabel("Aadhar:");
        aadhar.setFont(new Font("Arial",Font.PLAIN,15));
        aadhar.setBounds(230,70,250,100);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Arial",Font.PLAIN,15));
        aadharField.setBounds(330,108,200,20);
        add(aadharField);

        fetchButton = new JButton();
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aadhar = aadharField.getText();
                String name, nationality, address, gender;
                try{
                    Conn c = new Conn();

                    ResultSet rs = c.stmt.executeQuery("select * from passengers where aadhar = '"+aadhar+"'");
                    if(rs.next()){
                        name = rs.getString("username");
                        nationality = rs.getString("nationality");
                        address = rs.getString("address");
                        gender = rs.getString("gender");

                        usernameFetch.setText(name);
                        nationalityFetch.setText(nationality);
                        addressFetch.setText(address);
                        genderFetch.setText(gender);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "User not available!");
                        aadharField.setText("");
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setText("Fetch Details");
        fetchButton.setFocusable(false);
        fetchButton.setFont(new Font("Arial",Font.PLAIN,12));
        fetchButton.setBounds(560,108,120,19);
        add(fetchButton);

        username = new JLabel("Name:");
        username.setFont(new Font("Arial",Font.PLAIN,15));
        username.setBounds(230,110,250,100);
        add(username);

        usernameFetch = new JLabel("Name");
        usernameFetch.setFont(new Font("Arial",Font.PLAIN,15));
        usernameFetch.setBounds(330,110,250,100);
        add(usernameFetch);

        nationality = new JLabel("Nationality:");
        nationality.setFont(new Font("Arial",Font.PLAIN,15));
        nationality.setBounds(230,150,250,100);
        add(nationality);

        nationalityFetch = new JLabel("Nationality");
        nationalityFetch.setFont(new Font("Arial",Font.PLAIN,15));
        nationalityFetch.setBounds(330,150,250,100);
        add(nationalityFetch);

        address = new JLabel("Address:");
        address.setFont(new Font("Arial",Font.PLAIN,15));
        address.setBounds(230,190,250,100);
        add(address);

        addressFetch = new JLabel("Address");
        addressFetch.setFont(new Font("Arial",Font.PLAIN,15));
        addressFetch.setBounds(330,190,250,100);
        add(addressFetch);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial",Font.PLAIN,15));
        gender.setBounds(230,230,250,100);
        add(gender);

        genderFetch = new JLabel("Gender");
        genderFetch.setFont(new Font("Arial",Font.PLAIN,15));
        genderFetch.setBounds(330,230,250,100);
        add(genderFetch);

        source = new JLabel("Source:");
        source.setFont(new Font("Arial",Font.PLAIN,15));
        source.setBounds(230,310,100,100);
        add(source);

        destination = new JLabel("Destination:");
        destination.setFont(new Font("Arial",Font.PLAIN,15));
        destination.setBounds(230,350,100,100);
        add(destination);

        sourceChoice = new Choice();
        sourceChoice.setBounds(330,348,200,20);
        add(sourceChoice);

        getFlight = new JButton();
        getFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String source = sourceChoice.getSelectedItem();
                String destination = destinationChoice.getSelectedItem();
                String flightName, flightCode;
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.stmt.executeQuery("select * from flights where f_source = '"+source+"' and f_destination = '"+destination+"'");
                    if(rs.next()){
                        flightName = rs.getString("f_name");
                        flightCode = rs.getString("f_code");

                        flightNameFetch.setText(flightName);
                        flightCodeFetch.setText(flightCode);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Flight not available!");
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        getFlight.setBackground(Color.black);
        getFlight.setForeground(Color.white);
        getFlight.setText("Get Flights");
        getFlight.setFocusable(false);
        getFlight.setFont(new Font("Arial",Font.PLAIN,12));
        getFlight.setBounds(560,348,120,19);
        add(getFlight);

        destinationChoice = new Choice();
        destinationChoice.setBounds(330,388,200,20);
        add(destinationChoice);

        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from flights");
            while(rs.next()){
                sourceChoice.add(rs.getString("f_source"));
                destinationChoice.add(rs.getString("f_destination"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        flightName = new JLabel("Flight Name:");
        flightName.setFont(new Font("Arial",Font.PLAIN,15));
        flightName.setBounds(230,433,100,16);
        add(flightName);

        flightNameFetch = new JLabel("Flight Name");
        flightNameFetch.setFont(new Font("Arial",Font.PLAIN,15));
        flightNameFetch.setBounds(330,433,100,16);
        add(flightNameFetch);

        flightCode = new JLabel("Flight Name:");
        flightCode.setFont(new Font("Arial",Font.PLAIN,15));
        flightCode.setBounds(230,473,100,16);
        add(flightCode);

        flightCodeFetch = new JLabel("Flight Code");
        flightCodeFetch.setFont(new Font("Arial",Font.PLAIN,15));
        flightCodeFetch.setBounds(330,473,100,16);
        add(flightCodeFetch);

        date = new JLabel("Date:");
        date.setFont(new Font("Arial",Font.PLAIN,15));
        date.setBounds(230,512,100,18);
        add(date);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(330,513,200,20);
        add(dateChooser);

        bookButton = new JButton();
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aadhar = aadharField.getText();
                String name = usernameFetch.getText();
                String address = addressFetch.getText();
                String nationality = nationalityFetch.getText();
                String gender = genderFetch.getText();
                String source = sourceChoice.getSelectedItem();
                String destination = destinationChoice.getSelectedItem();
                String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                String f_name = flightNameFetch.getText();
                String f_code = flightCodeFetch.getText();

                Random random = new Random();
                String ticket = String.valueOf(random.nextInt(1000000));

                try{
                    Conn c = new Conn();
                    String query = "insert into reservations (ticket, aadhar, name, address, nationality, gender, source, destination, date, f_name, f_code) values ('TICKET-" + ticket + "', '" + aadhar + "', '" + name + "', '" + address + "', '" + nationality + "', '" + gender + "', '" + source + "', '" + destination + "', '" + date + "', '" + f_name + "', '" + f_code + "')";
                    c.stmt.execute(query);
                    JOptionPane.showMessageDialog(null, "Ticket Booked Successfully!\n Your ticket is: TICKET-"+ticket);
                    dispose();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        bookButton.setBackground(Color.decode("#2EA2D1"));
        bookButton.setForeground(Color.white);
        bookButton.setText("Book Ticket");
        bookButton.setFocusable(false);
        bookButton.setFont(new Font("Arial",Font.PLAIN,20));
        bookButton.setBounds(350,590,150,31);
        add(bookButton);

        setVisible(true);
    }
}