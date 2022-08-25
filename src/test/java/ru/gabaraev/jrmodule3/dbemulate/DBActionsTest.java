package ru.gabaraev.jrmodule3.dbemulate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gabaraev.jrmodule3.dbemulate.DBActions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DBActionsTest {

    public DBActions dbActions;
    public Map<Integer, String> dbData;

    @BeforeAll
    public void init() {
        dbActions = DBActions.getInstance();
        dbData = generateData();
    }

    private Map<Integer, String> generateData() {
        Map<Integer, String> resultMap = new HashMap<>();
        resultMap.put(1, "Пойти в зоо-магазин");
        resultMap.put(2, "Пойти в цветочный");
        resultMap.put(3, "Купить кота");
        resultMap.put(4, "Пойти на поводу у товарищей");
        resultMap.put(5, "Мужик кремень! Идет домой!");
        resultMap.put(6, "Дарит кота жене, радуется.");
        resultMap.put(7, "Попытаться увернуться от тапка");
        resultMap.put(8, "Принять свою судьбу");
        resultMap.put(9, "Купить гладиолусы");
        resultMap.put(10, "Купить розы");
        resultMap.put(11, "Поддаться и пойти на поводу у товарищей");
        resultMap.put(12, "Пойти в ювелирный за сережками");
        resultMap.put(13, "Вернуться домой");

        return resultMap;
    }

    static Stream<Integer> argsForTestGetAction() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
    }

    @ParameterizedTest
    @MethodSource("argsForTestGetAction")
    public void testGetAction(Integer testArg) {
        String result = dbActions.getAction(testArg);
        assertEquals(dbData.get(testArg), result);
    }

    @Test
    void testGetDb() {
        assertNotNull(DBActions.getDb());
    }
}
