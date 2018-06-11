package com.example.admin.calculator;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class ProgrammerActivity extends AppCompatActivity {
    private Button[] btn = new Button[10];// 0~9十个数字
    private TextView show;
    private Button clear,cancel,div, mul, sub, add, equal,a,b,c,d,e,f;
    private RadioButton sixteenj,eightj,twoj,tenj;
    private Boolean sjsign = false, tensign= true, eightsign= false, twosign = false,optsign = false
            ,equsign = false;//进制标志
    private int jzsign = 10;
    private  String opt = "" ,num1 = "",num2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        show = (TextView)findViewById(R.id.show);
        btn[0] = (Button) findViewById(R.id.zero);
        btn[1] = (Button) findViewById(R.id.one);
        btn[2] = (Button) findViewById(R.id.two);
        btn[3] = (Button) findViewById(R.id.three);
        btn[4] = (Button) findViewById(R.id.four);
        btn[5] = (Button) findViewById(R.id.five);
        btn[6] = (Button) findViewById(R.id.six);
        btn[7] = (Button) findViewById(R.id.seven);
        btn[8] = (Button) findViewById(R.id.eight);
        btn[9] = (Button) findViewById(R.id.nine);
        div = (Button) findViewById(R.id.divide);
        mul = (Button) findViewById(R.id.multiply);
        sub = (Button) findViewById(R.id.subtract);
        add = (Button) findViewById(R.id.add);
        equal = (Button) findViewById(R.id.equal);
        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.E);
        f = (Button) findViewById(R.id.F);
        clear = (Button) findViewById(R.id.clear);
        cancel = (Button) findViewById(R.id.cancel);
        sixteenj = (RadioButton) findViewById(R.id.sixteenj);
        eightj = (RadioButton) findViewById(R.id.eightj);
        tenj = (RadioButton) findViewById(R.id.tenj);
        twoj = (RadioButton) findViewById(R.id.twoj);
        // 为按键绑定监听器
        for (int i = 0; i < 10; i++) {
            btn[i].setOnClickListener(actionPerformed);
        }
        div.setOnClickListener(actionPerformed);
        mul.setOnClickListener(actionPerformed);
        sub.setOnClickListener(actionPerformed);
        add.setOnClickListener(actionPerformed);
        equal.setOnClickListener(actionPerformed);
        a.setOnClickListener(actionPerformed);
        b.setOnClickListener(actionPerformed);
        c.setOnClickListener(actionPerformed);
        d.setOnClickListener(actionPerformed);
        e.setOnClickListener(actionPerformed);
        f.setOnClickListener(actionPerformed);
        sixteenj.setOnClickListener(actionPerformed);
        eightj.setOnClickListener(actionPerformed);
        tenj.setOnClickListener(actionPerformed);
        twoj.setOnClickListener(actionPerformed);
        clear.setOnClickListener(actionPerformed);
        cancel.setOnClickListener(actionPerformed);
    }


    private OnClickListener actionPerformed = new OnClickListener() {

        public void onClick(View v) {

            String command = ((Button) v).getText().toString();
            String t = "0123456789ABCDEFabcdef";

            // 显示器上的字符串
            //String str = show.getText().toString();
            if (("0123456789ABCDEF".indexOf(command) != -1 && optsign)||("0123456789ABCDEF".indexOf(command) != -1 &&equsign)) {
                show.setText("");
                show.append(command);
                equsign = false;
            }else
            if ("0123456789ABCDEF".indexOf(command) != -1) {
                show.append(command);
            }
            else if(command.compareTo("X") == 0){
                if (show.getText().toString().length() > 0) {
                    show.setText(show.getText().toString().substring(0, show.getText().toString().length() - 1));
                }
            }else
            if (command.compareTo("L") == 0) {
                // 将显示器内容设置为0
                show.setText("");
            }else if (command.compareTo("十六进制") == 0 && show.getText().toString().equals("")) {
                // 将显示器内容设置为0
                sjsign = true;
                if(tensign){
                    jzsign = 10;
                    tensign = false;
                }else if(eightsign){
                    jzsign = 8;
                    eightsign = false;
                }else if(twosign ){
                    jzsign = 2;
                    twosign = false;
                }
            }
            else if (command.compareTo("十六进制") == 0) {
                // 将显示器内容设置为0
                sjsign = true;
                if(tensign){
                    jzsign = 10;
                    tensign = false;
                }else if(eightsign){
                    jzsign = 8;
                    eightsign = false;
                }else if(twosign ){
                    jzsign = 2;
                    twosign = false;
                }
                jztran();
            }else
            if (command.compareTo("八进制") == 0 && show.getText().toString().equals("")) {
                // 将显示器内容设置为0
                eightsign = true;
                if(tensign){
                    jzsign = 10;
                    tensign = false;
                }else if(sjsign){
                    jzsign = 16;
                    sjsign = false;
                }else if(twosign ){
                    jzsign = 2;
                    twosign = false;
                }
            }else
            if (command.compareTo("八进制") == 0) {
                // 将显示器内容设置为0
                eightsign = true;
                if(tensign){
                    jzsign = 10;
                    tensign = false;
                }else if(sjsign){
                    jzsign = 16;
                    sjsign = false;
                }else if(twosign ){
                    jzsign = 2;
                    twosign = false;
                }
                jztran();
            }else
            if (command.compareTo("二进制") == 0 && show.getText().toString().equals("")) {
                // 将显示器内容设置为0
                twosign = true;
                if(tensign){
                    jzsign = 10;
                    tensign = false;
                }else if( sjsign){
                    jzsign = 16;
                    sjsign = false;
                }else if( eightsign){
                    jzsign = 8;
                    eightsign = false;
                }
            }else
            if (command.compareTo("二进制") == 0) {
                // 将显示器内容设置为0
                twosign = true;
                if(tensign){
                    jzsign = 10;
                    tensign = false;
                }else if( sjsign){
                    jzsign = 16;
                    sjsign = false;
                }else if( eightsign){
                    jzsign = 8;
                    eightsign = false;
                }
                jztran();
            }else
            if (command.compareTo("十进制") == 0 && show.getText().toString().equals("")) {
                // 将显示器内容设置为0
                tensign= true;
                if(twosign){
                    jzsign = 2;
                    twosign = false;
                }else if( sjsign){
                    jzsign = 16;
                    sjsign = false;
                }else if( eightsign){
                    jzsign = 8;
                    eightsign = false;
                }
            }else
            if (command.compareTo("十进制") == 0) {
                // 将显示器内容设置为0
                tensign= true;
                if(twosign){
                    jzsign = 2;
                    twosign = false;
                }else if( sjsign){
                    jzsign = 16;
                    sjsign = false;
                }else if( eightsign){
                    jzsign = 8;
                    eightsign = false;
                }
                jztran();
            }else
            if(command.compareTo("+") == 0){
                num1 =  show.getText().toString();
                opt = "+";
                optsign = true;
            }else
            if(command.compareTo("-") == 0){
                num1 = show.getText().toString();
                opt = "-";
                optsign = true;
            }else
            if(command.compareTo("*") == 0){
                num1 =  show.getText().toString();
                opt = "*";
                optsign = true;
            }else
            if(command.compareTo("/") == 0){
                num1 = show.getText().toString();
                opt = "/";
                optsign = true;
            }else
            if(command.compareTo("=") == 0){
                num2 = show.getText().toString();
                optsign = false;
                equsign = true;
                calc();
            }
        }
    };

    private void jztran(){
        int result;
        if(sjsign){
            result = Integer.valueOf(show.getText().toString(),jzsign);
            show.setText(Integer.toHexString(result));
        }else if(tensign){
            String a = Integer.valueOf(show.getText().toString(),jzsign).toString();
            show.setText(a);
        }else if(eightsign){
            result = Integer.valueOf(show.getText().toString(),jzsign);
            show.setText(Integer.toOctalString(result));
        }else if(twosign){
            result = Integer.valueOf(show.getText().toString(),jzsign);
            show.setText(Integer.toBinaryString(result));
        }
    }

    private void calc(){
        int n1,n2,res;
        switch (opt){
            case "+":
                if(sjsign){
                    n1  =  Integer.valueOf(num1,16);
                    n2  =  Integer.valueOf(num2,16);
                    res = n1 + n2;
                    show.setText(res + "");
                }
                if(tensign){
                    n1  =  Integer.valueOf(num1,10);
                    n2  =  Integer.valueOf(num2,10);
                    res = n1 + n2;
                    show.setText(res + "");
                }
                if(eightsign){
                    n1  =  Integer.valueOf(num1,8);
                    n2  =  Integer.valueOf(num2,8);
                    res = n1 + n2;
                    show.setText(res + "");
                }
                if(twosign){
                    n1  =  Integer.valueOf(num1,2);
                    n2  =  Integer.valueOf(num2,2);
                    res = n1 + n2;
                    show.setText(res + "");
                }
                break;
            case "-":
                if(sjsign){
                    n1  =  Integer.valueOf(num1,16);
                    n2  =  Integer.valueOf(num2,16);
                    res = n1 - n2;
                    show.setText(res + "");
                }
                if(tensign){
                    n1  =  Integer.valueOf(num1,10);
                    n2  =  Integer.valueOf(num2,10);
                    res = n1 - n2;
                    show.setText(res + "");
                }
                if(eightsign){
                    n1  =  Integer.valueOf(num1,8);
                    n2  =  Integer.valueOf(num2,8);
                    res = n1 - n2;
                    show.setText(res + "");
                }
                if(twosign){
                    n1  =  Integer.valueOf(num1,2);
                    n2  =  Integer.valueOf(num2,2);
                    res = n1 - n2;
                    show.setText(res + "");
                }
                break;
            case "*":
                if(sjsign){
                    n1  =  Integer.valueOf(num1,16);
                    n2  =  Integer.valueOf(num2,16);
                    res = n1 * n2;
                    show.setText(res + "");
                }
                if(tensign){
                    n1  =  Integer.valueOf(num1,10);
                    n2  =  Integer.valueOf(num2,10);
                    res = n1 * n2;
                    show.setText(res + "");
                }
                if(eightsign){
                    n1  =  Integer.valueOf(num1,8);
                    n2  =  Integer.valueOf(num2,8);
                    res = n1 * n2;
                    show.setText(res + "");
                }
                if(twosign){
                    n1  =  Integer.valueOf(num1,2);
                    n2  =  Integer.valueOf(num2,2);
                    res = n1 * n2;
                    show.setText(res + "");
                }
                break;
            case "/":
                if(num2=="0"){
                    show.setText("除数不能为0");
                }
                if(sjsign){
                    n1  =  Integer.valueOf(num1,16);
                    n2  =  Integer.valueOf(num2,16);
                    res = n1 / n2;
                    show.setText(res + "");
                }
                if(tensign){
                    n1  =  Integer.valueOf(num1,10);
                    n2  =  Integer.valueOf(num2,10);
                    res = n1 / n2;
                    show.setText(res + "");
                }
                if(eightsign){
                    n1  =  Integer.valueOf(num1,8);
                    n2  =  Integer.valueOf(num2,8);
                    res = n1 / n2;
                    show.setText(res + "");
                }
                if(twosign){
                    n1  =  Integer.valueOf(num1,2);
                    n2  =  Integer.valueOf(num2,2);
                    res = n1 / n2;
                    show.setText(res + "");
                }
        }
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
            case R.id.unit:
                intent.setClass(ProgrammerActivity.this,UnitActivity.class);
                startActivity(intent);
                ProgrammerActivity.this.finish();
                break;
            case R.id.usual:
                intent.setClass(ProgrammerActivity.this,MainActivity.class);
                startActivity(intent);
                ProgrammerActivity.this.finish();
                break;
        }
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }
}
