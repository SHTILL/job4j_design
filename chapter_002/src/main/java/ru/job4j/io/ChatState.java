package ru.job4j.io;

public abstract class ChatState {
    private boolean chatIsOver = false;
    protected ConditionChat chat;

    public ChatState(ConditionChat chat) {
        this.chat = chat;
    }

    public void exit(String s) {
        if (s.equals("закончить")) {
            chatIsOver = true;
        }
    }

    public boolean isTheChatOver () {
        return chatIsOver;
    }

    public abstract void process(String s);
}
