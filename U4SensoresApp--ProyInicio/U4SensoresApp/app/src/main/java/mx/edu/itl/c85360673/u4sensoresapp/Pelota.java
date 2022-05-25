package mx.edu.itl.c85360673.u4sensoresapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;


public class Pelota extends View implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;

    private int x;
    private int y;
    private int radio = 50;
    private int ancho;
    private int alto;
    private Paint paint;

    public Pelota(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        Display pantalla = ( (WindowManager) context.getSystemService ( Context.WINDOW_SERVICE ) )
                .getDefaultDisplay ();
        Point dimensiones = new Point ();
        pantalla.getSize ( dimensiones );

        ancho = dimensiones.x;
        alto = dimensiones.y;
        x = ancho / 2;
        y = alto / 2;

        paint = new Paint ();
        paint.setColor (Color.RED );

        sensorManager = (SensorManager) context.getSystemService ( Context.SENSOR_SERVICE );
        sensor = sensorManager.getDefaultSensor ( Sensor.TYPE_ACCELEROMETER );

    }
    public void iniciar () {
        sensorManager.registerListener ( this, sensor, SensorManager.SENSOR_DELAY_UI );
    }

    public void detener () {
        sensorManager.unregisterListener ( this, sensor );
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x -= sensorEvent.values [ 0 ] * 2;
        y += sensorEvent.values [ 1 ] * 2;

        if ( x < radio )
            x = radio;
        else if ( x > ancho - radio )
            x = ancho - radio;

        if ( y < radio )
            y = radio;
        else if ( y > alto - 2 * radio )
            y = alto - 2* radio;

        invalidate ();
    }
    @Override
    public void draw ( Canvas canvas ) {
        super.draw(canvas);
        canvas.drawCircle ( x, y, radio, paint );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
