package com.example.telegrambotdeploy1.test;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface Test {
    String getStartMessage();
    boolean hasNextQuest();
    String getQuest();
    void setResult(String answer);
    String getResult();
    boolean checkAnswer(String answer);
    InlineKeyboardMarkup getKeybord();
    void rollbackQuest();
}
