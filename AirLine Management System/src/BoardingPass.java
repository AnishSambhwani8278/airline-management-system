import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BoardingPass extends JFrame {

    JLabel text, ticket, aadhar, aadharFetch, username, nationality, address, gender, usernameFetch, nationalityFetch, addressFetch, genderFetch, source, sourceFetch, destination, destinationFetch, flightName, flightCode, flightNameFetch, flightCodeFetch, date, dateFetch;
    JTextField ticketField;
    JButton fetchButton;

    BoardingPass(String name){
        super(name);
        setSize(900,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        text = new JLabel("Boarding Pass");
        text.setFont(new Font("Arial",Font.BOLD,20));
        text.setBounds(350,10,300,100);
        add(text);

        ticket = new JLabel("Ticket:");
        ticket.setFont(new Font("Arial",Font.PLAIN,15));
        ticket.setBounds(230,108,80,16);
        add(ticket);

        ticketField = new JTextField();
        ticketField.setFont(new Font("Arial",Font.PLAIN,15));
        ticketField.setBounds(330,108,200,17);
        add(ticketField);

        fetchButton = new JButton();
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticket = ticketField.getText();
                try{
                    Conn c = new Conn();
                    String query = "select * from reservations where ticket = '"+ticket+"'";
                    ResultSet rs = c.stmt.executeQuery(query);

                    if(rs.next()){
                        String username = rs.getString("name");
                        String aadhar = rs.getString("aadhar");
                        String address = rs.getString("address");
                        String nationality = rs.getString("nationality");
                        String gender = rs.getString("gender");
                        String source = rs.getString("source");
                        String destination = rs.getString("destination");
                        String date = rs.getString("date");
                        String flightName = rs.getString("f_name");
                        String flightCode = rs.getString("f_code");

                        usernameFetch.setText(username);
                        aadharFetch.setText(aadhar);
                        addressFetch.setText(address);
                        nationalityFetch.setText(nationality);
                        genderFetch.setText(gender);
                        sourceFetch.setText(source);
                        destinationFetch.setText(destination);
                        dateFetch.setText(date);
                        flightNameFetch.setText(flightName);
                        flightCodeFetch.setText(flightCode);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"No Boarding Pass Found!");
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setText("Get Boarding Pass");
        fetchButton.setFocusable(false);
        fetchButton.setFont(new Font("Arial",Font.PLAIN,12));
        fetchButton.setBounds(560,108,150,19);
        add(fetchButton);

        username = new JLabel("Name:");
        username.setFont(new Font("Arial",Font.PLAIN,15));
        username.setBounds(230,148,100,16);
        add(username);

        usernameFetch = new JLabel("Name");
        usernameFetch.setFont(new Font("Arial",Font.PLAIN,15));
        usernameFetch.setBounds(330,148,100,16);
        add(usernameFetch);

        nationality = new JLabel("Nationality:");
        nationality.setFont(new Font("Arial",Font.PLAIN,15));
        nationality.setBounds(230,188,100,16);
        add(nationality);

        nationalityFetch = new JLabel("Nationality");
        nationalityFetch.setFont(new Font("Arial",Font.PLAIN,15));
        nationalityFetch.setBounds(330,188,100,16);
        add(nationalityFetch);

        aadhar = new JLabel("Aadhar:");
        aadhar.setFont(new Font("Arial",Font.PLAIN,15));
        aadhar.setBounds(230,228,100,16);
        add(aadhar);

        aadharFetch = new JLabel("Aadhar");
        aadharFetch.setFont(new Font("Arial",Font.PLAIN,15));
        aadharFetch.setBounds(330,228,100,16);
        add(aadharFetch);

        address = new JLabel("Address:");
        address.setFont(new Font("Arial",Font.PLAIN,15));
        address.setBounds(230,268,100,16);
        add(address);

        addressFetch = new JLabel("Address");
        addressFetch.setFont(new Font("Arial",Font.PLAIN,15));
        addressFetch.setBounds(330,268,100,16);
        add(addressFetch);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial",Font.PLAIN,15));
        gender.setBounds(230,308,100,16);
        add(gender);

        genderFetch = new JLabel("Gender");
        genderFetch.setFont(new Font("Arial",Font.PLAIN,15));
        genderFetch.setBounds(330,308,100,16);
        add(genderFetch);

        source = new JLabel("Source:");
        source.setFont(new Font("Arial",Font.PLAIN,15));
        source.setBounds(230,348,100,16);
        add(source);

        sourceFetch = new JLabel("Source");
        sourceFetch.setFont(new Font("Arial",Font.PLAIN,15));
        sourceFetch.setBounds(330,348,100,16);
        add(sourceFetch);

        destination = new JLabel("Destination:");
        destination.setFont(new Font("Arial",Font.PLAIN,15));
        destination.setBounds(230,388,100,16);
        add(destination);

        destinationFetch = new JLabel("Destination");
        destinationFetch.setFont(new Font("Arial",Font.PLAIN,15));
        destinationFetch.setBounds(330,388,100,16);
        add(destinationFetch);

        flightName = new JLabel("Flight Name:");
        flightName.setFont(new Font("Arial",Font.PLAIN,15));
        flightName.setBounds(230,428,100,17);
        add(flightName);

        flightNameFetch = new JLabel("Flight Name");
        flightNameFetch.setFont(new Font("Arial",Font.PLAIN,15));
        flightNameFetch.setBounds(330,428,100,17);
        add(flightNameFetch);

        flightCode = new JLabel("Flight Code:");
        flightCode.setFont(new Font("Arial",Font.PLAIN,15));
        flightCode.setBounds(230,468,100,17);
        add(flightCode);

        flightCodeFetch = new JLabel("Flight Code");
        flightCodeFetch.setFont(new Font("Arial",Font.PLAIN,15));
        flightCodeFetch.setBounds(330,468,100,17);
        add(flightCodeFetch);

        date = new JLabel("Date:");
        date.setFont(new Font("Arial",Font.PLAIN,15));
        date.setBounds(230,508,100,17);
        add(date);

        dateFetch = new JLabel("Date");
        dateFetch.setFont(new Font("Arial",Font.PLAIN,15));
        dateFetch.setBounds(330,508,100,17);
        add(dateFetch);

        setVisible(true);
    }
}