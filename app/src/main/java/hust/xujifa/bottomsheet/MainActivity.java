package hust.xujifa.bottomsheet;

import android.app.Activity;
import android.app.Dialog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;


public class MainActivity extends Activity  {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.activity_main);
        LinearLayoutCompat.LayoutParams params=new LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        LinearLayoutCompat compat=new LinearLayoutCompat(this);
        compat.setOrientation(LinearLayoutCompat.HORIZONTAL);
        SimpleBottomSheet bottomSheet=new SimpleBottomSheet(this,R.style.MaterialDialogSheet);
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.mipmap.test24dp);
        bottomSheet.add(bitmap,"列表一");
        bottomSheet.add(bitmap,"列表一");
        bottomSheet.add(bitmap,"列表一");
        bottomSheet.show();

    }







}