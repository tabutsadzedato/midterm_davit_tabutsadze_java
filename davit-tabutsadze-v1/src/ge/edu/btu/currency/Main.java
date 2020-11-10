package ge.edu.btu.currency;


import ge.edu.btu.currency.service.CurrencyService;
import ge.edu.btu.currency.service.impl.CurrencyServiceImpl;

public class Main {

    public static void main(String[] args) {
        CurrencyService cs = new CurrencyServiceImpl();
        cs.setExchangeRate(3);
        System.out.println(cs.convert(12));
        System.out.println(cs.convert(122.3));
    }


}