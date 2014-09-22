
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
9. Click "Run" to run the application on either a connected device (over USB) or an emulator (create an AVD and select it from the list in the pop-up dialog that appears here). _Note that using a real device is faster for debug/launch. However if you are using AVD, make sure you follow [instructions](https://docs.google.com/document/d/1APFAHFQTXJTrp4h-9qiiB74SuGQa1W0cD5mPnM0pG-4/pub) for configuring these correctly.

### Update project icon


L1: Connect Sunshine to the Cloud
---------------------------------


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