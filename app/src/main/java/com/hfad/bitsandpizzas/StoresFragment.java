package com.hfad.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StoresFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView storesRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_pizza, container, false);

        String[] storesNames = new String[ObjectData.stores.length];

        for (int i = 0; i < storesNames.length; i++) {
            storesNames[i] = ObjectData.stores[i].getName();
        }

        int[] pizzaImages = new int[ObjectData.stores.length];

        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = ObjectData.stores[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(storesNames, pizzaImages);
        storesRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        storesRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, position);
                intent.putExtra(DetailActivity.TYPE_ID, 2);
                getActivity().startActivity(intent);
            }
        });

        return storesRecycler;
    }
}