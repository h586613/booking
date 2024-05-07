package no.solhaug.booking.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.List;

//TODO: implement form binding
@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


}

