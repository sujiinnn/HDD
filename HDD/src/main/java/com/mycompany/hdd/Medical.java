/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author sujin
 */
public class Medical {

    ActionEvent selector = null;
    JList MediL = null;
    
    JLabel label = new JLabel();
    JTextArea txtArea = new JTextArea();
    BufferedImage SaYongImage = null;

    String s1 = "<html><div width='115px' align='center'>";
    String s2 = "</div></html>";
    
    JScrollPane scrollPane = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JScrollPane scrollPane2 = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    public JScrollPane scroll() {
        scrollPane.setBounds(750, 20, 20, 510);
        scrollPane2.setBounds(750, 20, 20, 510);
        //scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        return scrollPane;
    }
    
    public Medical(ActionEvent e, JList MediL) {
        selector = e;
        this.MediL = MediL;
        
        label.setBounds(230, 20, 550, 510);
        label.setBackground(Color.GREEN);
        label.setOpaque(true);
        
        txtArea.setBounds(230, 20, 556, 515);
        txtArea.setEditable(false); // 입력 제한
        txtArea.setBackground(Color.white);
        txtArea.setFont(new Font("궁서", Font.BOLD, 14));
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
    }

    public JLabel Imagerun() {
        System.out.println("지금 현재는 Medical 클래스로 넘어옴");

        if (MediL.getSelectedIndex() == -1) {

            String MediLER = s1 + " 응급의료 상황을 골라주세요. " + s2;

            JLabel MLER = new JLabel(MediLER);
            JOptionPane.showMessageDialog(null, MLER, " 응급의료 선택 오류", JOptionPane.WARNING_MESSAGE);

        } else {
            switch (MediL.getSelectedValue().toString().trim()) { // 선택된 아이템을 문자열로 변경 후 앞 뒤 공백 제거
                case "심폐소생술":
                    try {
                        SaYongImage = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\hdd\\Image\\cpr.jpg"));
                        // 이미지 크기 조절
                        ImageIcon icon = new ImageIcon(SaYongImage);
                        Image img = icon.getImage();
                        Image changeImg = img.getScaledInstance(550, 510, Image.SCALE_SMOOTH); // JLabel 사이즈에 맞춰서 이미지를 변경
                        ImageIcon changeIcon = new ImageIcon(changeImg);

                        label.setIcon(changeIcon);

                        return label;
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
        return label;
    }
    
    public JTextArea Textrun() {

        System.out.println("지금 현재는 DaeChu 클래스로 넘어옴");

        // 상황 대처법 아이템을 선택하지 않았을 경우에 -1 반환
       if (MediL.getSelectedIndex() == -1) {

            String MediLER = s1 + " 응급의료 상황을 골라주세요. " + s2;

            JLabel MLER = new JLabel(MediLER);
            JOptionPane.showMessageDialog(null, MLER, " 응급의료 선택 오류", JOptionPane.WARNING_MESSAGE);
            
            return txtArea;
        } else { 
            switch (MediL.getSelectedValue().toString().trim()) { 
                case "화상":
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJK14433.html?cd1=33&cd2=999&pagecd=SDIJK144.33&menuSeq=128";
                    Crawler crawler = new Crawler(url);
                    
                    crawler.title = crawler.doc.select("h3.title_02");
                    crawler.contents = crawler.doc.select("p");
                    
                    txtArea.append("[" + crawler.title.get(1).text() + "]\n");

                        for(String result : crawler.contents.get(3).text().split("\\.")){
                          txtArea.append(result + "\n");
                        }

                } catch (IOException ex) {
                    Logger.getLogger(DaeChu.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
          
                default:
                    System.out.println("상황 대처법을 선택했다.");
            }
        }
        return txtArea;
    }
}
