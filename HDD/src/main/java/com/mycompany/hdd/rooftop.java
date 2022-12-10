/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hdd;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class rooftop {

    public Root Roof;

    public class Head {

        public int totalCount;
        public String numOfRows;
        public String pageNo;
        public String type;
        public RESULT1 RESULT;
    }
    public class RESULT1 {

        public String resultCode;
        public String resultMsg;
    }

    public class Root {
        public ArrayList<EarthquakeOutdoorsShelter1> EarthquakeOutdoorsShelter;
    }
    public class Row {

        public String arcd;
        public int acmdfclty_sn;
        public String ctprvn_nm;
        public String sgg_nm;
        public String vt_acmdfclty_nm; // 상세 이름 (ex : OO초등학교 이므로 JTable 필드에 상세 이름이라고 설정해주면 됨)
        public String rdnmadr_cd;
        public String bdong_cd;
        public String hdong_cd;
        public String dtl_adres;   // 주소 (전국단위임)
        public int fclty_ar;
        public String xcord;
        public String ycord;
    }

    public class EarthquakeOutdoorsShelter1 {

        public ArrayList<Head> head;
        public ArrayList<Row> row;
    }

    public rooftop() {
        rooftopa();
        rooftopea();
    }

    private void rooftopa() {
        String serviceKey = "AFJ4QyShCEI2kwbgwzwAWW27XwnVapyT7MOPlI67ODGtF3ZfDfAjI%2FYe9dCEDGaPJJ81sPp378M%2FO5BC0tTfNg%3D%3D";
        String urll = "http://apis.data.go.kr/1741000/EmergencyAssemblyArea_Earthquake2/getArea1List?";
        String numOfRows = "5";
        String PageNo = "1";
        String result;
        String type = "Json";
        try {
            URL url = new URL("http://apis.data.go.kr/1741000/EmergencyAssemblyArea_Earthquake2/getArea1List?serviceKey=AFJ4QyShCEI2kwbgwzwAWW27XwnVapyT7MOPlI67ODGtF3ZfDfAjI%2FYe9dCEDGaPJJ81sPp378M%2FO5BC0tTfNg%3D%3D&pageNo=" + PageNo + "&numOfRows=" + numOfRows + "&type=json");

            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = br.readLine();
          //  System.out.println(result);
            Gson gson = new Gson();
            Roof = gson.fromJson(result, Root.class);
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
        }
    }

    private void rooftopea() {
        try ( FileWriter writer = new FileWriter("./root.txt")) {
            Gson gson = new Gson();
            gson.toJson(this, writer);
            writer.flush();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
