package ma.emsi.miage.pfa_application.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import ma.emsi.miage.pfa_application.R;
import ma.emsi.miage.pfa_application.activities.ExhibitDetailActivity;
import ma.emsi.miage.pfa_application.adapters.ExhibitsAdapter;
import ma.emsi.miage.pfa_application.models.Person;
import ma.emsi.miage.pfa_application.utils.PersonApiInterface;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ABD3LKAR1M on 04/12/2017.
 */

public class ExhibitsListFragment extends ListFragment {
    private ExhibitsAdapter mAdapter;

    public  static ExhibitsListFragment getInstance(){
        ExhibitsListFragment fragment = new ExhibitsListFragment();

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListShown(false);
        mAdapter = new ExhibitsAdapter(getActivity(), 0);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.exhibits_feed))
                .build();
        PersonApiInterface animalApiInterface = restAdapter.create(PersonApiInterface.class);
        animalApiInterface.getStreams(new Callback<List<Person>>() {
            @Override
            public void success(List<Person> animals, Response response) {
                if( animals ==null || animals.isEmpty()) return;

                for(Person animal : animals){
                    Log.e("Person", "Retrofit success " + animal.getName());
                    mAdapter.add(animal);
                }
                mAdapter.notifyDataSetChanged();
                setListAdapter(mAdapter);
                setListShown(true);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Person", "Retrofit error " + error.getMessage());
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), ExhibitDetailActivity.class);
        intent.putExtra(ExhibitDetailActivity.EXTRA_PERSON, mAdapter.getItem(position));
        startActivity(intent);
    }
}
