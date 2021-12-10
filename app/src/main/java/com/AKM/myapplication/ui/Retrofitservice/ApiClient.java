package com.AKM.myapplication.ui.Retrofitservice;




import android.content.Context;

import com.google.android.material.internal.ContextUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anil on 10/14/17.
 */

public class ApiClient {

    // Main Link
    public static final String discussion_image_URL="http://103.205.64.197/fs/post/";
    public static final String BASE_URL = "https://api.mystral.in/tt/mobile/logistics/";



    private static Retrofit retrofit = null;
    private static final ApiClient ourInstance = new ApiClient();
Context context;
    public static ApiClient getInstance() {
        return ourInstance;
    }

    /**
     * prepare api client setup for one time only.
     *
     * @return api service.
     * @param context
     */
    public ApiService getApiService(Context context) {
        this.context=context;
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }


    /**
     * prepared custom client here.
     *
     * @return OkHttpClient.
     */
    private OkHttpClient getClient() {

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(getInterceptor())
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {

                        if(!NetworkUtils.isOnline(context.getApplicationContext()))
                        {
                            throw new NoConnectivityException();
                        }
                        Request original = chain.request();
                        Request request = original.newBuilder()
//                                .header("CLIENT-OS", "ANDROID")
                                .method(original.method(), original.body())
                                .build();

                        return chain.proceed(request);
                    }
                })
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();

        return client;
    }

    /**
     * get interceptor here.
     *
     * @return Interceptor.
     */
    private Interceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
