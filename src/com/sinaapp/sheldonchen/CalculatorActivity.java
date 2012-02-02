package com.sinaapp.sheldonchen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

	protected final static String TAG = "CALCULATOR_ACTIVITY";

	private static int[] numbers = { R.id.id0, R.id.id1, R.id.id2, R.id.id3,
			R.id.id4, R.id.id5, R.id.id6, R.id.id7, R.id.id8, R.id.id9 };

	private static int[] ops = { R.id.idPlus, R.id.idMinus, R.id.idMultiple,
			R.id.idDivid, R.id.iddot, R.id.idequal };
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		TextView equationView = (TextView)this.findViewById(R.id.equation);
		TextView resultView = (TextView) this.findViewById(R.id.result);

		for (int number : numbers) {
			Button button = (Button) this.findViewById(number);
			button.setOnClickListener(new NumberButtonListener(resultView, equationView));
		}
		
		for (int op : ops) {
			Button button = (Button)this.findViewById(op);
			button.setOnClickListener(new OperationButtonListener(resultView, equationView));
		}
	}

}