/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HDDUSER extends JFrame{
    
    public HDDUSER(){
        
        Container userScreen = getContentPane();
        setTitle("호다닥 : 부산 재난 안전 관리 시스템");
        setBounds(750,230,1020,630);
        userScreen.setBackground(Color.white);
        userScreen.setLayout(null);
        
        JButton AccidentButton = new JButton("사건 / 사고");
        AccidentButton.setSize(200, 80);
        AccidentButton.setLocation(0, 20);
        AccidentButton.setBackground(Color.white);
        AccidentButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
        
        JButton ShelterButton = new JButton("대피소");
        ShelterButton.setSize(200, 80);
        ShelterButton.setLocation(0, 102);
        ShelterButton.setBackground(Color.white);
        ShelterButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
        
        JButton MethodButton = new JButton("대처 방법");
        MethodButton.setSize(200, 80);
        MethodButton.setLocation(0, 184);
        MethodButton.setBackground(Color.white);
        MethodButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
        
        JButton UseButton = new JButton("안전도구 사용 방법");
        UseButton.setSize(200, 80);
        UseButton.setLocation(0, 266);
        UseButton.setBackground(Color.white);
        UseButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
        
        ImageIcon Logo = new ImageIcon("src\\main\\java\\com\\mycompany\\hdd\\LogoSmall.PNG");
        JLabel HDDLogo = new JLabel(Logo);
        HDDLogo.setSize(100, 80);
        HDDLogo.setLocation(10, 495);
        
        ImageIcon BackImage = new ImageIcon("src\\main\\java\\com\\mycompany\\hdd\\BackButton.PNG");
        JButton BackButton = new JButton(BackImage);
        BackButton.setSize(80,80);
        BackButton.setLocation(120,495);
        BackButton.setBackground(Color.white);
        
        BackButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HDD main = new HDD();
                setVisible(false);
            }
        });
      
        userScreen.add(AccidentButton);
        userScreen.add(ShelterButton);
        userScreen.add(MethodButton);
        userScreen.add(UseButton);
        userScreen.add(HDDLogo);
        userScreen.add(BackButton);
        
        //drawline(220,5,220, 470);

        setVisible(true);
        
        
    }
    
    
}
