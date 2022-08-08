package ru.gabaraev.jrmodule3.dbemulate;

import java.util.HashMap;
import java.util.Map;

public class DB implements DBEmulate{
    private final Map<Integer, String> dbData = new HashMap<>();
    private static volatile DBEmulate db = null;

    private DB() {
        this.dbData.put(0, "Action 1");
        this.dbData.put(1, "Action 2");
        this.dbData.put(2, "Action 3");
        this.dbData.put(3, "Action 4");
        this.dbData.put(4, "Action 5");
        this.dbData.put(5, "Action 6");
    }


    public static DBEmulate getInstance() {
        if (db == null) {
            synchronized (DB.class) {
                if (db == null) {
                    db = new DB();
                }
            }
        }
        return db;
    }

    @Override
    public String getAction(Integer index) {
        return this.dbData.get(index);
    }
}
