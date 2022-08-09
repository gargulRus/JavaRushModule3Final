package ru.gabaraev.jrmodule3.dbemulate;

import java.util.HashMap;
import java.util.Map;

public class DBStory {
    private final Map<Integer, String> dbData = new HashMap<>();
    private static volatile DBStory db = null;

    private DBStory() {
        this.dbData.put(0, "ДР жены. Время добывать подарок");
        this.dbData.put(1, "Решил пойти в зоомагазин - увидел там кота - решил купить кота. ");
        this.dbData.put(2, "Решил пойти в цветочный. Какие цветы будет выбирать?");
        this.dbData.put(3, "Купил кота. Встретил друзей. Стоит выбор - что делать дальше.");
        this.dbData.put(4, "Получить тапком, спать на диване");
        this.dbData.put(5, "Не попал под влияние друзей, принес домой кота.");
        this.dbData.put(6, "Пытаешься подарить кота жене.");
        this.dbData.put(7, "Увернулся от тапка. Закрылся в туалете. Думаешь о смысле жизни.");
        this.dbData.put(8, "Получить по мозгам тапком. Пообещать сережки. Вторем сидите пьете чай.");
        this.dbData.put(9, "Купил гладиолусы. Но по пути попал под влияние свои друзей утупков");
        this.dbData.put(10, "Розы купил. Поход в ювелирный за сережками.");
        this.dbData.put(11, "Попал под влияние. Получить гладиолусами - спать на диване");
        this.dbData.put(12, "Все успешно куплено. Встречи с друзьями избежал. Вернулся домой вовремя и как огурец.");
        this.dbData.put(13, "Вернуться домой. Подарить. С тобой разводятся все равно. Думаешь о смысле жизни.");
    }


    public static DBStory getInstance() {
        if (db == null) {
            synchronized (DBStory.class) {
                if (db == null) {
                    db = new DBStory();
                }
            }
        }
        return db;
    }

    public String getAction(Integer index) {
        return this.dbData.get(index);
    }
}
