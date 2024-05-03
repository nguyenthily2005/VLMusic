package DTO;

import java.io.Serializable;

public class PlaylistSongsEntityPK implements Serializable {
    private int playlistId;
    private int songId;

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistSongsEntityPK that = (PlaylistSongsEntityPK) o;

        if (playlistId != that.playlistId) return false;
        if (songId != that.songId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playlistId;
        result = 31 * result + songId;
        return result;
    }
}
