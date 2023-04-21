package OvChipKaart;

public class Station {
    private final String stad;
    private double latitude;
    private double longitude;

    public Station(String stad, double latitude, double longitude) {
        this.stad = stad;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getStad() {
        return stad;
    }
}