package com.zinnox.projects.followappui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sgiosviews.SGPickerView;
import com.zinnox.projects.followappui.R;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


public class TabHomeSettings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TabHomeSettings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabHomeSettings.
     */
    // TODO: Rename and change types and number of parameters
    public static TabHomeSettings newInstance(String param1, String param2) {
        TabHomeSettings fragment = new TabHomeSettings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void setFontForView(TextView view) {
        Typeface font = Typeface.createFromAsset(getResources().getAssets(), "fonts/HelveticaNeue-Bold.ttf");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //operatoins on all the settings
        final View InputFragmentView = inflater.inflate(R.layout.setting, container, false);
        final SGPickerView pickerView = (SGPickerView) InputFragmentView.findViewById(R.id.pickerView);
        final RelativeLayout settingxml = (RelativeLayout)InputFragmentView.findViewById(R.id.settingxml);
        RelativeLayout setting3 = (RelativeLayout)InputFragmentView.findViewById(R.id.setting_3);
        final TextView setting_3_menu = (TextView)InputFragmentView.findViewById(R.id.setting_3_menu);
        RelativeLayout setting4 = (RelativeLayout)InputFragmentView.findViewById(R.id.setting_4);
        RelativeLayout setting5 = (RelativeLayout)InputFragmentView.findViewById(R.id.setting_5);
        final TextView setting_5_menu = (TextView)InputFragmentView.findViewById(R.id.setting_5_menu);
        RelativeLayout setting6 = (RelativeLayout)InputFragmentView.findViewById(R.id.setting_6);
        final TextView setting_6_menu = (TextView)InputFragmentView.findViewById(R.id.setting_6_menu);
        RelativeLayout setting8 = (RelativeLayout)InputFragmentView.findViewById(R.id.setting_8);
        RelativeLayout setting9 = (RelativeLayout)InputFragmentView.findViewById(R.id.setting_9);

        LinearLayout DisablePickerView = (LinearLayout)InputFragmentView.findViewById(R.id.DisablePickerView);


        //Invisible Picker View on parent click
        DisablePickerView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pickerView.setVisibility(View.INVISIBLE);
            }
        });
        //Default Setting
        setting_3_menu.setText("Record and Save All");
        setting_5_menu.setText("Not Set");
        setting_6_menu.setText("Voice up & Downlink");



        //SETTING 3===========================fś

        //info icon onclick listener
        ImageView setting_3_info = (ImageView)InputFragmentView.findViewById(R.id.info_set_3);
        setting_3_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutIn = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                CardView viewToShow = (CardView) layoutIn.inflate(R.layout.popup_set_3,null);
                viewToShow.setBackground(new ColorDrawable(Color.TRANSPARENT));
                new AlertDialog.Builder(getActivity())
                        .setView(viewToShow).create().show();
            }
        });

        setting3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(getActivity(), "setting3!", Toast.LENGTH_SHORT).show();
                if(pickerView.getVisibility() == View.INVISIBLE){
                    pickerView.setVisibility(View.VISIBLE);
                }else
                    pickerView.setVisibility(View.INVISIBLE);


                ArrayList<String> items = new ArrayList<String>();
                items.add("Record and Save All");
                items.add("Ask To Save");
                items.add("Only Group Members");
                pickerView.setItems(items);

                pickerView.setPickerListener(new SGPickerView.SGPickerViewListener() {
                    @Override
                    public void itemSelected(String item, int index) {
                        //Toast.makeText(getActivity(), " Index = " + String.valueOf(index) + " Item name " + item, Toast.LENGTH_SHORT).show();
                        setting_3_menu.setText(item);
                    }
                });

            }
        });

        //SETTING 4 =====================================
        setting4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ImageView setting_4_info = (ImageView)InputFragmentView.findViewById(R.id.info_set_4);
                setting_4_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater layoutIn = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                        CardView viewToShow = (CardView) layoutIn.inflate(R.layout.popup_set_3,null);
                        viewToShow.setBackground(new ColorDrawable(Color.TRANSPARENT));
                        new AlertDialog.Builder(getActivity())
                                .setView(viewToShow).create().show();
                    }
                });
            }
        });

        //SETTING 5 =====================================
        TextView setting_5_info = (TextView)InputFragmentView.findViewById(R.id.info_set_5);
        setting_5_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater layoutIn = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                        CardView viewToShow = (CardView) layoutIn.inflate(R.layout.popup_set_5,null);
                        viewToShow.setBackground(new ColorDrawable(Color.TRANSPARENT));
                        new AlertDialog.Builder(getActivity())
                                .setView(viewToShow).create().show();
                    }
                });


        //SETTING 6 ===========================
        //info icon onclick listener
        ImageView setting_6_info = (ImageView)InputFragmentView.findViewById(R.id.info_set_6);
        setting_6_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutIn = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                CardView viewToShow = (CardView) layoutIn.inflate(R.layout.popup_set_3,null);
                viewToShow.setBackground(new ColorDrawable(Color.TRANSPARENT));
                new AlertDialog.Builder(getActivity())
                        .setView(viewToShow).create().show();
            }
        });

        setting6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(getActivity(), "setting3!", Toast.LENGTH_SHORT).show();
                if(pickerView.getVisibility() == View.INVISIBLE){
                    pickerView.setVisibility(View.VISIBLE);
                }else
                    pickerView.setVisibility(View.INVISIBLE);


                ArrayList<String> items = new ArrayList<String>();
                items.add("Voice up & Downlink");
                items.add("Microphone");
                items.add("Voice for VoIP");
                pickerView.setItems(items);

                pickerView.setPickerListener(new SGPickerView.SGPickerViewListener() {
                    @Override
                    public void itemSelected(String item, int index) {
                        //Toast.makeText(getActivity(), " Index = " + String.valueOf(index) + " Item name " + item, Toast.LENGTH_SHORT).show();
                        setting_6_menu.setText(item);
                    }
                });

            }
        });

        //SETTING 8 ===========================
        //info icon onclick listener

        ImageView setting_8_info = (ImageView)InputFragmentView.findViewById(R.id.info_set_8);
        setting_8_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutIn = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                CardView viewToShow = (CardView) layoutIn.inflate(R.layout.popup_set_3,null);
                viewToShow.setBackground(new ColorDrawable(Color.TRANSPARENT));
                new AlertDialog.Builder(getActivity())
                        .setView(viewToShow).create().show();
            }
        });

        setting8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(getActivity(), "setting3!", Toast.LENGTH_SHORT).show();
                if(pickerView.getVisibility() == View.INVISIBLE){
                    pickerView.setVisibility(View.VISIBLE);
                }else
                    pickerView.setVisibility(View.INVISIBLE);


                ArrayList<String> items = new ArrayList<String>();
                items.add("Mode 1");
                items.add("Mode 2");
                items.add("Mode 3");
                pickerView.setItems(items);

                pickerView.setPickerListener(new SGPickerView.SGPickerViewListener() {
                    @Override
                    public void itemSelected(String item, int index) {
                        //Toast.makeText(getActivity(), " Index = " + String.valueOf(index) + " Item name " + item, Toast.LENGTH_SHORT).show();
                       // setting_6_menu.setText(item);
                    }
                });

            }
        });
        //SETTING 9 =====================================
        setting9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getContext(),"call fragment",Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return InputFragmentView;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
