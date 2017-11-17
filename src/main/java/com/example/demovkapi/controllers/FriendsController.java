package com.example.demovkapi.controllers;

import com.example.demovkapi.dto.friendsdto.FriendsResponseDTO;
import com.example.demovkapi.dto.sendmessagedto.Sendmessagedto;
import com.example.demovkapi.service.VKservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsController {

    @Autowired
    private VKservice vKservice;

    @RequestMapping(value ="/friends", method = RequestMethod.GET)
    public FriendsResponseDTO getFriendsList(){
        FriendsResponseDTO friend = vKservice.getFriends();
        return friend;
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public Sendmessagedto responseOfSend(){
        Sendmessagedto sendmessagedto = vKservice.sendMessage();
        return sendmessagedto;
    }



    }

