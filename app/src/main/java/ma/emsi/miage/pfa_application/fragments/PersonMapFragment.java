package ma.emsi.miage.pfa_application.fragments;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by ABD3LKAR1M on 04/12/2017.
 */

public class PersonMapFragment extends SupportMapFragment {
    public static PersonMapFragment getInstance(){
        PersonMapFragment fragment = new PersonMapFragment();
        return fragment;
    }
}
