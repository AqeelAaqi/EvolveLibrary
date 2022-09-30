# EvolveLibrary

[![](https://jitpack.io/v/AqeelAaqi/EvolveLibrary.svg)](https://jitpack.io/#AqeelAaqi/EvolveLibrary)

This is Social login library in which you can login through Facebook and Google

## Installation

#### Step 1.  Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

#### Step 2. Add the dependency

```java
dependencies {
	         implementation 'com.github.AqeelAaqi:EvolveLibrary:Tag'
	}
```
where Tag is the version of the lib. You can find the latest version in the badge on top of the page



## Usage for Facebook

To login into some Facebook, you should call Facebook.

## Config
For facebook login you will need to add the following to your android manifest

```AndroidMenifest.xml

 <uses-permission android:name="android.permission.INTERNET" />
 
<meta-data
        android:name="com.facebook.sdk.ApplicationId"
        android:value="@string/facebook_app_id" />
```

```java
import com.evolve.evolvear.Facebook;

facebook = new Facebook(this);
facebook.login();
```
Also you should impliments EvolveLibrary listener for callback

```java
implements Facebook.FacebookResponseListener

@Override
    public void onFacebookResponseListener(JSONObject response, boolean error) {
        Log.d("Response", String.valueOf(response));
    }

```
Also you should redirect you onActivityResult() callback to EvolveLibrary

```java
@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebook.activityResult(requestCode, resultCode, data);
    }
```

## Usage for Google

#### Step 1. Register App

Register your app on [Google Developer](https://console.firebase.google.com/) Account

Please view the Goolgle documentation if you face any issue related to dependency

* Add JSON file into app folder of the Project

```gradle

	implementation 'com.google.android.gms:play-services-auth:20.3.0'
	
	plugins {
    id 'com.android.application' version '7.2.2' apply false
    id 'com.android.library' version '7.2.2' apply false
}
	
```
#### Step 2. 
```gradle.properties
android.enableJetifier=true
```

#### Step 3.  
To login into Google you should call EvolveLibrary.

```java
	import com.evolve.evolvear.Google;

        google = new Google(this);
	google.login();
```

```java
	 Google.GoogleResponseListener

 @Override
    public void onGoogleResponseListener(JSONObject response, boolean error) {
        Log.d("Response", String.valueOf(response));
    }

```

Also you should redirect you onActivityResult() callback to EvolveLibrary

```java

 @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SocialLoginConstant.GOOGLE_REQUEST_CODE) {
            google.activityResult(requestCode, resultCode, data);
        } 
    }

```



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT]
