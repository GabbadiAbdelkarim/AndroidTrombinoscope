package ma.emsi.miage.pfa_application.utils;

import java.util.List;

import ma.emsi.miage.pfa_application.models.Person;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ABD3LKAR1M on 04/12/2017.
 */

public interface PersonApiInterface {
    @GET("/model")
    void getStreams(Callback<List<Person>> callback);
}
