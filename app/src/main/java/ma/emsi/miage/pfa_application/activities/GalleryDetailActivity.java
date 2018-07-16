package ma.emsi.miage.pfa_application.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ma.emsi.miage.pfa_application.R;

/**
 * Created by ABD3LKAR1M on 06/12/2017.
 */

public class GalleryDetailActivity extends AppCompatActivity{

    public static final String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_CAPTION = "extra_caption";
    private TextView mCaptionTextView;
    private ImageView mImageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        mCaptionTextView = (TextView) findViewById(R.id.caption_img_detail);
        mImageView = (ImageView) findViewById(R.id.gallery_imageDetail);

        if(getIntent() != null || getIntent().getExtras()!=null){
            if(getIntent().getExtras().containsKey(EXTRA_IMAGE)){
                Picasso.with(this).load(getIntent().getExtras().getString(EXTRA_IMAGE)).into(mImageView);
            }
            if(getIntent().getExtras().containsKey(EXTRA_CAPTION)){
                mCaptionTextView.setText(getIntent().getExtras().getString(EXTRA_CAPTION));
            }
        }

    }
}
