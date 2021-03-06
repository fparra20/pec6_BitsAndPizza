package android.example.bitsandpizza;

public class Store {
    private String name;
    private int image;
    // Para guardar localización
    private String location;

    public Store(String name, int image, String location) {
        this.name = name;
        this.image = image;
        this.location = location;
    }

    public static final Store[] stores = {
            new Store("Ginos", R.drawable.store1, "Centro Comercial Plaza Mar 2\n" +
                    "Avinguda de Dénia, 1\n03690 Alicante"),
            new Store("Muerde la pasta", R.drawable.store2, "C.C. LUZ DEL TAJO\nAv. del Río Boladiez\n45007 Toledo")
    };

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
