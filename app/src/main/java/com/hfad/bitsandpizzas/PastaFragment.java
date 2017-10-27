package com.hfad.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PastaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pastaRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_pizza, container, false);
        
        String[] pastaNames = new String[ObjectData.pastas.length];

        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = ObjectData.pastas[i].getName();
        }

        int[] pastaImages = new int[ObjectData.pastas.length];

        for (int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = ObjectData.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pastaRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, position);
                intent.putExtra(DetailActivity.TYPE_ID, 1);
                getActivity().startActivity(intent);
            }
        });

        return pastaRecycler;
    }
}