import java.util.ArrayList;
import java.util.List;

class RevenueRecord {
    private int year;
    private double amount;

    public RevenueRecord(int year, double amount) {
        this.year = year;
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public double getAmount() {
        return amount;
    }
}

class ForecastEngine {
    private List<RevenueRecord> history;

    public ForecastEngine() {
        history = new ArrayList<>();
    }

    public void addRecord(RevenueRecord record) {
        history.add(record);
    }

    public double forecastNextYear() {
        if (history.size() < 2) return -1;

        double totalGrowth = 0;
        for (int i = 1; i < history.size(); i++) {
            double prev = history.get(i - 1).getAmount();
            double curr = history.get(i).getAmount();
            totalGrowth += (curr - prev) / prev;
        }

        double avgGrowthRate = totalGrowth / (history.size() - 1);
        double lastYearRevenue = history.get(history.size() - 1).getAmount();
        return lastYearRevenue * (1 + avgGrowthRate);
    }
}

public class FinancialForecastApp {
    public static void main(String[] args) {
        ForecastEngine engine = new ForecastEngine();
        engine.addRecord(new RevenueRecord(2020, 1_200_000));
        engine.addRecord(new RevenueRecord(2021, 1_500_000));
        engine.addRecord(new RevenueRecord(2022, 1_800_000));
        engine.addRecord(new RevenueRecord(2023, 2_000_000));

        double prediction = engine.forecastNextYear();
        System.out.printf("Predicted revenue for next year: %.2f%n", prediction);
    }
}
