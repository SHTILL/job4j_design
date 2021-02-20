package ru.job4j.lsp.food;

public class AcceptanceCriteriaStore extends AcceptanceCriteria {
    @Override
    public boolean checkQuality(Food f) {
        return AcceptanceCriteria.calcPercent(f) > 0.75;
    }
}