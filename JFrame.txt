import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingGUI extends JFrame implements ActionListener {

    private JLabel welcomeLabel;
    private JLabel accountNumberLabel;
    private JTextField accountNumberField;
    private JLabel customerNameLabel;
    private JTextField customerNameField;
    private JLabel balanceLabel;
    private JLabel balanceValueLabel;
    private JButton depositButton;
    private JTextField depositAmountField;
    private JButton withdrawButton;
    private JTextField withdrawAmountField;
    private JButton statementButton;
    private JButton exitButton;

    private BankAccount account;

    public BankingGUI() {
        setTitle("Banking Application");
        setLayout(null);

        // Welcome label
        welcomeLabel = new JLabel("Welcome to your bank account!");
        welcomeLabel.setBounds(50, 20, 200, 20);
        add(welcomeLabel);

        // Account number
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setBounds(50, 50, 100, 20);
        add(accountNumberLabel);

        accountNumberField = new JTextField();
        accountNumberField.setBounds(150, 50, 150, 20);
        add(accountNumberField);

        // Customer name
        customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setBounds(50, 80, 100, 20);
        add(customerNameLabel);

        customerNameField = new JTextField();
        customerNameField.setBounds(150, 80, 150, 20);
        add(customerNameField);

        // Balance
        balanceLabel = new JLabel("Balance:");
        balanceLabel.setBounds(50, 110, 100, 20);
        add(balanceLabel);

        balanceValueLabel = new JLabel("");
        balanceValueLabel.setBounds(150, 110, 150, 20);
        add(balanceValueLabel);

        // Deposit
        depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 140, 100, 20);
        depositButton.addActionListener(this);
        add(depositButton);

        depositAmountField = new JTextField();
        depositAmountField.setBounds(150, 140, 150, 20);
        add(depositAmountField);

        // Withdraw
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 170, 100, 20);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        withdrawAmountField = new JTextField();
        withdrawAmountField.setBounds(150, 170, 150, 20);
        add(withdrawAmountField);

        // Statement
        statementButton = new JButton("Statement");
        statementButton.setBounds(50, 200, 100, 20);
        statementButton.addActionListener(this);
        add(statementButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(50, 230, 100, 20);
        exitButton.addActionListener(this);
        add(exitButton);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override

    
public
 
void
 
actionPerformed(ActionEvent e)
 
{
        if (e.getSource() == depositButton) {
            try {
                double depositAmount = Double.parseDouble(depositAmountField.getText());
                account.depositMoney(depositAmount);
                updateBalance();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid deposit amount.");
            }
        } else if (e.getSource() == withdrawButton) {
            try {
                double withdrawAmount = Double.parseDouble(withdrawAmountField.getText());
                account.withdrawMoney(withdrawAmount);
                updateBalance();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid withdrawal amount.");
            }
        } else if (e.getSource() == statementButton) {
            account.generateStatement();