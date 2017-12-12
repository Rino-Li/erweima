package cn.edu.uzz.activity.erweima;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

public class MainActivity extends AppCompatActivity {
	private Button shengc;
	private TextView result1;
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		result1=findViewById(R.id.result);
		iv=findViewById(R.id.iv);
	}
	public void scan(View view){
		startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class),0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle bundle=data.getExtras();
			String result=bundle.getString("result");
			result1.setText(result);
		}
	}
	public void make(View view){
		Bitmap bitmap=EncodingUtils.createQRCode("www",256,256,null);
		iv.setImageBitmap(bitmap);
		BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);
	}
}
