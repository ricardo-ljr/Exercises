package StrategyPattern3;

public interface SalesTax {

    public double getSalesTaxRate();
}

class Utah implements SalesTax {

    @Override
    public double getSalesTaxRate() {
        return 4.85;
    }
}

class California implements SalesTax {

    @Override
    public double getSalesTaxRate() {
        return 7.25;
    }
}

class Arizona implements SalesTax {

    @Override
    public double getSalesTaxRate() {
        return 5.6;
    }
}
