package no.solhaug.booking.jpaRepos;


import no.solhaug.booking.beans.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}

