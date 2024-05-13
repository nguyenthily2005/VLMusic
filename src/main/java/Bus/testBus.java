package Bus;

import DTO.ArtistsEntity;
import DTO.FavoriteSong;
import DTO.SongsEntity;

import java.util.List;

public class testBus {
    public static void main(String[] args) {
        List<FavoriteSong> favoriteSongs = new FavoriteSongBus().getFavoriteSongs(1);
        for (FavoriteSong favoriteSong : favoriteSongs) {
            System.out.println(favoriteSong.getSongId());
        }

    }

}
