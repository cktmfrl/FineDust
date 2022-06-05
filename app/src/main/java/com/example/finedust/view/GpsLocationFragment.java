package com.example.finedust.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finedust.R;


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

    public void setCurrentLocation(String location, String address) {
        mAddressTextView.setText("주소 : " + address);
        mLocationTextView.setText(location);
    }

}