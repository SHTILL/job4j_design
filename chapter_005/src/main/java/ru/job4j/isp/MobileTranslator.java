package ru.job4j.isp;

public class MobileTranslator implements Translator {
    @Override
    public String translate(String phrase) {
        return null;
    }

    @Override
    public void sound(String phrase) {
        throw new IllegalArgumentException("Doesn't have such a functionality");
    }
}
