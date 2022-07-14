package com.timur.telegramlovebot.service;

import com.timur.telegramlovebot.compliments.Compliment;
import com.timur.telegramlovebot.compliments.PhotoCompliment;
import com.timur.telegramlovebot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    final BotConfig config;
    @Autowired
    Compliment compliment;
    PhotoCompliment photoCompliment = new PhotoCompliment();
    public Bot(BotConfig botConfig){
        this.config = botConfig;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();

            long chatId = update.getMessage().getChatId();

            switch(messageText){
                case "/start":
                    startCommandReceived(chatId,update.getMessage().getChat().getFirstName());
                    break;
                case "/love":
                    loveCommandRecieved(chatId);
                    break;
                default:
            }

        }

    }

    private void startCommandReceived(long chatId, String name){
        String answer = "Приветики, "+ name+"!!!\n"+ "Выбери /love чтобы получить комплимент!";
        sendMessage(chatId,answer);
    }
    private void loveCommandRecieved(long chatId){
        String answer = compliment.getCompliment();
        sendMessage(chatId,answer);
    }

    private void defaultCommandRecieved(long chatId){
        String answer = "Извини, не знаю такой команды :(";
        sendMessage(chatId,answer);
    }

    private void sendMessage(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);



        try{
            execute(message);
        }catch (TelegramApiException e){
            System.out.println("lol");
        }
    }
}
