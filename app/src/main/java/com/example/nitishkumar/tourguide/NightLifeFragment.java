package com.example.nitishkumar.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightLifeFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ArrayList<Info> placeInfo;
/**************************** empty constructor for fragment *************************************/
    public NightLifeFragment() {
        // Required empty public constructor
    }
/********************************* it gets first called when fragment called*************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String [] name = getResources().getStringArray(R.array.nameOfNightLife);
        String nearMetro = getResources().getString(R.string.nearestMetroNight);
        String disMetro = getResources().getString(R.string.disnearestMetroNight);
        int [] monumentImageResourceID = {R.drawable.bluonght, R.drawable.hauz_khasnght,R.drawable.housea_night, R.drawable.indiagatenght,
                R.drawable.kittysu_night_delhi, R.drawable.mochaarthouse, R.drawable.murthalnght};
        String [] phoneNo = getResources().getStringArray(R.array.phoneOfNightPlace);
        String [] address = getResources().getStringArray(R.array.addressOfNightPlace);
        String [] discription = getResources().getStringArray(R.array.discpOfNightPlace);


        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        placeInfo = new ArrayList<Info>();

        for (int i = 0; i < monumentImageResourceID.length; i++)
        {
            placeInfo.add(new Info(name[i], nearMetro, disMetro, monumentImageResourceID[i], phoneNo[i], address[i], discription[i]));
        }
        InfoCustomArrayAdapter infoCustomArrayAdapter = new InfoCustomArrayAdapter(getActivity(), placeInfo);
        ListView listView = (ListView) rootView.findViewById(R.id.fragmentListView);
        listView.setAdapter(infoCustomArrayAdapter);
        listView.setOnItemClickListener(this);
        return rootView;
    }
/***************************** it detects listView item click and redirect to detail item activity *******************/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), DetailedInfoActivity.class);
        intent.putExtra("object", placeInfo.get(position));
        intent.putExtra("index", position);
        startActivity(intent);
    }
}