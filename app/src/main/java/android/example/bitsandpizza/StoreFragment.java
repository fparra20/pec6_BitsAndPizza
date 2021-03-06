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

public class StoreFragment extends Fragment {

    Store[] stores;
    RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView storeRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_tab, container, false);

        // Obtenemos el array de tiendas
        stores = Store.stores;
        // Creamos las propiedades para el recycler view
        GridLayoutManager layoutManager= new GridLayoutManager(getActivity(),2);

        // Creamos el adaptador de las tiendas
        adapter = new RecyclerAdapter(stores,getActivity());

        // Rellenamos el recyclerView
        storeRecycler.setAdapter(adapter);

        storeRecycler.setLayoutManager(layoutManager);

        return storeRecycler;
    }
}
