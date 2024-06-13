
package b1.student.info;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class B1StudentInfo {

    
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            int choice = 5;
            int regno;
            String sname, sadd, sclass, scourse, sql;
            String dob;
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/student", "neelu", "abcd1234");
            Statement stmt = con.createStatement();
            ResultSet rs;
            do {
                System.out.println("            Menu");
                System.out.println("--------------------------------");
                System.out.println("1.Add new Student");
                System.out.println("2.Delete a specified students Record");
                System.out.println("3. Update Students Address specified");
                System.out.println("4. Search for a particular Student");
                System.out.println("5. Exit");
                System.out.println("--------------------------------");
                System.out.print("Enter your choice:");
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("***Enter Student Details****");
                        System.out.print("Reg.No:");
                        regno = in.nextInt();
                        in.nextLine();
                        System.out.print("Name");
                        sname = in.nextLine();
                        System.out.print("DOB[yyyy-mm-dd]:");
                        dob = in.nextLine();
                        System.out.print("Address:");
                        sadd = in.nextLine();
                        System.out.print("Class:");
                        sclass = in.nextLine();
                        System.out.print("Course:");
                        scourse = in.nextLine();
                        sql = "INSERT INTO NEELU.STDTABLE (STREGNO, STNAME, STDOB, STADDRESS, STCLASS, STCOURSE) VALUES"
                                + "(" + regno + ", '" + sname + "', '" + dob.toString() + "', '" + sadd + "', '" + sclass + "','" + scourse + "')";
                        int result = stmt.executeUpdate(sql);
                        if (result == 1) {
                            System.out.println("saved");

                        } else {
                            System.out.println("Error saving");

                        }

                        break;
                    case 2:
                        System.out.print("Enter Student Reg.No:");
                        regno = in.nextInt();
                        sql = "select count(*) from NEELU.STDTABLE where STREGNO=" + regno;
                        rs = stmt.executeQuery(sql);
                        rs.next();
                        if (rs.getInt(1) == 1) {
                            sql = "Delete from neelu.STDTABLE where STREGNO=" + regno;
                            int res = stmt.executeUpdate(sql);
                            if (res == 1) {
                                System.out.println("Record Deleted");
                            } else {
                                System.out.println("Error while deleting");
                            }
                        } else {
                            System.out.println("Student Record not found");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Student Reg.No:");
                        regno = in.nextInt();
                        in.nextLine();
                        sql = "select count(*) from NEELU.STDTABLE where STREGNO=" + regno;
                        rs = stmt.executeQuery(sql);
                        rs.next();
                        if (rs.getInt(1) == 1) {
                            sql = "select STADDRESS from NEELU.STDTABLE where STREGNO=" + regno;
                            rs = stmt.executeQuery(sql);
                            rs.next();
                            System.out.println("old Address" + rs.getString(1));
                            System.out.print("Enter new Adress:");
                            String add = in.nextLine();
                            sql = "UPDATE NEELU.STDTABLE SET STADDRESS='" + add + "'WHERE STREGNO=" + regno;
                            if (stmt.executeUpdate(sql) == 1) {
                                System.out.println("Addres updated");
                            } else {
                                System.out.println("Error while updating");
                            }
                        } else {
                            System.out.println("Record not found!!!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Student Reg.No:");
                        regno = in.nextInt();
                        in.nextLine();
                        sql = "select * from NEELU.STDTABLE where STREGNO=" + regno;
                        rs = stmt.executeQuery(sql);
                        if (rs != null) {
                            rs.next();
                            System.out.println("Student Details are:");
                            System.out.println("RegNo" + rs.getInt(1));
                            System.out.println("Name" + rs.getString(2));
                            System.out.println("DOB" + rs.getString(3));
                            System.out.println("Class" + rs.getString(4));
                            System.out.println("Course" + rs.getString(5));
                        }
                        rs.next();
                        break;
                    case 5:
                        stmt.close();
                        con.close();
                        System.out.print("Thank You");
                        return;
                    default:
                        System.out.print("Wrong choice");

                }

            } while (true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(B1StudentInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(B1StudentInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
