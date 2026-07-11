package service;
/*Chat Message Service Test Class
Kelly Pauline Nolte(218275358)
Date:25.July.2026*/

import org.junit.jupiter.api.*;
import za.ac.cput.itemhivesd2.domain.ChatMessage;
import za.ac.cput.itemhivesd2.factory.ChatMessageFactory;
import za.ac.cput.itemhivesd2.service.ChatMessageService;

import static org.junit.jupiter.api.Assertions.*;


    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ChatMessageServiceTest {

        private static ChatMessageService service;
        private static ChatMessage chatMessage;

        @BeforeAll
        static void setUp() {
            service = new ChatMessageService();

            chatMessage = ChatMessageFactory.createMessage(
                    "ST001",
                    "ST002",
                    "L001",
                    "Interested in your item"
            );
        }

        @Test
        @Order(1)
        void create() {
            ChatMessage created = service.create(chatMessage);
            assertNotNull(created);
        }

        @Test
        @Order(2)
        void read() {
            ChatMessage found = service.read(chatMessage.getMessageID());
            assertNotNull(found);
        }

        @Test
        @Order(3)
        void update() {

            ChatMessage updated = new ChatMessage.Builder()
                    .setMessageID(chatMessage.getMessageID())
                    .setSenderID(chatMessage.getSenderID())
                    .setReceiverID(chatMessage.getReceiverID())
                    .setListingID(chatMessage.getListingID())
                    .setMessageText(chatMessage.getMessageText())
                    .setStatus("READ")
                    .build();

            ChatMessage result = service.update(updated);

            assertEquals("READ", result.getStatus());
        }

        @Test
        @Order(4)
        void delete() {
            assertTrue(service.delete(chatMessage.getMessageID()));
        }

}//end of class
