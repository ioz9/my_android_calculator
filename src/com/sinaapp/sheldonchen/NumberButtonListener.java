package com.sinaapp.sheldonchen;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NumberButtonListener implements OnClickListener {

	protected static final String TAG = "NUMBER_BUTTON";

	private TextView textView;
	
	private TextView equationView;
	
	public static boolean isNew = true;

	public NumberButtonListener(TextView textView, TextView equationView) {
		this.textView = textView;
		this.equationView = equationView;
	}

	@Override
	public void onClick(View v) {
		Button b = null;
		if (v instanceof Button) {
			b = (Button) v;
			String result = textView.getText().toString();
			String text = b.getText().toString();
			if ((result.length() == 0 && text.equals("0"))
					|| result.trim().equals("0") || isNew == true) {
				this.equationView.setText("");
				result = text;
				isNew = false;
			} else {
				result += text;
			}
			textView.setText(result);
		}

	}

}
