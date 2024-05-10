package Bus;

import DAO.PlaylistSongsDAO;
import DTO.PlaylistSongsEntity;

import java.util.List;

public class PlayListSongsBus {

    public List<PlaylistSongsEntity> getAllPlaylistSongs() {
        return new PlaylistSongsDAO().getAllPlaylistSongs();
    }
}
