package jp.co.myself.mvvmsample02;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity4 extends AppCompatActivity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String baseUrl = "https://zipcloud.ibsnet.co.jp/";
        String zipcode = "3501142";

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // RxJavaに関する設定。
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiInterface service = retro.create(ApiInterface.class);

        Disposable d = service.API(zipcode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (response) -> {
                            for (Address address : response.results) {
                                Log.d("Retrofit2_Java", "address1:" + address.getAddress1());
                                Log.d("Retrofit2_Java", "address2:" + address.getAddress2());
                                Log.d("Retrofit2_Java", "address3:" + address.getAddress3());
                                Log.d("Retrofit2_Java", "kana1:" + address.getKana1());
                                Log.d("Retrofit2_Java", "kana2:" + address.getKana2());
                                Log.d("Retrofit2_Java", "kana3:" + address.getKana3());
                                Log.d("Retrofit2_Java", "prefcode:" + address.getPrefcode());
                                Log.d("Retrofit2_Java", "zipcode:" + address.getZipcode());
                            }
                        },
                        (err) -> {
                            Log.d("Retrofit2_Java", err.getMessage());
                        });
        compositeDisposable.add(d);

        // Non RxJava
        /*Call<ZipResponse> btc = service.API(zipcode);

        btc.enqueue(new Callback<ZipResponse>() {
            @Override
            public void onResponse(Call<ZipResponse> call, Response<ZipResponse> response) {
                if (response.isSuccessful()) {
                    ZipResponse zipResponse = response.body();
                    Log.d("Retrofit2_Java", "response_code:" + response.code());
                    Log.d("Retrofit2_Java", "url:" + response.raw().request().url());
                    Log.d("Retrofit2_Java", "message:" + zipResponse.message);
                    Log.d("Retrofit2_Java", "status:" + zipResponse.status);

                    for (Address address : zipResponse.results) {
                        Log.d("Retrofit2_Java", "address1:" + address.getAddress1());
                        Log.d("Retrofit2_Java", "address2:" + address.getAddress2());
                        Log.d("Retrofit2_Java", "address3:" + address.getAddress3());
                        Log.d("Retrofit2_Java", "kana1:" + address.getKana1());
                        Log.d("Retrofit2_Java", "kana2:" + address.getKana2());
                        Log.d("Retrofit2_Java", "kana3:" + address.getKana3());
                        Log.d("Retrofit2_Java", "prefcode:" + address.getPrefcode());
                        Log.d("Retrofit2_Java", "zipcode:" + address.getZipcode());
                    }
                } else {
                    Log.d("Retrofit2_Java", "error_code" + response.code());
                }
            }

            @Override
            public void onFailure(Call<ZipResponse> call, Throwable t) {
                Log.d("Retrofit2_Java", "onFailure" + t.getMessage());
            }
        });*/
    }
}
