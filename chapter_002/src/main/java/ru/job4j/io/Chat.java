package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Chat {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    private List<String> phrases = new ArrayList<>();
    private Map<String, Function<Chat, Boolean>> action = new HashMap<>();
    private File f;
    boolean mute = false;

    public Chat(String path) throws IllegalArgumentException {
        this.f = new File(path);
        if (!f.isFile()) {
            throw new IllegalArgumentException("File " + f.getAbsolutePath() + "is not found");
        }
    }

    public void addAction(String cmd, Function<Chat, Boolean> f) {
        action.put(cmd, f);
    }

    public void init() throws IOException {
        Scanner input = new Scanner(System.in);
        String cmd;
        boolean exit = false;
        int listSize = phrases.size();

        loadPhrases();
        System.out.println("Испльзование");
        System.out.println("стоп|продолжить|закончить|?");

        while (!exit) {
            cmd = input.next();
            Function<Chat, Boolean> f = action.get(cmd);
            if (f != null) {
                exit = f.apply(this);
            }
            if (!mute) {
                int idx = (int) (Math.random() * listSize);
                System.out.println(phrases.get(idx));
            }
        }
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    private void loadPhrases() throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String s;
            while ((s = r.readLine()) != null) {
                phrases.add(s);
            }
        } catch (Exception e) {
            throw new IOException("Can't read " + f.getAbsolutePath() + "file");
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.print("Usage:" + System.lineSeparator() + "java -jar chat.jar FILE_NAME" + System.lineSeparator());
                throw new IllegalArgumentException();
            }


            Chat c = new Chat(args[0]);
            c.addAction("стоп", chat -> {
                chat.setMute(true);
                return false;
            });
            c.addAction("продолжить", chat -> {
                chat.setMute(false);
                return false;
            });
            c.addAction("закончить", chat -> true);
            c.init();
        } catch (Exception e) {
            LOG.error("Exception", e);
        }
    }
}
