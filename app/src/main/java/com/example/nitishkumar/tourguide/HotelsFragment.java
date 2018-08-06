package com.example.nitishkumar.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
public class HotelsFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ArrayList<Info> placeInfo;
/**************************** empty constructor for fragment *************************************/
    public HotelsFragment() {
        // Required empty public constructor
    }
/********************************* it gets first called when fragment called*************************/
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String [] name = getResources().getStringArray(R.array.nameOfHotels);
        String [] nearMetro = getResources().getStringArray(R.array.neatrestMetroToHotels);
        String [] disMetro = getResources().getStringArray(R.array.distNearMetroOfHotels);
        int [] monumentImageResourceID = {R.drawable.goldfinch_surjakund, R.drawable.paharganjhotel, R.drawable.piccadily_hotel_newdelhi,
                R.drawable.radissionplazadelhi, R.drawable.taj_hotel_agra};
        String [] phoneNo = getResources().getStringArray(R.array.phoneOfHotels);
        String [] address = getResources().getStringArray(R.array.addressOfHotels);
        String [] discription = getResources().getStringArray(R.array.discriptionOfHotels);


        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        placeInfo = new ArrayList<Info>();
        for (int i = 0; i < monumentImageResourceID.length; i++)
        {
            placeInfo.add(new Info(name[i], nearMetro[i], disMetro[i], monumentImageResourceID[i], phoneNo[i], address[i], discription[i]));
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
