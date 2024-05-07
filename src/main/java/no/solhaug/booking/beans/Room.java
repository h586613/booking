package no.solhaug.booking.beans;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import no.solhaug.booking.other.RoomStatus;

import java.util.List;

//TODO: implement form binding??

@Entity
@Table(name = "rooms")
@Getter @Setter @NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;
    private String name;
    private String roomNumber;
    private int capacity;


}
