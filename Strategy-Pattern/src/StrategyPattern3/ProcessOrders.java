package StrategyPattern3;

public class ProcessOrders {

    private double total;
    private double itemCost = 0.0;

    PaymentType paymentType;
    SalesTax salesTax;
    Shipping shipping;

    public ProcessOrders(PaymentType paymentType, SalesTax salesTax, Shipping shipping) {
        this.paymentType = paymentType;
        this.salesTax = salesTax;
        this.shipping = shipping;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double checkout() {
        total = (itemCost + shipping.getShippingRate()) + (itemCost * (salesTax.getSalesTaxRate()/100)) + paymentType.getPaymentType();
        return total;
    }
}
