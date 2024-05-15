package Bus;

import DAO.AlbumDAO;
import DTO.AlbumsEntity;

import java.util.List;

public class AlbumBus {
    public List<AlbumsEntity> getAllAlbums() {
        return new AlbumDAO().getAllAlbums();
    }
}
