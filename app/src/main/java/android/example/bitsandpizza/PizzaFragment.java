package android.example.bitsandpizza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaFragment extends Fragment {

    Pizza[] pizzas;
    RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_tab, container, false);

        // Obtenemos el array de pizzas
        pizzas = Pizza.pizzas;

        // Creamos las propiedades para el recycler view
        GridLayoutManager layoutManager= new GridLayoutManager(getActivity(),2);

        // Creamos el adaptador
        adapter = new RecyclerAdapter(pizzas,getActivity());

        // Rellenamos el recyclerView
        pizzaRecycler.setAdapter(adapter);

        pizzaRecycler.setLayoutManager(layoutManager);
        return pizzaRecycler;
    }
}
