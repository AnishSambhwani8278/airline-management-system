import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame {

    JLabel text, ticket;
    JTextField ticketField;
    JButton fetchButton;
    JTable table;
    JScrollPane jsp;

    JourneyDetails(String name){
        super(name);
        setSize(900,340);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        text = new JLabel("Journey Details");
        text.setFont(new Font("Arial",Font.BOLD,20));
        text.setBounds(360,10,250,100);
        add(text);

        ticket = new JLabel("Ticket:");
        ticket.setFont(new Font("Arial",Font.PLAIN,15));
        ticket.setBounds(250,108,80,16);
        add(ticket);

        ticketField = new JTextField();
        ticketField.setFont(new Font("Arial",Font.PLAIN,15));
        ticketField.setBounds(330,108,200,17);
        add(ticketField);

        table = new JTable();

        fetchButton = new JButton();
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ticket = ticketField.getText();
                try{
                    Conn c = new Conn();
                    String query = "select * from reservations where ticket = '"+ticket+"'";
                    ResultSet rs = c.stmt.executeQuery(query);
                    if(rs.isBeforeFirst()){
                        if(jsp != null){
                            remove(jsp);
                        }
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                        table.setFont(new Font("Arial",Font.PLAIN,14));
                        table.getTableHeader().setReorderingAllowed(false);
                        table.setDragEnabled(true);
                        table.setRowHeight(30);
                        jsp = new JScrollPane(table);
                        jsp.setBounds(0,150,900,550);
                        add(jsp);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Ticket not found!");
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setText("Get Journey Details");
        fetchButton.setFocusable(false);
        fetchButton.setFont(new Font("Arial",Font.PLAIN,12));
        fetchButton.setBounds(560,108,150,16);
        add(fetchButton);

        setVisible(true);
    }
}