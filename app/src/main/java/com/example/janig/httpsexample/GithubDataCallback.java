package com.example.janig.httpsexample;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Retrofit callback when getting weather data from SMHI
 */
class GithubDataCallback implements Callback<Response> {
    private final String LOGTAG = "GithubDataCallback";
    private Set<GithubUserRepositoriesListener> listeners = null;

    GithubDataCallback() {
        listeners = new HashSet<>();
    }

    public interface GithubUserRepositoriesListener {
        void receivedGithubUserRepositoryData(Response githubUserRepositories);

        void receivedError(String error);
    }

    public void addListener(GithubUserRepositoriesListener listener) {
        listeners.add(listener);
    }

    public void removeListener(GithubUserRepositoriesListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void success(Response githubUserRepositories, Response response) {
        Log.d(LOGTAG, "success githubUserRepositories:" + githubUserRepositories.toString());

        for (GithubUserRepositoriesListener listener : listeners) {
            listener.receivedGithubUserRepositoryData(githubUserRepositories);
        }

    }

    @Override
    public void failure(RetrofitError error) {
        Log.d(LOGTAG, "error:" + error);
        for (GithubUserRepositoriesListener listener : listeners) {
            listener.receivedError("errorUrl:" + error.getUrl() + " errorResponse:" + error.getResponse());
        }
    }
}
