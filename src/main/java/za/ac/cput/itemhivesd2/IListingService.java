package za.ac.cput.service;
/*IService.java
  ListingProduct
  Author: Sinobawo Nkomo(223174602)
  Date: 21 June 2026
 */

import za.ac.cput.domain.Listing;

import java.util.List;

public interface IListingService{
    Listing create(Listing listing);

    Listing read(String listingId);

    Listing update(Listing listing);

    boolean delete(String listingId);

    List<Listing> getAll();
}
