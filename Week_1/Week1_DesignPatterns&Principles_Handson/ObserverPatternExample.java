
import java.util.*;

interface Observer {
    void update(String stockName, double newPrice);
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers(String stockName, double newPrice);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String stockName, double newPrice) {
        for (Observer observer : observers) {
            observer.update(stockName, newPrice);
        }
    }

    public void updateStockPrice(String stockName, double newPrice) {
        System.out.println("Stock updated: " + stockName + " -> $" + newPrice);
        notifyObservers(stockName, newPrice);
    }
}

class MobileApp implements Observer {
    public void update(String stockName, double newPrice) {
        System.out.println("MobileApp: " + stockName + " is now $" + newPrice);
    }
}

class WebApp implements Observer {
    public void update(String stockName, double newPrice) {
        System.out.println("WebApp: " + stockName + " is now $" + newPrice);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.updateStockPrice("AAPL", 180.75);
        stockMarket.updateStockPrice("GOOGL", 2725.50);

        stockMarket.deregisterObserver(webApp);

        stockMarket.updateStockPrice("TSLA", 695.20);
    }
}
