package jp.co.myself.mvvmsample02;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    // Non RxJava
    /*@GET("api/search")
    Call<ZipResponse> API(@Query("zipcode") String zipcode);*/

    @GET("api/search")
    Observable<ZipResponse> API(@Query("zipcode") String zipcode);

}
