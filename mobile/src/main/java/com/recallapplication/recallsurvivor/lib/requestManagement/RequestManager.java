package com.recallapplication.recallsurvivor.lib.requestManagement;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public abstract class RequestManager
{
    private RequestQueue queue;
    protected String url, baseUrl;
    protected JSONObject requestJSONObject;
    protected int requestMethodCode;

    public RequestManager(Context context)
    {
        queue = Volley.newRequestQueue(context);
        //TODO: retrieve this from string resource instead of hard coding
        this.baseUrl = "app.recall/";
    }

    public void submitRequest()
    {
        StringRequest stringRequest = new StringRequest(this.requestMethodCode, this.baseUrl + this.url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

    public abstract void buildRequestBody();

}
