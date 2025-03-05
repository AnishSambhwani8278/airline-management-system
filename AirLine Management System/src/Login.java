import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    int boardWidth = 450;
    int boardHeight = 250;

    JLabel usernameLabel;
    JLabel passwordLabel;

    JTextField usernameField;
    JPasswordField passwordField;

    JButton reset;
    JButton close;
    JButton submit;

    Login(String title){
        super(title);
        setSize(boardWidth, boardHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        usernameLabel = new JLabel();
        usernameLabel.setFont(new Font("Arial",Font.PLAIN,15));
        usernameLabel.setText("Username: ");
        usernameLabel.setBounds(65, 20, 80,50);
        add(usernameLabel);

        passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("Arial",Font.PLAIN,15));
        passwordLabel.setText("Password: ");
        passwordLabel.setBounds(65, 60, 80,50);
        add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial",Font.PLAIN,15));
        usernameField.setBounds(165,35, 200,20);
        add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial",Font.PLAIN,15));
        passwordField.setBounds(165,75, 200,20);
        add(passwordField);

        reset = new JButton();
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        reset.setFont(new Font("Arial",Font.PLAIN,15));
        reset.setBounds(55, 150, 90, 30);
        reset.setText("Reset");
        reset.setBackground(Color.GRAY);
        reset.setForeground(Color.white);
        reset.setFocusable(false);
        add(reset);

        close = new JButton();
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        close.setFont(new Font("Arial",Font.PLAIN,15));
        close.setBounds(175, 150, 90, 30);
        close.setText("Close");
        close.setBackground(Color.GRAY);
        close.setForeground(Color.white);
        close.setFocusable(false);
        add(close);

        submit = new JButton();
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String userName = usernameField.getText();
                    String passWord = passwordField.getText();
                    Conn con = new Conn();
                    ResultSet rs = con.stmt.executeQuery("select * from login where username = '"+userName+"' and password ='"+passWord+"'");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Hi Admin!");
                        new Home("Home");
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid!");
                        System.exit(0);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        submit.setFont(new Font("Arial",Font.PLAIN,15));
        submit.setBounds(295, 150, 90, 30);
        submit.setText("Submit");
        submit.setBackground(Color.decode("#2EA2D1"));
        submit.setForeground(Color.white);
        submit.setFocusable(false);
        add(submit);

        setVisible(true);
    }

    public static void main(String[] args){
        new Login("Login Page");
    }
}