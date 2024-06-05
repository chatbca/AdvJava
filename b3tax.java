itax.java(interface)..

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3.tax;

import java.rmi.*;

/**
 *
 * @author HP
 */
public interface ITax extends Remote{
    double ComputeTax(double Salary) throws RemoteException;
}


itaxclent.java...

  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3.tax;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ITaxClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg =LocateRegistry.getRegistry(18888);
        ITax it = (ITax) reg.lookup("TaxServer");
        double salary;
        String ans="y";
        Scanner input= new Scanner(System.in);
        do{
            System.out.print("Enter your Annual salary:");
            salary=input.nextDouble();
            
            System.out.print("Income tax is: "+it.ComputeTax(salary));
            input.nextLine();
            System.out.print("\nDo You  want to continue[y/n]:");
            ans= input.nextLine();
        }while(ans.toLowerCase().charAt(0)=='y');
    }
}


iitaxServer.java..

  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3.tax;

import java.rmi.RemoteException;
import java.rmi.server.*;

/**
 *
 * @author HP
 */
public class ITaxServer extends UnicastRemoteObject implements ITax{
    public ITaxServer() throws RemoteException{
    super();
    }

    @Override
    public double ComputeTax(double Salary) throws RemoteException {
        if (Salary <= 300000) {
            return 0.0;
        } else if (Salary <= 600000) {
            return(Salary - 300000) * 0.05;
        } else if (Salary <= 900000) {
             return(600000 - 300000) * 0.05 + (Salary - 600000) * 0.1;
        } else if (Salary <= 1200000) {
            return(600000 - 300000) * 0.05 + (900000 - 600000) * 0.1 + (Salary- 900000) * 0.15;
        } else if (Salary <= 1500000) {
            return(600000 - 300000) * 0.05 + (900000 - 600000) * 0.1 + (1200000 - 900000) * 0.15 + (Salary - 1200000) * 0.20;
        } else {
            return(600000 - 300000) * 0.05 + (900000 - 600000) * 0.1 + (1200000 - 900000) * 0.15 + (1500000 - 1200000) * 0.20 + (Salary- 1500000) * 0.30;
        }
        
    
    }
    
}


StartServer.java..

  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3.tax;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


import java.rmi.registry.Registry;

/**
 *
 * @author HP
 */
public class StartServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException  {
        ITaxServer it  = new ITaxServer();
        Registry reg = LocateRegistry.createRegistry(18888);
        reg.bind("TaxServer", it);
        System.out.println("Server Staarted..........");
    }
    
}



