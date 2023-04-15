package com.example.tema1dawm;

import static java.util.Arrays.asList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListView animalsListView;
    static ArrayAdapter<String> arrayAdapter;
    SharedPreferences sharedPreferences;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animalsListView = (ListView)view.findViewById(R.id.animals_list_view);

        Animal a1 = new Animal("Elephant", "Africa");
        Animal a2 = new Animal("Kangaroo", "Australia");
        Animal a3 = new Animal("Cat", "Europe");
        Animal a4 = new Animal("Giraffe", "Africa");
        Animal a5 = new Animal("Koala", "Australia");
        Animal a6 = new Animal("Puma", "South America");
        Animal a7 = new Animal("Polar bear", "North America");
        Animal a8 = new Animal("Toucan", "South America");
        Animal a9 = new Animal("Emu", "Australia");
        Animal a10 = new Animal("Lion", "Africa");
        Animal a11 = new Animal("Grizzly bear", "North America");
        Animal a12 = new Animal("Anaconda", "South America");
        Animal a13 = new Animal("Kangaroo rat", "North America");
        Animal a14 = new Animal("Alpaca", "South America");
        Animal a15 = new Animal("Koala bear", "Australia");
        Animal a16 = new Animal("Hyena", "Africa");
        Animal a17 = new Animal("Puma cat", "South America");
        Animal a18 = new Animal("Kangaroo rat", "North America");
        Animal a19 = new Animal("Ocelot", "South America");
        Animal a20 = new Animal("Meerkat", "Africa");
        Animal a21 = new Animal("Condor", "South America");
        Animal a22 = new Animal("Kangaroo", "Australia");
        Animal a23 = new Animal("Grizzly bear", "North America");
        Animal a24 = new Animal("Lioness", "Africa");
        Animal a25 = new Animal("Tarsier", "Asia");
        Animal a26 = new Animal("Hippopotamus", "Africa");
        Animal a27 = new Animal("Gorilla", "Africa");
        Animal a28 = new Animal("Eagle", "North America");
        Animal a29 = new Animal("Bison", "North America");
        Animal a30 = new Animal("Toucan", "South America");
        Animal a31 = new Animal("Kangaroo", "Australia");
        Animal a32 = new Animal("Leopard", "Africa");
        Animal a33 = new Animal("Giant panda", "Asia");
        Animal a34 = new Animal("Capybara", "South America");
        Animal a35 = new Animal("Armadillo", "South America");
        Animal a36 = new Animal("Koala", "Australia");
        Animal a37 = new Animal("Kangaroo rat", "North America");
        Animal a38 = new Animal("Llama", "South America");
        Animal a39 = new Animal("Leopard", "Africa");
        Animal a40 = new Animal("Gorilla", "Africa");
        Animal a41 = new Animal("Kangaroo", "Australia");
        Animal a42 = new Animal("Tiger", "Asia");
        Animal a43 = new Animal("Puma cat", "South America");
        Animal a44 = new Animal("Kangaroo rat", "North America");
        Animal a45 = new Animal("Cheetah", "Africa");
        Animal a46 = new Animal("Alpaca", "South America");
        Animal a47 = new Animal("Kangaroo", "Australia");
        Animal a48 = new Animal("Gorilla", "Africa");
        Animal a49 = new Animal("Lion", "Africa");
        Animal a50 = new Animal("Toucan", "South America");

        ArrayList<Animal> animals = new ArrayList<Animal> (asList(
                a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                a11, a12, a13, a14, a15, a16, a17, a18, a19, a20,
                a21, a22, a23, a24, a25, a26, a27, a28, a29, a30,
                a31, a32, a33, a34, a35, a36, a37, a38, a39, a40,
                a41, a42, a43, a44, a45, a46, a47, a48, a49,a50)
        );

        ArrayList <String> animalsData = new ArrayList<String>();
        for(int index = 0; index< animals.size(); index++)
        {
            animalsData.add(animals.get(index).displayAnimal());
        }
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, animalsData);
        animalsListView.setAdapter(arrayAdapter);

        animalsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity mainActivity =(MainActivity)getActivity();
                sharedPreferences = mainActivity.getApplicationContext().getSharedPreferences("com.example.tema1dawm", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("animal", animals.get(i).getName()).apply();
                sharedPreferences.edit().putString("continent", animals.get(i).getContinent()).apply();
                replaceFragment(new Fragment2());
            }
        });
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();//getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.i("change", "ok");
    }
}