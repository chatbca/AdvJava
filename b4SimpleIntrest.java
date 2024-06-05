ISimpleIntrest.java (interface)

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b4.si;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author HP
 */
public interface ISimpleIntrest extends Remote{
    double ComputeIntrest(double p, double t, double r) throws RemoteException;
}


SIClient.java..

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b4.si;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class SIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg=LocateRegistry.getRegistry(18888);
        ISimpleIntrest si = (ISimpleIntrest) reg.lookup("SimpleIntrest");
        Scanner input = new Scanner(System.in);
        double p,t,r;
        String ans="n";
        do{
            System.out.println("SIMPLE INTREST CALCULATION");
            System.out.print("Principle:");
            p = input.nextDouble();
            System.out.print("Time:");
            t = input.nextDouble();
            System.out.print("Rate:");
            r = input.nextDouble();
            System.out.print("Simple Intrest is:-"+si.ComputeIntrest(p, t, r));
            System.out.println("\nDou want to continue[y/n]...?");
            input.nextLine();
            ans=input.nextLine();
        }while(ans.toLowerCase().charAt(0)=='y');
    }
}

SIServer.java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b4.si;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author HP
 */
public class SIServer extends UnicastRemoteObject implements ISimpleIntrest {
   public SIServer() throws RemoteException{
   super();
   }
    @Override
    public double ComputeIntrest(double p, double t, double r) throws RemoteException {
        return(p*t*r)/100;
    }
    
}


StartServer.java..

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b4.si;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author HP
 */
public class StartServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        SIServer si = new SIServer();
        Registry reg = LocateRegistry.createRegistry(18888);
        reg.bind("SimpleIntrest", si);
        System.out.println("Server Started...:)");
    }
}

