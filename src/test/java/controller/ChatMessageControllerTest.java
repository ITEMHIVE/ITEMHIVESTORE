package controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.itemhivesd2.controller.ChatMessageController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*Chat Message Controller Test Class
Kelly Pauline Nolte(218275358)
Date:19.July.2026*/
@WebMvcTest(ChatMessageController.class)
class ChatMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void read() throws Exception {
        mockMvc.perform(get("/chatmessage/read/1"))
                .andExpect(status().isOk());
    }
}//end of class
