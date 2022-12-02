package com.mycompany.hdd;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HDD extends JFrame {

    public HDD() {
        Container mainScreen = getContentPane();
        setTitle("호다닥 : 부산 재난 안전 관리 시스템");
        setBounds(400, 300, 415, 500);
        mainScreen.setBackground(Color.white); //255,255,228
        mainScreen.setLayout(null);

        JButton UserButton = new JButton(" 호다닥 달려가기 ");
        UserButton.setSize(300, 80);
        UserButton.setLocation(50, 280);
        UserButton.setBackground(Color.white);
        UserButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 25));

        JButton ManagerButton = new JButton("관리자 모드");
        ManagerButton.setSize(100, 30);
        ManagerButton.setLocation(290, 420);
        ManagerButton.setBackground(Color.white);
        ManagerButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));

        ImageIcon Logo = new ImageIcon("src\\main\\java\\com\\mycompany\\hdd\\Logo.png");
        JLabel HDDLogo = new JLabel(Logo);
        HDDLogo.setSize(200, 180);
        HDDLogo.setLocation(100, 70);

        mainScreen.add(UserButton);
        mainScreen.add(ManagerButton);
        mainScreen.add(HDDLogo);
        
        UserButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                HDDUSER UserHDD = new HDDUSER();
            }
        });
        
         ManagerButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                //dispose();
                ManageLogIn LogIn = new ManageLogIn();
            }
        });
      
        setVisible(true); // 프레임 출력
    }

    public static void main(String[] args) {
        HDD MainHDD = new HDD();
    }
}
