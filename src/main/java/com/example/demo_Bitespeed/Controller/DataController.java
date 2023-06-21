package com.example.demo_Bitespeed.Controller;

import com.example.demo_Bitespeed.Enitity.Dto;
import com.example.demo_Bitespeed.Enitity.ResponseDto;
import com.example.demo_Bitespeed.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    DataService dataService;

    @PostMapping("/save")
    public String Create(@RequestBody Dto dto) {
        String response = dataService.createData(dto);
        return response;
    }

    @GetMapping("/identify")
    public ResponseDto Identify(@RequestBody Dto dto) {
        return dataService.identifyDto(dto);
    }
}
