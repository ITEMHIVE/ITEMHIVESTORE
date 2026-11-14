package za.ac.cput.Repository;
/*Listing.java
  ListingProduct
  Author: Sinobawo Nkomo(223174602)
  Date: 27 March 2026
 */

import za.ac.cput.domain.Listing;
import java.util.List;

public interface ListingRepository {

    Listing create(Listing listing);

    Listing read(String listingId);

    List<Listing> getAll();

    Listing update(Listing listing);

    boolean delete(String listingId);
}