package com.aisharooble.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DetailFragment detailFragment;

    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailFragment = DetailFragment.newInstance("Welcome");
        presentFragment(R.id.displayFragment, detailFragment);

    }

    public void viewList(View view) {
        System.out.println("1");
        listFragment = ListFragment.newInstance(this);
        presentFragment(R.id.listDisplay, listFragment);
    }


    public void presentFragment(int resourceID, Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(resourceID, fragment)
                .commit();

    }
}
