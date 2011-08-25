package com.dibbus.android.demo.gradients;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class ButtonAdapter extends BaseAdapter {
    private Context mContext;

    public ButtonAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return Gradients.AllGradients().size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Button b;
        if (convertView == null) {
            b = new Button(mContext);
            b.setLayoutParams(new GridView.LayoutParams(LayoutParams.FILL_PARENT, 50));            
            b.setPadding(8, 8, 8, 8);
            b.setTextSize(18f);      
        } else {
            b = (Button) convertView;
        }
        
        final GradientColor gd = Gradients.AllGradients().get(position);
        b.setBackgroundDrawable(Gradients.NewGradient(gd));
        b.setText(gd.getName());
        b.setTextColor(gd.getTextColor());    
        b.setShadowLayer(1f, 1f, 1f, gd.getColorE());
        
        return b;
    }    
}