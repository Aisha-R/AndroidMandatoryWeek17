package com.aisharooble.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    private MainActivity mainActivity;

    public static ListFragment newInstance(MainActivity mainActivity) {
        ListFragment listFragment = new ListFragment();
        listFragment.mainActivity = mainActivity;
        return listFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listlayout, container, false);

        ListView listView = view.findViewById(R.id.myList);

        listView.setOnItemClickListener((adapterView, view2, adapter_pos, row_id) -> {
            //call parent 'MainActivity' and ask it to handle the click
            TextView textView = (TextView)view2;
            if ( textView != null ) {
                handleItemClick(textView.getText().toString());
            }
        });

        return view;
    }

    public void handleItemClick(String item) {
        System.out.println("Clicked on: " + item);
        DetailFragment detailFragment = DetailFragment.newInstance(item);
        mainActivity.presentFragment(R.id.displayFragment, detailFragment);
    }


}
