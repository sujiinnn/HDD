package com.mycompany.hdd;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HDDUSER extends JFrame {

    public HDDUSER() {

        Container userScreen = getContentPane();
        setTitle("호다닥 : 부산 재난 안전 관리 시스템");
        setBounds(750, 230, 1020, 580);
        userScreen.setBackground(Color.white);
        userScreen.setLayout(null);

        JPanel contentA = new JPanel();
        contentA.setBounds(210, 0, 800, 580);
        contentA.setBackground(Color.white);
        contentA.setLayout(null);

        JPanel contentS = new JPanel();
        contentS.setBounds(210, 0, 800, 580);
        contentS.setBackground(Color.white);
        contentS.setLayout(null);

        JPanel contentM = new JPanel();
        contentM.setBounds(210, 0, 800, 580);
        contentM.setBackground(Color.white);
        contentM.setLayout(null);

        JPanel contentU = new JPanel();
        contentU.setBounds(210, 0, 800, 580);
        contentU.setBackground(Color.white);
        contentU.setLayout(null);

        userScreen.add(contentA);
        userScreen.add(contentS);
        userScreen.add(contentU);
        userScreen.add(contentM);

        //------------------------------------------------------ 패널추가
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

        //----------------------------------------------------------- 버튼추가
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //----------------------------------------------------------- 사건/사고
        String s1 = "<html><div width='115px' align='center'>";
        String s2 = "</div></html>";

        JLabel ChoiceLocation = new JLabel(" 위치를 선택해 주세요 ! ");
        ChoiceLocation.setBounds(20, 20, 200, 30);
        ChoiceLocation.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        JLabel ChoiceS = new JLabel(" 대피소 종류를 선택해 주세요 ! ");
        ChoiceS.setBounds(250, 20, 300, 30);
        ChoiceS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        JLabel InforM1 = new JLabel(" 위치와 대피소 종류 ");
        JLabel InforM2 = new JLabel(" 두가지 모두 선택하신 후에 ");
        JLabel InforM3 = new JLabel(" 아래의 다음 버튼을 눌러주세요 ! ");

        InforM1.setBounds(560, 30, 300, 30);
        InforM1.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        InforM2.setBounds(540, 60, 300, 30);
        InforM2.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
        InforM2.setForeground(Color.red);

        InforM3.setBounds(530, 90, 300, 30);
        InforM3.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        String[] Bgugun = {"  강서구", "  금정구", "  기장군", "  동구", "  동래구", "  부산진구", "  서구",
            "  연제구", "  해운대구", "  북구", "  사상구", "  사하구", "  영도구", "  남구", "  수영구", "  중구"};

        JList ShelL = new JList(Bgugun);
        ShelL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ShelL.setBackground(new Color(242, 255, 237));
        ShelL.setBounds(10, 60, 200, 390);
        ShelL.setFont(new Font("HY헤드라인M", Font.PLAIN, 18));

        JButton NextS = new JButton("다음");
        NextS.setBounds(580, 140, 100, 30);
        NextS.setBackground(new Color(248, 248, 248));
        NextS.setFont(new Font("맑은 고딕", Font.BOLD, 13));

        JCheckBox EmergencyS = new JCheckBox("지진해일 긴급대피장소");
        JCheckBox OutsideS = new JCheckBox("지진 옥외대피장소");
        JCheckBox CivilS = new JCheckBox("민방위 대피시설");

        EmergencyS.setBounds(240, 55, 230, 30);
        OutsideS.setBounds(240, 95, 230, 30);
        CivilS.setBounds(240, 135, 230, 30);

        EmergencyS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
        OutsideS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
        CivilS.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        contentS.add(ShelL);
        contentS.add(ChoiceLocation);
        contentS.add(NextS);
        contentS.add(EmergencyS);
        contentS.add(OutsideS);
        contentS.add(CivilS);
        contentS.add(ChoiceS);
        contentS.add(InforM1);
        contentS.add(InforM2);
        contentS.add(InforM3);

        JLabel tt = new JLabel();
        tt.setBounds(260, 180, 100, 30);
        tt.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        JLabel announ = new JLabel("에 있는 대피시설입니다 !");
        announ.setBounds(335, 180, 300, 30);
        announ.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        //--------------------------------------------------------- 대피소
        ButtonGroup Rg = new ButtonGroup();

        JRadioButton Situation = new JRadioButton(" 상황 대처법 ");
        Situation.setBounds(20, 30, 200, 30);
        Situation.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        JRadioButton Medical = new JRadioButton(" 응급 의료 대처법");
        Medical.setBounds(20, 70, 200, 30);
        Medical.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));

        String[] Situ = {"  상황1", "  상황2", "  상황3", "  상황4", "  상황5", "  상황6", "  상황7",
            "  상황8", "  상황9", "  상황10", "  상황11", "  상황12", "  상황13", "  상황14"};

        JList SituL = new JList(Situ);
        SituL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SituL.setBackground(new Color(242, 255, 237));
        SituL.setBounds(20, 120, 200, 350);
        SituL.setFont(new Font("HY헤드라인M", Font.PLAIN, 18));

        String[] Medi = {"  상황1", "  상황2", "  상황3", "  상황4", "  상황5", "  상황6", "  상황7",
            "  상황8", "  상황9", "  상황10", "  상황11", "  상황12", "  상황13", "  상황14"};

        JList MediL = new JList(Medi);
        MediL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        MediL.setBackground(new Color(242, 250, 237));
        MediL.setBounds(20, 120, 200, 350);
        MediL.setFont(new Font("HY헤드라인M", Font.PLAIN, 18));

        JButton NextM = new JButton("다음");
        NextM.setBounds(120, 480, 100, 30);
        NextM.setBackground(new Color(248, 248, 248));
        NextM.setFont(new Font("맑은 고딕", Font.BOLD, 13));

        JButton NextM2 = new JButton("다음");
        NextM2.setBounds(120, 480, 100, 30);
        NextM2.setBackground(new Color(248, 248, 248));
        NextM2.setFont(new Font("맑은 고딕", Font.BOLD, 13));

        Rg.add(Situation);
        Rg.add(Medical);

        contentM.add(Situation);
        contentM.add(Medical);

        //--------------------------------------------------------- 대처법
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //---------------------------------------------------------- 사용법
        AccidentButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                contentS.setVisible(false);
                contentM.setVisible(false);
                contentU.setVisible(false);
                contentA.setVisible(true);

            }

        });

        // -------------------------------------------------------- 사건 사고 액션
        ShelterButton.addActionListener(new ActionListener() {

            String Text;
            int index;

            @Override
            public void actionPerformed(ActionEvent e) {

                contentA.setVisible(false);
                contentM.setVisible(false);
                contentU.setVisible(false);
                contentS.setVisible(true);

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

                            contentS.add(tt);
                            contentS.add(announ);

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

        //------------------------------------------------------ 대피소 액션
        MethodButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                contentA.setVisible(false);
                contentU.setVisible(false);
                contentS.setVisible(false);
                contentM.setVisible(true);

                Situation.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {

                        if (e.getStateChange() == ItemEvent.DESELECTED) {
                            return;
                        }

                        if (Situation.isSelected()) {

                            MediL.setVisible(false);
                            NextM2.setVisible(false);

                            SituL.setVisible(true);
                            NextM.setVisible(true);

                            contentM.add(SituL);
                            contentM.add(NextM);

                            SituL.revalidate();
                            SituL.repaint();

                            NextM.revalidate();
                            NextM.repaint();

                        }

                    }

                });

                Medical.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {

                        if (e.getStateChange() == ItemEvent.DESELECTED) {
                            return;
                        }

                        if (Medical.isSelected()) {

                            SituL.setVisible(false);
                            NextM.setVisible(false);

                            MediL.setVisible(true);
                            NextM2.setVisible(true);

                            contentM.add(MediL);
                            contentM.add(NextM2);

                            MediL.revalidate();
                            MediL.repaint();

                            NextM2.revalidate();
                            NextM2.repaint();

                        }

                    }

                });

                NextM.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (SituL.getSelectedIndex() == -1) {

                            String SituLER = s1 + " 상황 대처법을 골라주세요. " + s2;

                            JLabel SLER = new JLabel(SituLER);
                            JOptionPane.showMessageDialog(null, SLER, " 상황 선택 오류", JOptionPane.WARNING_MESSAGE);

                        }

                    }
                });

                NextM2.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (MediL.getSelectedIndex() == -1) {

                            String MediLER = s1 + " 응급의료 상황을 골라주세요. " + s2;

                            JLabel MLER = new JLabel(MediLER);
                            JOptionPane.showMessageDialog(null, MLER, " 응급의료 선택 오류", JOptionPane.WARNING_MESSAGE);

                        }
                    }

                });
                
                Situation.revalidate();
                Medical.repaint();

            }
        });

        //------------------------------------------------------- 대처법 액션
        UseButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                contentA.setVisible(false);
                contentS.setVisible(false);
                contentM.setVisible(false);
                contentU.setVisible(true);

            }

        });

        //-------------------------------------------------------- 사용법 액션
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

        //--------------------------------------------------- 화면 기본 구성
    }

}
