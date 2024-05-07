package no.solhaug.booking.service;


import lombok.RequiredArgsConstructor;
import no.solhaug.booking.beans.Room;
import no.solhaug.booking.jpaRepos.RoomRepository;
import no.solhaug.booking.other.RoomStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

@Transactional
public List<Room> getAvailableRooms() {
    return roomRepository.findByRoomStatus(RoomStatus.AVAILABLE);
}

}
