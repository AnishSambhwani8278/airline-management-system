import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class Flights extends JFrame {

    JTable table;
    JScrollPane jsp;

    Flights(String name){
        super(name);
        setSize(900,550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from flights");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("Arial",Font.PLAIN,20));
            table.setRowHeight(20);
            jsp = new JScrollPane(table);
            jsp.setBounds(0,0,900,550);
            add(jsp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}