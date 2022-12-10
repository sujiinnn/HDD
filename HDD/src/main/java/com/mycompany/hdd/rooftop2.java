package com.mycompany.hdd;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

class rooftop2 {
    public ArrayList<rooftop1> roof;

    public rooftop2(){
        roof = new ArrayList<>();
    }

    public static void save1Info(rooftop2 roof1) {
        try(FileWriter writer = new FileWriter("./root1.txt")){
            Gson gson = new Gson();
            gson.toJson(roof1, writer);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        };
    }
    public void set1Info(rooftop rooftop){
        try {
            Reader reader = new FileReader("./root1.txt");
            Gson gson = new Gson();
            this.roof = gson.fromJson(reader, rooftop2.class).roof;
        } catch (FileNotFoundException e) {
            System.out.println(rooftop.Roof.EarthquakeOutdoorsShelter.get(1).row.size());
            rooftop1 r = new rooftop1();
            for(int i = 0; i < rooftop.Roof.EarthquakeOutdoorsShelter.get(1).row.size(); i++){
                r.vt_acmdfclty_nm = rooftop.Roof.EarthquakeOutdoorsShelter.get(1).row.get(i).vt_acmdfclty_nm;
                r.dtl_adres= rooftop.Roof.EarthquakeOutdoorsShelter.get(1).row.get(i).dtl_adres;
                roof.add(r);
                r = new rooftop1();
            }
        }
        save1Info(this);
    }
}
