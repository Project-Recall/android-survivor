package com.recallapplication.recallsurvivor.lib;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager
{
    public static final String ANDROID_CLIENT_KEY = "7887cc030f0ab256086fcfd98d3efe9b";
    private static final String TOKEN_FILE = "TokenPrefs";
    private static final String USER_TOKEN = "userToken";
    private static final String REFRESH_TOKEN = "refreshToken";
    private SharedPreferences settings;

    public TokenManager( Context context){
        this.settings = context.getSharedPreferences(TOKEN_FILE, 0);
    }

    public void setUserToken(String userToken)
    {
        SharedPreferences.Editor editor = this.settings.edit();
        editor.putString(USER_TOKEN, userToken);
        editor.apply();
    }

    public String getUserToken()
    {
        return this.settings.getString(USER_TOKEN, null);
    }

    public void setRefreshToken(String refreshToken)
    {
        SharedPreferences.Editor editor = this.settings.edit();
        editor.putString(REFRESH_TOKEN, refreshToken);
        editor.apply();
    }

    public String getRefreshToken()
    {
        return this.settings.getString(USER_TOKEN, null);
    }

    public String getAndroidClientKey()
    {
        return ANDROID_CLIENT_KEY;
    }
}
