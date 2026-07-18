package za.ac.cput.itemhivesd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.itemhivesd2.domain.ChatMessage;
import za.ac.cput.itemhivesd2.service.ChatMessageService;

/* Chat Message Controller Class
   Kelly Pauline Nolte (218275358)
   Date: 19.July.2026
*/
@RestController
@RequestMapping("/chatmessage")
public class ChatMessageController {

    private final ChatMessageService service;

    @Autowired
    public ChatMessageController(ChatMessageService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ChatMessage create(@RequestBody ChatMessage chatMessage) {
        return service.create(chatMessage);
    }

    @GetMapping("/read/{id}")
    public ChatMessage read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public ChatMessage update(@RequestBody ChatMessage chatMessage) {
        return service.update(chatMessage);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}//end of class