package StrategyPattern3;

public interface Shipping {
    public double getShippingRate();
}

class WestCoast implements Shipping {

    @Override
    public double getShippingRate() {
        return 10.0;
    }
}

class EastCoast implements Shipping {

    @Override
    public double getShippingRate() {
        return 20.0;
    }
}
