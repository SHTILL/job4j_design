package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class ConditionChat {
    private File f;
    private List<String> phrases = new ArrayList<>();
    private ChatState active = new ChatStateActive(this);
    private ChatState silent = new ChatStateSilent(this);
    private ChatState state = active;

    public ConditionChat(String path) throws IllegalArgumentException {
        this.f = new File(path);
        if (!f.isFile()) {
            throw new IllegalArgumentException("File " + f.getAbsolutePath() + "is not found");
        }
    }

    public void loadPhrases() throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String s;
            while ((s = r.readLine()) != null) {
                phrases.add(s);
            }
        } catch (Exception e) {
            throw new IOException("Can't read " + f.getAbsolutePath() + "file");
        }
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        String cmd;

        System.out.println("Испльзование");
        System.out.println("стоп|продолжить|закончить|?");

        while (!state.isTheChatOver()) {
            cmd = input.next();
            state.process(cmd);
        }

        System.out.println("Пока-пока!!!");
    }

    public ChatState getActiveState() {
        return active;
    }

    public ChatState getSilentState() {
        return silent;
    }

    public void setState(ChatState state) {
        this.state = state;
    }

    public void showMessage() {
        int listSize = phrases.size();
        int idx = (int) (Math.random() * listSize);
        System.out.println(phrases.get(idx));
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.print("Usage:" + System.lineSeparator() + "java -jar chat.jar FILE_NAME" + System.lineSeparator());
            throw new IllegalArgumentException();
        }

        ConditionChat c = new ConditionChat(args[0]);
        c.loadPhrases();
        c.run();
    }
}
