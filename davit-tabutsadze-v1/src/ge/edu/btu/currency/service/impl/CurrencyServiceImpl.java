package ge.edu.btu.currency.service.impl;

import ge.edu.btu.currency.service.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService {
    private double ExchangeRate;

    public CurrencyServiceImpl(){
        this.ExchangeRate = 0;
    }

    public double convert(int amount) {
        return amount/ExchangeRate;
    }
    public double convert(double amount){
        return amount/ExchangeRate;
    }

    public void setExchangeRate(int amount) {
        this.ExchangeRate = amount;
    }
    public void setExchangeRate(double amount) {
        this.ExchangeRate = amount;
    }
}