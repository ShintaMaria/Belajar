package com.example.belajar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomGraphView35 extends View {
    private double[] dataPoints; // Array untuk menyimpan data titik
    private Paint paintLine; // Paint untuk garis grafik
    private Paint paintPoint; // Paint untuk titik data
    private Paint borderPaint; // Paint untuk border
    private int graphColor = Color.RED; // Warna default grafik

    public CustomGraphView35(Context context) {
        super(context);
        init();
    }

    public CustomGraphView35(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // Inisialisasi paint untuk garis grafik
        paintLine = new Paint();
        paintLine.setColor(graphColor); // Set warna garis grafik
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(5); // Ketebalan garis

        // Inisialisasi paint untuk titik data
        paintPoint = new Paint();
        paintPoint.setColor(graphColor);
        paintPoint.setStyle(Paint.Style.FILL_AND_STROKE);

        // Inisialisasi paint untuk border
        borderPaint = new Paint();
        borderPaint.setColor(Color.BLACK); // Warna border
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(4); // Ketebalan border
    }

    public void setGraphColor(int color) {
        this.graphColor = color;
        paintLine.setColor(color);
        paintPoint.setColor(color);
        invalidate(); // Redraw the view
    }

    public void setDataPoints(double[] dataPoints) {
        this.dataPoints = dataPoints;
        invalidate(); // Meminta untuk menggambar ulang tampilan
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Gambar border
        canvas.drawRect(0, 0, getWidth(), getHeight(), borderPaint); // Gambar border

        if (dataPoints == null || dataPoints.length == 0) return;

        // Lebar dan tinggi dari view
        int width = getWidth();
        int height = getHeight();

        // Skala untuk menggambar grafik
        float scaleX = width / (float) (dataPoints.length - 1);
        float scaleY = height / 500f; // Misalnya grafik memiliki range 0-900

        // Gambar garis antar titik
        for (int i = 0; i < dataPoints.length - 1; i++) {
            float startX = i * scaleX;
            float startY = height - (float)(dataPoints[i] * scaleY);
            float stopX = (i + 1) * scaleX;
            float stopY = height - (float)(dataPoints[i + 1] * scaleY);
            canvas.drawLine(startX, startY, stopX, stopY, paintLine);
        }

        // Gambar titik data
        for (int i = 0; i < dataPoints.length; i++) {
            float x = i * scaleX;
            float y = height - (float)(dataPoints[i] * scaleY);
            canvas.drawCircle(x, y, 10f, paintPoint); // Gambar lingkaran kecil sebagai titik
        }
    }
}
