package com.recallapplication.recallsurvivor.lib.requestManagement;

import android.content.Context;

import com.android.volley.Request;
import com.recallapplication.recallsurvivor.model.Survivor;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpRequestManager extends RequestManager {
    private Survivor survivor;

    public SignUpRequestManager(Context context, Survivor survivor)
    {
        super(context);
        this.url = "sign-up";
        this.survivor = survivor;
        this.requestMethodCode = Request.Method.POST;
    }

    public void buildRequestBody()
    {

        try {
            this.requestJSONObject.put("first_name", this.survivor.getFirstName());
            this.requestJSONObject.put("last_name", this.survivor.getLastName());
            this.requestJSONObject.put("email", this.survivor.getEmail());
            this.requestJSONObject.put("password", this.survivor.getPassword());
            this.requestJSONObject.put("user_type_code", "survivor");
        } catch(JSONException e) {
            //TODO: Handle Exceptions correctly
        }
    }

    public void signUp()
    {
        this.buildRequestBody();
        super.submitRequest();
    }
}
