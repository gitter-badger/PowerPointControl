package com.PPCtrl.malain.powerpointcontrol;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.PPCtrl.malain.adapter.TabsPagerAdapter;


public class MainActivity extends Activity implements ActionBar.TabListener {

    private final int ANTERIOR = 1;
    private final int SIGUIENTE = 2;
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    //Titulos de pestañas
    private String[] tabs = {"Actual", "Diapositivas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicialización
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getFragmentManager());

        viewPager.setAdapter(mAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Añadir pestañas
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_preview:
                mensaje(ANTERIOR);
                break;
            case R.id.action_next:
                mensaje(SIGUIENTE);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        int action = event.getAction();
        int keyCode = event.getKeyCode();

        switch (keyCode){
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_UP){
                    mensaje(SIGUIENTE);
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN){
                    mensaje(ANTERIOR);
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    //----------------------------------------------------------------------------------------------
    private void mensaje(int d){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Acción");
        switch (d){
            case ANTERIOR:
                alertDialog.setMessage("Anterior");
                break;
            case SIGUIENTE:
                alertDialog.setMessage("Siguiente");
                break;
        }
        alertDialog.show();
    }
}