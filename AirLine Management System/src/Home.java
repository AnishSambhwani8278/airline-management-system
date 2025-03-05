import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    ImageIcon home;
    JLabel homeImg;
    JLabel text;

    JMenuBar menuBar;

    JMenu details;
    JMenu ticket;
    JMenu quit;

    JMenuItem flightDetail;
    JMenuItem customerDetail;
    JMenuItem bookFlight;
    JMenuItem journeyDetails;
    JMenuItem ticketCancellation;
    JMenuItem boardingPass;
    JMenuItem quitApplication;

    Home(String title){
        super(title);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000,523);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        home = new ImageIcon(getClass().getResource("/AirlineHome.png"));
        homeImg = new JLabel(home);
        add(homeImg);
        homeImg.setBounds(0, 0, 1000, 523);

        text = new JLabel("Welcome to Jaipur Airlines!");
        text.setFont(new Font("Arial",Font.BOLD,20));
        text.setBounds(370,100,300,25);
        homeImg.add(text);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        details = new JMenu("Details");
        menuBar.add(details);

        flightDetail = new JMenuItem("Flight Details");
        flightDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Flights("Flight Details");
            }
        });
        details.add(flightDetail);

        customerDetail = new JMenuItem("Add Passenger Details");
        customerDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerDetails("Add Passenger Details");
            }
        });
        details.add(customerDetail);

        bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookFlight("Book Flight");
            }
        });
        details.add(bookFlight);

        journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JourneyDetails("Journey Details");
            }
        });
        details.add(journeyDetails);

        ticketCancellation = new JMenuItem("Ticket Cancellation");
        ticketCancellation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicketCancellation("Ticket Cancellation");
            }
        });
        details.add(ticketCancellation);

        ticket = new JMenu("Ticket");
        menuBar.add(ticket);

        boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BoardingPass("Boarding Pass");
            }
        });
        ticket.add(boardingPass);

        quit = new JMenu("Quit");
        menuBar.add(quit);

        quitApplication = new JMenuItem("Quit Application");
        quitApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        quit.add(quitApplication);

        setVisible(true);
    }
}