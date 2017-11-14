package gajendrasinghrathore.itunessongslist.pojos;

/**
 * Created by gajendrasinghrathore on 14/11/17.
 */
public class Songs {
    private String image;
    private String collectionName;
    private String artistName;
    private String trackName;

    public Songs(String image, String trackName, String artistName, String collectionName) {
        this.image = image;
        this.collectionName = collectionName;
        this.artistName = artistName;
        this.trackName = trackName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}
