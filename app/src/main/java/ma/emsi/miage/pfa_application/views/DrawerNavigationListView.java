package ma.emsi.miage.pfa_application.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ma.emsi.miage.pfa_application.adapters.DrawerNavigationListAdapter;
import ma.emsi.miage.pfa_application.events.DrawerSectionItemClickedEvent;
import ma.emsi.miage.pfa_application.utils.EventBus;

/**
 * Created by ABD3LKAR1M on 03/12/2017.
 */

public class DrawerNavigationListView extends ListView implements AdapterView.OnItemClickListener {
    public DrawerNavigationListView(Context context) {
        this(context, null);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        DrawerNavigationListAdapter adapter = new DrawerNavigationListAdapter( getContext(), 0 );
        adapter.add( "Exhibits" );
        adapter.add( "Gallery" );
        adapter.add( "others" );

        setAdapter( adapter );

        setOnItemClickListener( this );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EventBus.getInstance().post(new DrawerSectionItemClickedEvent( (String)parent.getItemAtPosition( position )));
    }
}
