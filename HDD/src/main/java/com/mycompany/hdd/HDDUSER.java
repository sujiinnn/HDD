package com.mycompany.hdd;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HDDUSER extends JFrame {

    public HDDUSER() {

        Container userScreen = getContentPane();
        setTitle("호다닥 : 부산 재난 안전 관리 시스템");
        setBounds(750, 230, 1020, 580);
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

        ShelterButton.addActionListener(new ActionListener() {

            String Text;
            int index;

            @Override
            public void actionPerformed(ActionEvent e) {

                String s1 = "<html><div width='115px' align='center'>";
                String s2 = "</div></html>";

                JLabel ChoiceLocation = new JLabel(" 위치를 선택해 주세요 ! ");
                ChoiceLocation.setBounds(230, 20, 200, 30);
                ChoiceLocation.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

                JLabel ChoiceS = new JLabel(" 대피소 종류를 선택해 주세요 ! ");
                ChoiceS.setBounds(450, 20, 300, 30);
                ChoiceS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

                JLabel InforM1 = new JLabel(" 위치와 대피소 종류 ");
                JLabel InforM2 = new JLabel(" 두가지 모두 선택하신 후에 ");
                JLabel InforM3 = new JLabel(" 아래의 다음 버튼을 눌러주세요 ! ");

                InforM1.setBounds(770, 30, 300, 30);
                InforM1.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

                InforM2.setBounds(750, 60, 300, 30);
                InforM2.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
                InforM2.setForeground(Color.red);

                InforM3.setBounds(730, 90, 300, 30);
                InforM3.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

                String[] Bgugun = {"  강서구", "  금정구", "  기장군", "  동구", "  동래구", "  부산진구", "  서구",
                    "  연제구", "  해운대구", "  북구", "  사상구", "  사하구", "  영도구", "  남구", "  수영구", "  중구"};

                JList ShelL = new JList(Bgugun);
                ShelL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                ShelL.setBackground(new Color(242, 255, 237));
                ShelL.setBounds(220, 60, 200, 390);
                ShelL.setFont(new Font("HY헤드라인M", Font.PLAIN, 18));

                JButton NextS = new JButton("다음");
                NextS.setBounds(790, 140, 100, 30);
                NextS.setBackground(new Color(248, 248, 248));
                NextS.setFont(new Font("맑은 고딕", Font.BOLD, 13));

                JCheckBox EmergencyS = new JCheckBox("지진해일 긴급대피장소");
                JCheckBox OutsideS = new JCheckBox("지진 옥외대피장소");
                JCheckBox CivilS = new JCheckBox("민방위 대피시설");

                EmergencyS.setBounds(450, 55, 230, 30);
                OutsideS.setBounds(450, 95, 230, 30);
                CivilS.setBounds(450, 135, 230, 30);

                EmergencyS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
                OutsideS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
                CivilS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

                userScreen.add(ShelL);
                userScreen.add(ChoiceLocation);
                userScreen.add(NextS);
                userScreen.add(EmergencyS);
                userScreen.add(OutsideS);
                userScreen.add(CivilS);
                userScreen.add(ChoiceS);
                userScreen.add(InforM1);
                userScreen.add(InforM2);
                userScreen.add(InforM3);

                JLabel tt = new JLabel();
                tt.setBounds(470, 180, 100, 30);
                tt.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

                JLabel announ = new JLabel("에 있는 대피소입니다 !");
                announ.setBounds(540, 180, 300, 30);
                announ.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

                NextS.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (ShelL.getSelectedIndex() == -1) {

                            String LocationER = s1 + " 지역을 선택해주세요. " + s2;

                            JLabel LER = new JLabel(LocationER);
                            JOptionPane.showMessageDialog(null, LER, "인원 수 오류", JOptionPane.WARNING_MESSAGE);

                        } else if (!EmergencyS.isSelected() && !OutsideS.isSelected() && !CivilS.isSelected()) {

                            String ShelER = s1 + " 대피소 종류를 한 개 이상 선택해주세요. " + s2;

                            JLabel SER = new JLabel(ShelER);
                            JOptionPane.showMessageDialog(null, SER, "대피소 종류 오류", JOptionPane.WARNING_MESSAGE);

                        } else {

                            index = ShelL.getSelectedIndex();
                            Text = Bgugun[index];

                            tt.setText(Text);

                            userScreen.add(tt);
                            userScreen.add(announ);

                            announ.revalidate();
                            announ.repaint();

                            tt.revalidate();
                            tt.repaint();
                        }
                    }
                });

                ShelL.revalidate();
                ShelL.repaint();

                ChoiceLocation.revalidate();
                ChoiceLocation.repaint();

                ChoiceS.revalidate();
                ChoiceS.repaint();

                NextS.revalidate();
                NextS.repaint();

                EmergencyS.revalidate();
                EmergencyS.repaint();

                OutsideS.revalidate();
                OutsideS.repaint();

                CivilS.revalidate();
                CivilS.repaint();

                InforM1.revalidate();
                InforM1.repaint();

                InforM2.revalidate();
                InforM2.repaint();

                InforM3.revalidate();
                InforM3.repaint();

            }
            
        });

        JButton MethodButton = new JButton("대처 방법");
        MethodButton.setSize(200, 80);
        MethodButton.setLocation(0, 184);
        MethodButton.setBackground(Color.white);
        MethodButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
        
        JButton An = new JButton("사건 / 사고");
        An.setBounds(200,200,200,200);
        
        MethodButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                 
                
                userScreen.add(An);
                
                 An.revalidate();
                 An.repaint();
            
            
        }
                });

        JButton UseButton = new JButton("안전도구 사용 방법");
        UseButton.setSize(200, 80);
        UseButton.setLocation(0, 266);
        UseButton.setBackground(Color.white);
        UseButton.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));

        ImageIcon Logo = new ImageIcon("src\\main\\java\\com\\mycompany\\hdd\\LogoSmall.PNG");
        JLabel HDDLogo = new JLabel(Logo);
        HDDLogo.setSize(100, 80);
        HDDLogo.setLocation(10, 445);

        ImageIcon BackImage = new ImageIcon("src\\main\\java\\com\\mycompany\\hdd\\BackButton.PNG");
        JButton BackButton = new JButton(BackImage);
        BackButton.setSize(80, 80);
        BackButton.setLocation(120, 445);
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

        setVisible(true);

    }

}
