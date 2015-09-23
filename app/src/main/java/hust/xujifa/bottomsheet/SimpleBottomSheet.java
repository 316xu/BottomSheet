package hust.xujifa.bottomsheet;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by xujifa on 2015/9/20.
 */
public class SimpleBottomSheet extends Dialog{
    LinearLayoutCompat linearLayoutCompat;
    LinearLayoutCompat.LayoutParams params;
    Context context;
    GestureDetector detector;
    float temp;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("AAA",event.toString());
        if(event.getAction()== MotionEvent.ACTION_DOWN){
            temp=event.getY();
        }else if(event.getAction()== MotionEvent.ACTION_UP){
            if(event.getY()-temp>100){
                hide();
            }
        }




        return true;
    }

    public SimpleBottomSheet(Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(linearLayoutCompat);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }


    void init(Context context){
        this.context=context;
        linearLayoutCompat=new LinearLayoutCompat(context);

        params=new ActionMenuView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayoutCompat.setPadding(
                context.getResources().getDimensionPixelOffset(R.dimen.bottom_sheet_margin_horizontal),
                context.getResources().getDimensionPixelOffset(R.dimen.bottom_sheet_margin_vertical),
                context.getResources().getDimensionPixelOffset(R.dimen.bottom_sheet_margin_horizontal),
                context.getResources().getDimensionPixelOffset(R.dimen.bottom_sheet_padding_vertical)
        );
        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
        linearLayoutCompat.setLayoutParams(params);

    }
    public void add(Bitmap bitmap,String list){
        LinearLayoutCompat compat=new LinearLayoutCompat(context);
        compat.setOrientation(LinearLayoutCompat.HORIZONTAL);

        Resources resources=context.getResources();

        compat.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                resources.getDimensionPixelOffset(R.dimen.bottomsheetheight)));

        TextView textView=new TextView(context);
        textView.setText(list);

        textView.setPadding(resources.getDimensionPixelOffset(R.dimen.bottom_sheet_padding_horizontal),
                0, 0, 0
        );

        textView.setTextSize(20);


        ImageView b=new ImageView(context);
        b.setImageBitmap(bitmap);
        b.setPadding(0, 0, resources.getDimensionPixelOffset(R.dimen.bottom_sheet_padding_horizontal), 0);
        b.setForegroundGravity(Gravity.CENTER);

        compat.setGravity(Gravity.CENTER_VERTICAL);

        compat.addView(b);
        compat.addView(textView);
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        linearLayoutCompat.addView(compat);

    }


}
