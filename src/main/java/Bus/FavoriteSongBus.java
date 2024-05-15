package Bus;

import DTO.FavoriteSong;

import java.util.List;

public class FavoriteSongBus {
    public void addFavoriteSong(int userId, int songId) {
        new DAO.FavouriteDAO().addFavourite(userId, songId);
    }

    public List<FavoriteSong> getFavoriteSongs(int userId) {
        return new DAO.FavouriteDAO().getFavourites(userId);
    }

    public void removeFavoriteSong(int userId, int songId) {
        new DAO.FavouriteDAO().removeFavourite(userId, songId);
    }
}
