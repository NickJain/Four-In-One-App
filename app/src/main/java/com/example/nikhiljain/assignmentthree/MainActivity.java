package com.example.nikhiljain.assignmentthree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button b1, b2, b3;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText) findViewById(R.id.editText);
        ed2= (EditText) findViewById(R.id.editText2);
        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);
        txt1= (TextView) findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= ed1.getText().toString();
                String str1= ed2.getText().toString();

                int str_length= str.length();
                int str1_length= str1.length();
                if(str1_length > str_length){
                    String t;
                    t= str;
                    str= str1;
                    str1= t;
                }

                int c=0,i=0,j=0;
                for(i=0; i<str1.length(); i++){
                    char ch = str1.charAt(i);
                    for(; j<str.length();j++){
                        if(ch==str.charAt(j))
                        {
                            c++;j++;break;
                        }
                    }
                }

                if(c==str1.length())
                {
                    txt1.setText(str + " and " + str1 + " are marsupial.");
                }
                else
                    txt1.setText(str + " and " + str1 + " are not marsupial.");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= ed1.getText().toString();
                String str1= ed2.getText().toString();

                char[] characters1= str.toUpperCase().toCharArray();
                char[] characters2= str1.toUpperCase().toCharArray();
                Arrays.sort(characters1);
                Arrays.sort(characters2);
                String char1= String.valueOf(characters1);
                String char2= String.valueOf(characters2);

                if(char1.equals(char2)){
                    txt1.setText(str + " and " + str1 + " are anagrams.");
                }

                else{
                    txt1.setText(str + " and " + str1  + " are not anagrams.");
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= ed1.getText().toString();
                String str1= ed2.getText().toString();
                StringBuffer sb1= new StringBuffer(str1);
                sb1= sb1.reverse();
                str1= sb1.toString();
                if(str.equals(str1)){
                    txt1.setText(str + " and " + sb1.reverse() + " are anadromes.");
                }
                else{
                    txt1.setText(str + " and " + sb1.reverse() + " are not anadromes.");
                }
            }
        });

        ed2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String str= ed2.getText().toString();
                    int c=0;
                    if(str.length()<26){
                        txt1.setText(str + " is not a panagram.");
                    }
                    else{
                        char[] pan_str= str.toUpperCase().toCharArray();
                        Arrays.sort(pan_str);
                        for(int i=0; i<pan_str.length;i++){
                            if(pan_str[i]==pan_str[i+1]){
                                c++;
                            }
                        }
                        if(c>0){
                            txt1.setText(str + " is not a panagram.");
                        }
                        else{
                            txt1.setText(str + " is a panagram.");
                        }
                    }
                }
            }
        });

    }

}
