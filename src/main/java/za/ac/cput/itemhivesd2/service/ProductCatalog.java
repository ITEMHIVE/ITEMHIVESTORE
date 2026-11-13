package za.ac.cput.transactionentity.service;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Map;

import static java.util.Map.entry;

@Component
public class ProductCatalog {
    public record ProductInfo(String name, BigDecimal price) {}

    private final Map<Integer, ProductInfo> products = Map.ofEntries(
            entry(1,  new ProductInfo("Rainbow Mouse",      new BigDecimal("200.00"))),
            entry(2,  new ProductInfo("Grey Laptop",        new BigDecimal("5000.00"))),
            entry(3,  new ProductInfo("White Printer",      new BigDecimal("2500.00"))),
            entry(4,  new ProductInfo("Computer SSD",       new BigDecimal("250.00"))),
            entry(6,  new ProductInfo("White Headphones",   new BigDecimal("300.00"))),
            entry(7,  new ProductInfo("Black Headphones",   new BigDecimal("250.00"))),
            entry(8,  new ProductInfo("Rainbow Printer",    new BigDecimal("600.00"))),
            entry(9,  new ProductInfo("Rainbow USB",        new BigDecimal("100.00"))),
            entry(10, new ProductInfo("Black Monitor",      new BigDecimal("7000.00"))),
            entry(11, new ProductInfo("Black Monitor",      new BigDecimal("6500.00"))),
            entry(12, new ProductInfo("Rainbow Headphones", new BigDecimal("7000.00"))),
            entry(14, new ProductInfo("Keyboard & Mouse",   new BigDecimal("3500.00"))),
            entry(15, new ProductInfo("Keyboard & Mouse",   new BigDecimal("5000.00"))),
            entry(16, new ProductInfo("3D Printer",         new BigDecimal("10000.00"))),
            entry(17, new ProductInfo("Sleek Monitor",      new BigDecimal("4000.00"))),
            entry(18, new ProductInfo("Apple Monitor",      new BigDecimal("12000.00"))),
            entry(19, new ProductInfo("White SSD",          new BigDecimal("400.00"))),
            entry(20, new ProductInfo("Apple Monitor",      new BigDecimal("11000.00")))
    );

    public ProductInfo find(int id) {
        return products.get(id);
    }
}