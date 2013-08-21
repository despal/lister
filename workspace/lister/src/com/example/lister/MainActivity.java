package com.example.lister;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	String[] array1;
	String[] array2;
	int N1,N2,List;
	SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        array1 = getResources().getStringArray(R.array.list);
        array2 = getResources().getStringArray(R.array.list2);
        mSettings = getSharedPreferences("mySettings",MODE_PRIVATE);
        N1 = mSettings.getInt("N1",0);
        N2 = mSettings.getInt("N2",0);
        List = mSettings.getInt("List",0);
        TextView tv = (TextView) findViewById(R.id.textView1);
        if(List==0)
        {
        	tv.setText(array1[N1]);
        	tv = (TextView) findViewById(R.id.textView2);
            tv.setText(String.valueOf(N1)+"/"+String.valueOf(array1.length));
        }
        else if(List ==1)
        {
        	tv.setText(array2[N2]);
        	tv = (TextView) findViewById(R.id.textView2);
        	tv.setText(String.valueOf(N2)+"/"+String.valueOf(array2.length));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
        
    @Override
    protected void onPause() {
      super.onStop();
      Editor edit;
      edit = mSettings.edit();
      edit.putInt("N1", N1);
      edit.putInt("N2", N2);
      edit.putInt("List", List);
      edit.commit();
      }
    
    public void forward(View view)
    {
    	TextView tv = (TextView) findViewById(R.id.textView1);
    	if(List == 0)
    	{
    		if(N1+1 < array1.length)
    		{
    			N1++;
    			tv.setText(array1[N1]);
    		}
    		tv = (TextView) findViewById(R.id.textView2);
    		tv.setText(String.valueOf(N1)+"/"+String.valueOf(array1.length));
    	}
    	else if(List == 1)
    	{
    		if(N2+1 < array2.length)
    		{
    			N2++;
    			tv.setText(array2[N2]);
    		}
    		tv = (TextView) findViewById(R.id.textView2);
    		tv.setText(String.valueOf(N2)+"/"+String.valueOf(array2.length));
    	}
    }
    
    public void backward(View view)
    {
    	TextView tv = (TextView) findViewById(R.id.textView1);
    	if(List == 0)
    	{
    		if(N1-1 >=0 )
    		{
    			N1--;
    			tv.setText(array1[N1]);
    		}
    		tv = (TextView) findViewById(R.id.textView2);
    		tv.setText(String.valueOf(N1)+"/"+String.valueOf(array1.length));
    	}
    	else if(List == 1)
    	{
    		if(N2-1 >=0 )
    		{
    			N2--;
    			tv.setText(array2[N2]);
    		}
    		tv = (TextView) findViewById(R.id.textView2);
    		tv.setText(String.valueOf(N2)+"/"+String.valueOf(array2.length));
    	}
    }
    
    public void toList1(View view)
    {
    	List = 0;
    	TextView tv = (TextView) findViewById(R.id.textView1);
    	tv.setText(array1[N1]);
    	tv = (TextView) findViewById(R.id.textView2);
		tv.setText(String.valueOf(N1)+"/"+String.valueOf(array1.length));
    }
    
    public void toList2(View view)
    {
    	List = 1;
    	TextView tv = (TextView) findViewById(R.id.textView1);
    	tv.setText(array2[N2]);
    	tv = (TextView) findViewById(R.id.textView2);
		tv.setText(String.valueOf(N2)+"/"+String.valueOf(array2.length));
    }
}
