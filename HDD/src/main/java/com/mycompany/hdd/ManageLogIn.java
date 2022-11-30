
package com.mycompany.hdd;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageLogIn extends JFrame{

    public ManageLogIn(){
        
        Container LogInScreen = getContentPane();
        setTitle("호다닥 : 관리자 로그인");
        setBounds(850, 300, 500, 300);
        LogInScreen.setBackground(Color.white);
        LogInScreen.setLayout(null);
        
        JLabel Infor = new JLabel("해당 화면은 관리자로 로그인하는 화면 입니다 !");
        JLabel Infor2 = new JLabel ("일반 사용자는 '호다닥 달려가기'를 이용해주세요.");
        
        JLabel word = new JLabel("비밀번호");
        JPasswordField passwordIN = new JPasswordField();
        
        Infor.setBounds(112, 30, 300, 30);
        Infor.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        
        Infor2.setBounds(110, 50, 300, 50);
        Infor2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        
        word.setBounds(100, 90, 150, 90);
        word.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 16));
        
        passwordIN.setBounds(180, 120, 200, 30);
        
        JButton Log = new JButton("로그인");
        Log.setBounds(200, 180, 100, 30);
        Log.setBackground(Color.white);
        Log.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        
        LogInScreen.add(Infor);
        LogInScreen.add(Infor2);
        LogInScreen.add(word);
        LogInScreen.add(passwordIN);
        LogInScreen.add(Log);
        
        Log.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                dispose();
                
                String PW = "22hashtag#";
                String input = new String (passwordIN.getPassword());
                
                if (input.equals(PW)){ // 비밀번호 비교 (아마도 for 문)
                    HDDMANAGER Manager = new HDDMANAGER();
                }
                
                else {
                    
                    String s1 = "<html><div width='115px' align='center'>";
                    String s2 = "</div></html>";
                    // 중앙 정렬
                    
                    String errorms = s1 + "비밀번호가 틀렸습니다." + s2;
                    
                    JLabel ms = new JLabel(errorms);
                    JOptionPane.showMessageDialog(null, ms,"비밀번호 오류",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

}
