package android.example.bitsandpizza;

public class Pizza {
    private String name;
    private int image;

    // Para guardar ingredientes
    private String topping;

    public Pizza(String name, int image, String topping) {
        this.name = name;
        this.image = image;
        this.topping = topping;
    }

    public static final Pizza[] pizzas = {
            new Pizza ("Diavolo", R.drawable.diavolo, "Base de tomate, pimiento rojo, pimiento verde, pepperoni"),
            new Pizza ("Funghi", R.drawable.funghi, "Base de carbonara, champiñones, cebolla, alcachofas.")
    };

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getTopping() {
        return topping;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}
