package com.example.aymaan.cse110applogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Heatmap extends AppCompatActivity {
    private TextView[][] idArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heatmap);

        idArray = new TextView[19][7];
        idArray[0][0] = findViewById(R.id.m6);
        idArray[1][0] = findViewById(R.id.m7);
        idArray[2][0] = findViewById(R.id.m8);
        idArray[3][0] = findViewById(R.id.m9);
        idArray[4][0] = findViewById(R.id.m10);
        idArray[5][0] = findViewById(R.id.m11);
        idArray[6][0] = findViewById(R.id.m12);
        idArray[7][0] = findViewById(R.id.m13);
        idArray[8][0] = findViewById(R.id.m14);
        idArray[9][0] = findViewById(R.id.m15);
        idArray[10][0] = findViewById(R.id.m16);
        idArray[11][0] = findViewById(R.id.m17);
        idArray[12][0] = findViewById(R.id.m18);
        idArray[13][0] = findViewById(R.id.m19);
        idArray[14][0] = findViewById(R.id.m20);
        idArray[15][0] = findViewById(R.id.m21);
        idArray[16][0] = findViewById(R.id.m22);
        idArray[17][0] = findViewById(R.id.m23);
        idArray[18][0] = findViewById(R.id.m0);

        idArray[0][1] = findViewById(R.id.t6);
        idArray[1][1] = findViewById(R.id.t7);
        idArray[2][1] = findViewById(R.id.t8);
        idArray[3][1] = findViewById(R.id.t9);
        idArray[4][1] = findViewById(R.id.t10);
        idArray[5][1] = findViewById(R.id.t11);
        idArray[6][1] = findViewById(R.id.t12);
        idArray[7][1] = findViewById(R.id.t13);
        idArray[8][1] = findViewById(R.id.t14);
        idArray[9][1] = findViewById(R.id.t15);
        idArray[10][1] = findViewById(R.id.t16);
        idArray[11][1] = findViewById(R.id.t17);
        idArray[12][1] = findViewById(R.id.t18);
        idArray[13][1] = findViewById(R.id.t19);
        idArray[14][1] = findViewById(R.id.t20);
        idArray[15][1] = findViewById(R.id.t21);
        idArray[16][1] = findViewById(R.id.t22);
        idArray[17][1] = findViewById(R.id.t23);
        idArray[18][1] = findViewById(R.id.t0);

        idArray[0][2] = findViewById(R.id.w6);
        idArray[1][2] = findViewById(R.id.w7);
        idArray[2][2] = findViewById(R.id.w8);
        idArray[3][2] = findViewById(R.id.w9);
        idArray[4][2] = findViewById(R.id.w10);
        idArray[5][2] = findViewById(R.id.w11);
        idArray[6][2] = findViewById(R.id.w12);
        idArray[7][2] = findViewById(R.id.w13);
        idArray[8][2] = findViewById(R.id.w14);
        idArray[9][2] = findViewById(R.id.w15);
        idArray[10][2] = findViewById(R.id.w16);
        idArray[11][2] = findViewById(R.id.w17);
        idArray[12][2] = findViewById(R.id.w18);
        idArray[13][2] = findViewById(R.id.w19);
        idArray[14][2] = findViewById(R.id.w20);
        idArray[15][2] = findViewById(R.id.w21);
        idArray[16][2] = findViewById(R.id.w22);
        idArray[17][2] = findViewById(R.id.w23);
        idArray[18][2] = findViewById(R.id.w0);

        idArray[0][3] = findViewById(R.id.th6);
        idArray[1][3] = findViewById(R.id.th7);
        idArray[2][3] = findViewById(R.id.th8);
        idArray[3][3] = findViewById(R.id.th9);
        idArray[4][3] = findViewById(R.id.th10);
        idArray[5][3] = findViewById(R.id.th11);
        idArray[6][3] = findViewById(R.id.th12);
        idArray[7][3] = findViewById(R.id.th13);
        idArray[8][3] = findViewById(R.id.th14);
        idArray[9][3] = findViewById(R.id.th15);
        idArray[10][3] = findViewById(R.id.th16);
        idArray[11][3] = findViewById(R.id.th17);
        idArray[12][3] = findViewById(R.id.th18);
        idArray[13][3] = findViewById(R.id.th19);
        idArray[14][3] = findViewById(R.id.th20);
        idArray[15][3] = findViewById(R.id.th21);
        idArray[16][3] = findViewById(R.id.th22);
        idArray[17][3] = findViewById(R.id.th23);
        idArray[18][3] = findViewById(R.id.th0);

        idArray[0][4] = findViewById(R.id.f6);
        idArray[1][4] = findViewById(R.id.f7);
        idArray[2][4] = findViewById(R.id.f8);
        idArray[3][4] = findViewById(R.id.f9);
        idArray[4][4] = findViewById(R.id.f10);
        idArray[5][4] = findViewById(R.id.f11);
        idArray[6][4] = findViewById(R.id.f12);
        idArray[7][4] = findViewById(R.id.f13);
        idArray[8][4] = findViewById(R.id.f14);
        idArray[9][4] = findViewById(R.id.f15);
        idArray[10][4] = findViewById(R.id.f16);
        idArray[11][4] = findViewById(R.id.f17);
        idArray[12][4] = findViewById(R.id.f18);
        idArray[13][4] = findViewById(R.id.f19);
        idArray[14][4] = findViewById(R.id.f20);
        idArray[15][4] = findViewById(R.id.f21);
        idArray[16][4] = findViewById(R.id.f22);
        idArray[17][4] = findViewById(R.id.f23);
        idArray[18][4] = findViewById(R.id.f0);

        idArray[0][5] = findViewById(R.id.st6);
        idArray[1][5] = findViewById(R.id.st7);
        idArray[2][5] = findViewById(R.id.st8);
        idArray[3][5] = findViewById(R.id.st9);
        idArray[4][5] = findViewById(R.id.st10);
        idArray[5][5] = findViewById(R.id.st11);
        idArray[6][5] = findViewById(R.id.st12);
        idArray[7][5] = findViewById(R.id.st13);
        idArray[8][5] = findViewById(R.id.st14);
        idArray[9][5] = findViewById(R.id.st15);
        idArray[10][5] = findViewById(R.id.st16);
        idArray[11][5] = findViewById(R.id.st17);
        idArray[12][5] = findViewById(R.id.st18);
        idArray[13][5] = findViewById(R.id.st19);
        idArray[14][5] = findViewById(R.id.st20);
        idArray[15][5] = findViewById(R.id.st21);
        idArray[16][5] = findViewById(R.id.st22);
        idArray[17][5] = findViewById(R.id.st23);
        idArray[18][5] = findViewById(R.id.st0);

        idArray[0][6] = findViewById(R.id.s6);
        idArray[1][6] = findViewById(R.id.s7);
        idArray[2][6] = findViewById(R.id.s8);
        idArray[3][6] = findViewById(R.id.s9);
        idArray[4][6] = findViewById(R.id.s10);
        idArray[5][6] = findViewById(R.id.s11);
        idArray[6][6] = findViewById(R.id.s12);
        idArray[7][6] = findViewById(R.id.s13);
        idArray[8][6] = findViewById(R.id.s14);
        idArray[9][6] = findViewById(R.id.s15);
        idArray[10][6] = findViewById(R.id.s16);
        idArray[11][6] = findViewById(R.id.s17);
        idArray[12][6] = findViewById(R.id.s18);
        idArray[13][6] = findViewById(R.id.s19);
        idArray[14][6] = findViewById(R.id.s20);
        idArray[15][6] = findViewById(R.id.s21);
        idArray[16][6] = findViewById(R.id.s22);
        idArray[17][6] = findViewById(R.id.s23);
        idArray[18][6] = findViewById(R.id.s0);
    }

    public void myMethod(View view) {
        int iX = -1;
        int jX = -1;
        for (int i = 0; i < idArray.length; i++) {
            for (int j = 0; j < idArray[0].length; j++) {
                if (view.getId() == idArray[i][j].getId()) {
                    iX = i;
                    jX = j;
                }
            }

        }
    }
}
