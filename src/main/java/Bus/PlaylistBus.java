package Bus;

import DTO.PlaylistSongsEntity;
import DTO.PlaylistsEntity;

import java.util.List;

public class PlaylistBus {

    public void addPlaylist(int userId, String title) {
        new DAO.PlaylistDAO().createPlaylist(userId, title);
    }

    public void removePlaylist(int playlistId) {
        new DAO.PlaylistDAO().removePlaylist(playlistId);
    }

    public void addSongToPlaylist(int playlistId, int songId) {
        new DAO.PlaylistDAO().addSongToPlaylist(playlistId, songId);
    }

    public List<PlaylistsEntity> getPlaylists(int userId) {
        return new DAO.PlaylistDAO().getPlaylists(userId);
    }

    public List<PlaylistSongsEntity> getPlaylistSongs(int playlistId) {
        return new DAO.PlaylistDAO().getPlaylistSongs(playlistId);
    }


}
