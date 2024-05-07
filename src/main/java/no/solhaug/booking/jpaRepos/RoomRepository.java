package no.solhaug.booking.jpaRepos;



import no.solhaug.booking.beans.Room;
import no.solhaug.booking.other.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByRoomStatus(RoomStatus status);
}

