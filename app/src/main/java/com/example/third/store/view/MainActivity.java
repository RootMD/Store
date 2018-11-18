package com.example.third.store.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.third.store.R;
import com.example.third.store.models.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	protected ArrayList<Product> products;
	private ListAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		products = getProductMockup();
		listAdapter = new ListAdapter(products,this);
		ListView modelList = findViewById(R.id.lvModelList);
		Button newButton = findViewById(R.id.bNewProduct);
		newButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				listAdapter.getModelList().clear();
				listAdapter.getModelList().addAll(products);
			}
		});
		modelList.setAdapter(listAdapter);
	}

	private ArrayList<Product> getProductMockup() {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product("product1", "first product"));
		list.add(new Product("product2", "second product"));
		list.add(new Product("milk", "milk product"));
		list.add(new Product("eggs", "egg product"));
		list.add(new Product("chocolate", "dark"));
		list.add(new Product("chocolate", "milk chocolate"));
		return list;
	}
}
