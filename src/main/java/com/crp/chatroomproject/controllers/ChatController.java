package com.crp.chatroomproject.controllers;

import com.crp.chatroomproject.models.Message;
import com.crp.chatroomproject.models.MessageRequest;
import com.crp.chatroomproject.services.ChatService;
import com.crp.chatroomproject.services.PageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    PageDataService pageDataService;
    ChatService chatService;
    @Autowired
    public ChatController(PageDataService pageDataService, ChatService chatService) {
        this.pageDataService = pageDataService;
        this.chatService = chatService;
    }

    @GetMapping("/chatRoom/{userId}")
    public String showRoomPage(Model model, @PathVariable Long userId){
        model.addAttribute("appTitle", pageDataService.getAppTitle());
        model.addAttribute("pageInfo", pageDataService.getPage("chatRoom"));
        model.addAttribute("availablePages", pageDataService.getPages());
        model.addAttribute("userId", userId);
        model.addAttribute("messages", chatService.getMessages());
        return "chatRoom";
    }
    @PostMapping("/sendMessage")
    public String handleSendMessage(MessageRequest messageRequest){
        try {
            chatService.createMessage(messageRequest);
            return "redirect:chatRoom/"+ messageRequest.getUserId();
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:chatRoom/" + messageRequest.getUserId()
                    +"?status=message_send_failed&message="+e.getMessage();
        }
    }
}
