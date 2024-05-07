package no.solhaug.booking.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import no.solhaug.booking.beans.Customer;
import no.solhaug.booking.beans.Room;
import no.solhaug.booking.other.RoomStatus;
import no.solhaug.booking.service.BookingService;
import no.solhaug.booking.service.CustomerService;
import no.solhaug.booking.service.RoomService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;


    @PostMapping("/submitRoomDetails")
    public String roomDetails (@RequestParam(name="name") String name,
                               @RequestParam(name="roomNumber") String roomNumber,
                               @RequestParam(name="capacity") int capacity){


        Room room = new Room();
        room.setName(name);
        room.setRoomNumber(roomNumber);
        room.setCapacity(capacity);
        room.setRoomStatus(RoomStatus.AVAILABLE);

        roomService.saveRoom(room);

        return "redirect:/roomCreatedConfirmation";
    }






    @GetMapping(value="/room")
    public String roomForm() {
        return "roomForm";
    }
    @GetMapping(value="/roomCreatedConfirmation")
    public String roomCreatedConfirmation() {
        return "roomCreatedConfirmation";
    }

}
