package com.example.jimit.uicontrols;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText txtName, txtPhone, txtUser, txtPassword;
    private Spinner spnDay, spnMonth, spnYear;

    private RadioGroup rgGender;
    private ToggleButton togglePublic;
    private CheckBox chkAccept;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txtName = (EditText) findViewById(R.id.txt_name);
        txtPhone = (EditText) findViewById(R.id.txt_phone);
        txtUser = (EditText) findViewById(R.id.txt_user);
        txtPassword = (EditText) findViewById(R.id.txt_password);

        spnDay = (Spinner) findViewById(R.id.spn_day);
        spnMonth = (Spinner) findViewById(R.id.spn_month);
        spnYear = (Spinner) findViewById(R.id.spn_year);

        rgGender = (RadioGroup) findViewById(R.id.rg_gender);

        togglePublic = (ToggleButton) findViewById(R.id.toggle_public);
        chkAccept = (CheckBox) findViewById(R.id.chk_accept);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                makeToast("Name=" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                makeToast("Phone=" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                makeToast("User=" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                makeToast("Password=" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                makeToast("txtName Focus=" + hasFocus);
            }
        });

        initSpinnerDay();
        initSpinnerMonth();
        initSpinnerYear();
        initGender();
        initOthers();
    }

    private void initSpinnerDay() {
        ArrayAdapter<CharSequence> adapterDay = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.day, android.R.layout.simple_spinner_item);
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDay.setAdapter(adapterDay);
        spnDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                makeToast("spnDay selected=" + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initSpinnerMonth() {
        ArrayAdapter<CharSequence> adapterMonth = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.months, android.R.layout.simple_spinner_item);
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMonth.setAdapter(adapterMonth);
        spnMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                makeToast("spnMonth selected=" + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initSpinnerYear() {
        ArrayList<String> yearList = new ArrayList<>();
        for (int i = 1950; i < 2016; i++) {
            yearList.add(String.valueOf(i));
        }

        ArrayAdapter<String> adapterYear = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, yearList);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnYear.setAdapter(adapterYear);
        spnYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                makeToast("spnYear selected=" + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initGender() {
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                makeToast("Gender selected=" + rb.getText());
            }
        });
    }

    private void initOthers() {
        togglePublic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                makeToast("togglePublic checked=" + isChecked);
            }
        });

        chkAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                makeToast("Conditions Accepted = " + isChecked);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Submit Clicked");
            }
        });

        btnSubmit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                makeToast("Submit Long Clicked");
                return false;
            }
        });
    }

    private void makeToast(@NonNull String display) {
        Toast.makeText(getApplicationContext(), display, Toast.LENGTH_SHORT).show();
    }
}
