/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author VIET HOANG
 */
public class Student implements Serializable{
    static final long serialVersionUID=1L;
    private String maSV;
    private String hovaten;
    private String IP;
    private int group;
    private String rmiName ;
    private int rmiPort;

    public Student() {
    }

    public Student(String maSV, String hovaten, String IP, int group, String rmiName, int rmiPort) {
        this.maSV = maSV;
        this.hovaten = hovaten;
        this.IP = IP;
        this.group = group;
        this.rmiName = rmiName;
        this.rmiPort = rmiPort;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getRmiName() {
        return rmiName;
    }

    public void setRmiName(String rmiName) {
        this.rmiName = rmiName;
    }

    public int getRmiPort() {
        return rmiPort;
    }

    public void setRmiPort(int rmiPort) {
        this.rmiPort = rmiPort;
    }
    
    
}
