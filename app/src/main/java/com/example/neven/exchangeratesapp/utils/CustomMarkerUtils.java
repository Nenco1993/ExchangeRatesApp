package com.example.neven.exchangeratesapp.utils;

import android.content.Context;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.exchangeratesapp.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/**
 * Created by Neven on 18.6.2017..
 */
public class CustomMarkerUtils extends MarkerView {

    @BindView(R.id.tvMarkerText)
    TextView tvMarkerText;


    public CustomMarkerUtils(Context context, int layoutResource) {
        super(context, layoutResource);
        ButterKnife.bind(this);


    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        super.refreshContent(e, highlight);

        String value = String.valueOf(e.getY());

        if (!value.equalsIgnoreCase("")){
            tvMarkerText.setText(String.valueOf(e.getY()));
        }



    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
