package ru.gabaraev.jrmodule3.helpers;

public class Helper {

    public Helper() {
    }

    public String getDescription() {
        String description = "LittleAdventure";
        return description;
    }

    public String getGreetings() {
        String greetings = "" +
                "Приветствую тебя игрок!\n" +
                "Для начала приключения нажми кнопку!";
        return greetings;
    }

    public String getLinkToStart() {
        String linkToStart = "/start";
        return linkToStart;
    }
}
