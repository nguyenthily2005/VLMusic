package Bus;

import DTO.ArtistsEntity;
import DTO.SongsEntity;

import java.util.List;

public class testBus {
    public static void main(String[] args) {
        List<SongsEntity> songs = new SongBus().getAllSongs();
        for (SongsEntity song : songs) {
            System.out.println(song.getImgUrl());
        }
        List<ArtistsEntity> artists = new ArtistBus().getAllArtists();
        for (ArtistsEntity artist : artists) {
            System.out.println(artist.getName());
        }

    }
}
