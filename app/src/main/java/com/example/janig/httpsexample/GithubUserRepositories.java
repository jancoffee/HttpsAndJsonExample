package com.example.janig.httpsexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Parse class for weather data
 */
public class GithubUserRepositories
{
    @Expose public final String has_issues;

    @Expose public final String teams_url;

    @Expose public final String compare_url;

    @Expose public final String releases_url;

    @Expose public final String keys_url;

    @Expose public final String has_pages;

    @Expose public final String description;

    @Expose public final String milestones_url;

    @Expose public final String has_wiki;

    @Expose public final String events_url;

    @Expose public final String archive_url;

    @Expose public final String subscribers_url;

    @Expose public final String contributors_url;

    @Expose public final String pushed_at;

    @Expose public final String fork;

    @Expose public final String svn_url;

    @Expose public final String collaborators_url;

    @Expose public final String subscription_url;

    @Expose public final String clone_url;

    @Expose public final String trees_url;

    @Expose public final String homepage;

    @Expose public final String url;

    @Expose public final String size;

    @Expose public final String notifications_url;

    @Expose public final String updated_at;

    @Expose public final String branches_url;

    @Expose public final Owner owner;

    @Expose public final String issue_events_url;

    @Expose public final String language;

    @Expose public final String forks_count;

    @Expose public final String contents_url;

    @Expose public final String watchers_count;

    @Expose public final String blobs_url;

    @Expose public final String commits_url;

    @Expose public final String has_downloads;

    @Expose public final String git_commits_url;

    @Expose public final String default_branch;

    @Expose public final String open_issues;

    @Expose public final String id;

    @Expose public final String downloads_url;

    @Expose public final String mirror_url;

    @Expose public final String comments_url;

    @Expose public final String name;

    @Expose public final String created_at;

    @Expose public final String stargazers_count;

    @Expose public final String assignees_url;

    @Expose public final String pulls_url;

    @Expose public final String watchers;

    @Expose public final String stargazers_url;

    @Expose public final String hooks_url;

    @Expose public final String languages_url;

    @Expose public final String issues_url;

    @Expose public final String git_tags_url;

    @Expose public final String merges_url;

    @Expose public final String git_refs_url;

    @Expose public final String open_issues_count;

    @Expose public final String ssh_url;

    @Expose public final String html_url;

    @Expose public final String forks;

    @Expose public final String statuses_url;

    @Expose public final String forks_url;

    @Expose public final String issue_comment_url;

    @Expose public final String labels_url;

    @Expose public final String tags_url;

    @Expose public final String git_url;

    @Expose public final String full_name;

    public GithubUserRepositories(String has_issues, String teams_url, String compare_url, String releases_url, String keys_url, String has_pages, String description, String milestones_url, String has_wiki, String events_url, String archive_url, String subscribers_url, String contributors_url, String pushed_at, String fork, String svn_url, String collaborators_url, String subscription_url, String clone_url, String trees_url, String homepage, String url, String size, String notifications_url, String updated_at, String branches_url, Owner owner, String issue_events_url, String language, String forks_count, String contents_url, String watchers_count, String blobs_url, String commits_url, String has_downloads, String git_commits_url, String default_branch, String open_issues, String id, String downloads_url, String mirror_url, String comments_url, String name, String created_at, String stargazers_count, String assignees_url, String pulls_url, String watchers, String stargazers_url, String hooks_url, String languages_url, String issues_url, String git_tags_url, String merges_url, String git_refs_url, String open_issues_count, String ssh_url, String html_url, String forks, String statuses_url, String forks_url, String issue_comment_url, String labels_url, String tags_url, String git_url, String full_name) {
        this.has_issues = has_issues;
        this.teams_url = teams_url;
        this.compare_url = compare_url;
        this.releases_url = releases_url;
        this.keys_url = keys_url;
        this.has_pages = has_pages;
        this.description = description;
        this.milestones_url = milestones_url;
        this.has_wiki = has_wiki;
        this.events_url = events_url;
        this.archive_url = archive_url;
        this.subscribers_url = subscribers_url;
        this.contributors_url = contributors_url;
        this.pushed_at = pushed_at;
        this.fork = fork;
        this.svn_url = svn_url;
        this.collaborators_url = collaborators_url;
        this.subscription_url = subscription_url;
        this.clone_url = clone_url;
        this.trees_url = trees_url;
        this.homepage = homepage;
        this.url = url;
        this.size = size;
        this.notifications_url = notifications_url;
        this.updated_at = updated_at;
        this.branches_url = branches_url;
        this.owner = owner;
        this.issue_events_url = issue_events_url;
        this.language = language;
        this.forks_count = forks_count;
        this.contents_url = contents_url;
        this.watchers_count = watchers_count;
        this.blobs_url = blobs_url;
        this.commits_url = commits_url;
        this.has_downloads = has_downloads;
        this.git_commits_url = git_commits_url;
        this.default_branch = default_branch;
        this.open_issues = open_issues;
        this.id = id;
        this.downloads_url = downloads_url;
        this.mirror_url = mirror_url;
        this.comments_url = comments_url;
        this.name = name;
        this.created_at = created_at;
        this.stargazers_count = stargazers_count;
        this.assignees_url = assignees_url;
        this.pulls_url = pulls_url;
        this.watchers = watchers;
        this.stargazers_url = stargazers_url;
        this.hooks_url = hooks_url;
        this.languages_url = languages_url;
        this.issues_url = issues_url;
        this.git_tags_url = git_tags_url;
        this.merges_url = merges_url;
        this.git_refs_url = git_refs_url;
        this.open_issues_count = open_issues_count;
        this.ssh_url = ssh_url;
        this.html_url = html_url;
        this.forks = forks;
        this.statuses_url = statuses_url;
        this.forks_url = forks_url;
        this.issue_comment_url = issue_comment_url;
        this.labels_url = labels_url;
        this.tags_url = tags_url;
        this.git_url = git_url;
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("full name:"+full_name);
        stringBuffer.append("url:"+url);

        return stringBuffer.toString();
    }

    public class Owner
    {
        @Expose public final String received_events_url;

        @Expose public final String organizations_url;

        @Expose public final String avatar_url;

        @Expose public final String gravatar_id;

        @Expose public final String gists_url;

        @Expose public final String starred_url;

        @Expose public final String site_admin;

        @Expose public final String type;

        @Expose public final String url;

        @Expose public final String id;

        @Expose public final String html_url;

        @Expose public final String following_url;

        @Expose public final String events_url;

        @Expose public final String login;

        @Expose public final String subscriptions_url;

        @Expose public final String repos_url;

        @Expose public final String followers_url;

        public Owner(String received_events_url, String organizations_url, String avatar_url, String gravatar_id, String gists_url, String starred_url, String site_admin, String type, String url, String id, String html_url, String following_url, String events_url, String login, String subscriptions_url, String repos_url, String followers_url) {
            this.received_events_url = received_events_url;
            this.organizations_url = organizations_url;
            this.avatar_url = avatar_url;
            this.gravatar_id = gravatar_id;
            this.gists_url = gists_url;
            this.starred_url = starred_url;
            this.site_admin = site_admin;
            this.type = type;
            this.url = url;
            this.id = id;
            this.html_url = html_url;
            this.following_url = following_url;
            this.events_url = events_url;
            this.login = login;
            this.subscriptions_url = subscriptions_url;
            this.repos_url = repos_url;
            this.followers_url = followers_url;
        }
    }
}
