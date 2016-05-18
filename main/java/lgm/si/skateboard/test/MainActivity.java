package lgm.si.skateboard.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity{

    Button b = null;
    float timePressed = 0.0f;
    long lastTime = 0;
    long duration = System.currentTimeMillis();
    long dt = System.currentTimeMillis();
    boolean released = false;
    TextView tw = null;

  /*  private static final int REQUEST_ENABLE_BT = 1;
    private boolean m_bluetoothEnable = false;
    private BluetoothAdapter m_bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();*/

   //int FGU = ;//Frequence of Gui Update

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // layout = (LinearLayout) LinearLayout.inflate(this, R.layout.imc,null);
        setContentView(R.layout.content_my);
        tw = (TextView)findViewById(R.id.label);
        tw.setText(String.format(getResources().getString(R.string.tbp),0.0f));
       // Log.i("MyApp", "Created");
       // System.out.println("Down");
    }


   /* private void initBluetooth(){
        if (m_bluetoothAdapter==null){
            return;
        }
        if (!m_bluetoothAdapter.isEnabled()){
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode== KeyEvent.KEYCODE_VOLUME_DOWN){
            if (released) {
                released = false;
                duration = 60;
            }
            else {
                dt = System.currentTimeMillis() - lastTime;
                duration += dt;
            }
            tw.setText(String.format(getResources().getString(R.string.tbp), (float)duration*0.001f));
        }
        lastTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            if (!released){
                released = true;
              //  Log.i("MyApp", "KeyButton Released "+duration);
                duration=0;
                tw.setText(String.format(getResources().getString(R.string.tbp), 0.0f));
            }
        }
        return true;
    }

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode!=REQUEST_ENABLE_BT){
            return;
        }
        if (resultCode==RESULT_OK){
            m_bluetoothEnable = true;
        }
        else{

        }
    }*/



}
