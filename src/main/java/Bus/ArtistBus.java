package Bus;

import DAO.ArtistDAO;
import DTO.ArtistsEntity;

import java.util.List;

public class ArtistBus {

    public List<ArtistsEntity> getAllArtists() {
        return new ArtistDAO().getAllArtists();
    }
}
