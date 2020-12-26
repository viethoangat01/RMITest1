/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import control.IRemoteClient;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
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
public class SocketServer {
    private static String IP="localhost";
    private static int RMI_PORT;
    private static String RMI_NAME="";
    public static void main(String[] args) {
            SocketServer server =new SocketServer();
            try {
                server.run();
            } catch (IOException ex) {
                Logger.getLogger(SocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Gọi RMI
            System.out.println(IP+" "+RMI_NAME+" "+RMI_PORT);
            try {
                IRemoteClient iRemoteClient=(IRemoteClient) Naming.lookup("rmi://"+"localhost"+":"+RMI_PORT+"/"+RMI_NAME);
                System.out.println(iRemoteClient.getUSCLN(12, 16));
                System.out.println(iRemoteClient.getBSCNN(12, 16));
                System.out.println(iRemoteClient.getReverse("1234"));
                System.out.println(iRemoteClient.getNormalization("b có     thể hah hah  h  khác.hello halô bele."));
            } catch (NotBoundException ex) {
                Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void run() throws IOException{
        ServerSocket serverSocket=new ServerSocket(11001);
        System.out.println("Server running");
        //Nhan du lieu tu client gui len tu port 11001
        Socket socket=serverSocket.accept();
        //Nhận dữ liệu từ client gửi lên
        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        String maSV=dataInputStream.readUTF();
        String hovaten =dataInputStream.readUTF();
        IP=dataInputStream.readUTF();
        int group=dataInputStream.readInt();
        RMI_NAME=dataInputStream.readUTF();
        RMI_PORT=dataInputStream.readInt();
        System.out.println(maSV+" "+hovaten+" "+IP+" "+group+" "+RMI_NAME+" "+RMI_PORT);
        dataInputStream.close();
        serverSocket.close();
        socket.close();
    }
}
