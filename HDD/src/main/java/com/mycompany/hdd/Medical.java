/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author sujin
 */
public class Medical {

    ActionEvent selector = null;
    JList MediL = null;

    String s1 = "<html><div width='115px' align='center'>";
    String s2 = "</div></html>";

    public Medical(ActionEvent e, JList MediL) {
        selector = e;
        this.MediL = MediL;
    }

    public void run() {
        System.out.println("지금 현재는 Medical 클래스로 넘어옴");

        if (MediL.getSelectedIndex() == -1) {

            String MediLER = s1 + " 응급의료 상황을 골라주세요. " + s2;

            JLabel MLER = new JLabel(MediLER);
            JOptionPane.showMessageDialog(null, MLER, " 응급의료 선택 오류", JOptionPane.WARNING_MESSAGE);

        } else {
            switch (MediL.getSelectedValue().toString().trim()) { // 선택된 아이템을 문자열로 변경 후 앞 뒤 공백 제거
                case "심폐소생술":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");
                    break;
                case "화상":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");
                    break;
                case "벌쏘임":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");
                    break;
                case "뱀물림":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");
                    break;
                case "붉은불개미":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");
                    break;

                default:
                    System.out.println("응급 의료 상황 선택했다.");
            }
        }
    }
}
