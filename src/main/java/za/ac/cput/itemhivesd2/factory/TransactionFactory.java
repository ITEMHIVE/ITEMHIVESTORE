package za.ac.cput.transactionentity.factory;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import za.ac.cput.transactionentity.domain.Transaction;
import za.ac.cput.transactionentity.util.Helper;
/*
TransactionFactory.java
Transaction factory model class
Author:Athini Ngquke(222352302)
Date: 18 March 2026
 */
import java.time.LocalDate;
import java.util.UUID;

public class TransactionFactory {
    public static Transaction createTransaction(String transactionId, String buyerId, String sellerId, String listing, int quantity,double price,double total, LocalDate pdate) {
        if(Helper.isNullOrEmpty(transactionId)){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(Helper.isNullOrEmpty(buyerId)){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(Helper.isNullOrEmpty(sellerId)){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(Helper.isNullOrEmpty(listing)){
            throw new IllegalArgumentException("Id cannot be null");
        }
        if(quantity<0){
            throw new IllegalArgumentException("quantity cannot zero");
        }
        if(price<0){
            throw new IllegalArgumentException("price cannot be less than zero");
        }
        if(total<0){
            throw new IllegalArgumentException("total cannot be less than zero");
        }
        if(pdate==null){
            throw new IllegalArgumentException("date cannot be null");
        }
        return new Transaction.Builder()
                .setTransactionId(generatedId(transactionId))
                .setBuyerId(buyerId)
                .setSellerId(sellerId)
                .setListing(listing)
                .setQuantity(quantity)
                .setPrice(price)
                .setTotal(total)
                .setPdate(pdate)
                .build();
    }
private static String generatedId(String id){
   return "ID"+ UUID.randomUUID().toString();
}

}
