package com.mycompany.hdd;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

class sago1 {
    public ArrayList<sago> date1 ;


    public sago1(){
        date1 = new ArrayList<>();
    }
    public static void saveInfo(sago1 data) {
        try(FileWriter writer = new FileWriter("./data.txt")) {
            Gson gson = new Gson();
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }

    public void setInfo(Pasing pasing){
        try {
            Reader reader = new FileReader("./data.txt");
            Gson gson = new Gson();
            this.date1 = gson.fromJson(reader, sago1.class).date1;
        } catch (FileNotFoundException e) {
            sago s = new sago();
            for(int i = 0; i < pasing.root.currentCount; i++){
                s.발생일 = pasing.root.data.get(i).발생일;
                s.발생장소 = pasing.root.data.get(i).발생장소;
                s.재난상황명 = pasing.root.data.get(i).재난상황명;
                s.부상 = pasing.root.data.get(i).부상;
                s.사망 = pasing.root.data.get(i).사망;
                date1.add(s);
                s = new sago();
            }

        }


        saveInfo(this);
    }
}
