package za.ac.cput.itemhivesd2.service;

/*Chat Message Service Class
Kelly Pauline Nolte(218275358)
Date:25.July.2026*/

import za.ac.cput.itemhivesd2.domain.ChatMessage;

import java.util.HashMap;
import java.util.Map;

public class ChatMessageService implements IChatMessageService{
    private final Map<String, ChatMessage> chatMessages = new HashMap<>();

    @Override
    public ChatMessage create(ChatMessage chatMessage) {
        chatMessages.put(chatMessage.getMessageID(), chatMessage);
        return chatMessage;
    }

    @Override
    public ChatMessage read(String id) {
        return chatMessages.get(id);
    }

    @Override
    public ChatMessage update(ChatMessage chatMessage) {
        if(chatMessages.containsKey(chatMessage.getMessageID())) {
            chatMessages.put(chatMessage.getMessageID(), chatMessage);
            return chatMessage;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return chatMessages.remove(id) != null;
    }
}//end of class
