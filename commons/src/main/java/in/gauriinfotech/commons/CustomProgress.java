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

    private CustomProgress(Context context) {
        super(context);
    }

    public static CustomProgress from(Context context) {
        CustomProgress instance = new CustomProgress(context);
        instance = new CustomProgress(context);
        instance.setCancelable(true);
        return instance;
    }

    public CustomProgress cancelable(boolean cancelable) {
        this.setCancelable(cancelable);
        return this;
    }

    public CustomProgress onCancel(DialogInterface.OnCancelListener listener) {
        this.setOnCancelListener(listener);
        return this;
    }

    public CustomProgress title(String title) {
        this.setTitle(title);
        return this;
    }

    public CustomProgress message(String message) {
        this.setMessage(message);
        return this;
    }

    public void display() {
        if(this.isShowing()) {
            this.dismiss();
        }
        this.show();
    }

}