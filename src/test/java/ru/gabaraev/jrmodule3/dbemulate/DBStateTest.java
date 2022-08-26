package ru.gabaraev.jrmodule3.dbemulate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DBStateTest {

    public DBState dbState;
    public Map<Integer, ArrayList<Integer>> dbData;

    @BeforeAll
    public void init() {
        dbState = DBState.getInstance();
        dbData = generateData();
    }

    private Map<Integer, ArrayList<Integer>> generateData() {
        Map<Integer, ArrayList<Integer>> resultMap = new HashMap<>();
        resultMap.put(0, new ArrayList<Integer>(Arrays.asList(1, 2)));
        resultMap.put(1, new ArrayList<Integer>(Arrays.asList(3)));
        resultMap.put(2, new ArrayList<Integer>(Arrays.asList(9, 10)));
        resultMap.put(3, new ArrayList<Integer>(Arrays.asList(4, 5)));
        resultMap.put(4, new ArrayList<Integer>(Arrays.asList()));
        resultMap.put(5, new ArrayList<Integer>(Arrays.asList(6)));
        resultMap.put(6, new ArrayList<Integer>(Arrays.asList(7, 8)));
        resultMap.put(7, new ArrayList<Integer>(Arrays.asList()));
        resultMap.put(8, new ArrayList<Integer>(Arrays.asList()));
        resultMap.put(9, new ArrayList<Integer>(Arrays.asList(11)));
        resultMap.put(10, new ArrayList<Integer>(Arrays.asList(12)));
        resultMap.put(11, new ArrayList<Integer>(Arrays.asList()));
        resultMap.put(12, new ArrayList<Integer>(Arrays.asList()));
        resultMap.put(13, new ArrayList<Integer>(Arrays.asList()));
        return resultMap;
    }

    static Stream<Integer> argsForTestGetAction() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
    }

    @ParameterizedTest
    @MethodSource("argsForTestGetAction")
    public void testGetAction(Integer testArg) {
        ArrayList<Integer> result = dbState.getState(testArg);
        assertEquals(dbData.get(testArg), result);
    }

    @Test
    void testGetDb() {
        assertNotNull(DBState.getDb());
    }
}
