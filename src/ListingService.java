package za.ac.cput.service;
/*ListingService.java
  ListingProduct
  Author: Sinobawo Nkomo(223174602)
  Date: 21 June 2026
 */

import za.ac.cput.Repository.ListingRepositoryImpl;
import za.ac.cput.domain.Listing;

import java.util.List;

@Service
public class ListingService implements IListingService {

    private final ListingRepositoryImpl repository;

    private static ListingService service = null;

    private ListingService() {
        this.repository = ListingRepositoryImpl.getRepository();
    }

    public static ListingService getService() {
        if (service == null) {
            service = new ListingService();
        }
        return service;
    }

    @Override
    public Listing create(Listing listing) {
        return repository.create(listing);
    }

    @Override
    public Listing read(String listingId) {
        return repository.read(listingId);
    }

    @Override
    public Listing update(Listing listing) {
        return repository.update(listing);
    }

    @Override
    public boolean delete(String listingId) {
        return repository.delete(listingId);
    }

    @Override
    public List<Listing> getAll() {
        return repository.getAll();
    }
}