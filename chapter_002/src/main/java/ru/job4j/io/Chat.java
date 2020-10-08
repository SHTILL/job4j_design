package ru.job4j.io;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Chat {
    private Scanner input;
    private List<String> phrases = new ArrayList<>();
    private File f;

    public Chat(String path) throws IllegalArgumentException {
        this.f = new File(path);
        if (!f.isFile()) {
            throw new IllegalArgumentException("File " + f.getAbsolutePath() + "is not found");
        }
    }

    public void init() throws IOException {
        Scanner input = new Scanner(System.in);
        String cmd;
        boolean showPhrases = true;
        loadPhrases();
        int listSize = phrases.size();
        System.out.println("Испльзование");
        System.out.println("стоп|продолжить|закончить|?");

        while (input.hasNext()) {
            cmd = input.next();
            if (cmd.equals("стоп")) {
                showPhrases = false;
            }
            if (cmd.equals("продолжить")) {
                showPhrases = true;
            }
            if (cmd.equals("закончить")) {
                System.out.print("Пока-пока!!!");
                break;
            }
            if (showPhrases) {
                int idx = (int) (Math.random() * listSize);
                System.out.println(phrases.get(idx));
            }
        }
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

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.print("Usage:" + System.lineSeparator() + "java -jar chat.jar FILE_NAME" + System.lineSeparator());
            throw new IllegalArgumentException();
        }

        Chat c = new Chat(args[0]);
        c.init();
    }
}
