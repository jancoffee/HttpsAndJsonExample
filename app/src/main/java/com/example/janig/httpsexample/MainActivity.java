package com.example.janig.httpsexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private static final String LOGTAG = "MainActivity";
    DownloadHandler downLoadHandler;
    GithubDataCallback callback = new GithubDataCallback();

    GithubDataCallback.GithubUserRepositoriesListener listener = new GithubDataCallback.GithubUserRepositoriesListener() {
        @Override
        public void receivedGithubUserRepositoryData(Response githubUserRepositories) {
            Log.d(LOGTAG, "receivedGithubUserRepositoryData:" + githubUserRepositories);
        }

        @Override
        public void receivedError(String error) {
            Log.d(LOGTAG, "receivedError:" + error);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downLoadHandler = new DownloadHandler(this);
        callback.addListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void downloadButtonClicked(View view) {
        downLoadHandler.downloadGithubData("jancoffee", callback);
    }


}
