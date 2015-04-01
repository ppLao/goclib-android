package org.goclib.android.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;


public class SimpleProcessDialog extends Dialog {

	public static Dialog show(Context context){
		 SimpleProcessDialog dialog = new SimpleProcessDialog(context);
	        dialog.setCancelable(true);
	        dialog.setOnCancelListener(null);
	        dialog.addContentView(new ProgressBar(context), new LayoutParams(50, 50));
	        //dialog.
	        dialog.show();

	        return dialog;
	}
	public static Dialog show(Context context,int theme){
		//Transparent_Dialog
		 SimpleProcessDialog dialog = new SimpleProcessDialog(context,theme);
	        dialog.setCancelable(true);
	        dialog.setOnCancelListener(null);
	        dialog.addContentView(new ProgressBar(context), new LayoutParams(50, 50));
	        //dialog.
	        dialog.show();

	        return dialog;
	}
    public static Dialog show(Context context, CharSequence title,
            CharSequence message) {
        return show(context, title, message, false);
    }

    public static Dialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    public static Dialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    public static Dialog show(Context context, CharSequence title,
            CharSequence message, boolean indeterminate,
            boolean cancelable, OnCancelListener cancelListener) {
        SimpleProcessDialog dialog = new SimpleProcessDialog(context);
        dialog.setTitle(title);
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        /* The next line will add the ProgressBar to the dialog. */
        dialog.addContentView(new ProgressBar(context), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        dialog.show();

        return dialog;
    }
    
    public SimpleProcessDialog(Context context) {
        //super(context, R.style.NewDialog);
    	super(context);
    }
    public SimpleProcessDialog(Context context,int theme) {
        //super(context, R.style.NewDialog);
    	super(context,theme);
    }
}
