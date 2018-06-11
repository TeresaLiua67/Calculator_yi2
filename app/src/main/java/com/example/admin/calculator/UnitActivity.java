package com.example.admin.calculator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;

public class UnitActivity extends AppCompatActivity {
    private Spinner type,choose1,choose2;
    private TextView out;
    private EditText in;
    private String input="公里" ,result="公里",data2;
    private Double data;
    private Button pointd,cleard,canceld;
    private Button[] btn = new Button[10];
    private ArrayAdapter<String> adapterBasic,adapterCh1,adapterCh2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        out = (TextView) findViewById(R.id.out);
        in = (EditText) findViewById(R.id.in);
        btn[0] = (Button) findViewById(R.id.zerod);
        btn[1] = (Button) findViewById(R.id.oned);
        btn[2] = (Button) findViewById(R.id.twod);
        btn[3] = (Button) findViewById(R.id.threed);
        btn[4] = (Button) findViewById(R.id.fourd);
        btn[5] = (Button) findViewById(R.id.fived);
        btn[6] = (Button) findViewById(R.id.sixd);
        btn[7] = (Button) findViewById(R.id.sevend);
        btn[8] = (Button) findViewById(R.id.eightd);
        btn[9] = (Button) findViewById(R.id.nined);
        pointd = (Button) findViewById(R.id.pointd);
        cleard = (Button) findViewById(R.id.cleard);
        canceld = (Button) findViewById(R.id.canceld);
        type = (Spinner) findViewById(R.id.type);
        choose1 = (Spinner) findViewById(R.id.choose1);
        choose2 = (Spinner) findViewById(R.id.choose2);


        for (int i = 0; i < 10; i++) {
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String command = ((Button) view).getText().toString();
                    if(in.getText().toString().equals("0"))
                        in.setText(command);
                    else
                        in.append(command);
                }
            });
        }
        pointd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String command = ((Button) view).getText().toString();
                if(in.getText().toString().equals("0"))
                    in.setText(command);
                else
                    in.append(command);
            }
        });
        cleard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                in.setText("");
            }
        });
        canceld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (in.getText().toString().length() > 0) {
                    in.setText(in.getText().toString().substring(0, in.getText().toString().length() - 1));
                }
            }
        });
        //MyOnItemSelectedListener cho=new MyOnItemSelectedListener();
        //this.type.setOnItemSelectedListener(cho);
        //this.choose1.setOnItemSelectedListener(cho);
        //this.choose2.setOnItemSelectedListener(cho);
        adapterBasic = new ArrayAdapter<String>(UnitActivity.this, android.R.layout.simple_spinner_dropdown_item, getBasicDataSource());
        type.setAdapter(adapterBasic);
        type.setOnItemSelectedListener(new MyOnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                if (pos == 0) {
                    adapterCh1 = new ArrayAdapter<String>(UnitActivity.this, android.R.layout.simple_spinner_dropdown_item, getLengthDataSource());
                    choose1.setAdapter(adapterCh1);
                    adapterCh2 = new ArrayAdapter<String>(UnitActivity.this, android.R.layout.simple_spinner_dropdown_item, getLengthDataSource());
                    choose2.setAdapter(adapterCh2);
                } else if (pos == 1) {
                    adapterCh1 = new ArrayAdapter<String>(UnitActivity.this, android.R.layout.simple_spinner_dropdown_item, getMassDataSource());
                    choose1.setAdapter(adapterCh1);
                    adapterCh2 = new ArrayAdapter<String>(UnitActivity.this, android.R.layout.simple_spinner_dropdown_item, getMassDataSource());
                    choose2.setAdapter(adapterCh2);
                }
            }
        });

        in.addTextChangedListener(textWatcher);

        choose1.setOnItemSelectedListener(new MyOnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                input=choose1.getSelectedItem().toString();
                tran();
            }
        });

        choose2.setOnItemSelectedListener(new MyOnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                result=choose2.getSelectedItem().toString();
                tran();
            }
        });

    }



    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            tran();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
    };


    public class MyOnItemSelectedListener implements OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){

        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            //nothing to do
        }
    }
    public List<String> getBasicDataSource(){
        List<String> list = new ArrayList<String>();
        list.add("长度");
        list.add("质量");
        return list;
    }
    public List<String> getLengthDataSource(){
        List<String> list = new ArrayList<String>();
        list.add("公里");
        list.add("米");
        list.add("英尺");
        return list;
    }

    public List<String> getMassDataSource(){
        List<String> list = new ArrayList<String>();
        list.add("吨");
        list.add("千克");
        list.add("磅");
        return list;
    }

    public void tran(){
        data = Double.parseDouble(in.getText().toString());
        switch (input){
            case "公里":
                switch (result){
                    case "公里":
                        data2=Double.toString(data);//将转换后的data转换成String赋值给data2
                        break;
                    case "米":
                        data2=Double.toString(data*1000);
                        break;
                    case "英尺":
                        data2=Double.toString(data*3280.839895013123);
                        break;
                }break;
            case "米":
                switch (result){
                    case "公里":
                        data2=Double.toString(data/1000);//将转换后的data转换成String赋值给data2
                        break;
                    case "米":
                        data2=Double.toString(data);
                        break;
                    case "英尺":
                        data2=Double.toString(data*3.280839895013123);
                        break;
                }break;
            case "英尺":
                switch (result){
                    case "公里":
                        data2=Double.toString(data*0.0003048);//将转换后的data转换成String赋值给data2
                        break;
                    case "米":
                        data2=Double.toString(data*0.3048);
                        break;
                    case "英尺":
                        data2=Double.toString(data);
                        break;
                }break;
            case "吨":
                switch (result){
                    case "吨":
                        data2=Double.toString(data);//将转换后的data转换成String赋值给data2
                        break;
                    case "千克":
                        data2=Double.toString(data*1000);
                        break;
                    case "磅":
                        data2=Double.toString(data*2204.622621848776);
                        break;
                }break;
            case "千克":
                switch (result){
                    case "吨":
                        data2=Double.toString(data/1000);//将转换后的data转换成String赋值给data2
                        break;
                    case "千克":
                        data2=Double.toString(data);
                        break;
                    case "磅":
                        data2=Double.toString(data*2.204622621848776);
                        break;
                }break;
            case "磅":
                switch (result){
                    case "吨":
                        data2=Double.toString(data*0.00045359237);//将转换后的data转换成String赋值给data2
                        break;
                    case "千克":
                        data2=Double.toString(data*0.45359237);
                        break;
                    case "磅":
                        data2=Double.toString(data);
                        break;
                }break;

        }
        out.setText(data2);

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = new Intent();
        switch(id){
            case R.id.jinzhi:
                intent.setClass(UnitActivity.this,ProgrammerActivity.class);
                startActivity(intent);
                UnitActivity.this.finish();
                break;
            case R.id.usual:
                intent.setClass(UnitActivity.this,MainActivity.class);
                startActivity(intent);
                UnitActivity.this.finish();
                break;
        }
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }
}
