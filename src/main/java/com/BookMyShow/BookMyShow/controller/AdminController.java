package com.BookMyShow.BookMyShow.controller;

import com.BookMyShow.BookMyShow.DTO.BookdetailsDTO;
import com.BookMyShow.BookMyShow.DTO.NewShowDTO;
import com.BookMyShow.BookMyShow.Security.UserVerification;
import com.BookMyShow.BookMyShow.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Admin")
public class AdminController {


    UserVerification userverification;

    AdminController(UserVerification userverificatione){
        this.userverification=userverification;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> BookTickets(@RequestBody NewShowDTO NewShowDTO, @CookieValue(name = "Bearer", defaultValue = "") String token) throws Exception {
        Map<String, String> re = new HashMap<>();
        if(!userverification.userverification(token,"Admin")){
            re.put("Status","InvalidUser");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(re);
        }
        try{
            re.put("Status", "Shows Creation Process Started");
        } catch (Exception e) {
            re.put("Status", e.getMessage()); ;
        }
        return ResponseEntity.status(HttpStatus.OK).body(re);
    }
}
