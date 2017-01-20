HOW TO USE GUID.
==============

1) Add dependancy in your app/build.gradle file like below
--------------
      dependencies {
            ....
            compile 'in.gauriinfotech:commons:1.0.8’
      }

2) Get file path from below code.
--------------

        String path = in.gauriinfotech.commons.Commons.getPath(uri, context);

NOTE : Be sure your app has READ_EXTERNAL_STORAGE permissions declared in manifest.

3) Use Progress using below code.
--------------

        in.gauriinfotech.commons.Progress.from(this) // Context
                .title("Please wait") // title
                .message("Connecting to server.") // message
                .onCancel(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        // add cancelation login here
                    }
                }).display();

4) Display toast using below code
---------------

        in.gauriinfotech.commons.Commons.toast(YourActivity.this, "This is test toast message.");


5) Check if device has active internet connection using below code.
---------------

        if(in.gauriinfotech.commons.Commons.isOnline(this)) { // Context
            // your logic here
        }








If you have any doubts or required any common task to be added in this, contact me on nirranjan.raut@gmail.com
