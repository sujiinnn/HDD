/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class admin extends JFrame {
    
    Pasing nomal = new Pasing();

    public admin() {
        // TODO Auto-generated constructor stub
        setLayout(new FlowLayout());
        // 필드(Field, Column) 생성
        
        Vector columnNames = new Vector<>();
        columnNames.add("재난상황명");
        columnNames.add("발생일");
        columnNames.add("발생장소");
        columnNames.add("부상");
        columnNames.add("사망");
        columnNames.add("실종");
        columnNames.add("인명피해");

        // 레코드(Record, Row) 생성
         DefaultTableModel dtm = new DefaultTableModel(null, columnNames);
        System.out.println(nomal.root.data.size());
        for(Pasing.Datum d : nomal.root.data){
            String str[] = {d.재난상황명, d.발생일, d.발생장소, String.valueOf(d.부상), String.valueOf(d.사망), String.valueOf(d.실종), String.valueOf(d.인명피해)};
            if(d.발생일.contains("2019") && d.발생장소.contains("금정구"))
                dtm.addRow(str);
        }

        // 값 입력
      

        // Talbe 생성
        JTable jTable = new JTable(dtm);

        // 스크롤 페널 생성
        JScrollPane pane = new JScrollPane(jTable);
        pane.setPreferredSize(new Dimension(400,300));

        for(int i=1; i<8; i++){

            JTextField T = new JTextField(5);
            T.setBounds(50*i,400,25,25);
            super.add(T);
        }
        JButton btn= new JButton("수정");
        JButton btn1= new JButton("추가");
        JButton btn2= new JButton("삭제");

        super.add(btn);
        super.add(btn1);
        super.add(btn2);

        // JFrame에 페널 추가
        super.add(pane);

        // JFrame 화면 보이기
        super.setVisible(true);
        
        

    }

}