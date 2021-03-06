package android.example.bitsandpizza;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    Pizza[] pizzas;
    Store[] stores;
    Pasta[] pastas;
    Activity activity;

    // Declaramos un constructor para cada tipo
    public RecyclerAdapter(Pizza[] pizzas, Activity activity) {
        this.pizzas = pizzas;
        this.activity = activity;
    }

    public RecyclerAdapter(Pasta[] pastas, Activity activity) {
        this.pastas = pastas;
        this.activity = activity;
    }

    public RecyclerAdapter(Store[] stores, Activity activity) {
        this.stores = stores;
        this.activity = activity;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private ImageView imgPhoto;
        private CardView cardView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            // Iniciamos todos los item con los que vamos a trabajar
            // Estos item son comunes a los 3 tipos que tenemos
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.imgPhoto);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
        }
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_recycler,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recViewHolder, int position) {

        // Comprobamos qué objeto ha sido pasado por parámetro
        // Trabajaremos con el que no sea null
        // Para cada uno de ellos hacemos lo mismo
        // 1º: rellenar el cardview
        // 2º: crear un listener de clic en el cardview, y lanzar una nueva actividad
        //     con los parámetros del objeto en concreto
        if(pizzas!=null) {
            Pizza pizza = pizzas[position];
            recViewHolder.imgPhoto.setImageResource(pizza.getImage());
            recViewHolder.tvName.setText(pizza.getName());

            // Que si clickamos el cardview, nos lleve a la actividad de detalle
            recViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_NAME,pizza.getName());
                    intent.putExtra(DetailActivity.EXTRA_IMG,pizza.getImage());

                    // Concatenamos para saber qué estamos mostrando en cada caso
                    intent.putExtra(DetailActivity.EXTRA_FIELD, "Toppings:\n" +pizza.getTopping());
                    activity.startActivity(intent);
                }
            });
        }

        if(stores!=null) {
            Store store = stores[position];
            recViewHolder.imgPhoto.setImageResource(store.getImage());
            recViewHolder.tvName.setText(store.getName());

            // Que si clickamos el cardview, nos lleve a la actividad de detalle
            recViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_NAME,store.getName());
                    intent.putExtra(DetailActivity.EXTRA_IMG,store.getImage());

                    // Concatenamos para saber qué estamos mostrando en cada caso
                    intent.putExtra(DetailActivity.EXTRA_FIELD, "Localización:\n" +store.getLocation());
                    activity.startActivity(intent);
                }
            });
        }

        if(pastas!=null) {
            Pasta pasta = pastas[position];
            recViewHolder.imgPhoto.setImageResource(pasta.getImage());
            recViewHolder.tvName.setText(pasta.getName());

            // Que si clickamos el cardview, nos lleve a la actividad de detalle
            recViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_NAME,pasta.getName());
                    intent.putExtra(DetailActivity.EXTRA_IMG,pasta.getImage());

                    // Concatenamos para saber qué estamos mostrando en cada caso
                    intent.putExtra(DetailActivity.EXTRA_FIELD, "Ingredientes:\n" +pasta.getIngredients());
                    activity.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        // Para devolver la longitud también necesitamos comprobar con qué objeto se está trabajando.
        int num=0;
        if(pastas!=null) {
            num = pastas.length;
        }

        if(stores!=null) {
            num = stores.length;
        }

        if(pizzas!=null) {
            num = pizzas.length;
        }

        return num;
    }
}
