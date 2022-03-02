package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
