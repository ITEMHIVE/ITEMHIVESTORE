package service;

import org.junit.jupiter.api.*;
import za.ac.cput.itemhivesd2.domain.FlagReport;
import za.ac.cput.itemhivesd2.factory.FlagReportFactory;
import za.ac.cput.itemhivesd2.service.FlagReportService;

import static org.junit.jupiter.api.Assertions.*;
/*Flag Report Service Test Class
Kelly Pauline Nolte(218275358)
Date:25.July.2026*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FlagReportServiceTest {

    private static FlagReportService service;
    private static FlagReport flagReport;

    @BeforeAll
    static void setUp() {

        service = new FlagReportService();

        flagReport = FlagReportFactory.createFlagReport(
                "ST001",
                "L001",
                "Spam",
                "Duplicate listing"
        );
    }

    @Test
    @Order(1)
    void create() {
        FlagReport created = service.create(flagReport);
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        FlagReport found = service.read(flagReport.getFlagID());
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {

        FlagReport updated = new FlagReport.Builder()
                .setFlagID(flagReport.getFlagID())
                .setStudentID(flagReport.getStudentID())
                .setListingID(flagReport.getListingID())
                .setReason(flagReport.getReason())
                .setDescription(flagReport.getDescription())
                .setStatus("Resolved")
                .build();

        FlagReport result = service.update(updated);

        assertEquals("Resolved", result.getStatus());
    }

    @Test
    @Order(4)
    void delete() {
        assertTrue(service.delete(flagReport.getFlagID()));
    }
}//end of class
