package com.example.finedust.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finedust.MainActivity;
import com.example.finedust.R;
import com.example.finedust.data.FineDustRepository;
import com.example.finedust.data.LocationFineDustRepository;
import com.example.finedust.model.FineDust;
import com.example.finedust.model.dust_material.Body;
import com.example.finedust.model.dust_material.Dust;
import com.example.finedust.model.dust_material.Item;
import com.example.finedust.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class FineDustFragment extends Fragment implements FineDustContract.View {

    private static final String TAG = FineDustFragment.class.getSimpleName();

    private RecyclerView mDustListView;

    private FineDustRepository mRepository;
    private FineDustPresenter mPresenter;

    private TextView mLocationTextView;

    public FineDustFragment() {
    }

    public static FineDustFragment newInstance(String city) {
        Bundle args = new Bundle();
        args.putString("city", city);

        FineDustFragment fragment = new FineDustFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finedust, container, false);

        mLocationTextView = view.findViewById(R.id.text_result);
        if (savedInstanceState != null) {
            mLocationTextView.setText("위치 : " + savedInstanceState.getString("city"));
        }

        mDustListView = view.findViewById(R.id.recycler_view);
        RecyclerViewDecoration decoration = new RecyclerViewDecoration(5);
        mDustListView.addItemDecoration(decoration);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            String city = getArguments().getString("city");
            mRepository = new LocationFineDustRepository(getActivity(), city);
        } else {
            mRepository = new LocationFineDustRepository(getActivity(), "서울");
            ((MainActivity) getActivity()).getLastKnownLocation();
        }

        mPresenter = new FineDustPresenter(mRepository, this);

        mPresenter.loadFineDustData();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("city", mLocationTextView.getText().toString());
    }

    @Override
    public void showFineDustResult(FineDust fineDust) {
        try {
            Log.d(TAG, "showFineDustResult(fineDust =  " + fineDust.toString() + ")");

//            mLocationTextView.setText(fineDust.getWeather().getDust().get(0).getStation().getName());
//            mTimeTextView.setText(fineDust.getWeather().getDust().get(0).getTimeObservation());
//            mDustTextView.setText(fineDust.getWeather().getDust().get(0).getPm10().getValue() + " ㎍/㎥, "
//                    + fineDust.getWeather().getDust().get(0).getPm10().getGrade());

            Body body = fineDust.getResponse().getBody();
            int totalCount = body.getTotalCount();
            List<Item> items = body.getItems();
            Log.d(TAG, "totalCount = " + totalCount + ", items.size = " + items.size());
            Item selectedItem = null;
            for (int i = 0; i < items.size(); i++) {
                String grade = items.get(i).getSo2Grade();
                if (null == grade || "null".equals(grade)) {
                    continue;
                } else {
                    selectedItem = items.get(i);
                    break;
                }
            }

            List<Dust> dustItemList = new ArrayList<>();
            dustItemList.add(new Dust("아황산가스(SO2))", selectedItem.getSo2Value(), "ppm", selectedItem.getSo2Grade(), selectedItem.getSo2Flag()));
            dustItemList.add(new Dust("일산화탄소(CO)", selectedItem.getCoValue(), "ppm", selectedItem.getCoGrade(), selectedItem.getCoFlag()));
            dustItemList.add(new Dust("오존(O3)", selectedItem.getO3Value(), "ppm", selectedItem.getO3Grade(), selectedItem.getO3Flag()));
            dustItemList.add(new Dust("이산화질소(NO2)", selectedItem.getNo2Value(), "ppm", selectedItem.getNo2Grade(), selectedItem.getNo2Flag()));
            dustItemList.add(new Dust("미세먼지(PM10)", selectedItem.getPm10Value(), "㎍/㎥", selectedItem.getPm10Grade(), selectedItem.getPm10Flag()));
            dustItemList.add(new Dust("초미세먼지(PM2.5)", selectedItem.getPm25Value(), "㎍/㎥", selectedItem.getPm25Grade(), selectedItem.getPm25Flag()));
            dustItemList.add(new Dust("통합대기지수(CAI)", selectedItem.getKhaiValue(), "", selectedItem.getKhaiGrade(), ""));

            if (selectedItem != null) {
                Log.d(TAG, "selectedItem = " + selectedItem.toString());
                Log.d(TAG, "dustItemList = " + dustItemList.toString());

                ((TextView) getView().findViewById(R.id.text_station_name)).setText("측정소명 : " + selectedItem.getStationName());

                FineDustRecyclerAdapter adapter = new FineDustRecyclerAdapter(dustItemList);
                mDustListView.setAdapter(adapter);

                // log..
                StringBuilder sb = new StringBuilder();
                sb.append("측정소명 : " + selectedItem.getStationName() + ""); // stationName : 측정소명
                sb.append("\n측정망 정보 : " + selectedItem.getSidoName() + ""); // sidoName : 시도 이름 (서울, 부산, 대구, 인천, 광주, 대전, 울산, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주, 세종)
                sb.append("\n시도 이름 :" + selectedItem.getDataTime() + " 분"); // dataTime : 오염도 측정 연-월-일 시간 : 분
                sb.append("\n오염도 측정 연-월-일 시간 : " + selectedItem.getSo2Value() + " ppm"); // so2Value : 아황산가스 농도(단위 : ppm)
                sb.append("\n아황산가스 농도 : " + selectedItem.getCoValue() + " ppm"); // coValue : 일산화탄소 농도(단위 : ppm)
                sb.append("\n오존 농도 : " + selectedItem.getO3Value() + " ppm"); // o3Value : 오존 농도(단위 : ppm)
                sb.append("\n이산화질소 농도 : " + selectedItem.getNo2Value() + " ppm"); // no2Value : 이산화질소 농도(단위 : ppm)
                sb.append("\n미세먼지(PM10) 농도 : " + selectedItem.getPm10Value() + " ㎍/㎥"); // pm10Value : 미세먼지(PM10) 농도(단위 : ㎍/㎥)
                sb.append("\n미세먼지(PM2.5) 농도 : " + selectedItem.getPm25Value() + " ㎍/㎥"); // pm25Value : 미세먼지(PM2.5) 농도(단위 : ㎍/㎥)
                sb.append("\n통합대기환경수치 : " + selectedItem.getKhaiValue() + ""); // khaiValue : 통합대기환경수치
                sb.append("\n통합대기환경지수 : " + Utils.getDustGrade(selectedItem.getKhaiGrade()) + ""); // khaiGrade : 통합대기환경지수(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
                sb.append("\n아황산가스 지수 : " + Utils.getDustGrade(selectedItem.getSo2Grade()) + ""); // so2Grade : 아황산가스 지수(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
                sb.append("\n일산화탄소 지수 : " + Utils.getDustGrade(selectedItem.getCoGrade()) + ""); // coGrade : 일산화탄소 지수(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
                sb.append("\n오존 지수 : " + Utils.getDustGrade(selectedItem.getO3Grade()) + ""); // o3Grade : 오존 지수(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
                sb.append("\n이산화질소 지수 : " + Utils.getDustGrade(selectedItem.getNo2Grade()) + ""); // no2Grade : 이산화질소 지수(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
                sb.append("\n미세먼지(PM10) 24시간 등급 : " + Utils.getDustGrade(selectedItem.getPm10Grade()) + ""); // pm10Grade : 미세먼지(PM10) 24시간 등급자료(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
                sb.append("\n미세먼지(PM2.5) 24시간 등급 : " + Utils.getDustGrade(selectedItem.getPm25Grade()) + ""); // pm25Grade : 미세먼지(PM2.5) 24시간 등급자료(1 : 좋음, 2: 보통, 3: 나쁨, 4: 매우나쁨)
//            sb.append("\nSo2 측정자료 상태정보 : " + selectedItem.getSo2Flag() + ""); // so2Flag : 측정자료 상태정보(점검및교정,장비점검,자료이상,통신장애)
//            sb.append("\nCo 측정자료 상태정보 : " + selectedItem.getCoFlag() + ""); // coFlag : 측정자료 상태정보(점검및교정,장비점검,자료이상,통신장애)
//            sb.append("\nO3 측정자료 상태정보 : " + selectedItem.getO3Flag() + ""); // o3Flag : 측정자료 상태정보(점검및교정,장비점검,자료이상,통신장애)
//            sb.append("\nNo2 측정자료 상태정보 : " + selectedItem.getNo2Flag() + ""); // no2Flag : 측정자료 상태정보(점검및교정,장비점검,자료이상,통신장애)
//            sb.append("\nPm10 측정자료 상태정보 : " + selectedItem.getPm10Flag() + ""); // pm10Flag : 측정자료 상태정보(점검및교정,장비점검,자료이상,통신장애)
//            sb.append("\nPm25 측정자료 상태정보 : " + selectedItem.getPm25Flag() + ""); // pm25Flag : 측정자료 상태정보(점검및교정,장비점검,자료이상,통신장애)
                Log.d(TAG, "selectedItem = " + sb);
            }

        } catch (Exception e) {
            Log.d(TAG, "exception = " + e);
//            mLocationTextView.setText("일일 허용량 초과");
//            mTimeTextView.setText("일일 허용량 초과");
//            mDustTextView.setText("일일 허용량 초과");
        }
    }

    @Override
    public void showLoadError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadingStart() {

    }

    @Override
    public void loadingEnd() {

    }

    @Override
    public void reload(String city) {
        mLocationTextView.setText("위치 : " + city);

        mRepository = new LocationFineDustRepository(getActivity(), city);
        mPresenter = new FineDustPresenter(mRepository, this);
        mPresenter.loadFineDustData();
    }

}
