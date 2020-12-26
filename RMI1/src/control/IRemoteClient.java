/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Student;

/**
 *
 * @author VIET HOANG
 */
public interface IRemoteClient extends Remote{
    Student getStudent() throws RemoteException;
    int getMax(int a,int b)throws RemoteException;
    int getUSCLN(int a,int b)throws RemoteException;
    int getBSCNN(int a,int b)throws RemoteException;
    String getReverse(String str)throws RemoteException;
    String getNormalization(String str)throws RemoteException;
}
