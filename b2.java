/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b2.bank;

/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class B2Bank {
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;
            String accNo, accName, accAddress;
            double balance;
            
            // Establishing database connection
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/bank", "neelu", "abcd1234");
            Statement statement = connection.createStatement();
            
            // Main menu loop
            do {
                System.out.println("Menu");
                System.out.println("1. Add new Account Holder information");
                System.out.println("2. Amount Deposit");
                System.out.println("3. Amount Withdrawal (Maintain minimum balance 500 Rs)");
                System.out.println("4. Display all information");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter Account Holder Information:");
                        System.out.print("Account Number: ");
                        accNo = scanner.next();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Account Holder Name: ");
                        accName = scanner.nextLine();
                        System.out.print("Account Holder Address: ");
                        accAddress = scanner.nextLine();
                        System.out.print("Initial Balance: ");
                        balance = scanner.nextDouble();
                        // Inserting new account holder information into the database
                        String insertQuery = "INSERT INTO NEELU.Bank (ACC_NO, ACC_NAME, ACC_ADDRESS, BALANCE) VALUES ('" + accNo + "', '" + accName + "', '" + accAddress + "', " + balance + ")";
                        int rowsInserted = statement.executeUpdate(insertQuery);
                        if (rowsInserted > 0) {
                            System.out.println("Account holder information added successfully.");
                        } else {
                            System.out.println("Failed to add account holder information.");
                        }
                        break;
                    case 2:
                        // Deposit functionality
                        System.out.print("Enter Account Number: ");
                        String depositAccNo = scanner.next();
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        String depositQuery = "UPDATE NEELU.Bank SET BALANCE = BALANCE + " + depositAmount + " WHERE ACC_NO = '" + depositAccNo + "'";
                        int rowsUpdated = statement.executeUpdate(depositQuery);
                        if (rowsUpdated > 0) {
                            System.out.println("Amount deposited successfully.");
                        } else {
                            System.out.println("Failed to deposit amount. Account not found.");
                        }
                        break;
                    case 3:
                        // Withdrawal functionality
                        System.out.print("Enter Account Number: ");
                        String withdrawAccNo = scanner.next();
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        // Check if balance is sufficient
                        String balanceQuery = "SELECT BALANCE FROM NEELU.Bank WHERE ACC_NO = '" + withdrawAccNo + "'";
                        ResultSet balanceResult = statement.executeQuery(balanceQuery);
                        if (balanceResult.next()) {
                            double currentBalance = balanceResult.getDouble("BALANCE");
                            if (currentBalance - withdrawAmount >= 500) {
                                String withdrawQuery = "UPDATE NEELU.Bank SET BALANCE = BALANCE - " + withdrawAmount + " WHERE ACC_NO = '" + withdrawAccNo + "'";
                                int rowsWithdrawn = statement.executeUpdate(withdrawQuery);
                                if (rowsWithdrawn > 0) {
                                    System.out.println("Amount withdrawn successfully.");
                                } else {
                                    System.out.println("Failed to withdraw amount. Please try again.");
                                }
                            } else {
                                System.out.println("Insufficient balance. Minimum balance of 500 Rs must be maintained.");
                            }
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;
                    case 4:
                        // Display all account holder information
                        String selectQuery = "SELECT * FROM NEELU.Bank";
                        ResultSet resultSet = statement.executeQuery(selectQuery);
                        System.out.println("ACC_NO\tACC_NAME\tACC_ADDRESS\tBALANCE");
                        while (resultSet.next()) {
                            System.out.println(resultSet.getString("ACC_NO") + "\t" + resultSet.getString("ACC_NAME") + "\t" + resultSet.getString("ACC_ADDRESS") + "\t\t" + resultSet.getDouble("BALANCE"));
                        }
                        break;
                    case 5:
                        // Exit the program
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } while (choice != 5);
            
            // Closing resources
            statement.close();
            connection.close();
            scanner.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}

