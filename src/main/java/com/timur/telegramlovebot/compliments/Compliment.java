package com.timur.telegramlovebot.compliments;


import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

@Component
public class Compliment {
    List<String> compliments = Files.readAllLines(new File("src/main/java/com/timur/telegramlovebot/compl.txt").toPath(), Charset.defaultCharset() );

    public Compliment() throws IOException {
    }

    public String getCompliment(){
        Random random = new Random();
        return compliments.get(random.nextInt(compliments.size()));
    }

}
