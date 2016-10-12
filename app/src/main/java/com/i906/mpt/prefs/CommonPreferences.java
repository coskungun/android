package com.i906.mpt.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Noorzaini Ilhami
 */
@Singleton
public class CommonPreferences {

    private final static String KEY_IS_FIRST_START = "is_first_start";

    private final SharedPreferences mPrefs;

    @Inject
    public CommonPreferences(Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean isFirstStart() {
        return mPrefs.getBoolean(KEY_IS_FIRST_START, true);
    }

    public void setFirstStart(boolean firstStart) {
        mPrefs.edit()
                .putBoolean(KEY_IS_FIRST_START, firstStart)
                .apply();
    }

    public int getHijriOffset() {
        return Integer.valueOf(mPrefs.getString("hijri_offset", "0"));
    }

    public boolean isDeveloperUser() {
        return mPrefs.getBoolean("mpt_developer_user", false);
    }

    public void setAsDeveloperUser() {
        mPrefs.edit()
                .putBoolean("mpt_developer_user", true)
                .apply();
    }

    public boolean isGoodUser() {
        return mPrefs.getBoolean("mpt_good_user", false);
    }

    public void setAsGoodUser() {
        mPrefs.edit()
                .putBoolean("mpt_good_user", true)
                .apply();
    }

    public boolean isGenerousUser() {
        return mPrefs.getBoolean("mpt_generous_user", false);
    }

    public void setAsGenerousUser() {
        mPrefs.edit()
                .putBoolean("mpt_generous_user", true)
                .apply();
    }

    public void convertLegacyPreferences() {
        boolean al = mPrefs.getBoolean("automatic_location", true);

        mPrefs.edit()
                .remove("automatic_location")
                .putBoolean("location_automatic", al)
                .apply();
    }
}