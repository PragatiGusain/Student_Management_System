package com.example.pragatigusain.student_management_system;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class Student
{
    String name,address,college;
    long phone;
    Student(String name,String address,long phone,String college)
    {
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.college=college;
    }
}

public class MainActivity extends AppCompatActivity
{
    TextView user_name,user_address,user_phone,user_college,message,show;
    EditText enter_name,enter_address,enter_phone,enter_college;
    Button add,display,clear;
    ArrayList<Student> std=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name=(TextView)findViewById(R.id.tv1);
        user_address=(TextView)findViewById(R.id.tv2);
        user_phone=(TextView)findViewById(R.id.tv3);
        user_college=(TextView)findViewById(R.id.tv4);
        message=(TextView)findViewById(R.id.tv5);
        show=(TextView)findViewById(R.id.tv6);
        enter_name=(EditText)findViewById(R.id.et1);
        enter_address=(EditText)findViewById(R.id.et2);
        enter_phone=(EditText)findViewById(R.id.et3);
        enter_college=(EditText)findViewById(R.id.et4);
        add=(Button)findViewById(R.id.b1);
        display=(Button)findViewById(R.id.b2);
        clear=(Button)findViewById(R.id.b3);
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    String name=String.valueOf(enter_name.getText());
                    String address=String.valueOf(enter_address.getText());
                    long phone=Long.parseLong(enter_phone.getText().toString());
                    String college=String.valueOf(enter_college.getText());
                    std.add(new Student(name,address,phone,college));
                    Toast.makeText(getApplicationContext(),"Your Details Have Been Submitted",Toast.LENGTH_SHORT).show();
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Valid Details",Toast.LENGTH_SHORT).show();
                }
            }
        });
        display.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for(int i=0;i<std.size();i++)
                {
                    show.setText(show.getText() + "\n" + std.get(i).name);
                    show.setText(show.getText() + "\n" + std.get(i).address);
                    show.setText(show.getText() + "\n" + std.get(i).phone);
                    show.setText(show.getText() + "\n" + std.get(i).college);
                    show.setText(show.getText() + "\n************");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                enter_name.getText().clear();
                enter_address.getText().clear();
                enter_phone.getText().clear();
                enter_college.getText().clear();
            }
        });

    }
}
