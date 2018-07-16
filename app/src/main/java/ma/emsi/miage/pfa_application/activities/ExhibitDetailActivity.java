package ma.emsi.miage.pfa_application.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ma.emsi.miage.pfa_application.R;
import ma.emsi.miage.pfa_application.models.Person;

/**
 * Created by ABD3LKAR1M on 05/12/2017.
 */

public class ExhibitDetailActivity extends AppCompatActivity {

    public static final  String EXTRA_PERSON = "Extra_person";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_detail);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        //
        try{
           // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           // getSupportActionBar().setHomeButtonEnabled(true);
        }catch (Exception e){
            Log.e("--->ActionBar","eroorrrrr");
            e.printStackTrace();
        }
        Person animal = getIntent().getExtras().getParcelable(EXTRA_PERSON);

        TextView species = (TextView) findViewById(R.id.species);
        TextView description = (TextView) findViewById(R.id.description);
        ImageView image = (ImageView) findViewById(R.id.imagethumb);

        species.setText(animal.getSpecies());
        description.setText(animal.getSpecies());

        Picasso.with(this).load(animal.getImage()).into(image);
    }
}
