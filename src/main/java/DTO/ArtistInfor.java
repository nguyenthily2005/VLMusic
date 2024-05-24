package DTO;

import java.util.List;

public class ArtistInfor {

    private String stageName;
    private String realName;
    private String birthDate;
    private String hometown;
    private List<String> hitSongs;


    public ArtistInfor(String stageName, String realName, String birthDate, String hometown, List<String> hitSongs) {
        this.stageName = stageName;
        this.realName = realName;
        this.birthDate = birthDate;
        this.hometown = hometown;
        this.hitSongs = hitSongs;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public List<String> getHitSongs() {
        return hitSongs;
    }

    public void setHitSongs(List<String> hitSongs) {
        this.hitSongs = hitSongs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "stageName='" + stageName + '\'' +
                ", realName='" + realName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", hometown='" + hometown + '\'' +
                ", hitSongs=" + hitSongs +
                '}';
    }
}