package no.solhaug.booking.controllers;

import lombok.RequiredArgsConstructor;
import no.solhaug.booking.beans.Booking;
import no.solhaug.booking.beans.Customer;
import no.solhaug.booking.beans.Room;
import no.solhaug.booking.other.BookingStatus;
import no.solhaug.booking.other.RoomStatus;
import no.solhaug.booking.service.BookingService;
import no.solhaug.booking.service.CustomerService;
import no.solhaug.booking.service.RoomService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    private final RoomService roomService;

    private final CustomerService customerService;

@PostMapping("/submitBooking")
public String acceptBooking (@RequestParam(name = "room") Room room,
                             @RequestParam(name = "customer") Customer customer,
                             @RequestParam(name="startDate") LocalDateTime startDate,
                             @RequestParam(name="endDate") LocalDateTime endDate){
    Booking booking = new Booking();
    booking.setDateBooked(LocalDateTime.now());
    booking.setRoom(room);
    booking.setCustomer(customer);
    booking.setStartDate(startDate);
    booking.setEndDate(endDate);
    booking.setStatus(BookingStatus.CONFIRMED);
    bookingService.bookRoom(booking);


    return "redirect:/confirmation";
}

    @GetMapping("/index")
    public String index (){
        return "index";
    }


@GetMapping("/booking")
    public String booking (Model model){
        model.addAttribute("rooms",roomService.getAvailableRooms());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "bookingForm";
    }

    @GetMapping("/confirmation")
    public String confirmation (){
        return "confirmation";
    }

}

