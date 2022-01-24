package StrategyPattern3;

public interface PaymentType {
    public double getPaymentType();
}

class CreditCard implements PaymentType {

    @Override
    public double getPaymentType() {
        return 3.0;
    }
}

class DebitCard implements PaymentType {

    @Override
    public double getPaymentType() {
        return 0.0;
    }
}

class PayPal implements PaymentType {

    @Override
    public double getPaymentType() {
        return 3.0;
    }
}

