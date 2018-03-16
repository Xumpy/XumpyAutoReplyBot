package com.xumpy.autoreplybot;

import com.xumpy.autoreplybot.messages.AutoReplyManager;
import com.xumpy.autoreplybot.messages.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class AutoReplyBot extends TelegramLongPollingBot{

    @Autowired ReplyMessage replyMessage;
    @Autowired AutoReplyManager autoReplyManager;

    @PostConstruct
    public void registerBot() throws TelegramApiException{
        TelegramBotsApi botsApi = new TelegramBotsApi();
        botsApi.registerBot(this);
    }

    private void sendReply(Update update, String reply){
        long chat_id = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
        message.setParseMode("markdown");
        message.setChatId(chat_id);
        message.setText(reply);
        try {
            execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            List<String> replies = autoReplyManager.manage(message_text);

            for(String reply: replies){
                sendReply(update, reply);
            }
        }
    }

    public String getBotUsername() {
        return "AutoReplyBot";
    }

    public String getBotToken() {
        return "nietvoorjouwoogjes";
    }
}
