package ge.edu.btu.currency.service;

public interface CurrencyService {
    public double convert(int amount);
    public double convert(double amount);

    public void setExchangeRate(int amount);
    public void setExchangeRate(double amount);
}