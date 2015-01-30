package com.example.scrollview.yo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity 
	implements OnClickListener
{

	private ArrayList<Bitmap> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		HorizontalScrollView hsv = new HorizontalScrollView(this);
		setContentView(hsv);
		//setContentView(R.layout.activity_main);

		LinearLayout mygallery = new LinearLayout(this);
		mygallery.setOrientation(LinearLayout.HORIZONTAL);
		mygallery.setGravity(Gravity.CENTER_VERTICAL);
		hsv.addView(mygallery);
		
		list = new ArrayList<Bitmap>();
		Resources res = getResources();
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_add));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_delete));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_call));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_camera));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_day));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_directions));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_edit));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_help));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_info_details));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_preferences));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_search));
		
		for(int i=0; i<list.size(); i++){
			ImageView iv = new ImageView(this);
//			iv.setLayoutParams(new LayoutParams(140, 140));
			iv.setLayoutParams(new LayoutParams(250, 250));
			iv.setPadding(20, 0, 20, 0);
			iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
			iv.setImageBitmap(list.get(i));
			iv.setId(i);
			iv.setOnClickListener(this);
			mygallery.addView(iv);
		}
		
		
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {

		AlertDialog.Builder ad = new AlertDialog.Builder(this);
		long id = v.getId();
		ad.setMessage("id:" + id);
		ad.setPositiveButton("OK", null);
		ad.show();
	}
}
