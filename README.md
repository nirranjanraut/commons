HOW TO USE GUID.
==============

1) Add dependancy in your app/build.gradle file like below
--------------
      dependencies {
            ....
            compile 'in.gauriinfotech:commons:1.0.0'
      }

2) Upload File using below code.
--------------

        String path = in.gauriinfotech.commons.Commons.getPath(uri, context);

NOTE : Be sure your app has READ_EXTERNAL_STORAGE permissions declared in manifest.

If you have any doubts contact on nirranjan.raut@gmail.com
