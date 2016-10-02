package in.gauriinfotech.commons;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by NiRRaNjAN on 02/10/16.
 * Contact email    :   nirranjan.raut@gmail.com
 * Facebook         :   https://www.facebook.com/NiRRaNjAN.RauT
 * Stackoverflow    :   http://stackoverflow.com/users/1911941/elite
 * Blogs            :   http://technoscripts.com
 */
public class CustomProgress extends ProgressDialog {

    private static CustomProgress instance;

    private CustomProgress(Context context) {
        super(context);
    }

    public static CustomProgress from(Context context) {
        if(instance == null) {
            instance = new CustomProgress(context);
            instance.setCancelable(true);
        }
        return instance;
    }

    public CustomProgress cancelable(boolean cancelable) {
        instance.setCancelable(cancelable);
        return instance;
    }

    public CustomProgress onCancel(DialogInterface.OnCancelListener listener) {
        instance.setOnCancelListener(listener);
        return instance;
    }

    public CustomProgress title(String title) {
        instance.setTitle(title);
        return instance;
    }

    public CustomProgress message(String message) {
        instance.setMessage(message);
        return instance;
    }

    public void display() {
        if(instance.isShowing()) {
            instance.dismiss();
        }
        instance.show();
    }

    public static void close() {
        if(instance != null && instance.isShowing()) {
            instance.dismiss();
        }
    }

}