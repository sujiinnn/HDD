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
        contentS.setBounds(210, 0, 1000, 580);
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
        
        JButton EmergencyS  = new JButton("지진해일 긴급대피장소");
        EmergencyS.setBounds(20, 10, 200, 30);
        EmergencyS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        JButton OutsideS = new JButton("지진 옥외대피장소");
        OutsideS.setBounds(270, 10, 200, 30);
        OutsideS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
        
        contentS.add(EmergencyS);
        contentS.add(OutsideS);


        BackButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HDD main = new HDD();
                setVisible(false);
            }
        });

        AccidentButton.addActionListener(new ActionListener() {
            
            public void setList(DefaultTableModel model, sago1 dataList){
                model.setNumRows(0);
                for(sago s : dataList.date1){
                    String[] str = {s.재난상황명, s.발생일, s.발생장소, s.부상.toString(), s.사망.toString()};
                    model.addRow(str);
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                
                contentS.setVisible(false);
                contentA.setVisible(true);

                Pasing nomal = new Pasing();
                
                sago1 dataList = new sago1();
                dataList.setInfo(nomal);
                ArrayList<String> dtm = new ArrayList<>();
                String[] header = {"재난상황명", "발생일", "발생장소", "부상", "사망"};
                DefaultTableModel model = new DefaultTableModel(null , header);

                JTable jTable = new JTable(model);

               // 스크롤 페널 생성
                JScrollPane pane = new JScrollPane(jTable);
                setList(model, dataList);
                pane.setBounds(00,00,1000,380);
                //pane.setPreferredSize(new Dimension(400, 300));
  
                jTable.revalidate();
                jTable.repaint();

                JTextField name = new JTextField();
                JTextField date = new JTextField();
                JTextField Lo = new JTextField();
                JTextField hurt = new JTextField();
                JTextField die = new JTextField();

                name.setBounds(20, 400, 200, 30);
                contentA.add(name);
                name.revalidate();
                name.repaint();

                date.setBounds(250, 400, 250, 30);
                contentA.add(date);

                date.revalidate();
                date.repaint();

                Lo.setBounds(530, 400, 250, 30);
                contentA.add(Lo);
                Lo.revalidate();
                Lo.repaint();

                hurt.setBounds(810, 400, 70, 30);
                contentA.add(hurt);
                hurt.revalidate();
                hurt.repaint();

                die.setBounds(910, 400, 70, 30);
                contentA.add(die);
                die.revalidate();
                die.repaint();

                JButton Change = new JButton("수정");
                JButton Plus = new JButton("추가");
                JButton Except = new JButton("삭제");

                Change.setBounds(630, 440, 100, 30);
                Plus.setBounds(750, 440, 100, 30);
                Except.setBounds(870, 440, 100, 30);

                contentA.add(Change);
                contentA.add(Plus);
                contentA.add(Except);

                // JFrame에 페널 추가
                contentA.add(pane);

                Change.revalidate();
                Change.repaint();

                Plus.revalidate();
                Plus.repaint();

                Except.revalidate();
                Except.repaint();

                pane.revalidate();
                pane.repaint();
                
                Change.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selection = jTable.getSelectedRow();
                        sago s = new sago();
                        s.재난상황명 = name.getText();
                        s.발생일 = date.getText();
                        s.발생장소 = Lo.getText();
                        s.부상 = Integer.valueOf(hurt.getText());
                        s.사망 = Integer.valueOf(die.getText());
                        dataList.date1.set(selection, s);
                        sago1.saveInfo(dataList);
                        setList(model, dataList);
                        name.setText("");
                        date.setText("");
                        Lo.setText("");
                        hurt.setText("");
                        die.setText("");
                    }

                });
                
                Plus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sago s = new sago();
                        s.재난상황명 = name.getText();
                        s.발생일 = date.getText();
                        s.발생장소 = Lo.getText();
                        s.부상 = Integer.valueOf(hurt.getText());
                        s.사망 = Integer.valueOf(die.getText());

                        dataList.date1.add(s);
                        sago1.saveInfo(dataList);
                        setList(model, dataList);
                        name.setText("");
                        date.setText("");
                        Lo.setText("");
                        hurt.setText("");
                        die.setText("");

                        jTable.revalidate();
                        jTable.repaint();
                    }
                });
                
                Except.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selection = jTable.getSelectedRow();
                        dataList.date1.remove(selection);
                        sago1.saveInfo(dataList);
                        setList(model, dataList);
                        jTable.revalidate();
                        jTable.repaint();
                    }
                });

                // JFrame 화면 보이기
            }
        });
        
         ShelterButton.addActionListener(new ActionListener() {

           public void setList(DefaultTableModel model, Shelter2 dataList){
                model.setNumRows(0);
                for(Shelter1 s : dataList.bunker){
                    String[] str = {s.shel_nm, s.address};
                    model.addRow(str);
                }
            }
            public void setList(DefaultTableModel model, rooftop2 dataList){
                model.setNumRows(0);
                for(rooftop1 r : dataList.roof){
                    String[] str1 = {r.vt_acmdfclty_nm, r.dtl_adres};
                    model.addRow(str1);
                }
            }
             @Override
            public void actionPerformed(ActionEvent e) {

                contentS.setVisible(true);
                contentA.setVisible(false);

                EmergencyS.revalidate();
                EmergencyS.repaint();
                
                OutsideS.revalidate();
                OutsideS.repaint();

                JPanel contentSE = new JPanel();
                contentSE.setBounds(0, 0, 1000, 480);
                contentSE.setBackground(Color.white);
                contentSE.setLayout(null);

                JPanel contentSO = new JPanel();
                contentSO.setBounds(0, 0, 1000, 480);
                contentSO.setBackground(Color.white);
                contentSO.setLayout(null);

                contentS.add(contentSE);
                contentS.add(contentSO);


                     EmergencyS.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        contentSE.setVisible(true);
                        contentSO.setVisible(false);

                        Shelter nomal1 = new Shelter();

                        Shelter2 dataList = new Shelter2();
                        dataList.setInfo(nomal1);
                        ArrayList<String> dtm = new ArrayList<>();
                        String[] header = {"상세 이름", "대피소 주소"};
                        DefaultTableModel model = new DefaultTableModel(null, header);

                        JTable sTable = new JTable(model);

                        // 스크롤 페널 생성
                        JScrollPane pane = new JScrollPane(sTable);
                        setList(model, dataList);
                        pane.setBounds(00, 50, 1000, 330);
                        //pane.setPreferredSize(new Dimension(400, 300));

                        sTable.revalidate();
                        sTable.repaint();

                        JTextField shel_name = new JTextField();
                        JTextField address_name = new JTextField();


                        shel_name.setBounds(50, 400, 200, 30);
                        contentSE.add(shel_name);
                        shel_name.revalidate();
                        shel_name.repaint();

                        address_name.setBounds(280, 400, 300, 30);
                        contentSE.add(address_name);

                        address_name.revalidate();
                        address_name.repaint();

                        JButton Change = new JButton("수정");
                        JButton Plus = new JButton("추가");
                        JButton Except = new JButton("삭제");

                        Change.setBounds(630, 400, 100, 30);
                        Plus.setBounds(750, 400, 100, 30);
                        Except.setBounds(870, 400, 100, 30);

                        contentSE.add(Change);
                        contentSE.add(Plus);
                        contentSE.add(Except);

                        // JFrame에 페널 추가
                        contentSE.add(pane);

                        Change.revalidate();
                        Change.repaint();

                        Plus.revalidate();
                        Plus.repaint();

                        Except.revalidate();
                        Except.repaint();

                        pane.revalidate();
                        pane.repaint();

                        // JFrame 화면 보이기
                        
                         Change.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int selection = sTable.getSelectedRow();
                                Shelter1 s = new Shelter1();
                                s.shel_nm = shel_name.getText();
                                s.address = address_name.getText();

                                dataList.bunker.set(selection, s);
                                Shelter2.saveInfo(dataList);
                                setList(model, dataList);
                                shel_name.setText("");
                                address_name.setText("");
                            }
                        });

                        Plus.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Shelter1 s = new Shelter1();
                                s.shel_nm = shel_name.getText();
                                s.address = address_name.getText();

                                dataList.bunker.add(s);
                                Shelter2.saveInfo(dataList);
                                setList(model, dataList);
                                shel_name.setText("");
                                address_name.setText("");

                                sTable.revalidate();
                                sTable.repaint();
                            }
                        });
                        
                        Except.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int selection = sTable.getSelectedRow();
                                dataList.bunker.remove(selection);
                                Shelter2.saveInfo(dataList);
                                setList(model, dataList);
                                
                                sTable.revalidate();
                                sTable.repaint();
                            }
                        });
                        
                    }
                });

                     OutsideS.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        contentSE.setVisible(false);
                        contentSO.setVisible(true);


                        rooftop nomal2 = new rooftop();

                        rooftop2 dataList = new rooftop2();
                        dataList.set1Info(nomal2);
                        ArrayList<String> dtm = new ArrayList<>();
                        String[] header = {"상세 이름", "대피소 주소"};
                        DefaultTableModel model = new DefaultTableModel(null, header);

                        JTable sTable = new JTable(model);

                        // 스크롤 페널 생성
                        JScrollPane pane = new JScrollPane(sTable);
                        setList(model, dataList);
                        pane.setBounds(00, 50, 1000, 330);
                        //pane.setPreferredSize(new Dimension(400, 300));

                        sTable.revalidate();
                        sTable.repaint();

                        JTextField name = new JTextField();
                        JTextField addname = new JTextField();

                        name.setBounds(50, 400, 200, 30);
                        contentSO.add(name);
                        name.revalidate();
                        name.repaint();

                        addname.setBounds(280, 400, 300, 30);
                        contentSO.add(addname);

                        addname.revalidate();
                        addname.repaint();

                        JButton Change = new JButton("수정");
                        JButton Plus = new JButton("추가");
                        JButton Except = new JButton("삭제");

                        Change.setBounds(630, 400, 100, 30);
                        Plus.setBounds(750, 400, 100, 30);
                        Except.setBounds(870, 400, 100, 30);

                        contentSO.add(Change);
                        contentSO.add(Plus);
                        contentSO.add(Except);

                        // JFrame에 페널 추가
                        contentSO.add(pane);

                        Change.revalidate();
                        Change.repaint();

                        Plus.revalidate();
                        Plus.repaint();

                        Except.revalidate();
                        Except.repaint();

                        pane.revalidate();
                        pane.repaint();

                        // JFrame 화면 보이기
                        
                        Change.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int selection = sTable.getSelectedRow();
                                rooftop1 r = new rooftop1();
                                r.vt_acmdfclty_nm = name.getText();
                                r.dtl_adres = addname.getText();

                                dataList.roof.set(selection, r);
                                rooftop2.save1Info(dataList);
                                setList(model, dataList);
                                name.setText("");
                                addname.setText("");
                            }
                        });

                        Plus.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                rooftop1 r = new rooftop1();
                                r.vt_acmdfclty_nm = name.getText();
                                r.dtl_adres = addname.getText();

                                dataList.roof.add(r);
                                rooftop2.save1Info(dataList);
                                setList(model, dataList);
                                name.setText("");
                                addname.setText("");

                                sTable.revalidate();
                                sTable.repaint();
                            }
                        });
                        
                        Except.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int selection = sTable.getSelectedRow();
                                dataList.roof.remove(selection);
                                rooftop2.save1Info(dataList);
                                setList(model, dataList);
                                sTable.revalidate();
                                sTable.repaint();
                            }
                        });
                        
                    }
                });
            }
        });

        managerScreen.add(AccidentButton);
        managerScreen.add(ShelterButton);
        managerScreen.add(HDDLogo);
        managerScreen.add(BackButton);
        
        contentA.setVisible(false);
        contentS.setVisible(false);

        setVisible(true);

    }

}
