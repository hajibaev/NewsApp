# NewsApp
## A program written entirely in Kotlin using the principles of Clean Architecture according to the MVVM pattern


# Screens 

![2023-02-06 09 35 57](https://user-images.githubusercontent.com/114996205/217043877-e926d6ad-b813-43d6-95fa-9a3fc56adedc.jpg)

![black home](https://user-images.githubusercontent.com/114996205/217044479-fa385d21-f3c1-4917-bd1c-5850cfa8ba12.jpg)

![news_home](https://user-images.githubusercontent.com/114996205/217044778-590b4fba-1e96-4e8d-82d3-44cf0defd9ec.jpg)


# Animations

![mtgif](https://user-images.githubusercontent.com/114996205/217056328-0f3e1361-bb30-48b8-8b33-0c3ba32bcb98.mov)
![gif](https://user-images.githubusercontent.com/114996205/217056631-dbf03b52-e2e5-4458-92b6-7d5d329d4522.mp4)
![gitsave](https://user-images.githubusercontent.com/114996205/217056796-6e4eb9c3-7485-4ceb-a96f-eb2620eaab1f.mp4)


# Libraries

### Android Jetpack

+ [ViewBinding](https://developer.android.com/topic/libraries/view-binding) View binding is a feature that allows you to more easily write code that interacts with views. Once view binding is enabled in a module, it generates a binding class for each XML layout file present in that module. An instance of a binding class contains direct references to all views that have an ID in the corresponding layout
+ [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) An interface that automatically responds to lifecycle events

+ [Navigation](https://developer.android.com/guide/navigation?gclsrc=aw.ds&gclid=Cj0KCQiA09eQBhCxARIsAAYRiymyM6hTEs0cGr5ZCXOWtLhVUwDK1O86vf8V_Uq2DWvVYNFZwPFznzAaAllMEALw_wcB) Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer. The Navigation component also ensures a consistent and predictable user experience by adhering to an established

+ [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) Data objects that notify views of changes to the underlying database

+ [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) Data related to the user interface that is not destroyed when the application is rotated. Easily schedule asynchronous tasks for optimal execution

+ [Room](https://developer.android.com/jetpack/androidx/releases/room) The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite

+ [Kotlin flows](https://developer.android.com/kotlin/flow) In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. For example, you can use a flow to receive live updates from a database

### DI
+ [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) Hilt is a dependency injection library for Android that reduces the execution time of manual dependency injection into your project. Performing manual dependency injection requires that you create each class and its dependencies manually, and use containers to reuse and manage dependencies
### Images
+ [Glide](https://github.com/bumptech/glide) Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface
+ [Picasso](https://github.com/square/picasso) Many common pitfalls of image loading on Android are handled automatically by Picasso

### Network
+ [Retrofit2](https://habr.com/ru/post/314028/) Type-safe HTTP client for Android and Java
+ [OkHttp](https://github.com/square/okhttp) HTTP + HTTP/2 client for Android and Java applications
### Coroutines
+ [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines) Coroutines is a rich library for coroutines developed by JetBrains. It contains a number of high-level primitives with support for coroutines, which are discussed in this guide, including startup, asynchrony, and others

### Custom Libraries

+ []Shimmer](https://github.com/facebook/shimmer-android) Shimmer is an Android library that provides an easy way to add a shimmer effect to any view in your Android app
