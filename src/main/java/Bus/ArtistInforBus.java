package Bus;

import DAO.ArtistInforDAO;
import DTO.ArtistInfor;

import java.util.List;

public class ArtistInforBus {

    public List<ArtistInfor> getArtistInfors(String filePath) {
        return ArtistInforDAO.parseArtists(filePath);
    }

}