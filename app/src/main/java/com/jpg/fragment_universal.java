package com.jpg;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_universal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_universal extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String radioButtonSelected = "";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_universal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment universal.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_universal newInstance(String param1, String param2) {
        fragment_universal fragment = new fragment_universal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void onStop() {
        super.onStop();
        ((RegistroActivity)getActivity()).setVariable(radioButtonSelected);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_universal, container, false);
        final EditText date = (EditText) view.findViewById(R.id.etPlannedDate);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio);
        final RadioButton rbtn_commerce = (RadioButton)view.findViewById(R.id.rbtn_commerce);
        final RadioButton rbtn_deliver = (RadioButton)view.findViewById(R.id.rbtn_deliver);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.rbtn_commerce == checkedId){
                    ((RegistroActivity)getActivity()).setVariable("commerce");
                }else if (R.id.rbtn_deliver == checkedId){
                    ((RegistroActivity)getActivity()).setVariable("deliver");
                }else{
                    ((RegistroActivity)getActivity()).setVariable("client");
                }
            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.etPlannedDate:
                        showDatePickerDialog(date);
                        break;
                }
            }
        });



        return view;

    }



    private void showDatePickerDialog(final EditText d) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                d.setText(selectedDate);
            }
        });

        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }
}


