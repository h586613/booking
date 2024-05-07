package no.solhaug.booking.beans;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import no.solhaug.booking.other.BookingStatus;

import java.time.LocalDateTime;

//TODO: implement form binding??
@Entity
@Table(name = "bookings")
@Getter @Setter @NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Room room;
    @ManyToOne
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    private LocalDateTime dateBooked;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}

