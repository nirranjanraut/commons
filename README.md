HOW TO USE GUID.
==============

1) Add dependancy in your app/build.gradle file like below
--------------
      dependencies {
            ....
            compile 'in.gauriinfotech:commons:1.0.1'
      }

2) Get file path from below code.
--------------

        String path = in.gauriinfotech.commons.Commons.getPath(uri, context);

NOTE : Be sure your app has READ_EXTERNAL_STORAGE permissions declared in manifest.

3) Use CustomProgress using below code.
--------------

        CustomProgress.from(this) // Context
                .title("Please wait") // title
                .message("Connecting to server.") // message
                .onCancel(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        // add cancelation login here
                    }
                }).display();


If you have any doubts contact on nirranjan.raut@gmail.com
