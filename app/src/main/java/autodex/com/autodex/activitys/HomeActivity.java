package autodex.com.autodex.activitys;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import autodex.com.autodex.R;
import autodex.com.autodex.customview.BadgeDrawable;
import autodex.com.autodex.fragments.BaseFragment;
import autodex.com.autodex.fragments.ContactsAndFavouriteFragments;
import autodex.com.autodex.fragments.FavouritesFragment;
import autodex.com.autodex.fragments.GroupsFragment;
import autodex.com.autodex.fragments.NotificationFragment;
import autodex.com.autodex.fragments.SettingsFragment;
import autodex.com.autodex.fragments.SyncBackupFragment;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "HomeActivity";
    private TextView notificationcount, syncbackup;
    private RelativeLayout notify;
    private TextView badgeCount;
    private ImageView phoneImg, locationImg;
    private BaseFragment baseFragment;
    private FloatingActionButton fab;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.mipmap.ic_logo);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        notificationcount = (TextView) navigationView.getMenu().findItem(R.id.notifications).getActionView().findViewById(R.id.badge_notification_1);
        syncbackup = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.syncbackup));


        initializeCountDrawer();
        navigationView.getMenu().findItem(R.id.contact).setChecked(true);
        callFragment(R.id.contact);

        View view = navigationView.getHeaderView(0);
        phoneImg = (ImageView) view.findViewById(R.id.phoneimg);
        locationImg = (ImageView) view.findViewById(R.id.locationimg);


    }

    private void setFillColor(ImageView imageView) {
        imageView.setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);
    }


    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BadgeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }


    private void initializeCountDrawer() {
        notificationcount.setText("99+");
        //Gravity property aligns the text
//        notificationcount.setGravity(Gravity.CENTER_VERTICAL);
//        notificationcount.setTypeface(null, Typeface.BOLD);
//        notificationcount.setTextColor(getResources().getColor(R.color.white));
//        notificationcount.setText("99+");
//        notificationcount.setBackgroundResource(R.drawable.countcircle);
//        notificationcount.setWidth(20);
//        notificationcount.setHeight(20);
//        notificationcount.setGravity(Gravity.CENTER_VERTICAL);
//        notificationcount.setTypeface(null, Typeface.BOLD);
//        notificationcount.setTextColor(getResources().getColor(R.color.colorAccent));
////count is added
//        notificationcount.setText("7");

        syncbackup.setGravity(Gravity.CENTER_VERTICAL);
//        syncbackup.setTypeface(null, Typeface.BOLD);
//        syncbackup.setTextColor(getResources().getColor(R.color.black));
        syncbackup.setText("12 Aug 2017");
        syncbackup.setTextSize(8f);
//        syncbackup.setGravity(Gravity.CENTER_VERTICAL);
//        syncbackup.setTypeface(null, Typeface.BOLD);
//        syncbackup.setTextColor(getResources().getColor(R.color.colorAccent));

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        } else

        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);

        View count = menu.findItem(R.id.notification).getActionView();
        notify = (RelativeLayout) count.findViewById(R.id.notify);
        badgeCount = (TextView) count.findViewById(R.id.hotlist_hot);


        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                badgeCount.setText(String.valueOf("56"));
                callFragment(R.id.notifications);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.notification) {
//
//            Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show();
//
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        callFragment(id);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void callFragment(int id) {
        getSupportActionBar().setTitle("AutoDex");
        switch (id) {

            case R.id.contact:
                baseFragment = new ContactsAndFavouriteFragments();
                fab.show();
                break;

            case R.id.groups:
                baseFragment = new GroupsFragment();
                fab.show();
                break;

            case R.id.favorites:
                baseFragment = new FavouritesFragment();

                fab.show();
                break;

            case R.id.notifications:
                baseFragment = new NotificationFragment();
                getSupportActionBar().setTitle("Notifications");

                fab.hide();

                break;
            case R.id.syncbackup:
                baseFragment = new SyncBackupFragment();
                fab.show();
                break;
            case R.id.settings:
                baseFragment = new SettingsFragment();
                fab.show();
                break;

            case R.id.logout:
                startActivity(new Intent(this, LoginActivity.class));
                finish();

                return;
        }

        navigationView.getMenu().findItem(id).setChecked(true);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        if (id == R.id.contact) {
//            fragmentTransaction.replace(R.id.container, baseFragment).;
//        } else {
        fragmentTransaction.replace(R.id.container, baseFragment).addToBackStack(null);
//        }
        fragmentTransaction.commit();


    }


}
