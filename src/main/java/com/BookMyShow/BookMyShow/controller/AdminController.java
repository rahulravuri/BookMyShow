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
import com.BookMyShow.BookMyShow.services.ShowService;

@RestController
@RequestMapping("/Admin")
public class AdminController {


    UserVerification userverification;
    ShowService ShowService;

    AdminController(UserVerification userverificatione,ShowService ShowService){
        this.userverification=userverification;
        this.ShowService=ShowService;
    }

    @PostMapping("/Add")
    public ResponseEntity<Map<String, String>> CreateShows(@RequestBody NewShowDTO NewShowDTO, @RequestHeader("X-User-Id") String userId,
                                                           @RequestHeader("X-User-Roles") String roles) throws Exception {
        Map<String, String> re = new HashMap<>();

        try{
            ShowService.createshows(NewShowDTO);
            re.put("Status", "Shows Creation Process Started");
        } catch (Exception e) {
            re.put("Status", e.getMessage()); ;
        }
        return ResponseEntity.status(HttpStatus.OK).body(re);
    }

    @PostMapping("/Delete")
    public ResponseEntity<Map<String, String>> DeleteShow(@RequestBody int ShowId, @RequestHeader("X-User-Id") String userId,
                                                           @RequestHeader("X-User-Roles") String roles) throws Exception {
        Map<String, String> re = new HashMap<>();

        try{
            ShowService.CancelShow(ShowId);

            re.put("Status", "Shows Deleted");
        } catch (Exception e) {
            re.put("Status", e.getMessage()); ;
        }
        return ResponseEntity.status(HttpStatus.OK).body(re);
    }


}
