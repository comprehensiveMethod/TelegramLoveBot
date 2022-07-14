package com.timur.telegramlovebot;

import com.timur.telegramlovebot.compliments.Compliment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TelegramLoveBotApplicationTests {
    @Autowired
    Compliment compliment;
    @Test
    void complimentWorking() {
        System.out.println(compliment.getCompliment());
        Assert.isTrue(!compliment.getCompliment().isEmpty(),"lol");

    }

}
