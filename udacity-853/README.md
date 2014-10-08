**Table of Contents**  *generated with [DocToc](http://doctoc.herokuapp.com/)*

- [Sunshine](#user-content-sunshine)
    - [Android Studio Tips](#user-content-android-studio-tips)
    - [L1: Create Project Sunshine](#user-content-l1-create-project-sunshine)
        - [Create basic project](#user-content-create-basic-project)
        - [Update project icon](#user-content-update-project-icon)
        - [Android Software Stack](#user-content-android-software-stack)
        - [Gradle](#user-content-gradle)
        - [Create a User Interface](#user-content-create-a-user-interface)
    - [L2: Connect Sunshine to the Cloud](#user-content-l2-connect-sunshine-to-the-cloud)
    - [L3: New Activities and Intents](#user-content-l3-new-activities-and-intents)
    - [L4a: Lifecycle and Databases](#user-content-l4a-lifecycle-and-databases)
    - [L4b: Content Providers and Loaders](#user-content-l4b-content-providers-and-loaders)
    - [L5: Rich and Responsive Layouts](#user-content-l5-rich-and-responsive-layouts)
    - [L6: Services and Notifications](#user-content-l6-services-and-notifications)
    - [Final Project: Individual](#user-content-final-project-individual)
    
Sunshine
========

This is a step-by-step (tagged) check-in of the "Sunshine" application developed as part of the Udacity ["How to Develop Android Applications"](https://www.udacity.com/course/ud853) course (UD 853). 

This is the first project that we are tackling in the group, for self-study. We will use this document to provide links and summarize lessons related to the development. The planned learning schedule can be found [here](https://github.com/gdg-hudson-valley/android-garage/blob/master/MeetingPlan.md).

Here are the quick links to notes on the various lessons:
 * [Lesson 1](#l1-create-project-sunshine): Create Project Sunsine
 * [Lesson 2](#l2-connect-sunshine-to-cloud): Connect Sunshine to Cloud
 * [Lesson 3](#l3-new-activities-and-intents): New Activities and Intents
 * [Lesson 4a](#l4a-lifecycles-and-databases): Lifecycle and Databases
 * [Lesson 4b](#l4b-content-providers-and-loaders): Content Providers and Loaders
 * [Lesson 5](#l5-rich-and-responsive-layouts): Rich and Responsive Layouts
 * [Lesson 6](#l6-services-and-notifications): Services and Notifications
 * [Final Project](#final-project-individual): List our ideas or apps-in-progress here

Android Studio Tips
-------------------

Some useful tips for working with Android Studio v0.8.6 (and above)

  1. Go to 'Preferences' (Mac) or 'Settings' (other) and update Editor->Auto Import to check all options. This resolves a number of class resolution errors due to missing imports.
  
  2. Manually set up the path to ADB for command line usage (e.g., by setting PATH env vars) if you prefer to use adb from a terminal for debugging etc.
  
  3. Use "File -> Invalidate Caches and Restart" if you run into compile or build problems after some change in your project structure or IDE environment. (This seems to be the equivalent advice for 'did you power off and power it back on' for many of the Android Studio issues)


L1: Create Project Sunshine
---------------------------

### Create basic project

 1. Course structured around building a weather app called "Sunshine". You can get a sneak peek at a completed application's [source code here](https://github.com/udacity/Sunshine).
 2. Make sure you install the [Android Studio IDE](https://developer.android.com/sdk/installing/studio.html). You may need to periodically check for (and install) updates to the IDE since it is currently in Beta. _My currently installed version is v0.8.9_.
 3. Install packages/tools (using the SDK Manager) for Android devices you wish to support. Android is based on API levels, with [Kit Kat (API Level 19)](https://developer.android.com/about/versions/kitkat.html) being the most recent "Stable" release. Android "L" (Developer Preview) is intended for early exploration only.
 4. Create the first project with the name "Sunshine". Pick a package name that is likely to be unique to you. _I suggest using your reversed github domain name with a .android suffix as the default package name._
 5.The _Min SDK_ is a low pass filter -- its the lowest API level on which your application can be run; ideally you want to pick something higher than API 15. _I select 
 6. The _Target SDK_ is a signal about the largest API level on which you have tested your application; ideally you want to pick the latest stable release API level (e.g., Kit Kat, level 19.)
 7. Pick a layout for your app -- the default selected is Blank Layout with Fragment. Then correct the names used for the activity/fragment -- I chose "MainActivity" and its related versions. 
 8. Click finish and let Gradle complete the build. You can confirm your build settings by checking out the "build.gradle" file in the _app_ directory. My build.gradle file looks as follows:

```
apply plugin: 'com.android.application'

android {
    compileSdkVersion 20
    buildToolsVersion "20.0.0"

    defaultConfig {
        applicationId "android.io.github.nitya.sunshine"
        minSdkVersion 16
        targetSdkVersion 20
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            runProguard false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
}
```

Click "Run" to run the application on either a connected device (over USB) or an emulator (create an AVD and select it from the list in the pop-up dialog that appears here). 

_Note that using a real device is faster for debug/launch_. However if you are using AVD, make sure you follow [instructions](https://docs.google.com/document/d/1APFAHFQTXJTrp4h-9qiiB74SuGQa1W0cD5mPnM0pG-4/pub) for configuring these correctly.

### Update project icon

Now replace the default application icon for the project with the recommended [sunshine](https://s3.amazonaws.com/content.udacity-data.com/course/ud853/ic_launcher.png) icon. 

1. Download the icon from the link above, save to local folder.
2. In Android Studio, right-click on app and select New->ImageAsset; in the dialog, browse to the icon in step 1, select and confirm.
3. Now wait for Gradle to rebuild (you may need to click on 'Sync now' if that dialog occurs), then run the application again (Run->Run 'app'). 

The emulator/device should re-install the application and display it on the home screen with the new icon.

### Android Software Stack 

Here is an (old) popular image for the Android Architecture stack. While the contents of any particular layer may have changed, the basic layers remain the same.
![System Architecture](http://developer.android.com/images/system-architecture.jpg)

1. At the core is the _Linux Kernel_ which contains hardware device drivers, oversees memory and process management, and enforces [the security architecture](http://developer.android.com/guide/topics/security/permissions.html) for Android.

2. At the next level up are _Native Libraries_ (in C/C++), many developed by third parties and contributed to Android including WebKit (browser), OpenGL (graphics) and SQLlite (database).

3. Above this is the _Android Runtime_ (Dalvik VM + Core Java libraries) which effectively provides a sandbox or container within which each independent Android application is run.

4. Above this is the _Application Framework_ layer which abstracts core Android-specific functionality into a reusable set of components, tackling things like lifecycle management, telephony, resource management and location management.

5. Above this is the actual _Applications_ layer, the part of the stack where a developer-created application would reside. A default set of applications is typically provided (e.g., browser, contacts etc.) that provide key mobile services such as web browsing and address book management. However, these applications can be replaced (and often are, by carriers) by 3rd-party developed equivalents. However, all layers below this are typically out-of-bounds for users and developers.

### Gradle

[Gradle](http://www.gradle.org) is a build automation system that combines 'the flexibility of Ant with the dependency management and conventions of Maven'. The Android Studio build system has a plugin for Gradle - essentially allowing the Android project to be built either from command line (_gradlew_) or from the Android Studio IDE (Build->Make Project).

Read: [Building Your Project With Gradle](http://developer.android.com/sdk/installing/studio-build.html)

### Create a User Interface

Explore different UI view elements and their attributes/behavior in the [Android Developer Documentation](http://developer.android.com/reference/android/view/package-summary.html).

**Why AbsoluteLayout is Evil:** 
Absolute layouts specify the exact position of each element in the view. 
This prevents views from adapting to different device form factors (tablet, wearable, phone)

**Responsive Design**
Absolute layout is deprecated in favor of three common layouts (derived from ViewGroup)
    * LinearLayout: Stack views horizontally or vertically (proportionately)
    * FrameLayout: 1 child view
    * RelativeLayout: Views position relative to parent, sibling or child

**Scroll View**
Contains a linear layout containing a vertical list of items.
Challenge is to be resource-aware -- what is the minimum number of items you should create/display on the "visible" display area in order to be efficient and also smooth.
    * Number of items in visible area = # fits on screen
    * 1 extra item for above and below views = support scrolling
    * "Recycled View" = as view drops off visible screen, it is reused to contain new data and placed at the end of list in direction of scroll

**Adapters**
Given a list of data and instructions to build the View for each list item, the Adapter is then responsible for dynamically creating and rendering the right number of list items onscreen to optimize for both resource usage and user experience.AdapterView can be used with ListView, GridView etc.

[Commit 1.29] Initialize Adapter
[Commit 1.30] Bind Adapter to the ListView


L2: Connect Sunshine to the Cloud
---------------------------------

1. Using the [OpenWeatherMap API](openweathermap.org/API). The URL for the requirements (1 week, JSON, postal code 94043, metric) is 
```
http://api.openweathermap.org/data/2.5/forecast/daily?
    q=94043&units=metric&cnt=10&units=metric&mode=json
```

2. **Http Requests on Android** Now use this data in our app. Make an HTTP request, read response from input stream, clean up and log errors. Gist provides boilerplate.
```
http://gist.github.com/anonymous/1c04bf2423579e9d2dcd
```

3. **Log Messages on Android** See 'adb logcat' (commandline) or the DDMS tool (Android Studio 'Android Device Monitor' icon) and view the LogCat tab. 

To create logs from your code, use the following commands in Java. Refer to the [Log API](http://developer.android.com/reference/android/util/Log.html) documents for more information on best practices for usage.

``` 
    // Syntax: Log.X(tag, message, throwable)
    // where X can be 
    //  d (debug), e (error), w (warning), i (info), v (verbose)
    // e.g., 
    Log.d("PlaceholderFragment", "Debug ", debugMsg);
```

Note that using an appropriate "TAG" (see [Log API](http://developer.android.com/reference/android/util/Log.html) will allow you to use filters to view your app's debug logs easier.

[Commit 2.1] Logs & Http

L3: New Activities and Intents
------------------------------


L4a: Lifecycle and Databases
----------------------------


L4b: Content Providers and Loaders
-----------------------------------


L5: Rich and Responsive Layouts
-------------------------------


L6: Services and Notifications
------------------------------


Final Project: Individual
-------------------------