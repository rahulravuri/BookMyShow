package com.BookMyShow.BookMyShow.DTO;
import com.BookMyShow.BookMyShow.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

    private int BookingId;
    private int PaymentID;
    private BookingStatus BookingStatus;
}
