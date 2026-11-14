package za.ac.cput.main;
/*Main.java
  ListingProduct
  Author: Sinobawo Nkomo(223174602)
  Date: 27 March 2026
 */
import za.ac.cput.domain.Listing;
import za.ac.cput.factory.ListingFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        String studentId  = "22347603";
        String sellerName = "Sinobawo Nkomo";


        Listing item1 = ListingFactory.createNewItemListing(
                studentId,
                "Calculus Textbook",
                "R180.00",
                "CAT-BOOKS",
                "Brand new, never opened. Comes with solution manual.");

        Listing item2 = ListingFactory.createSecondHandListing(
                studentId,
                "HP Laptop Charger",
                "R120.00",
                "CAT-ELECTRONICS",
                "Works perfectly, compatible with most HP models.");

        Listing item3 = ListingFactory.createLikeNewListing(
                studentId,
                "Scientific Calculator",
                "R95.00",
                "CAT-STATIONERY",
                "Used for one semester only, all functions intact.");

        Listing item4 = ListingFactory.createFreeItemListing(
                studentId,
                "2023 Lecture Notes - Data Structures",
                "CAT-NOTES",
                "Full set of notes from DSA101. Free to a good home.");

        Listing item5 = ListingFactory.createDraftListing(
                studentId,
                "Wireless Mouse",
                "R75.00");

        List<Listing> sellerListings = List.of(item1, item2, item3, item4, item5);


        System.out.println("\n-----------------------------");
        System.out.println(" Student Marketplace - Seller Portal  ");
        System.out.println("-------------------------------");
        System.out.println("Seller : " + sellerName + " (" + studentId + ")");
        System.out.println("Total items listed : " + sellerListings.size());
        System.out.println("---------------------------------");

        for (int i = 0; i < sellerListings.size(); i++) {
            Listing list = sellerListings.get(i);
            System.out.println("\n  Item " + (i + 1));
            System.out.println("  Title       : " + list.getTitle());
            System.out.println("  Price       : " + list.getPrice());
            System.out.println("  Condition   : " + list.getCondition());
            System.out.println("  Category    : " + list.getCategoryId());
            System.out.println("  Description : " + list.getDescription());
            System.out.println("  Listing ID  : " + list.getListingId());
        }

        System.out.println("\n-------------------");
        System.out.println("Items have been listed. Good luck with your sales!");
    }
}