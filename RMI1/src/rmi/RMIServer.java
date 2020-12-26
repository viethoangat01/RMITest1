/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author VIET HOANG
 */
public class RMIServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, IOException {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost/viethoang", new ServerImpl());
    }
    
}
