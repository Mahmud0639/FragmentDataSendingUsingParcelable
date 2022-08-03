package com.manuni.fragmentdatasendingusingparcelable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataReceiverFragment extends Fragment {


    public DataReceiverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_receiver, container, false);

        Bundle dataBundle = getArguments();
        Person p = dataBundle.getParcelable("key");
        TextView myTxt = view.findViewById(R.id.personData);
        myTxt.setText(p.getName()+"\n");
        myTxt.append(p.getGender()+"\n");
        myTxt.append(p.getAge()+"");

        return view;
    }
}