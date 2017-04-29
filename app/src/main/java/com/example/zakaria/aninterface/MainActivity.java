package com.example.zakaria.aninterface;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    EditText E1,E2,E3;
    Button B1,B2,B3;
    TextView T1,T2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E1=(EditText)findViewById(R.id.E1);
        E2=(EditText)findViewById(R.id.E2);
        E3=(EditText)findViewById(R.id.E3);
        T1=(TextView) findViewById(R.id.T1);
        T2=(TextView)findViewById(R.id.T2);
        B1=(Button) findViewById(R.id.B1);
        B2=(Button) findViewById(R.id.B2);
    }

public void save(View view) {
    String name = E1.getText().toString();
    String Tt1 = E2.getText().toString();
    String Tt2 = E3.getText().toString();
    int old = Integer.parseInt(Tt1);
    int mark = Integer.parseInt(Tt2);
    save_1(name,old,mark);

}
    public void save_1(String name,int old,int mark)
    {
        File file=new File ("D:\\toto.txt");

        Employe employe = new Employe(name, old, mark);
        Employe temp=null;
        List<Employe>list=new ArrayList<Employe>();
        try
        {
            FileInputStream fis=this.openFileInput("myfile");
            if(fis.available()!=0)
            {
                ObjectInputStream ois=new ObjectInputStream(fis);
                while(fis.available()>0)
                {
                    temp=(Employe)ois.readObject();
                    list.add(temp);
                }
            }
            FileOutputStream fos=this.openFileOutput("myfile",this.MODE_PRIVATE);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(employe);
            for (Employe var:list)
            {
                oos.writeObject(var);
            }

            T1.setText("Done");
        }
        catch (Exception e){}
    }

    public void load(View view) {
        Employe temp=null;
        String s="";
        List<Employe>list=new ArrayList<Employe>();
        try
        {
            FileInputStream fis=this.openFileInput("myfile");
            T2.setText("Done");
            ObjectInputStream ois=new ObjectInputStream(fis);
            while(fis.available()!=0)
            {
                while(fis.available()>0)
                {
                    temp=(Employe)ois.readObject();
                    list.add(temp);
                }

            }
            T2.setText(list.toString());
            T1.setText("Done1");
        }
        catch (Exception e) {}
    }
}
