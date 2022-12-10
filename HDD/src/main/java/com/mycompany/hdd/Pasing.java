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

public class Pasing {

    public static Object Datum;
    public Root root;

    public class Datum{
        public String 그밖의피해;
        public String 등록시간;
        public String 발생일;
        public String 발생장소;
        public int 부상;
        public int 사망;
        public String 수정시간;
        public int 실종;
        public int 인명피해;
        public String 재난상황명;
        public String 재산피해;
        public String 조치사항;
    }

    public String get발생일(int i) {return root.data.get(i).발생일;
    }
    public String get발생장소(int i) {
        return root.data.get(i).발생장소;
    }
    public String get재난상황명(int i) {
        return root.data.get(i).재난상황명;
    }
    public int get부상(int i) {
        return root.data.get(i).부상;
    }
    public int get사망(int i) {
        return root.data.get(1).사망;
    }
    public class Root{
        public int currentCount;
        public ArrayList<Datum> data;
        public int matchCount;
        public int page;
        public int perPage;
        public int totalCount;
        private String Adrress;
    }

    public String getAddress(){
        //return root.data.get(0).재산피해;
    return "";
    }

    public Pasing() {
        accdient();
        asdasd();
    }

    private void accdient() {
        String ServiceKey = "RjKhXzPpeqFtJpjzT2dN7RYQ%2Fvo%2Bv1KDnDuKMbXDNk2LYbb%2BVhk5MDEroOrrhH8ujUGl2h%2FlapcU37VgCi1gvA%3D%3D";
        String url1 = "https://www.data.go.kr/data/15083554/fileData.do";
        String perPage = "10";
        String Page = "1";
        String result;
        String type = "Json";
        try {
            URL url = new URL("https://api.odcloud.kr/api/15083554/v1/uddi:7c6b0dee-3251-491e-9eb5-92618662a61b?serviceKey=RjKhXzPpeqFtJpjzT2dN7RYQ%2Fvo%2Bv1KDnDuKMbXDNk2LYbb%2BVhk5MDEroOrrhH8ujUGl2h%2FlapcU37VgCi1gvA%3D%3D&page=" + Page + "&perPage=" + perPage + "&type=json");

            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = br.readLine();
            String array[] = result.split(" ");
            Gson gson = new Gson();
            root = gson.fromJson(result, Root.class);

// this.tsunamiShelter = gson.fromJson(result,aaaa.class).tsunamiShelter;
        }
        catch (JsonIOException | JsonSyntaxException | IOException e) {

        }
    }

    private void asdasd() {
        try ( FileWriter writer = new FileWriter("./run.txt")) {
            Gson gson = new Gson();
            gson.toJson(this, writer);
            writer.flush();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pasing();
    }
}

