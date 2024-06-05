b8mvc.java..

  
package b8mvc;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class B8MVC {

    
    public static void main(String[] args) {
        String rNo,sName;
        int m1,m2,m3;
        Scanner in= new Scanner(System.in);
        System.out.print("Enter Roll No:");
        rNo= in.nextLine();
        System.out.print("Enter your Name:");
        sName=in.nextLine();
        System.out.print("Enter your Marks in 3 Subjects:");
        m1=in.nextInt();
        m2=in.nextInt();
        m3=in.nextInt();
        
        StudentModel sm = new StudentModel(rNo, sName, m1, m2, m3);
        StudentView sv= new StudentView();
        StudentCntroller sc= new StudentCntroller(sm, sv);
        sc.UpdateView();
        
        
        
        
    }
    
}

StudentController.java

  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b8mvc;

/**
 *
 * @author HP
 */
public class StudentCntroller {
    private StudentModel model;
    private StudentView view;

    public StudentCntroller(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    
    public void UpdateView(){
 view.displayResult(model.getRolno(), model.getName(), model.getM1(),model.getM2(),model.getM3(), model.getResult(),model.getGrade());
}
    
}

StudentModel.java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b8mvc;

/**
 *
 * @author HP
 */
public class StudentModel {

    private String rolno, name;
    private int m1, m2, m3;

    public StudentModel(String rolno, String name, int m1, int m2, int m3) {
        this.rolno = rolno;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public String getRolno() {
        return rolno;
    }

    public void setRolno(String rolno) {
        this.rolno = rolno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getM1() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1 = m1;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getM3() {
        return m3;
    }

    public void setM3(int m3) {
        this.m3 = m3;
    }

    public String getResult() {
        String result = "";
        if (m1 < 35 || m2 < 35 || m3 < 35) {
            result = "Fail";
        } else {
            double per = ((m1 + m2 + m3) / 3);
            if (per >= 75) {
                result = "Distinction";
            } else if (per >= 60) {
                result = "First Class";
            } else if (per >= 50) {
                result = "Second Class";
            } else if (per >= 35) {
                result = "Pass";
            } else {
                result = "Fail";
            }

        }

        return result;
    }
    public String getGrade(){
    double per = ((m1 + m2 + m3) / 3);
    String grade="";
   
         if (per >= 90) {
                grade = "A";
            } else if (per >= 80) {
                grade = "B";
            } else if (per >= 70) {
                grade = "C";
            } else if (per >= 60) {
                grade = "D";
            } else {
                grade = "E";
            }
            return grade;
        }
}

StudentView.java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b8mvc;

/**
 *
 * @author HP
 */
public class StudentView {
    public void displayResult(String rNo, String sName, int m1,int m2,int m3, String result, String grade){
        System.out.println("---------------------------------RESULT------------------------------");
        System.out.println("\tRoll No\t Name\t\t Marks1\tMarks2\tMarks3\tResult\t\tGrade");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("\t"+rNo+"\t"+sName+"\t\t"+m1+"\t"+m2+"\t"+m3+"\t"+result+"\t\t"+grade);
        System.out.println("----------------------------------------------------------------------");
    
    }
}

  
