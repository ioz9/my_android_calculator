package com.sinaapp.sheldonchen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OperationButtonListener implements OnClickListener {

	protected static final String TAG = "OPERATION_BUTTON";

	private TextView resultView;
	private TextView equationView;

	private static String nowResult = null;

	private static List<String> list = new LinkedList<String>();

	private static int index = 0;
	
	private static List<String> opList = new ArrayList<String>();

	public OperationButtonListener(TextView resultView, TextView equationView) {
		this.resultView = resultView;
		this.equationView = equationView;
		opList.add("+");
		opList.add("-");
		opList.add("*");
		opList.add("/");
	}

	@Override
	public void onClick(View v) {
		Button button = null;
		if (v instanceof Button) {
			Log.d(TAG, "list size: " + list.size());
			String result = resultView.getText().toString();
			button = (Button) v;
			int id = button.getId();
			if (id == R.id.iddot) {
				if (!result.contains(".")) {
					result += ".";
				}
				resultView.setText(result);
			} else if (id == R.id.idequal) {
				if (list.size() == 2) {
					String equation = this.equationView.getText().toString();
					if (equation.trim().equals("")) {
						equation = result;
					} else {
						equation = equation + " " + result;
					}
					this.equationView.setText(equation);
					double opt1 = Double.valueOf(list.get(0));
					String operation = list.get(1);
					list.remove(0);
					list.remove(0);
					double opt2 = Double.valueOf(result);
					if (operation.trim().equals("+")) {
						nowResult = String.valueOf((opt1 + opt2));
					} else if (operation.trim().equals("-")) {
						nowResult = String.valueOf((opt1 - opt2));
					} else if (operation.trim().equals("*")) {
						nowResult = String.valueOf((opt1 * opt2));
					} else if (operation.trim().equals("/")) {
						nowResult = String.valueOf((opt1 / opt2));
					}
					index = 0;
					NumberButtonListener.isNew = true;
					Log.v(TAG, "result: " + nowResult);
					this.resultView.setText(nowResult);
				}
			} else {
				String op = button.getText().toString();
				if (list.size() == 0 || opList.contains(list.get(list.size() - 1))) {
					list.add(index, result);
					index++;
					list.add(index, op);
					index++;
				}
				this.resultView.setText("");
				String equation = this.equationView.getText().toString();
				if (equation.trim().equals("")) {
					equation = result;
				} else {
					equation = equation + " " + result;
				}
				this.equationView.setText(equation + " " + op);
				if (list.size() == 4) {
					double opt1 = Double.valueOf((String) list.get(0));
					String operation = (String) list.get(1);
					Log.v(TAG, "operation: " + operation);
					double opt2 = Double.valueOf((String) list.get(2));
					if (operation.trim().equals("+")) {
						nowResult = String.valueOf((opt1 + opt2));
					} else if (operation.trim().equals("-")) {
						nowResult = String.valueOf((opt1 - opt2));
					} else if (operation.trim().equals("*")) {
						nowResult = String.valueOf((opt1 * opt2));
					} else if (operation.trim().equals("/")) {
						nowResult = String.valueOf((opt1 / opt2));
					}
					list.set(0, nowResult);
					list.set(1, list.get(3));
					index = 2;

					list.remove(2);
					list.remove(2);
					Log.v(TAG, "result: " + nowResult);
					NumberButtonListener.isNew = true;
					this.resultView.setText(nowResult);
				}
			}
		}
	}

}
