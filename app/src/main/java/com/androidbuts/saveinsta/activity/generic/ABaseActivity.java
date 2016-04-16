package com.androidbuts.saveinsta.activity.generic;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.androidbuts.saveinsta.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Pratik Butani
 */
public abstract class ABaseActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        // ButterKnife
        ButterKnife.bind(this);
        // Init ToolBar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            mToolbar.setTitle("");
        }
        setSupportActionBar(mToolbar);
    }

    @Override
    public void finishAfterTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.finishAfterTransition();
        } else {
            super.finish();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
