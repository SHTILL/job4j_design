package ru.job4j.io;

public class ChatStateActive extends ChatState {
    public ChatStateActive(ConditionChat chat) {
        super(chat);
    }

    @Override
    public void process(String cmd) {
        if (cmd.equals("стоп")) {
            chat.setState(chat.getSilentState());
        } else {
            chat.showMessage();
        }
        exit(cmd);
    }
}
