package com.example.finedust.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finedust.R;
import com.example.finedust.model.dust_material.Item;
import com.example.finedust.util.Utils;
import com.github.lzyzsd.circleprogress.ArcProgress;

// TODO : MainFragment로 클래스명 변경하기
public class GpsLocationFragment extends Fragment {

    private static final String TAG = GpsLocationFragment.class.getSimpleName();

    private TextView mLocationTextView;
    private TextView mAddressTextView;

    public GpsLocationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gpslocation, container, false);

        mLocationTextView = view.findViewById(R.id.text_current_location);
        mAddressTextView = view.findViewById(R.id.text_current_address);
        if (savedInstanceState != null) {
            mLocationTextView.setText(savedInstanceState.getString("location"));
            mAddressTextView.setText(savedInstanceState.getString("address"));
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            String location = getArguments().getString("location");
            String address = getArguments().getString("address");
            mLocationTextView.setText(location);
            mAddressTextView.setText(address);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("location", mLocationTextView.getText().toString());
        outState.putString("address", mAddressTextView.getText().toString());
    }

    public void setAddress(String address) {
        mAddressTextView.setText(address);
    }

    public void showFineDust(Item finedust) {
        ArcProgress graph = getView().findViewById(R.id.graph_cai);
        try {
            graph.setProgress(Float.parseFloat(finedust.getKhaiValue())); // 통합대기환경수치
            graph.setBottomText(Utils.getDustGrade(finedust.getKhaiGrade())); // 통합대기환경지수(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)

            int grade = Integer.parseInt(finedust.getKhaiGrade());
            switch (grade) {
                case 1:
                    graph.setFinishedStrokeColor(Color.BLUE);
                    graph.setTextColor(Color.BLUE);
                    break;
                case 2:
                    graph.setFinishedStrokeColor(Color.parseColor("#24AE5F"));
                    graph.setTextColor(Color.parseColor("#24AE5F"));
                    break;
                case 3:
                    graph.setFinishedStrokeColor(Color.YELLOW);
                    graph.setTextColor(Color.YELLOW);
                    break;
                case 4:
                    graph.setFinishedStrokeColor(Color.RED);
                    graph.setTextColor(Color.RED);
                    break;
            }
        } catch (Exception e) {
            graph.setProgress(0);
        }
    }

}