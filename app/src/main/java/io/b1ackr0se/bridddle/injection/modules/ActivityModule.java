package io.b1ackr0se.bridddle.injection.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import io.b1ackr0se.bridddle.injection.ActivityContext;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Activity provideActivity() {
        return activity;
    }
}