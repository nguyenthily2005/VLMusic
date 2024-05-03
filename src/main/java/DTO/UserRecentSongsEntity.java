package DTO;

public class UserRecentSongsEntity {
    private int userId;
    private int songId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

        UserRecentSongsEntity that = (UserRecentSongsEntity) o;

        if (userId != that.userId) return false;
        if (songId != that.songId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + songId;
        return result;
    }
}
