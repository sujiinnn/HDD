/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author sujin 내용 : 상황 대처법 관련 클래스
 */



public class DaeChu {

    ActionEvent selector = null;
    JList SituL = null;
    String s1 = "<html><div width='115px' align='center'>";
    String s2 = "</div></html>";
    

    public DaeChu() {
        // 기본 생성자 사용할 일 있으면 내용 추가하기
        //JTextArea txtArea = new JTextArea();
        //txtArea.setBounds(230, 0 ,600, 560);
        
        //contentM.add(txtArea);
        
    }

    public DaeChu(ActionEvent e, JList SituL) { // ActionEvent 필요 없으면 제거하기
        selector = e;
        this.SituL = SituL;
    }

    // 실행하는 코드
    public void run() {
        // test
        System.out.println("지금 현재는 DaeChu 클래스로 넘어옴");
        
        // 상황 대처법 아이템을 선택하지 않았을 경우에 -1 반환
        if (SituL.getSelectedIndex() == -1) {

            String SituLER = s1 + " 상황 대처법을 골라주세요. " + s2;

            JLabel SLER = new JLabel(SituLER);
            JOptionPane.showMessageDialog(null, SLER, " 상황 선택 오류", JOptionPane.WARNING_MESSAGE);

        } else { // 상황을 추가하고 싶으면 case 부분에 추가하기 + Situ String[]에 들어가 있는 값 이름 변경하기 ex) 상황4, 상황5 ... 이런식으로 되어있는걸 화재, 지진, 이런식으로 변경
            switch (SituL.getSelectedValue().toString().trim()) { // 선택된 아이템을 문자열로 변경 후 앞 뒤 공백 제거
                case "화재":
                    System.out.println(SituL.getSelectedValue().toString().trim() + "입니다.");
                    
                    // 화재 관련 내용 크롤링하여 패널에 추가하기. ex) 기존에 테스트했던 코드들 복사 붙여넣기 이후 수정 필요한 부분만 수정해서 사용하기
                    break;
                case "지진":
                    System.out.println(SituL.getSelectedValue().toString().trim() + "입니다.");

                    // 지진 관련 내용 크롤링하여 패널에 추가하기.
                    break;
                case "해일":
                    System.out.println(SituL.getSelectedValue().toString().trim() + "입니다.");

                    // 해일 관련 내용 크롤링하여 패널에 추가하기.
                    break;
                default:
                    System.out.println("상황 대처법을 선택했다.");
            }
        }
    }
}
