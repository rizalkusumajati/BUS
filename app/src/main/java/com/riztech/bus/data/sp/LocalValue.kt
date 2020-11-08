package com.riztech.bus.data.sp

import android.content.Context
import android.content.SharedPreferences
import com.riztech.bus.data.model.BusApiResponse


private const val NAME = "BUS_LOCALE"

const val TOKEN = "${NAME}token"
const val TOKENEXPIRE = "${NAME}tokenexpire"
const val REFRESHTOKEN = "${NAME}refreshtoken"
const val REFRESHTOKENEXPIRE = "${NAME}refreshtokenexpire"
const val NOTBEFORE = "${NAME}notbefore"
const val SCOPE = "${NAME}scope"
const val TOKENTYPE = "${NAME}tokenType"
const val SESSIONSTATE = "${NAME}sessionstate"

object LocalValue {
    private lateinit var preferences: SharedPreferences
    private const val MODE = Context.MODE_PRIVATE

    fun init(ctx: Context) {
        preferences = ctx.getSharedPreferences(NAME, MODE)
    }

    var userData: BusApiResponse.UserToken?
    get() {
        return BusApiResponse.UserToken(
            access_token = preferences.getString(TOKEN, "") ?: "",
            expires_in = preferences.getInt(TOKENEXPIRE, 0),
            not_before_policy = preferences.getInt(NOTBEFORE, 0),
            refresh_expires_in = preferences.getInt(REFRESHTOKENEXPIRE, 0),
            refresh_token = preferences.getString(REFRESHTOKEN, "") ?: "",
            scope = preferences.getString(SCOPE, "") ?: "",
            session_state = preferences.getString(SESSIONSTATE, "") ?: "",
            token_type = preferences.getString(TOKENTYPE, "") ?: ""
        )
    }
    set(value) {
        value?.let {
            setPref(value.access_token, TOKEN)
            setPref(value.expires_in, TOKENEXPIRE)
            setPref(value.not_before_policy, NOTBEFORE)
            setPref(value.refresh_expires_in, REFRESHTOKENEXPIRE)
            setPref(value.refresh_token, REFRESHTOKEN)
            setPref(value.scope, SCOPE)
            setPref(value.session_state, SESSIONSTATE)
            setPref(value.token_type, TOKENTYPE)
        } ?: run {
            setPref("", TOKEN)
            setPref(0, TOKENEXPIRE)
            setPref(0, NOTBEFORE)
            setPref(0, REFRESHTOKENEXPIRE)
            setPref("", REFRESHTOKEN)
            setPref("", SCOPE)
            setPref("", SESSIONSTATE)
            setPref("", TOKENTYPE)
        }
    }

    private fun setPref(value: Any?, TAG: String) {
        value?.let {
            val editor = preferences.edit()
            if (value is String) {
                editor.putString(TAG, value)
            } else if (value is Int) {
                editor.putInt(TAG, value)
            } else if (value is Boolean) {
                editor.putBoolean(TAG, value)
            }
            editor.apply()
        }
    }
}