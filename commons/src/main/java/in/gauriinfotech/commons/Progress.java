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
public class Progress extends ProgressDialog {

    private Progress(Context context) {
        super(context);
    }

    public static Progress from(Context context) {
        Progress instance = new Progress(context);
        instance = new Progress(context);
        instance.setCancelable(true);
        return instance;
    }

    public Progress cancelable(boolean cancelable) {
        this.setCancelable(cancelable);
        return this;
    }

    public Progress onCancel(DialogInterface.OnCancelListener listener) {
        this.setOnCancelListener(listener);
        return this;
    }

    public Progress title(String title) {
        this.setTitle(title);
        return this;
    }

    public Progress message(String message) {
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