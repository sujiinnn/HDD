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

public class Shelter {

    public Root root;
  
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

        public ArrayList<TsunamiShelter1> TsunamiShelter;

      
    }

    public class Row {

        public int id;
        public String sido_name;
        public String sigungu_name;
        public String remarks;
        public String shel_nm;
        public String address;
        public double lon; //위도
        public double lat; //경도
        public int shel_av;
        public int lenth;
        public String shel_div_type;
        public String seismic;
        public int height;
    }
    
  
    public String getAddress(int i) {
        return root.TsunamiShelter.get(1).row.get(i).address;
    }

    
  
    public class TsunamiShelter1 {

        public ArrayList<Head> head;
        public ArrayList<Row> row;
    }

    public Shelter() {
        accdient();
        asdasd();
    }

    private void accdient() {
        String ServiceKey = "RjKhXzPpeqFtJpjzT2dN7RYQ%2Fvo%2Bv1KDnDuKMbXDNk2LYbb%2BVhk5MDEroOrrhH8ujUGl2h%2FlapcU37VgCi1gvA%3D%3D";
        String url1 = "http://www.data.go.kr/data/3058512/openapi.do?recommendDataYn=Y";
        String numOfRows = "10";
        String PageNo = "1";
        String result;
        String type = "Json";
        try {
            URL url = new URL("http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List?serviceKey=RjKhXzPpeqFtJpjzT2dN7RYQ%2Fvo%2Bv1KDnDuKMbXDNk2LYbb%2BVhk5MDEroOrrhH8ujUGl2h%2FlapcU37VgCi1gvA%3D%3D&pageNo=" + PageNo + "&numOfRows=" + numOfRows + "&type=json");

            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = br.readLine();
            
            Gson gson = new Gson();
            root = gson.fromJson(result, Root.class);
    
// this.tsunamiShelter = gson.fromJson(result,aaaa.class).tsunamiShelter;
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
        }
    }

    private void asdasd() {
        try ( FileWriter writer = new FileWriter("./rungo.txt")) {
            Gson gson = new Gson();
            gson.toJson(this, writer);
            writer.flush();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
  
    
}
