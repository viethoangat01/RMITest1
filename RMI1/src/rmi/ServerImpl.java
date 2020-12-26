/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import control.IRemoteClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Student;

/**
 *
 * @author VIET HOANG
 */
public class ServerImpl extends UnicastRemoteObject implements IRemoteClient{
    private static final long serialVersionUID=1L;
    public ServerImpl() throws RemoteException{
        super();
    }
    
    @Override
    public Student getStudent() throws RemoteException {
        return new Student("B17DCAT081", "Mai Viet Hoang", "172.20.10.7", 1, "viethoang", 1099);
    }

    @Override
    public int getMax(int a, int b) throws RemoteException {
        return Math.max(a, b);
    }

    @Override
    public int getUSCLN(int a, int b) throws RemoteException {
        while(a*b!=0){
            if(a>b){
                a%=b;
            }else b%=a;
        }
        return a+b;
    }

    @Override
    public int getBSCNN(int a, int b) throws RemoteException {
        return (a*b)/getUSCLN(a, b);
    }

    @Override
    public String getReverse(String str) throws RemoteException {
        String temp = "";
        for(int i=str.length()-1;i>=0;i--){
            temp+=str.charAt(i);
        }
        return temp;
    }

    @Override
    public String getNormalization(String str) throws RemoteException {
//        //Xóa khoảng trắng ở đầu và cuối xâu
//        str=str.trim();
//        //Xóa các khoảng trắng thừa ở giữa xâu
//        str=str.replaceAll("\\s+"," ");
//        //Chuyển chữ cái đầu tiên xâu thành hoa
        return normalText(str);
    }
    //Viết hoa ký tự đầu câu có dấu chấm câu
    private String toCapitalize(String para, char punctuation){
        //para là đoạn cần chuẩn hóa
        //punctuation dấu câu: . ? !
        boolean isCap = true;
        char c;
        StringBuilder strb = new StringBuilder("");
        for (int i = 0; i < para.length(); i++) {
            c = para.charAt(i);
            if (c == punctuation) {
                isCap = true;
            }
            if (isCap && Character.isAlphabetic(c)) {
                c = Character.toUpperCase(c);
                isCap = false;
            }
            strb.append(c);
        }
        return strb.toString();
    }//hello.haha
    public String normalText(String line) {
        String out = ""; 
        //dòng lệnh này có thể bỏ vì có tên riêng viết hoa
        line = line.toLowerCase();
        //mỗi từ cách 1 khoảng cách
        line = line.replaceAll("\\s+", " ");
        line = line.replaceAll("\\.", "\\. ");
        line = line.replaceAll(" \\.", "\\.");
        line = line.replaceAll("\\!", "\\! ");
        line = line.replaceAll(" \\!", "\\!");
        line = line.replaceAll("\\?", "\\? ");
        line = line.replaceAll(" \\?", "\\?");
        line = line.replaceAll(" \\,", "\\,");
        line = line.replaceAll("\\,", "\\, ");
        line = line.trim();
        out=line;
        out=toCapitalize(out,'.');
        out=toCapitalize(out, '!');
        out=toCapitalize(out, '?');
        if (out.charAt(out.length()-1) != '.') {
            out = out + ".";
        }
        return out;
    }
    
}
