package ru.gabaraev.jrmodule3.dbemulate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DBStoryTest {

    public DBStory dbStory;
    public Map<Integer, String> dbData;

    @BeforeAll
    public void init() {
        dbStory = DBStory.getInstance();
        dbData = generateData();
    }

    private Map<Integer, String> generateData() {
        Map<Integer, String> resultMap = new HashMap<>();
        resultMap.put(0, "Снова настал черный день мук выбора. День рождения жены. Получится в этот раз достичь гармонии?" +
                " Открыв утром глаза, напрягши голову, родились две достойные мысли." +
                " Давно хотел кота. Возможно он будет понимать тяжкие мысли мужика и скрасит будни." +
                " Либо же пойти и добыть сережки, что жена давно просит.");
        resultMap.put(1, "Поразмыслив чуток и зад почесав, побрел мужик в зоо-магазин. Всяко кот интереснее будет, подумал. Ходил, в общем, смотрел." +
                " И увидал мужик кота, на него только и смотрит глазами своими. Зацепились взгляадми оба. У обоих жизнь не простая, видимо на том и сошлись." +
                " Понял мужик - надо брать.");
        resultMap.put(2, "Решил мужик не рисковать, и сделать все как задумано было заранее. Побрел мужик за цветами сначала. Так вроде правильнее." +
                " Дошел, в общем в магазин мужик. А там сколько их цветов этих, какие выбрать - сложный вопрос.");
        resultMap.put(3, "Купил, животинку за пазуху и побрел домой. А на встречу гля - друзья закадычные, с двора-то идут." +
                " Что ты, говорят, фигней занимаешься, животных таскаешь, пойдем с нами - отдохнем от будней этих серых.");
        resultMap.put(4, "Дал мужик слабину, поперся с компанией своей. А там что, все как обычно. Наливают, да разговоры разговаривают." +
                " Дошло дело до карт. И сам уже мужик не помнит - как играл, как кота проиграл, как домой возвращался. Помнит только как тапок в морду летел." +
                " Лежит теперь мужик в гостинной на диване. Спать сегодня ему тут придется. След на лбу от тапка, и мысли в голове о смысле жизни.");
        resultMap.put(5, "Но сегодня настрой у мужика другой совсем. Не поддался он на эти уговоры хлипкие." +
                " Нашел в себе силы домой пойти. Кота жене показать. Ну классный же право кошак!");
        resultMap.put(6, "Но не поняла жена добрых порывов. Напомнила она про сережки свои, а следом и тапок полетел прямо в лоб.");
        resultMap.put(7, "Ловкость еще на совсем растерял мужик. Увернулся с котом от тапка коварного. Успел от гнева в туалете укрыться." +
                " Теперь, вдвоем с котом, ждут когда буря уляжется. А пока сидят оба, о смысле жизни думают.");
        resultMap.put(8, "Не стал мужик свои последние силы тратить на попытки наказания избежать." +
                " Поймал тапок лбом. Да и привык уже к тапку этому. Как родной уже." +
                " Все равно вечером на кухне, как ни крути, сидят - чай пьют. А кот рядом сидит - о смысле жизни думает.");
        resultMap.put(9, "Долго выбирал мужик. Итак и сяк смотрел, думал. Выбрал в итоге гладиолусы. Вышел из магазина. А тут как напасть какая. " +
                " Мужики со двора то его и перехватили. А деваться-то и некуда. Неудобно же, каблук он что ли какой. Увлекли его собутыльники в темные омуты гуляний.");
        resultMap.put(10, "Решил мужик долго не мучиться, купил быстро розы, и пошел дальше план свой выполнять. Сережки сами себя не купят.");
        resultMap.put(11, "Где цветы потерял - не помнит, как домой вернулся - не помнит. " +
                " Лежит теперь мужик в гостинной на диване. Спать сегодня ему тут придется. След на лбу от тапка, и мысли в голове о смысле жизни.");
        resultMap.put(12, "В ювеоирном повезло. Продавец хороший, подсказал все быстро, все мужик успел сделать, да еще и друзей своих дурацких не встретил" +
                " Можно смело домой топать!");
        resultMap.put(13, "Пришел домой мужик. Подарил жене подарок, как полагается, все как у людей. Посадила его жена кухне, и тоже подарок сделать решила." +
                " Хороший ты мужик, говорит, но все равно разведусь я с тобой." +
                " Лежит теперь мужик в гостинной на диване. Спать сегодня ему тут придется. Следа на лбу от тапка нет, но мысли в голове о смысле жизни.");

        return resultMap;
    }

    static Stream<Integer> argsForTestGetAction() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
    }

    @ParameterizedTest
    @MethodSource("argsForTestGetAction")
    public void testGetAction(Integer testArg) {
        String result = dbStory.getAction(testArg);
        assertEquals(dbData.get(testArg), result);
    }

    @Test
    void testGetDb() {
        assertNotNull(DBStory.getDb());
    }

}
