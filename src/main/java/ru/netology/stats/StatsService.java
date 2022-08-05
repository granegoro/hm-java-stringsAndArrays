package ru.netology.stats;

import java.security.PublicKey;

public class StatsService {

    //1.Сумма всех продаж
    public long sum(long[] sales) {
        long sum = 0;
        for (long sale : sales) {
            sum += sale;
        }
        return sum;
    }

    //2.Средняя сумма продаж в месяц
    public long avg(long[] sales) {
        return sum(sales) / 12;
    }


    //3. Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)
    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0;
        for (long sale : sales) {
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1;
        }
        return maxMonth + 1;
    }


    //4. Номер месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму)
    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }


    //5. Кол-во месяцев, в которых продажи были ниже среднего
    public int countBelowAvg(long[] sales) {
        int count = 0;
        long avg = avg(sales);
        for (long sale : sales) {
            if (sale < avg) {
                count++;
            }
        }
        return count;
    }

    //6. Кол-во месяцев, в которых продажи были выше среднего
    public int countAboveAvg(long[] sales) {
        int count = 0;
        long avg = avg(sales);
        for (long sale : sales) {
            if (sale > avg) {
                count++;
            }
        }
        return count;
    }

}
