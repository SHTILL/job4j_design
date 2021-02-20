package ru.job4j.lsp.food;

public class AcceptanceCriteriaSale extends AcceptanceCriteria {
    @Override
    public boolean checkQuality(Food f) {
        double p = AcceptanceCriteria.calcPercent(f);
        boolean goodForSale = (p <= 0.75 && p >= 0);
        if (goodForSale && p < 0.25) {
            f.setDiscount(0.5);
        }
        return goodForSale;
    }
}
