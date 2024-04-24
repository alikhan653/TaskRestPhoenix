package kz.iitu.taskrestphoenix.rest;

import kz.iitu.taskrestphoenix.dto.ObjectRequestDto;
import kz.iitu.taskrestphoenix.dto.UserRegisterDto;
import kz.iitu.taskrestphoenix.model.News;
import kz.iitu.taskrestphoenix.model.ObjectRequest;
import kz.iitu.taskrestphoenix.model.User;
import kz.iitu.taskrestphoenix.service.NewsService;
import kz.iitu.taskrestphoenix.service.ObjectRequestService;
import kz.iitu.taskrestphoenix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/request/")
public class RequestRestControllerV1 {

    private final ObjectRequestService objectRequestService;
    private final NewsService newsService;



    @Autowired
    public RequestRestControllerV1(ObjectRequestService objectRequestService, NewsService newsService) {
        this.objectRequestService = objectRequestService;
        this.newsService = newsService;
    }

    @PostMapping("addObject")
    public ResponseEntity addObject(@RequestBody ObjectRequestDto objectRequestDto) {
        try {
            ObjectRequest objectRequest = new ObjectRequest();
            objectRequest.setName(objectRequestDto.getName());
            objectRequest.setPhone(objectRequestDto.getPhone());
            objectRequest.setAddress(objectRequestDto.getAddress());
            objectRequest.setPhone(objectRequestDto.getPhone());

            objectRequestService.create(objectRequest);

            return ResponseEntity.ok("Object added successfully");


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("showNews")
    public List<News> showNews() {
        return newsService.getNews();
    }
}
