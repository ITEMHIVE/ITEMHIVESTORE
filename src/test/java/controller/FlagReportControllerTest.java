package controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.itemhivesd2.controller.FlagReport;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*Flag Report Controller Test Class
Kelly Pauline Nolte(218275358)
Date:19.July.2026*/
@WebMvcTest(FlagReport.class)
class FlagReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void read() throws Exception {
        mockMvc.perform(get("/flagreport/read/1"))
                .andExpect(status().isOk());
    }
}//end of class
