package com.tech.v.labouryou;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import yalantis.com.sidemenu.interfaces.Resourceble;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.util.ViewAnimator;


public class MainActivity extends AppCompatActivity implements ViewAnimator.ViewAnimatorListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private List<SlideMenuItem> list = new ArrayList<>();
    private ContentFragment contentFragment;
    private ViewAnimator viewAnimator;
    private int res = R.drawable.content_music;
    private LinearLayout linearLayout;

    Gallery simpleGallery;
    CustomGalleryAdapter customGalleryAdapter;
    ImageView selectedImageView;
    // array of images
    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
            R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11,
            R.drawable.image12, R.drawable.image13};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menu stuff
        contentFragment = ContentFragment.newInstance(R.drawable.content_music);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame,contentFragment)
                .commit();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        linearLayout = (LinearLayout) findViewById(R.id.left_drawer);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        setActionBar();
        createMenuList();
        viewAnimator = new ViewAnimator<>(this, list, contentFragment, drawerLayout,this);
        /*
        simpleGallery = (Gallery) findViewById(R.id.simpleGallery); // get the reference of Gallery
        selectedImageView = (ImageView) findViewById(R.id.selectedImageView); // get the reference of ImageView
        selectedImageView.setImageResource(images[0]);

        customGalleryAdapter = new CustomGalleryAdapter(getApplicationContext(), images); // initialize the adapter
        simpleGallery.setAdapter(customGalleryAdapter); // set the adapter
        simpleGallery.setSpacing(10);
        // perform setOnItemClickListener event on the Gallery
        simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set the selected image in the ImageView
                selectedImageView.setImageResource(images[position]);

            }
        });
        */
    }

    private void createMenuList(){
        SlideMenuItem menuItem0 = new SlideMenuItem(ContentFragment.CLOSE,R.drawable.icn_close);
        list.add(menuItem0);
        SlideMenuItem menuItem1 = new SlideMenuItem(ContentFragment.BUILDING,R.drawable.icn_1);
        list.add(menuItem1);
        SlideMenuItem menuItem2 = new SlideMenuItem(ContentFragment.BOOK,R.drawable.icn_2);
        list.add(menuItem2);
        SlideMenuItem menuItem3 = new SlideMenuItem(ContentFragment.PAINT,R.drawable.icn_3);
        list.add(menuItem3);
        SlideMenuItem menuItem4 = new SlideMenuItem(ContentFragment.CASE,R.drawable.icn_4);
        list.add(menuItem4);
        SlideMenuItem menuItem5 = new SlideMenuItem(ContentFragment.SHOP,R.drawable.icn_5);
        list.add(menuItem5);
        SlideMenuItem menuItem6 = new SlideMenuItem(ContentFragment.SHOP,R.drawable.icn_5);
        list.add(menuItem6);
        SlideMenuItem menuItem7 = new SlideMenuItem(ContentFragment.SHOP,R.drawable.icn_5);
        list.add(menuItem7);
    }

    private void setActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().
    }
}
