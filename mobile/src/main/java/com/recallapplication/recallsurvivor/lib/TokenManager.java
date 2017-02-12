package com.recallapplication.recallsurvivor.lib;

import android.app.Activity;
import android.content.SharedPreferences;

public class TokenManager extends Activity
{
    public static final String ANDROID_CLIENT_KEY = "7887cc030f0ab256086fcfd98d3efe9b";
    private static final String TOKEN_FILE = "TokenPrefs";
    private static final String USER_TOKEN = "userToken";
    private static final String REFRESH_TOKEN = "refreshToken";
    private static SharedPreferences settings;

    private TokenManager(){
        settings = getSharedPreferences(TOKEN_FILE, 0);
    }

    public static void setUserToken(String userToken)
    {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USER_TOKEN, userToken);
        editor.apply();
    }

    public static String getUserToken()
    {
        return settings.getString(USER_TOKEN, null);
    }

    public void setRefreshToken(String refreshToken)
    {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(REFRESH_TOKEN, refreshToken);
        editor.apply();
    }

    public String getRefreshToken()
    {
        return settings.getString(USER_TOKEN, null);
    }

    public String getAndroidClientKey()
    {
        return ANDROID_CLIENT_KEY;
    }
}
