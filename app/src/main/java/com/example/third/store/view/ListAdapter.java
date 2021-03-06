package com.example.third.store.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.third.store.R;
import com.example.third.store.models.Product;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter{

	private ArrayList<Product> modelList;
	private Context context;

	private static class ListViewHolder {
		protected TextView text;
		protected TextView description;
		protected ImageView image;
		protected CheckBox checkBox;
	}

	public ListAdapter(ArrayList<Product> modelList, Context context) {
		this.modelList = modelList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return modelList.size();
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	public ArrayList<Product> getModelList() {
		return modelList;
	}

	@Override
	public View getView(final int position, View cView, ViewGroup parent) {
		final ListViewHolder viewHolder;
		final View result;
		if (cView == null) {
			viewHolder = new ListViewHolder();
			LayoutInflater inflater = LayoutInflater.from(context);
			result = inflater.inflate(R.layout.product_item, parent, false);
			viewHolder.text = result.findViewById(R.id.productText);
			viewHolder.image = result.findViewById(R.id.productImage);
			viewHolder.description = result.findViewById(R.id.productDesc);
			viewHolder.checkBox = result.findViewById(R.id.productCheckBox);

			result.setTag(viewHolder);
		} else {
			result=cView;
			viewHolder = (ListViewHolder) result.getTag();
		}
		viewHolder.description.setText(modelList.get(position).getDesc());
		viewHolder.text.setText(modelList.get(position).getName());
		viewHolder.image.setImageResource(modelList.get(position).getImage());
		viewHolder.checkBox.setChecked(modelList.get(position).isChecked());
		viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				modelList.get(position).setChecked(!(modelList.get(position).isChecked()));
			}
		});

		return result;
	}

	public int countTrueProducts () {
		int count = 0;
		for (Product value : modelList) {
			if (value.isChecked()) {
				count ++;
			}
		}
		return count;
	}
}
