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

        if (MediL.getSelectedIndex() == 0 || MediL.getSelectedIndex() == 1 || MediL.getSelectedIndex() == 7 || MediL.getSelectedIndex() == 8 || MediL.getSelectedIndex() == 9) {
            scrollPane.setVisible(true);
            return scrollPane;
        } else {
            scrollPane2.setVisible(true);
            return scrollPane2;
        }

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
        txtArea.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
    }

    public JLabel Imagerun() {
        System.out.println("지금 현재는 Medical 클래스로 넘어옴");

        label.setVisible(true);

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

                    try {
                        SaYongImage = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\hdd\\Image\\burn.jpg"));
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

                case "하임리히법":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");

                    try {
                        SaYongImage = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\hdd\\Image\\Heimlich method.png"));
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

                case "발목염좌":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");

                    try {
                        SaYongImage = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\hdd\\Image\\ankle sprain.png"));
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

                case "제염방법":
                    System.out.println(MediL.getSelectedValue().toString().trim() + "입니다.");

                    try {
                        SaYongImage = ImageIO.read(new File("src\\main\\java\\com\\mycompany\\hdd\\Image\\jeyum.png"));
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

                default:
                    System.out.println("응급 의료 상황 선택했다.");
            }
        }
        return label;
    }

    public JTextArea Textrun() {

        System.out.println("지금 현재는 DaeChu 클래스로 넘어옴");

        txtArea.setVisible(true);

        // 상황 대처법 아이템을 선택하지 않았을 경우에 -1 반환
        if (MediL.getSelectedIndex() == -1) {

            String MediLER = s1 + " 응급의료 상황을 골라주세요. " + s2;

            JLabel MLER = new JLabel(MediLER);
            JOptionPane.showMessageDialog(null, MLER, " 응급의료 선택 오류", JOptionPane.WARNING_MESSAGE);

            return txtArea;
        } else {
            switch (MediL.getSelectedValue().toString().trim()) {

                case "벌쏘임":
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJK14433.html?cd1=33&cd2=999&pagecd=SDIJK144.33&menuSeq=128";
                    Crawler crawler = new Crawler(url);

                    crawler.title = crawler.doc.select("h3.title_02");
                    crawler.contents = crawler.doc.select("p");

                    txtArea.append("[" + crawler.title.get(7).text() + "]\n");

                    for (String result : crawler.contents.get(9).text().split("\\.")) {
                        txtArea.append(result + "\n");
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

                case "붉은불개미":
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJK14941.html?cd1=41&cd2=999&pagecd=SDIJK149.41&menuSeq=128";
                    Crawler crawler = new Crawler(url);

                    crawler.title = crawler.doc.select("h3.title_02");
                    crawler.contents = crawler.doc.select("p");

                    System.out.println(crawler.contents);
                    for (int i = 0; i < crawler.title.size() - 1; i++) {
                        txtArea.append("[" + crawler.title.get(i).text() + "]\n");

                        for (String result : crawler.contents.get(i).text().split("\\.")) {
                            txtArea.append(result + "\n");
                        }
                        txtArea.append("\n");

                    }

                } catch (IOException ex) {
                    Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

                case "식중독":
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJK15346.html?cd1=46&cd2=999&pagecd=SDIJK153.46&menuSeq=128";
                    Crawler crawler = new Crawler(url);

                    crawler.title = crawler.doc.select("h3.title_02");
                    crawler.subtitle = crawler.doc.select("strong.level4_title");
                    crawler.contents = crawler.doc.select("p");

                    //System.out.println(crawler.subtitle);
                    //System.out.println(crawler.contents);
                    for (int i = 0; i < crawler.title.size() - 1; i++) {
                        txtArea.append("[" + crawler.title.get(i).text() + "]\n");
                        if (i == 0) {
                            for (String result : crawler.contents.get(0).text().split("\\.")) {
                                txtArea.append(result + "\n");
                            }
                        }
                        if (i == 1) {
                            for (int j = 1; j < crawler.subtitle.size() - 1; j++) {
                                txtArea.append(crawler.subtitle.get(j).text() + "\n");
                                for (String result : crawler.contents.get(j + j).text().split("\\.")) {
                                    txtArea.append(result + "\n");

                                }
                            }

                        }
                        txtArea.append("\n");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

                case "승강기사고":
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJK15043.html?cd1=43&cd2=999&pagecd=SDIJK150.43&menuSeq=128";
                    Crawler crawler = new Crawler(url);

                    crawler.title = crawler.doc.select("h3.title_02");
                    //crawler.subtitle = crawler.doc.select("strong.level4_title");
                    crawler.contents = crawler.doc.select("p");

                    //System.out.println(crawler.subtitle);
                    System.out.println(crawler.contents);

                    for (int i = 0; i < crawler.title.size() - 1; i++) {
                        txtArea.append("[" + crawler.title.get(i).text() + "]\n");

                        for (int j = 0; j < crawler.contents.size(); j++) {
                            for (String result : crawler.contents.get(j).text().split("\\.")) {
                                txtArea.append(result + "\n");
                            }
                        }

                    }
                    txtArea.append("\n");

                } catch (IOException ex) {
                    Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

                case "해파리피해":
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJK14638.html?cd1=38&cd2=999&pagecd=SDIJK146.38&menuSeq=128";
                    Crawler crawler = new Crawler(url);

                    crawler.title = crawler.doc.select("h3.title_02");
                    crawler.contents = crawler.doc.select("p");

                    txtArea.append("[" + crawler.title.get(0).text() + "]\n");

                    for (String result : crawler.contents.get(0).text().split("\\.")) {
                        txtArea.append(result + "\n");
                    }

                    txtArea.append("\n");

                } catch (IOException ex) {
                    Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                default:
                    System.out.println("상황 대처법을 선택했다.");
            }
        }
        return txtArea;
    }
}
