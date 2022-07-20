public class Coord {
    private int id;
    private int longitude;
    private int latitude;

    public Coord(int id, int longitude, int latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return this.id;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }
}
