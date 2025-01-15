package com.BookMyShow.BookMyShow.controller;

import com.BookMyShow.BookMyShow.DTO.PaymentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BookMyShow.BookMyShow.DTO.BookdetailsDTO;
import com.BookMyShow.BookMyShow.services.BookingService;

import java.util.HashMap;
import java.util.Map;
import com.BookMyShow.BookMyShow.Security.UserVerification;

@RestController
@RequestMapping("/Booking")
public class BookingController {

	private final BookingService BookingService;

	UserVerification userverification;
	
	BookingController(BookingService BookingService, UserVerification userverificatione){
		this.BookingService=BookingService;
		this.userverification=userverification;
	}
	
	@PostMapping("/book")
	public ResponseEntity<Map<String, String>> BookTickets(@RequestBody BookdetailsDTO BookdetailsDTO,@CookieValue(name = "Bearer", defaultValue = "") String token) throws Exception {
		Map<String, String> re = new HashMap<>();
		if(!userverification.userverification(token,"User")){
			re.put("Status","InvalidUser");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(re);
		}
		try{

		BookingService.BookTicket(BookdetailsDTO);
			re.put("Booking Status", "Locked");
			re.put("PaymentLink", "paymentlink/38/23");
		} catch (Exception e) {
			re.put("Booking Status", e.getMessage()); ;
		}
		return ResponseEntity.status(HttpStatus.OK).body(re);
	}

	@PostMapping("/clear")
	public ResponseEntity<Map<String, String>> CleatTickets(@RequestBody PaymentDTO PaymentDTO) throws Exception {
		Map<String, String> re = new HashMap<>();
		try{
			BookingService.PaymentStatustickets(PaymentDTO);
			re.put("Status", "Cleared");
		} catch (Exception e) {
			re.put(" Status", e.getMessage()); ;
		}
		return ResponseEntity.status(HttpStatus.OK).body(re);
	}

}
