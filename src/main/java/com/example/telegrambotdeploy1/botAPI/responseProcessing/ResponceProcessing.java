package com.example.telegrambotdeploy1.botAPI.responseProcessing;

import com.example.telegrambotdeploy1.test.Test;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface ResponceProcessing {

    void dataAcceptance(Update update);
    Test getTest(String answer);
    void getAnswer(int userId, String answer);

}
