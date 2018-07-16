package ma.emsi.miage.pfa_application.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ma.emsi.miage.pfa_application.R;
import ma.emsi.miage.pfa_application.models.GalleryImage;

/**
 * Created by ABD3LKAR1M on 05/12/2017.
 */

public class GalleryImageAdapter extends ArrayAdapter<GalleryImage> {

    public GalleryImageAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            holder = new ViewHolder();
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.view_gallery_thumbnail, parent,false);
            holder.image=(ImageView)convertView.findViewById(R.id.gallery_image);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(getContext()).load(getItem(position).getThumbnail()).into(holder.image);
        return convertView;
    }

    private class ViewHolder{
        ImageView image;
    }
}
