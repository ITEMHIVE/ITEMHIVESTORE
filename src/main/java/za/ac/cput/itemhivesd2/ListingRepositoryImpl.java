package za.ac.cput.Repository;
/*Listing.java
  ListingProduct
  Author: Sinobawo Nkomo(223174602)
  Date: 27 March 2026
 */

import za.ac.cput.domain.Listing;
import java.util.ArrayList;
import java.util.List;

public class ListingRepositoryImpl implements ListingRepository {

    private static ListingRepositoryImpl repository = null;
    private final List<Listing> listingList;

    // Private constructor (Singleton)
    public ListingRepositoryImpl() {
        listingList = new ArrayList<>();
    }

    // Singleton instance
    public static ListingRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new ListingRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Listing create(Listing listing) {
        listingList.add(listing);
        return listing;
    }

    @Override
    public Listing read(String listingId) {
        for (Listing listing : listingList) {
            if (listing.getListingId().equals(listingId)) {
                return listing;
            }
        }
        return null;
    }

    @Override
    public List<Listing> getAll() {
        return listingList;
    }

    @Override
    public Listing update(Listing listing) {
        Listing existingListing = read(listing.getListingId());

        if (existingListing != null) {
            listingList.remove(existingListing);
            listingList.add(listing);
            return listing;
        }

        return null;
    }

    @Override
    public boolean delete(String listingId) {
        Listing listing = read(listingId);

        if (listing != null) {
            listingList.remove(listing);
            return true;
        }

        return false;
    }
}