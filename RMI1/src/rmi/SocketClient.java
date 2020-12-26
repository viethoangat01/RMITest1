/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import control.IRemoteClient;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIET HOANG
 */
public class SocketClient {
    public static void main(String[] args) {
        SocketClient client=new SocketClient();
        try {
            client.run();
        } catch (IOException ex) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void run() throws IOException{
        Socket socket=new Socket("localhost",11001);
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        String maSV="B17DCAT081";
        dataOutputStream.writeUTF(maSV);
        String hovaten ="Mai Viet Hoang";
        dataOutputStream.writeUTF(hovaten);
        String IP="172.20.10.7";
        dataOutputStream.writeUTF(IP);
        int group=1;
        dataOutputStream.writeInt(group);
        String RMI_NAME="viethoang";
        dataOutputStream.writeUTF(RMI_NAME);
        int RMI_PORT=1099;
        dataOutputStream.writeInt(RMI_PORT);
        dataOutputStream.close();
        socket.close();
        
    }

    
}
