package ru.gabaraev.jrmodule3.dbemulate;

import java.util.HashMap;
import java.util.Map;

public class DBActions {
    private final Map<Integer, String> dbData = new HashMap<>();
    private static volatile DBActions db = null;

    private DBActions() {
        this.dbData.put(1, "Пойти в зоо-магазин");
        this.dbData.put(2, "Пойти в цветочный");
        this.dbData.put(3, "Купить кота");
        this.dbData.put(4, "Пойти на поводу у товарищей");
        this.dbData.put(5, "Мужик кремень! Идет домой!");
        this.dbData.put(6, "Дарит кота жене, радуется.");
        this.dbData.put(7, "Попытаться увернуться от тапка");
        this.dbData.put(8, "Принять свою судьбу");
        this.dbData.put(9, "Купить гладиолусы");
        this.dbData.put(10, "Купить розы");
        this.dbData.put(11, "Поддаться и пойти на поводу у товарищей");
        this.dbData.put(12, "Пойти в ювелирный за сережками");
        this.dbData.put(13, "Вернуться домой");
    }


    public static DBActions getInstance() {
        if (db == null) {
            synchronized (DBActions.class) {
                if (db == null) {
                    db = new DBActions();
                }
            }
        }
        return db;
    }

    public String getAction(Integer index) {
        return this.dbData.get(index);
    }

    public static DBActions getDb() {
        return db;
    }
}
