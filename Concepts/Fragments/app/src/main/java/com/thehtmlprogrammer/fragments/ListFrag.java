package com.thehtmlprogrammer.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;


public class ListFrag extends ListFragment {

    String [] data;
    onItemClick activity;
    public interface onItemClick {
        void onListClick(int idx);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (onItemClick) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data));

        activity.onListClick(0);
//        // if phone is in landscape mode
//        if (this.getActivity().findViewById(R.id.layout_land) != null) {
//            activity.onListClick(0);
//        }
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        activity.onListClick(position);
    }
}