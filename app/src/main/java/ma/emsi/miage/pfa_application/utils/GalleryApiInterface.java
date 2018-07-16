package ma.emsi.miage.pfa_application.utils;

import java.util.List;

import ma.emsi.miage.pfa_application.models.GalleryImage;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ABD3LKAR1M on 05/12/2017.
 */

public interface GalleryApiInterface {
    @GET("/Gallery")
    void getStreams(Callback<List<GalleryImage>> callback);
}
