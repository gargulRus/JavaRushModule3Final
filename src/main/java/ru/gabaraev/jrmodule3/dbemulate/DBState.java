package ru.gabaraev.jrmodule3.dbemulate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DBState {
    private final Map<Integer, ArrayList<Integer>> dbData = new HashMap<>();
    private static volatile DBState db = null;

    private DBState() {
        this.dbData.put(0, new ArrayList<Integer>(Arrays.asList(1,2)));
        this.dbData.put(1, new ArrayList<Integer>(Arrays.asList(3)));
        this.dbData.put(2, new ArrayList<Integer>(Arrays.asList(9,10)));
        this.dbData.put(3, new ArrayList<Integer>(Arrays.asList(4,5)));
        this.dbData.put(4, new ArrayList<Integer>(Arrays.asList()));
        this.dbData.put(5, new ArrayList<Integer>(Arrays.asList(6)));
        this.dbData.put(6, new ArrayList<Integer>(Arrays.asList(7,8)));
        this.dbData.put(7, new ArrayList<Integer>(Arrays.asList()));
        this.dbData.put(8, new ArrayList<Integer>(Arrays.asList()));
        this.dbData.put(9, new ArrayList<Integer>(Arrays.asList(11)));
        this.dbData.put(10, new ArrayList<Integer>(Arrays.asList(12)));
        this.dbData.put(11, new ArrayList<Integer>(Arrays.asList()));
        this.dbData.put(12, new ArrayList<Integer>(Arrays.asList(13)));
        this.dbData.put(13, new ArrayList<Integer>(Arrays.asList()));
    }

    public static DBState getInstance() {
        if (db == null) {
            synchronized (DBState.class) {
                if (db == null) {
                    db = new DBState();
                }
            }
        }
        return db;
    }

    public ArrayList<Integer> getState(Integer index) {
        return this.dbData.get(index);
    }
}
