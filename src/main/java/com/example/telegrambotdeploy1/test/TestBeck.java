package com.example.telegrambotdeploy1.test;

import com.example.telegrambotdeploy1.botAPI.ButtonState;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBeck implements Test{

    int MAX_QUEST = 2;
    int current_quest = 0;
    int result = 0;

    List<String> quest = Arrays.asList(
            "Вопрос 1.\n" +
                    "1. Я не чувствую себя несчастным\n" +
                    "2. Я чувствую себя несчастным\n" +
                    "3. Я все время несчастен и не могу освободиться от этого чувства\n" +
                    "4. Я настолько несчастен и опечален, что не могу этого вынести",

            "Вопрос 2.\n" +
                    "1. Думая о будущем, я не чувствую себя особенно разочарованным\n" +
                    "2. Думая о будущем, я чувствую себя разочарованным\n" +
                    "3. Я чувствую, что мне нечего ждать в будущем\n" +
                    "4. Я чувствую, что будущее безнадежно и ничего не изменится к лучшему"
    );


    @Override
    public String getStartMessage() {
        return "Вы выбирали тест Бека." +
                "В этом тесте вам понадобится выбирать варианты ответа, наиболее близкие к вам.\n" +
                "Начнем тест?";
    }

    public boolean hasNextQuest() {
        return current_quest < MAX_QUEST;
    }

    public String getQuest() {
        return quest.get(current_quest);
    }

    public void setResult(String answer) {
        switch (answer) {
            case "TEST_1": case "1": result += 0; break;
            case "TEST_2": case "2": result +=1; break;
            case "TEST_3": case "3": result +=2; break;
            case "TEST_4": case "4": result += 3; break;
        }
        current_quest += 1;
    }

    public String getResult() {
        String textResult = "Произошел сбой.";
        if (result < 21) {
            textResult = "Все отлично";
        } else if (result >=21 && result < 42) {
            textResult = "Сомнительно";
        } else if (result >=42) {
            textResult = "Все плохо";
        }
        return "Ваш результат: " +
                String.valueOf(result) +
                ".\n" +
                textResult;

    }

    @Override
    public boolean checkAnswer(String answer) {
        switch (answer) {
            case "TEST_1": case "1":
            case "TEST_2": case "2":
            case "TEST_3": case "3":
            case "TEST_4": case "4":
                return true;
            default: return false;
        }
    }

    @Override
    public InlineKeyboardMarkup getKeybord() {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton().setText("1");
        button1.setCallbackData(ButtonState.TEST_1.name());
        InlineKeyboardButton button2 = new InlineKeyboardButton().setText("2");
        button2.setCallbackData(ButtonState.TEST_2.name());
        InlineKeyboardButton button3 = new InlineKeyboardButton().setText("3");
        button3.setCallbackData(ButtonState.TEST_3.name());
        InlineKeyboardButton button4 = new InlineKeyboardButton().setText("4");
        button4.setCallbackData(ButtonState.TEST_4.name());


        List<InlineKeyboardButton> keyboardButtonList1 = new ArrayList<>();
        keyboardButtonList1.add(button1);
        keyboardButtonList1.add(button2);
        List<InlineKeyboardButton> keyboardButtonList2 = new ArrayList<>();
        keyboardButtonList2.add(button3);
        keyboardButtonList2.add(button4);

        List<List<InlineKeyboardButton>> keyboardButtonList = new ArrayList<>();
        keyboardButtonList.add(keyboardButtonList1);
        keyboardButtonList.add(keyboardButtonList2);
        inlineKeyboardMarkup.setKeyboard(keyboardButtonList);

        return inlineKeyboardMarkup;
    }

    @Override
    public void rollbackQuest() {
        --current_quest;
    }

}
