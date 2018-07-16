package ma.emsi.miage.pfa_application.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import ma.emsi.miage.pfa_application.R;
import ma.emsi.miage.pfa_application.events.DrawerSectionItemClickedEvent;
import ma.emsi.miage.pfa_application.fragments.ExhibitsListFragment;
import ma.emsi.miage.pfa_application.fragments.GalleryFragment;
import ma.emsi.miage.pfa_application.fragments.PersonMapFragment;
import ma.emsi.miage.pfa_application.utils.EventBus;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private String mCurrentFragmentTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(android.R.color.transparent);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                                                            MainActivity.this,
                                                            mDrawerLayout,
                                                            R.string.drawer_opened,
                                                            R.string.drawer_closed
        ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(getSupportActionBar()!=null)
                    getSupportActionBar().setTitle(R.string.drawer_opened);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if(getSupportActionBar()!=null)
                    getSupportActionBar().setTitle(R.string.drawer_closed );
            }
        };
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        displayInitialFragment();

    }

    public  void displayInitialFragment (){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, ExhibitsListFragment.getInstance()).commit();
        mCurrentFragmentTitle = "Exhibits";
    }
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getInstance().unregister(this);
        super.onStop();
    }
    @Subscribe
    public void onDrawerSectionItemClickEvent(DrawerSectionItemClickedEvent event){

        mDrawerLayout.closeDrawers();

        if(event==null || TextUtils.isEmpty(event.section) || event.section.equalsIgnoreCase( mCurrentFragmentTitle)){
            return;
        }
        //Toast.makeText(this, "Main activy : Section clicked : " + event.section, Toast.LENGTH_SHORT).show();

        if(event.section.equalsIgnoreCase("maps")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, PersonMapFragment.getInstance()).commit();
        }else if(event.section.equalsIgnoreCase("gallery")){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, GalleryFragment.getInstance())
                    .commit();
        }else if (event.section.equalsIgnoreCase("Exhibits")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, ExhibitsListFragment.getInstance()).commit();
        }else{
            return;
        }

        mCurrentFragmentTitle = event.section;
    }
}
