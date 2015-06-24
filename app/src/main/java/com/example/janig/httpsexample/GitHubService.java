package com.example.janig.httpsexample;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Interface for define how to get github repositories per a user
 */
public interface GitHubService {
    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, GithubDataCallback cb);
}
