package Bus;

import DTO.ArtistsEntity;
import DTO.FavoriteSong;
import DTO.PlaylistsEntity;
import DTO.SongsEntity;

import java.util.List;

public class testBus {
    public static void main(String[] args) {
        List<PlaylistsEntity> playlists = new PlaylistBus().getPlaylists(1);
        for (PlaylistsEntity playlist : playlists) {
            System.out.println(playlist.getTitle());
        }
    }

}
