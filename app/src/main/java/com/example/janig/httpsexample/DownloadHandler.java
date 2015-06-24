package com.example.janig.httpsexample;

import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Download resources from web service, with our SSL certificates
 */
public class DownloadHandler {
    private static final String LOGTAG = "DownloadHandler";
    private GitHubService service;

    public DownloadHandler(MainActivity mainActivity) {

        OkHttpClient okHttpClient = new OkHttpClient();

        if (!setupSSLSocketFactor(okHttpClient, mainActivity.getAssets())) {
            Log.e(LOGTAG, "failed to set SSL socket factory");
        }

        service = createGithubConnectionHandler(okHttpClient);

    }

    /**
     * Create a Github connection handler using the Retrofit framework
     *
     * @param okHttpClient a instantiated okHttpClient, okHttpClient != null
     * @return A Retrofit Github connection handler
     */
    private GitHubService createGithubConnectionHandler(OkHttpClient okHttpClient) {
        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setClient(new OkClient(okHttpClient))
                .build();

        return restAdapter.create(GitHubService.class);
    }

    /**
     * Setup a SSL socket factory on the OkHttpClient, only certificate in this factory will be valid!
     *
     * @param okHttpClient a instantiated okHttp client, okHttpClient != null
     * @param assetManager a valid assetManager, assetManager != null
     * @return True if successfully set our own SSL socket factory, False is failed to set the factory
     */
    private boolean setupSSLSocketFactor(OkHttpClient okHttpClient, AssetManager assetManager) {
        SSLSocketFactory mySSLSockerFactory = MySSL.getSSLSocketFactory(assetManager);
        if (mySSLSockerFactory == null) {
            return false;
        }
        okHttpClient.setSslSocketFactory(mySSLSockerFactory);
        //Enable this if DNS name for the site doesn't match DNS name in certificate
//        okHttpClient.setHostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String hostname, SSLSession session) {
//                HostnameVerifier hv =
//                        HttpsURLConnection.getDefaultHostnameVerifier();
//                return hv.verify("example.com", session);
//            }
//        });
        return true;
    }


    public void downloadGithubData(String user, GithubDataCallback callback) {
        service.listRepos(user, callback);
    }


}
