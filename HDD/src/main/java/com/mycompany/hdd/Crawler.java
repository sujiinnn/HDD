/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author sujin
 * 내용 : 크롤링하기 위한 크롤러 클래스
 */
public class Crawler {
    
    String URL = null;// 크롤링 URL 담는 변수
    Document doc = null; // 
    Elements title = null; // select 사용하기
    Elements subtitle = null;
    Elements contents = null;
    Elements contents2 = null;
   
    
    public Crawler(String url) throws IOException {
        URL = url;
        doc = Jsoup.connect(URL).get();
    }    
}
