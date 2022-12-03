/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
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
    JTextArea txtArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //JScrollBar scrollBar = new JScrollBar();

    public DaeChu() {
        // 기본 생성자 사용할 일 있으면 내용 추가하기

    }

    public DaeChu(ActionEvent e, JList SituL) { // ActionEvent 필요 없으면 제거하기
        selector = e;
        this.SituL = SituL;
        txtArea.setBounds(230, 20, 556, 515);
        txtArea.setEditable(false); // 입력 제한
        txtArea.setBackground(Color.white);
        txtArea.setFont(new Font("궁서", Font.BOLD, 14));
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);

        //scrollPane.setBounds(550, 0, 558, 515);
    }

    public JScrollPane scroll() {
        scrollPane.setBounds(750, 20, 20, 510);
        //scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        return scrollPane;
    }

    // 실행하는 코드
    public JTextArea run() {

        System.out.println("지금 현재는 DaeChu 클래스로 넘어옴");

        // 상황 대처법 아이템을 선택하지 않았을 경우에 -1 반환
        if (SituL.getSelectedIndex() == -1) {

            String SituLER = s1 + " 상황 대처법을 골라주세요. " + s2;

            JLabel SLER = new JLabel(SituLER);
            JOptionPane.showMessageDialog(null, SLER, " 상황 선택 오류", JOptionPane.WARNING_MESSAGE);

            return txtArea;
        } else { // 상황을 추가하고 싶으면 case 부분에 추가하기 + Situ String[]에 들어가 있는 값 이름 변경하기 ex) 상황4, 상황5 ... 이런식으로 되어있는걸 화재, 지진, 이런식으로 변경
            switch (SituL.getSelectedValue().toString().trim()) { // 선택된 아이템을 문자열로 변경 후 앞 뒤 공백 제거
                case "화재":

                    // 화재 관련 내용 크롤링하여 패널에 추가하기. ex) 기존에 테스트했던 코드들 복사 붙여넣기 이후 수정 필요한 부분만 수정해서 사용하기
                    try {
                        txtArea.setText(null);

                        String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/SDIJKM5116.html?menuSeq=127";
                        Crawler crawler = new Crawler(url);

                        crawler.title = crawler.doc.select("h4.title_02"); // 제목
                        crawler.subtitle = crawler.doc.select("h4.title_03"); // 소제목
                        crawler.contents = crawler.doc.select("strong.level4_title"); // 내용

                        int index = 0; // 두번째 for문 인덱스 체크
                        for (int i = 2; i < crawler.title.size() - 3; i++) { // i가 2부터 시작하는 이유는 "화재가 울릴 때" 부터 출력, size -3하는 이유는 "불을 발견했을 때"까지 출력하기 위함

                            txtArea.append("[" + crawler.title.get(i).text() + "]\n");

                            for (int j = index; j < crawler.subtitle.size() - 3; j++) {
                                txtArea.append(crawler.subtitle.get(j).text() + "\n");
                                if (j == 4) {
                                    index++;
                                    break;
                                }
                                for (String result : crawler.contents.get(j).text().split("\\.")) {
                                    txtArea.append(result + "\n");
                                }
                                txtArea.append("\n");
                                index++;
                            }

                            txtArea.append("\n\n");
                        }

                        return txtArea;

                    } catch (IOException ex) {
                        Logger.getLogger(DaeChu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "지진":
                    
                    // 지진 관련 내용 크롤링하여 패널에 추가하기.
                    try {
                        txtArea.setText(null);

                        String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent09.html?menuSeq=126";
                        Crawler crawler = new Crawler(url);

                        crawler.title = crawler.doc.select("ul.tablist li"); // 제목
                        crawler.contents = crawler.doc.select("div.detail"); // 내용

                        for (int i = 0; i < crawler.title.size(); i++) {
                            txtArea.append(crawler.title.get(i).text() + "\n");

                            for (String result : crawler.contents.get(i).text().split("\\.")) {
                                txtArea.append(result + "\n");
                            }

                        }
                        return txtArea;
                    } catch (IOException ex) {
                        Logger.getLogger(DaeChu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "해일":

                    // 해일 관련 내용 크롤링하여 패널에 추가하기.
                    try {
                        // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                        txtArea.setText(null);

                        // 크롤링 시작
                        String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent10.html?menuSeq=126";
                        Crawler crawler = new Crawler(url);
                        crawler.title = crawler.doc.select("h3.title_02");
                        crawler.contents = crawler.doc.select("p");

                        for (int i = 0; i < crawler.title.size(); i++) {
                            txtArea.append("[" + crawler.title.get(i).text() + "]\n");

                            for (String result : crawler.contents.text().split("\\.")) {
                                txtArea.append(result + "\n");
                            }
                            txtArea.append("\n");
                        }
                        return txtArea;

                    } catch (IOException ex) {
                        Logger.getLogger(DaeChu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "침수":
                    System.out.println(SituL.getSelectedValue().toString().trim() + "입니다.");

                    // 해일 관련 내용 크롤링하여 패널에 추가하기.
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent21.html?menuSeq=126";
                    Crawler crawler = new Crawler(url);

                    crawler.title = crawler.doc.select("h4.title_02");
                    crawler.subtitle = crawler.doc.select("strong.level4_title");
                    crawler.contents = crawler.doc.select("div.know_how_w");
                    crawler.contents2 = crawler.doc.select("ul.contextIndent_twoDepList");

                    for (int i = 0; i < crawler.title.size(); i++) {
                        if (i == 0) {
                            txtArea.append("[" + crawler.title.get(i).text() + "]\n");
                            for (String result : crawler.contents.get(i).text().split("\\.")) {
                                txtArea.append(result + "\n");

                            }
                        }
                        if (i == 1) {
                            txtArea.append("[" + crawler.title.get(i).text() + "]\n");

                            for (int j = 0; j < crawler.subtitle.size() - 1; j++) {
                                txtArea.append(crawler.subtitle.get(j).text() + "\n");
                                for (String result : crawler.contents2.get(j + (j + 1)).text().split("\\.")) {
                                    txtArea.append(result + "\n");
                                }

                                txtArea.append("\n");
                            }

                        }
                        txtArea.append("\n");

                    }
                    return txtArea;
                } catch (IOException ex) {
                    Logger.getLogger(DaeChu.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                case "지진해일":
                    System.out.println(SituL.getSelectedValue().toString().trim() + "입니다.");

                    // 해일 관련 내용 크롤링하여 패널에 추가하기.
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent16.html?menuSeq=126";
                    Crawler crawler = new Crawler(url);

                    crawler.contents = crawler.doc.select("div.preventTop_boxWrap");

                    for (String result : crawler.contents.get(0).text().split("\\.")) {
                        txtArea.append(result + "\n");
                    }
                    return txtArea;

                } catch (IOException ex) {
                    Logger.getLogger(DaeChu.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                case "태풍":
                    System.out.println(SituL.getSelectedValue().toString().trim() + "입니다.");

                    // 해일 관련 내용 크롤링하여 패널에 추가하기.
                    try {
                    // 버튼 클릭할 때마다 맨 처음에 화면 지우기
                    txtArea.setText(null);

                    // 크롤링 시작
                    String url = "https://www.safekorea.go.kr/idsiSFK/neo/sfk/cs/contents/prevent/prevent02.html?menuSeq=126";
                    Crawler crawler = new Crawler(url);
                    
                    crawler.title = crawler.doc.select("h4.title_02");
                    crawler.contents = crawler.doc.select("strong.level4_title");

                    txtArea.append("[" + crawler.title.text() + "]\n");
                    
                    for(int i = 11; i < crawler.contents.size(); i++){
                        for(String result : crawler.contents.get(i).text().split("\\.")){
                            txtArea.append(result + "\n");
                        }
                    }
                    return txtArea;
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
