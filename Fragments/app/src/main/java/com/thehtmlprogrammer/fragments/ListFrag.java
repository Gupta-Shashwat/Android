package com.thehtmlprogrammer.fragments;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFrag extends ListFragment {

    ArrayList<String> data;
    ItemClick activity;
    public interface ItemClick {
        void onListClick(int idx);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (ItemClick) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data = new ArrayList<>();

        data.add("1. First data");
        data.add("2. Second data");
        data.add("3. Third data");
        data.add("4. Fourth data");
        data.add("5. Fifth data");

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        activity.onListClick(position);
    }
}