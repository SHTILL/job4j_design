package ru.job4j.io;

public class ChatStateSilent extends ChatState {
    public ChatStateSilent(ConditionChat chat) {
        super(chat);
    }

    @Override
    public void process(String cmd) {
        if (cmd.equals("продолжить")) {
            chat.setState(chat.getActiveState());
            chat.showMessage();
        }
        exit(cmd);
    }
}
