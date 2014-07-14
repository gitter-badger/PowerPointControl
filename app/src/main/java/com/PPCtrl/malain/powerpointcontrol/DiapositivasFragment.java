package com.PPCtrl.malain.powerpointcontrol;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DiapositivasFragment extends Fragment {
    ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_diapositivas, container, false);
        list = (ListView)rootView.findViewById(R.id.list_slides);
        return rootView;
    }
}
