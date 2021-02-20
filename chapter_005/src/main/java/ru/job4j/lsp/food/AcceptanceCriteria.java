package ru.job4j.lsp.food;

import static java.time.OffsetDateTime.now;
import static java.time.temporal.ChronoUnit.DAYS;

public abstract class AcceptanceCriteria {
    protected static double calcPercent(Food f) {
        long lifeTime = DAYS.between(f.getCreateDate().toInstant(), f.getExpiryDate().toInstant());
        long beforeExpired = DAYS.between(now().toInstant(), f.getExpiryDate().toInstant());
        return ((float) beforeExpired / lifeTime);
    }
    abstract boolean checkQuality(Food f);
}
