package com.mycompany.hdd;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

class Shelter2 {
    public ArrayList<Shelter1> bunker;

    public Shelter2(){ bunker = new ArrayList<>(); }
    public static void saveInfo(Shelter2 bunker1) {
        try(FileWriter writer = new FileWriter("./rungo.txt")) {
            Gson gson = new Gson();
            gson.toJson(bunker1, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }
    public void setInfo(Shelter Shelter){
        try {
            Reader reader = new FileReader("./rungo1.txt");
            Gson gson = new Gson();
            this.bunker = gson.fromJson(reader, Shelter2.class).bunker;
        } catch (FileNotFoundException e) {
            Shelter1 h = new Shelter1();
            for(int i = 0; i < Shelter.root.TsunamiShelter.get(1).row.size(); i++){
                h.shel_nm = Shelter.root.TsunamiShelter.get(1).row.get(i).shel_nm;
                h.address = Shelter.root.TsunamiShelter.get(1).row.get(i).address;
                bunker.add(h);
                h = new Shelter1();
            }
        }
        saveInfo(this);

    }
}
