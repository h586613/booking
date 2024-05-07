package no.solhaug.booking.service;


import lombok.RequiredArgsConstructor;
import no.solhaug.booking.beans.Booking;
import no.solhaug.booking.beans.Customer;
import no.solhaug.booking.beans.Room;
import no.solhaug.booking.jpaRepos.BookingRepository;
import no.solhaug.booking.other.BookingStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    @Transactional
    public Booking bookRoom(Booking booking){
        return bookingRepository.save(booking);
    }


    @Transactional //all or nuthin', baby
    public Booking cancelBooking(Long id){
        Booking booking = bookingRepository.findById(id).get();
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking); //make it a habit to return the object you persist
    }
}
