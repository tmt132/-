package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUM1="com.example.myapplication.EXTRA_NUM1";
    public static final String EXTRA_NUM2="com.example.myapplication.EXTRA_NUM2";
    public static final String EXTRA_NUM3="com.example.myapplication.EXTRA_NUM3";

    Spinner SpinnerGu, SpinnerDong;
    Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        InputStream is = getResources().openRawResource(R.raw.bjdcode);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );







        String line = "";
        try {

            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String array[] = line.split(",");




        SpinnerGu = findViewById(R.id.spinnerGu);
        SpinnerDong = findViewById(R.id.spinnerDong);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                open2(); //버튼 눌렀을 때

            }
        });













        final String jongro[]=new String[92];
        final String jung[]=new String[84];
        final String yongsan[] = new String[49];
        final String seongdong[] = new String[102];
        final String gwangjin[] = new String[9];
        final String dongdaemun[] = new String[56];
        final String jungrang[] = new String[22];
        final String seongbuk[] = new String[80];
        final String gangbuk[] = new String[4];
        final String dobong[] = new String[39];
        final String nowon[] = new String[24];
        final String eunpyeong[] = new String[23];
        final String seodaemun[] = new String[75];
        final String mapo[] = new String[42];
        final String yangcheon[] = new String[20];
        final String gangseo[] = new String[27];
        final String guro[] = new String[40];
        final String geumcheon[] = new String[3];
        final String yeongdeungpo[] = new String[102];
        final String dongjak[] = new String[23];
        final String gwanak[] = new String[37];
        final String seocho[] = new String[27];
        final String gangnam[] = new String[68];
        final String songpa[] = new String[14];
        final String gangdong[] = new String[24];
        final String select[]=new String[1];


        final String gu [][]= {select,jongro,jung,yongsan,seongdong,gwangjin,dongdaemun,jungrang,seongbuk,gangbuk,dobong,nowon,eunpyeong,seodaemun,
        mapo,yangcheon,gangseo,guro,geumcheon,yeongdeungpo,dongjak,gwanak,seocho,gangnam,songpa,gangdong};





        int i=0;
        int j=0;


        for(j=1;j<26;j++) {

            try {
                for (i = 0; i < gu[j].length; i++) {
                    line = reader.readLine();
                    array = line.split(",");
                    gu[j][i] = array[2];
                }
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }// 각 구 array에 동명 할당

        String guhangeul[]={"구선택","종로구","중구","용산구","성동구","광진구",
                "동대문구","중랑구","성북구","강북구","도봉구",
                "노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구",
                "동작구","관악구","서초구","강남구","송파구","강동구"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, guhangeul);


        SpinnerGu.setAdapter(adapter);
        SpinnerGu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                int j=1;
                for(j=1;j<26;j++)
                {
                    if (i == j) {
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, gu[j]);
                        SpinnerDong.setAdapter(adapter1);
                    }
                }// ㅁㅁ구 선택하면 ㅁㅁ구에 해당하는 동만 동 spinner에 나오게 함
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    public void open2() {

        String dong = SpinnerDong.getSelectedItem().toString();
        String gu = SpinnerGu.getSelectedItem().toString();
        Toast.makeText(MainActivity.this, gu + ", " + dong + "selected!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, SubActivity.class);

        InputStream is = getResources().openRawResource(R.raw.bjdcode); //bjd2 파일 불러와서 스피너에 동 이름 지정
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        try {
            String line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }


        String guselected= (String) SpinnerGu.getSelectedItem();
        dong= (String) SpinnerDong.getSelectedItem();

        String selectednum1 = "dkdk";
        String array[]=new String[4];
        String line;

        try {
            for (int i=0;i<1113;i++){
                line = reader.readLine(); //다음줄 읽기
                array = line.split(","); //컴마 단위로 나누기
               if(array[1].equals(guselected)) {
                   if (array[2].equals(dong)) { //동 이름 같을 경우 루프 break
                       break;
                   }
               }
            }
            selectednum1=array[3]; //법정동코드 할당하기
        } catch (IOException e) {
            e.printStackTrace();
        }

        intent.putExtra("name",selectednum1); //법정동코드 다음페이지에 출력
        int selectednum1_ = parseInt(selectednum1);
        intent.putExtra("si",array[0]); //시 다음페이지에 출력
        intent.putExtra("gu",array[1]); //구 다음페이지에 출력
        intent.putExtra("dong",array[2]); //동 다음페이지에 출력



        EditText editText1 = (EditText) findViewById(R.id.edittext1); //면적
        int number1 = parseInt(editText1.getText().toString());

        EditText editText2 = (EditText) findViewById(R.id.edittext2); //층
        int number2 = parseInt(editText2.getText().toString());

        EditText editText3 = (EditText) findViewById(R.id.edittext3); //건축년도
        int number3 = parseInt(editText3.getText().toString());


        intent.putExtra(EXTRA_NUM1, number1);
        intent.putExtra(EXTRA_NUM2, number2);
        intent.putExtra(EXTRA_NUM3, number3);


        final CheckBox cb1 = (CheckBox)findViewById(R.id.check1);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.check2);

        String resultText = "";
        if (cb1.isChecked()) {
            resultText = "전세";
        }
        if (cb2.isChecked()) {
            resultText = "월세";
              }

        intent.putExtra("check",resultText); //전세 월세 중 선택한거 출력

            if(resultText=="월세") {
            String[] arrayselected = new String[7];


            if (selectednum1_ >= 1123010100 && selectednum1_ <= 1123011000) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.dongdaemoonpricemon), selectednum1_, number1, number2, number3, 163);
            }
            if (selectednum1_ >= 1159010100 && selectednum1_ <= 1159010900) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.dongjakpricemon), selectednum1_, number1, number2, number3, 326);
            }
            if (selectednum1_ >= 1138010100 && selectednum1_ <= 1138011400) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.eunpyeongpricemon), selectednum1_, number1, number2, number3, 367);
            }
            if (selectednum1_ >= 1154510100 && selectednum1_ <= 1154510300) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.geumchunpricemon), selectednum1_, number1, number2, number3, 121);
            }
            if (selectednum1_ >= 1153010100 && selectednum1_ <= 1153011200) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.gooropricemon), selectednum1_, number1, number2, number3, 176);
            }
            if (selectednum1_ >= 1135010200 && selectednum1_ <= 1135010600) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.nowonpricemon), selectednum1_, number1, number2, number3, 137);
            }
            if (selectednum1_ >= 1120000100 && selectednum1_ <= 1120092100) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.seongdongpricemon), selectednum1_, number1, number2, number3, 106);
            }
            if (selectednum1_ >= 1129000100 && selectednum1_ <= 1129092600) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.seongbookpricemon), selectednum1_, number1, number2, number3, 235);
            }
            if (selectednum1_ >= 1144000100 && selectednum1_ <= 1144091100) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.mapopricemon), selectednum1_, number1, number2, number3, 448);
            }
            if (selectednum1_ >= 1141000100 && selectednum1_ <= 1141091800) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.seodaemoonpricemon), selectednum1_, number1, number2, number3, 222);
            }
            if (selectednum1_ >= 1174000100 && selectednum1_ <= 1174011000) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.gangdongpricemon), selectednum1_, number1, number2, number3, 396);
            }
            if (selectednum1_ >= 1132000300 && selectednum1_ <= 1132092600) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.dobongpricemon), selectednum1_, number1, number2, number3, 122);
            }
            if (selectednum1_ >= 1156000100 && selectednum1_ <= 1156092100) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.yeongdengpopricemon), selectednum1_, number1, number2, number3, 132);
            }
            if (selectednum1_ >= 1117000100 && selectednum1_ <= 1117090800) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.yongsanpricemon), selectednum1_, number1, number2, number3, 165);
            }
            if (selectednum1_ >= 1147010100 && selectednum1_ <= 1147091700) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.yangchunpricemon), selectednum1_, number1, number2, number3, 233);
            }
            if (selectednum1_ >= 1171010100 && selectednum1_ <= 1171011400) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.songpapricemon), selectednum1_, number1, number2, number3, 1239);
            }
            if (selectednum1_ >= 1150000100 && selectednum1_ <= 1150091100) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.gangseopricemon), selectednum1_, number1, number2, number3, 381);
            }
            if (selectednum1_ >= 1121510100 && selectednum1_ <= 1121510900) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.kwangjinpricemon), selectednum1_, number1, number2, number3, 373);
            }
            if (selectednum1_ >= 1162000100 && selectednum1_ <= 1162092400) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.kwanakpricemon), selectednum1_, number1, number2, number3, 351);
            }
            if (selectednum1_ >= 1168000100 && selectednum1_ <= 1168091800) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.kangnampricemon), selectednum1_, number1, number2, number3, 564);
            }
            if (selectednum1_ >= 1126010100 && selectednum1_ <= 1126091600) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.joongrangpricemon), selectednum1_, number1, number2, number3, 189);
            }
            if (selectednum1_ >= 1114000100 && selectednum1_ <= 1114090600) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.joongpricemon), selectednum1_, number1, number2, number3, 74);
            }
            if (selectednum1_ >= 1111010100 && selectednum1_ <= 1111090500) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.jongroopricemon), selectednum1_, number1, number2, number3, 112);
            }
            if (selectednum1_ >= 1130510100 && selectednum1_ <= 1130510400) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.gangbookpricemon), selectednum1_, number1, number2, number3, 95);
            }
            if (selectednum1_ >= 1165000100 && selectednum1_ <= 1165091300) {
                arrayselected = openmonthly(getResources().openRawResource(R.raw.seochopricemon), selectednum1_, number1, number2, number3, 414);
            }






            intent.putExtra("room1", arrayselected[0]);
            intent.putExtra("room2", arrayselected[1]);
            intent.putExtra("room3", arrayselected[2]);
            intent.putExtra("room4", arrayselected[3]);
            intent.putExtra("room5", arrayselected[4]);
            intent.putExtra("room6", arrayselected[5]);
            intent.putExtra("room7", arrayselected[6]);


        }


        if(resultText=="전세") {

            String[] arrayselected = new String[7];

            if (selectednum1_ >= 1123010100 && selectednum1_ <= 1123011000) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.dongdaemoondeposit), selectednum1_, number1, number2, number3, 345);
            }
            if (selectednum1_ >= 1159010100 && selectednum1_ <= 1159010900) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.dongjakdeposit), selectednum1_, number1, number2, number3, 691);
            }
            if (selectednum1_ >= 1138010100 && selectednum1_ <= 1138011400) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.eunpyeongdeposit), selectednum1_, number1, number2, number3, 1256);
            }
            if (selectednum1_ >= 1154510100 && selectednum1_ <= 1154510300) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.geumchundeposit), selectednum1_, number1, number2, number3, 358);
            }
            if (selectednum1_ >= 1153010100 && selectednum1_ <= 1153011200) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.goorodeposit), selectednum1_, number1, number2, number3, 565);
            }
            if (selectednum1_ >= 1135010200 && selectednum1_ <= 1135010600) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.nowondeposit), selectednum1_, number1, number2, number3, 236);
            }
            if (selectednum1_ >= 1156000100 && selectednum1_ <= 1156092100) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.yeongdengpodeposit), selectednum1_, number1, number2, number3, 397);
            }
            if (selectednum1_ >= 1117000100 && selectednum1_ <= 1117090800) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.yongsandeposit), selectednum1_, number1, number2, number3, 549);
            }
            if (selectednum1_ >= 1168000100 && selectednum1_ <= 1168091800) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.kangnamdeposit), selectednum1_, number1, number2, number3, 623);
            }
            if (selectednum1_ >= 1174000100 && selectednum1_ <= 1174011000) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.gangdongdeposit), selectednum1_, number1, number2, number3, 1041);
            }
            if (selectednum1_ >= 1130510100 && selectednum1_ <= 1130510400) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.gangbookdeposit), selectednum1_, number1, number2, number3, 245);
            }
            if (selectednum1_ >= 1114000100 && selectednum1_ <= 1114090600) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.joongdeposit), selectednum1_, number1, number2, number3, 144);
            }
            if (selectednum1_ >= 1165000100 && selectednum1_ <= 1165091300) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.seochodeposit), selectednum1_, number1, number2, number3, 758);
            }
            if (selectednum1_ >= 1171010100 && selectednum1_ <= 1171011400) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.songpadeposit), selectednum1_, number1, number2, number3, 1881);
            }
            if (selectednum1_ >= 1132000300 && selectednum1_ <= 1132092600) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.dobongdeposit), selectednum1_, number1, number2, number3, 344);
            }
            if (selectednum1_ >= 1111010100 && selectednum1_ <= 1111090500) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.jongrodeposit), selectednum1_, number1, number2, number3, 201);
            }
            if (selectednum1_ >= 1150000100 && selectednum1_ <= 1150091100) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.gangseodeposit), selectednum1_, number1, number2, number3, 1739);
            }
            if (selectednum1_ >= 1147010100 && selectednum1_ <= 1147091700) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.yangchundeposit), selectednum1_, number1, number2, number3, 927);
            }
            if (selectednum1_ >= 1120000100 && selectednum1_ <= 1120092100) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.seongdongdeposit), selectednum1_, number1, number2, number3, 223);
            }
            if (selectednum1_ >= 1129000100 && selectednum1_ <= 1129092600) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.seongbookdeposit), selectednum1_, number1, number2, number3, 502);
            }
            if (selectednum1_ >= 1144000100 && selectednum1_ <= 1144091100) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.mapodeposit), selectednum1_, number1, number2, number3, 800);
            }
            if (selectednum1_ >= 1141000100 && selectednum1_ <= 1141091800) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.seodaemoondeposit), selectednum1_, number1, number2, number3, 430);
            }
            if (selectednum1_ >= 1121510100 && selectednum1_ <= 1121510900) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.kwangjindeposit), selectednum1_, number1, number2, number3, 825);
            }
            if (selectednum1_ >= 1162000100 && selectednum1_ <= 1162092400) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.kwanakdeposit), selectednum1_, number1, number2, number3, 683);
            }
            if (selectednum1_ >= 1126010100 && selectednum1_ <= 1126091600) {
                arrayselected = opendeposit(getResources().openRawResource(R.raw.joongrangdeposit), selectednum1_, number1, number2, number3, 642);
            }


            intent.putExtra("room1", arrayselected[0]);
            intent.putExtra("room2", arrayselected[1]);
            intent.putExtra("room3", arrayselected[2]);
            intent.putExtra("room4", arrayselected[3]);
            intent.putExtra("room5", arrayselected[4]);
            intent.putExtra("room6", arrayselected[5]);
            intent.putExtra("room7", arrayselected[6]);


        }

        startActivity(intent);

    }


    public String[]  openmonthly(InputStream is2,int selectednum1_,int number1,int number2,int number3,int loopnum){
        String[] arrayselected =new String[7];
        String line2="";
        String array[]=new String[6];

        BufferedReader reader2 = new BufferedReader(
                new InputStreamReader(is2, Charset.forName("UTF-8"))
        );
        try {
            line2 = reader2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < loopnum; i++) {

            try {
                line2 = reader2.readLine();
                array = line2.split(",");


            } catch (IOException e) {
                e.printStackTrace();
            }

            int diff_bjd = Math.abs(valueOf(array[0]) - selectednum1_);
            int diff_area = Math.abs(valueOf(array[1]) - number1);
            int diff_floor = Math.abs(valueOf(array[3]) - number2);
            int diff_year = Math.abs(valueOf(array[4]) - number3); //데이터에 있는 값과 입력한 값의 차이


            if (diff_bjd == 0) {
                if (diff_area == 0) {
                    if (diff_floor == 0) {
                        if (diff_year == 0) {
                            try {
                                arrayselected[0]=array[5];
                                line2 = reader2.readLine();
                                arrayselected[1]=line2;
                                line2 = reader2.readLine();
                                arrayselected[2]=line2;
                                line2 = reader2.readLine();
                                arrayselected[3]=line2;
                                line2 = reader2.readLine();
                                arrayselected[4]=line2;
                                line2 = reader2.readLine();
                                arrayselected[5]=line2;
                                arrayselected[6]=" ";
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        } else {
                            arrayselected[0] = "없음";
                            arrayselected[1] = "";
                            arrayselected[2] = "";
                            arrayselected[3] = "";
                            arrayselected[4] = "";
                            arrayselected[5] = "";


                            try {
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    } else {
                        arrayselected[0] = "없음";
                        arrayselected[1] = "";
                        arrayselected[2] = "";
                        arrayselected[3] = "";
                        arrayselected[4] = "";
                        arrayselected[5] = "";

                        try {
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    arrayselected[0] = "없음";
                    arrayselected[1] = "";
                    arrayselected[2] = "";
                    arrayselected[3] = "";
                    arrayselected[4] = "";
                    arrayselected[5] = "";

                    try {
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                arrayselected[0] = "없음";
                arrayselected[1] = "";
                arrayselected[2] = "";
                arrayselected[3] = "";
                arrayselected[4] = "";
                arrayselected[5] = "";

                try {
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return arrayselected;
    }






    public String[]  opendeposit(InputStream is2,int selectednum1_,int number1,int number2,int number3,int loopnum){
        String[] arrayselected =new String[7];
        String line2="";
        String array[]=new String[6];


        BufferedReader reader2 = new BufferedReader(
                new InputStreamReader(is2, Charset.forName("UTF-8"))
        );
        try {
            line2 = reader2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < loopnum; i++) {

            try {
                line2 = reader2.readLine();
                array = line2.split(",");


            } catch (IOException e) {
                e.printStackTrace();
            }

            int diff_bjd = Math.abs(valueOf(array[0]) - selectednum1_);
            int diff_area = Math.abs(valueOf(array[1]) - number1);
            int diff_floor = Math.abs(valueOf(array[3]) - number2);
            int diff_year = Math.abs(valueOf(array[4]) - number3); //데이터에 있는 값과 입력한 값의 차이


            if (diff_bjd == 0) {
                if (diff_area == 0) {
                    if (diff_floor == 0) {
                        if (diff_year == 0) {
                            try {
                                arrayselected[0]=array[5];
                                line2 = reader2.readLine();
                                arrayselected[1]=line2;
                                line2 = reader2.readLine();
                                arrayselected[2]=line2;
                                line2 = reader2.readLine();
                                arrayselected[3]=line2;
                                line2 = reader2.readLine();
                                arrayselected[4]=line2;

                                line2 = reader2.readLine();
                                array=line2.split(",");
                                arrayselected[5]=array[0];
                                arrayselected[6]=array[1];



                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        } else {
                            arrayselected[0] = "없음";
                            arrayselected[1] = "";
                            arrayselected[2] = "";
                            arrayselected[3] = "";
                            arrayselected[4] = "";
                            arrayselected[5] = "";

                            try {
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();
                                line2 = reader2.readLine();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    } else {
                        arrayselected[0] = "없음";
                        arrayselected[1] = "";
                        arrayselected[2] = "";
                        arrayselected[3] = "";
                        arrayselected[4] = "";
                        arrayselected[5] = "";

                        try {
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();
                            line2 = reader2.readLine();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    arrayselected[0] = "없음";
                    arrayselected[1] = "";
                    arrayselected[2] = "";
                    arrayselected[3] = "";
                    arrayselected[4] = "";
                    arrayselected[5] = "";

                    try {
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();
                        line2 = reader2.readLine();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                arrayselected[0] = "없음";
                arrayselected[1] = "";
                arrayselected[2] = "";
                arrayselected[3] = "";
                arrayselected[4] = "";
                arrayselected[5] = "";

                try {
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();
                    line2 = reader2.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return arrayselected;
    }




}

