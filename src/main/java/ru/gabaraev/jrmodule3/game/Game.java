package ru.gabaraev.jrmodule3.game;

public class Game {
    public static volatile Game gameInstance = null;
    private Integer progress = 0;

    public Game() {
    }

    public static Game getInstance() {
        if (gameInstance == null) {
            synchronized (Game.class) {
                if (gameInstance == null) {
                    gameInstance = new Game();
                }
            }
        }
        return gameInstance;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
