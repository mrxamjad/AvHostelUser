package com.example.avhostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.avhostel.ui.about.AboutFragment;
import com.example.avhostel.ui.faculty.FacultyFragment;
import com.example.avhostel.ui.gallery.GalleryFragment;
import com.example.avhostel.ui.home.HomeFragment;
import com.example.avhostel.ui.notice.NoticeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavController navController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNagivationView);
        drawerLayout= findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation_view);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_videoLacture: {
//                        loadFragment(new VideoFragment());
                        break;
                    }
                    case R.id.navigation_ebook: {
//                        loadFragment(new VideoFragment());
                        break;
                    }
                    case R.id.navigation_theme: {
//                        loadFragment(new VideoFragment());
                        break;
                    }
                    case R.id.navigation_website: {
//                        loadFragment(new VideoFragment());
                        break;
                    }
                    case R.id.navigation_Share: {
//                        loadFragment(new VideoFragment());
                        break;
                    }
                    case R.id.navigation_rate: {
//                        loadFragment(new VideoFragment());
                        break;
                    }
                    case R.id.navigation_developer: {
//                        loadFragment(new VideoFragment());
                        break;
                    }
                }

                return true;
            }
        });



        //Auto Load Home Fragment
        loadFragment(new HomeFragment());

        //change the fragment as per the click of button
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                if (id==R.id.navigation_home)
                {
                    loadFragment(new HomeFragment());
                }
                else if(id ==R.id.navigation_notice)
                {
                    loadFragment(new NoticeFragment());
                }
                else if(id ==R.id.navigation_faculty)
                {
                    loadFragment(new FacultyFragment());
                }
                else if(id ==R.id.navigation_gallery)
                {
                    loadFragment(new GalleryFragment());
                }
                else if(id ==R.id.navigation_about)
                {
                    loadFragment(new AboutFragment());
                }
                return true;
            }
        });





    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return true;
    }





    // load fragment method
    private void loadFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.commit();
    }
}