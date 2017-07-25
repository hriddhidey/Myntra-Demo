# Myntra Demo
This is a simple application built during the new joinees' initiation bootcamp.
This was built in an attempt to learn basic android concepts, and build an Android application,
that can perform an Async Task, make network calls, handle JSON data, and build RecyclerView based
layouts.

## Concepts Learnt
The following concepts and technologies were learnt about, and experimented with over the course
of building this application -

- Types of Layouts used to build views. (LinearLayout, RelativeLayout, etc.)
- Intents, and using them to pass data between Activities.
- RecyclerView and Adapters, to build lists and grids.
- AsyncTasks and HttpUrlConnection to make network calls.
- Retrofit, Annotations, and their uses to simplify networking.
- GSON to convert JSON data to POJOs (_Plain Old Java Objects_)
- Glide image library for image handling, basic caching, etc.

## Screenshots
<img src="https://user-images.githubusercontent.com/11678594/28377550-bb9f3f90-6cca-11e7-9ac8-cc53076b037a.png" alt="Search Screen" width="200px" height="" />  <img src="https://user-images.githubusercontent.com/11678594/28377549-bb9b88e6-6cca-11e7-91f7-76888a3f3fca.png" alt="Search Query" width="200px" height="" />  <img src="https://user-images.githubusercontent.com/11678594/28377548-bb7b6e58-6cca-11e7-84d8-89feb3a9de96.png" alt="List Page" width="200px" height="" />   <img src="https://user-images.githubusercontent.com/11678594/28377545-bb3c7e8c-6cca-11e7-962e-43be6796c7f0.png" alt="Product Page" width="200px" height="" />

## Tools and Technologies Used
1. [Retrofit 2.0](http://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
2. [Gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back.
3. [Glide](https://github.com/bumptech/glide) - An image loading and caching library for Android focused on smooth scrolling.

### Dependencies
The following dependencies were added into the module's `build.gradle` file for the tools mentioned above - 
```
compile 'com.android.support:recyclerview-v7:26.+'
compile 'com.squareup.retrofit2:retrofit:2.1.0'
compile 'com.squareup.retrofit2:converter-gson:2.1.0'
compile 'com.google.code.gson:gson:2.8.0'
compile 'com.github.bumptech.glide:glide:3.7.0'
```
## Installation
- Clone the project : `git clone "https://github.com/hriddhidey/Myntra-Demo.git"`.
- Open [Android Studio](https://developer.android.com/studio/index.html), and import the root folder of the cloned repository as a project (_File > Open_). 
- Gradle will perform a basic sync for project, and all dependencies. If gradle sync fails for lack of target SDK, kindly follow Android Studio's promopts to install the same.
- Run application in [AVD (_Android Virtual Device_) Emulator](https://developer.android.com/studio/run/managing-avds.html), or connect to phone, and use USB Debugging to run application on your phone.

## Acknowledgements
I would like to express sincere gratitude to [@anshul1235](https://github.com/anshul1235), [@amarjain07](https://github.com/amarjain07), [@TasneemBohra](https://github.com/TasneemBohra), [@pranshu1701](https://github.com/pranshu1701), and [@muditpant13](https://github.com/muditpant13) for their constant guidance and tutelage, without which embarking on a journey into Android Dev would have been a lot more haphazard, and tedious.
