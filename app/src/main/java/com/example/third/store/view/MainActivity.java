package com.example.third.store.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
				int checkedProducts = listAdapter.countTrueProducts();
				String itemsChecked = getResources().getQuantityString(R.plurals.checkedNumber, checkedProducts, checkedProducts);
				Toast.makeText(getApplicationContext(), itemsChecked, Toast.LENGTH_SHORT).show();
			}
		});
		modelList.setAdapter(listAdapter);
	}

	private ArrayList<Product> getProductMockup() {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product("product1", "first product", R.drawable.book));
		list.add(new Product("product2", "second product", R.drawable.check));
		list.add(new Product("milk", "milk product", R.drawable.refresh));
		list.add(new Product("eggs", "egg product", R.drawable.book));
		list.add(new Product("chocolate", "dark", R.drawable.check));
		list.add(new Product("chocolate", "milk chocolate", R.drawable.refresh));
		return list;
	}
}
