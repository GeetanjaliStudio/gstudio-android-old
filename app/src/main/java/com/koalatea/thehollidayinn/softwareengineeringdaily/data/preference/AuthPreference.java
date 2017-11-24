package com.koalatea.thehollidayinn.softwareengineeringdaily.data.preference;

import android.support.annotation.NonNull;

import com.koalatea.thehollidayinn.softwareengineeringdaily.data.preference.base.PreferenceProvider;

/**
 * Created by Kurian on 25-Sep-17.
 */
public interface AuthPreference extends PreferenceProvider {

    String TOKEN_DEFAULT = "";

    /**
     * Save the auth token for further use
     * @param token
     */
    void saveToken(@NonNull String token);

    /**
     * Get a previously saved token if one exists (otherwise it's empty)
     * @return
     */
    String getToken();

    /**
     * Check if the user is currently logged in to an account
     * @return true if user has logged in to an account
     */
    boolean isLoggedIn();

    /**
     * Remove the token from preferences
     */
    void clearToken();

}
