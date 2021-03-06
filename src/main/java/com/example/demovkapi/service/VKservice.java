package com.example.demovkapi.service;

import com.example.demovkapi.dto.friendsdto.FriendsResponseDTO;
import com.example.demovkapi.dto.sendmessagedto.Sendmessagedto;
import com.example.demovkapi.exceptions.VKBadResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class VKservice {

    final String apiVkMethod = "https://api.vk.com/method/";
    final String friendsGet = "friends.get?";
    final String messagesSend = "messages.send?";
    final String meUser = "user_id=4338407";

    @Autowired
    RestTemplate restTemplate;

    @Value("${vk.token}")
    private String accessToken;

    /*
        sending method to get JSON response of
     */
    public FriendsResponseDTO getFriends() {

        HttpHeaders headers = new HttpHeaders();
        //headers.add("access_token", accessToken);
        RequestEntity<Void> requestEntity = new RequestEntity<Void>(headers, HttpMethod.GET, URI.create("https://api.vk.com/method/friends.get?user_id=4338407&fields=nickname, domain, sex, bdate, city&access_token=403b06020d4a983a326cf4656819ee3f8dc52b31f7a4d5d044802d3268f866a17e54f8136e2bd062f8315&v=5.52"));
        ResponseEntity<FriendsResponseDTO> response = restTemplate.exchange(requestEntity, FriendsResponseDTO.class);
        //     ResponseEntity<FriendsResponseDTO> response = restTemplate.exchange("https://api.vk.com/method/friends.get?user_id=4338407&fields=nickname, domain, sex, bdate, city&access_token=403b06020d4a983a326cf4656819ee3f8dc52b31f7a4d5d044802d3268f866a17e54f8136e2bd062f8315&v=5.52", HttpMethod.GET, requestEntity, FriendsResponseDTO.class);

        if (response.getStatusCode().is5xxServerError() || response.getStatusCode().is4xxClientError())
            throw new VKBadResponseException(response.getStatusCodeValue());
        return response.getBody();

    }
    /*
      sending template message after "/send" on service pushed
     */


    public Sendmessagedto sendMessage() {
        // HttpHeaders headers = new HttpHeaders();
        //headers.add("access_token", "f43a8a602c0e555e640de4c5e3b55820771fd23c11f34125d45eac82ed6b97038674d735d8d64b86fcb4f");
        RequestEntity<Void> requestEntity = new RequestEntity<Void>(HttpMethod.POST, URI.create("https://api.vk.com/method/messages.send?user_id=4338407&message=ИДИ&v=5.68&access_token=f43a8a602c0e555e640de4c5e3b55820771fd23c11f34125d45eac82ed6b97038674d735d8d64b86fcb4f"));
        ResponseEntity<Sendmessagedto> response = restTemplate.exchange(requestEntity, Sendmessagedto.class);
        return response.getBody();
    }
}
