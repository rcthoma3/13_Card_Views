package com.hfad.bitsandpizzas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_pizza, container, false);

        String[] pizzaNames = new String[ObjectData.pizzas.length];

        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = ObjectData.pizzas[i].getName();
        }

        int[] pizzaImages = new int[ObjectData.pizzas.length];

        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = ObjectData.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, position);
                intent.putExtra(DetailActivity.TYPE_ID, 0);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecycler;
    }
}