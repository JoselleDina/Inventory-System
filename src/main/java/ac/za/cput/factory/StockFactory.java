package ac.za.cput.factory;

/*
 *  @author: Sherwin Adams
 *  Desc: Factory for Stock Factory
 */

import ac.za.cput.entity.Stock;
import ac.za.cput.util.GenericHelper;

public class StockFactory
{
    public static Stock createStock(int quantity, String date)
    {
        String stockId = GenericHelper.generateId();
        Stock stock = new Stock.Builder()
                .setStockId(stockId)
                .setQuantity(quantity)
                .setDate(date)
                .build();
        return stock;
    }
}
