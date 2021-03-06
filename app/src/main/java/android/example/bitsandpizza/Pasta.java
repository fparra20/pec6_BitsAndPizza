package android.example.bitsandpizza;

public class Pasta {
    private String name;
    private int image;
    private String ingredients;

    public Pasta(String name, int image, String ingredients) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
    }


    public static final Pasta[] pastas = {
            new Pasta ("Spaguetti Bolognesa", R.drawable.spaguetti, "Spaguetti, carne picada de vacuno, tomate frito."),
            new Pasta ("Lasagna", R.drawable.lasagna, "Carne picada de cerdo, cebolla, queso rallado, harina.")
    };

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}