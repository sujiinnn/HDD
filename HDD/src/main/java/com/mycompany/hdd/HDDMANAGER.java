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
import javax.swing.table.DefaultTableModel;

public class HDDMANAGER extends JFrame {

    public HDDMANAGER() {

        Container managerScreen = getContentPane();
        setTitle("호다닥 : 관리자 모드");
        setBounds(850, 300, 1230, 520);
        managerScreen.setBackground(Color.white);
        managerScreen.setLayout(null);

        JPanel contentA = new JPanel();
        contentA.setBounds(210, 0, 1000, 580);
        contentA.setBackground(Color.white);
        contentA.setLayout(null);

        JPanel contentS = new JPanel();
        contentS.setBounds(210, 0, 100, 580);
        contentS.setBackground(Color.white);
        contentS.setLayout(null);

        managerScreen.add(contentA);
        managerScreen.add(contentS);

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

        ImageIcon Logo = new ImageIcon("src\\main\\java\\com\\mycompany\\hdd\\LogoSmall.PNG");
        JLabel HDDLogo = new JLabel(Logo);
        HDDLogo.setSize(100, 80);
        HDDLogo.setLocation(10, 365);

        ImageIcon BackImage = new ImageIcon("src\\main\\java\\com\\mycompany\\hdd\\BackButton.PNG");
        JButton BackButton = new JButton(BackImage);
        BackButton.setSize(80, 80);
        BackButton.setLocation(120, 365);
        BackButton.setBackground(Color.white);

        BackButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HDD main = new HDD();
                setVisible(false);
            }
        });

        AccidentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Pasing nomal = new Pasing();

                contentA.setVisible(true);
                
                Vector columnNames = new Vector<>();
                columnNames.add("재난상황명");
                columnNames.add("발생일");
                columnNames.add("발생장소");
                columnNames.add("부상");
                columnNames.add("사망");
                //columnNames.add("실종");
                //columnNames.add("인명피해");

                // 레코드(Record, Row) 생성
                DefaultTableModel dtm = new DefaultTableModel(null, columnNames);
                System.out.println(nomal.root.data.size());
                for (Pasing.Datum d : nomal.root.data) {
                    String str[] = {d.재난상황명, d.발생일, d.발생장소, String.valueOf(d.부상), String.valueOf(d.사망)};
//, String.valueOf(d.실종), String.valueOf(d.인명피해)};
                    if (d.발생일.contains("2019") && d.발생장소.contains("금정구")) {
                        dtm.addRow(str);
                
                    }
                }
  
                JTable jTable = new JTable(dtm);
                
                // 스크롤 페널 생성
                JScrollPane pane = new JScrollPane(jTable);
                pane.setBounds(00,00,1000,380); 
                //pane.setPreferredSize(new Dimension(400, 300));
                
                jTable.revalidate();
                jTable.repaint();

                JTextField name = new JTextField();
                JTextField date = new JTextField();
                JTextField Lo = new JTextField();
                JTextField hurt = new JTextField();
                JTextField die = new JTextField();

                name.setBounds(20, 400, 100, 30);
                contentA.add(name);
                name.revalidate();
                name.repaint();

                date.setBounds(140, 400, 100, 30);
                contentA.add(date);

                date.revalidate();
                date.repaint();

                Lo.setBounds(260, 400, 100, 30);
                contentA.add(Lo);
                Lo.revalidate();
                Lo.repaint();

                hurt.setBounds(380, 400, 100, 30);
                contentA.add(hurt);
                hurt.revalidate();
                hurt.repaint();

                die.setBounds(500, 400, 100, 30);
                contentA.add(die);
                die.revalidate();
                die.repaint();

                JButton btn = new JButton("수정");
                JButton btn1 = new JButton("추가");
                JButton btn2 = new JButton("삭제");

                btn.setBounds(630, 400, 100, 30);
                btn1.setBounds(750, 400, 100, 30);
                btn2.setBounds(870, 400, 100, 30);

                contentA.add(btn);
                contentA.add(btn1);
                contentA.add(btn2);

                // JFrame에 페널 추가
                contentA.add(pane);

                btn.revalidate();
                btn.repaint();

                btn1.revalidate();
                btn1.repaint();

                btn2.revalidate();
                btn2.repaint();

                pane.revalidate();
                pane.repaint();

                // JFrame 화면 보이기
            }
        });

        managerScreen.add(AccidentButton);
        managerScreen.add(ShelterButton);
        managerScreen.add(HDDLogo);
        managerScreen.add(BackButton);

        setVisible(true);

    }

}
