package Bus;

import DAO.SongDAO;
import DTO.SongsEntity;

import java.util.List;

public class SongBus {
    public List<SongsEntity> getAllSongs() {
        return new SongDAO().getAllSongs();
    }
}
