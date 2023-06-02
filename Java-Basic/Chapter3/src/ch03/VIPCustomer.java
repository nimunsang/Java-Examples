package ch03;

public class VIPCustomer extends Customer {

    private int agentID;
    double salesRatio;

    public VIPCustomer() {
        bonusRatio = 0.05;
        salesRatio = 0.1;
        
    }
}
