package com.timur.telegramlovebot.compliments;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhotoCompliment {
    Random random = new Random();
    public InputFile getPhoto(){
        InputFile inputFile = new InputFile();
        inputFile.setMedia("src/main/java/com/timur/telegramlovebot/photos"+random.nextInt(16) + ".png");
        return inputFile;
    }


}
