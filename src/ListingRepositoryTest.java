package za.ac.cput.RepositoryTest;
/*Listing.java
  ListingProduct
  Author: Sinobawo Nkomo(223174602)
  Date: 27 March 2026
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Repository.ListingRepositoryImpl;
import za.ac.cput.domain.Listing;
import za.ac.cput.factory.ListingFactory;

import static org.junit.jupiter.api.Assertions.*;

class ListingRepositoryTest {

    private ListingRepositoryImpl repository;
    private Listing listing;

    @BeforeEach //used to reset data
    void setUp() {
        repository = ListingRepositoryImpl.getRepository();

        listing = ListingFactory.createNewItemListing(
                "22347603",
                "Test Book",
                "R100.00",
                "CAT-BOOKS",
                "Test Description"
        );

        // Clear repository before each test
        repository.getAll().clear();
    }

    @Test
    void create() {
        Listing created = repository.create(listing);

        assertNotNull(created);
        assertEquals(listing.getListingId(), created.getListingId());
    }

    @Test
    void read() {
        repository.create(listing);

        Listing found = repository.read(listing.getListingId());

        assertNotNull(found);
        assertEquals(listing.getListingId(), found.getListingId());
    }

    @Test
    void update() {
        repository.create(listing);

        Listing updated = new Listing.Builder(
                listing.getStudentId(),
                "Updated Book",
                "R150.00"
        )
                .listingId(listing.getListingId())
                .categoryId("CAT-BOOKS")
                .description("Updated Description")
                .condition("New")
                .build();

        Listing result = repository.update(updated);

        assertNotNull(result);
        assertEquals("Updated Book", result.getTitle());
        assertEquals("R150.00", result.getPrice());
    }

    @Test
    void delete() {
        repository.create(listing);

        boolean deleted = repository.delete(listing.getListingId());

        assertTrue(deleted);
        assertNull(repository.read(listing.getListingId()));
    }

    @Test
    void getAll() {
        repository.create(listing);

        assertFalse(repository.getAll().isEmpty());
        assertEquals(1, repository.getAll().size());
    }
}