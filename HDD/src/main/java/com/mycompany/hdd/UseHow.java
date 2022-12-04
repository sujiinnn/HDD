/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import java.awt.Color;
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

/**
 *
 * @author sujin
 */
public class UseHow {

    ActionEvent selector = null;
    JList UseL = null;

    JLabel label = new JLabel();
    BufferedImage SaYongImage = null;
    JScrollPane scrollPane = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    String s1 = "<html><div width='115px' align='center'>";
    String s2 = "</div></html>";

    public JScrollPane scroll() {
        scrollPane.setBounds(750, 20, 20, 510);
        //scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        return scrollPane;
    }

    public UseHow(ActionEvent e, JList UseL) {
        selector = e;
        this.UseL = UseL;

        label.setBounds(230, 20, 550, 510);
        label.setBackground(Color.GREEN);
        label.setOpaque(true);
    }

    public JLabel run() {

        System.out.println("지금 현재는 JLabel 클래스로 넘어옴");

        if (UseL.getSelectedIndex() == -1) {

            String UseER = s1 + " 안전도구 종류를 선택해주세요. " + s2;

            JLabel UER = new JLabel(UseER);
            JOptionPane.showMessageDialog(null, UER, "사용방법 선택 오류", JOptionPane.WARNING_MESSAGE);

            return label;
        } else {
            switch (UseL.getSelectedValue().toString().trim()) {

                case "소화기":
                    try {
                    SaYongImage = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\hdd\\Image\\sohwagi.jpg"));
                    // 이미지 크기 조절
                    ImageIcon icon = new ImageIcon(SaYongImage);

                    Image img = icon.getImage();
                    Image changeImg = img.getScaledInstance(550, 510, Image.SCALE_SMOOTH); // JLabel 사이즈에 맞춰서 이미지를 변경
                    ImageIcon changeIcon = new ImageIcon(changeImg);

                    label.setIcon(changeIcon);

                    return label;
                } catch (IOException ex) {
                    Logger.getLogger(UseHow.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

                case "전기":
                     try {
                    SaYongImage = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\hdd\\Image\\jungi.png"));
                    // 이미지 크기 조절
                    ImageIcon icon = new ImageIcon(SaYongImage);

                    Image img = icon.getImage();
                    Image changeImg = img.getScaledInstance(550, 510, Image.SCALE_SMOOTH); // JLabel 사이즈에 맞춰서 이미지를 변경
                    ImageIcon changeIcon = new ImageIcon(changeImg);

                    label.setIcon(changeIcon);

                    return label;
                } catch (IOException ex) {
                    Logger.getLogger(UseHow.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }

        }

        return label;
    }
}
