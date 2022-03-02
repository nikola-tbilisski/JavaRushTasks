package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BotClient extends Client {
    public static void main(String[] args) {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x = (int) (Math.random() * (99) + 1);
        return "date_bot_" + x;
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            //new BotClient().sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            String name, text;
            String[] splResult;
            SimpleDateFormat dateFormat;

            ConsoleHelper.writeMessage(message);
            if(message == null) return;
            if(message.split(": ").length == 2) {
                splResult = message.split(": ");
                name = splResult[0];
                text = splResult[1];

                switch (text) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        break;
                    default:
                        dateFormat = null;
                }
                if (dateFormat != null) {
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                }
                else {
                    Map<String, String> botMap = new HashMap<>();

                    botMap.put("hi there", "Hi dude");
                    botMap.put("how are you man", "Working all day long, what about you?");
                    botMap.put("same shit", "I really understand you dude :)))");

                    String pat = botMap.get(text.toLowerCase());
                    if(pat == null) return;
                    sendTextMessage(pat);
                }
            }

        }
    }


}
