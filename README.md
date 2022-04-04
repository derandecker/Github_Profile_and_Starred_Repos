An app which takes a Github username then displays the bio and profile image for that user. Then, a "Show Starred Repos" button shows a list of repos that user has starred. Each repo can be clicked to show a detail screen with the profile image of that repo's owner, along with a description of the repo, the number of forks, watchers, and stars.

Uses retrofit to download from Github API, then moshi to parse the JSON. Picasso is used to download and cache profile images. Uses Room to store user profile for offline browsing. ViewModels, DataBinding, BindingAdapters, and RecyclerView are used to display the data. Uses Navigation component to move between Fragments and SafeArgs to pass data between them.