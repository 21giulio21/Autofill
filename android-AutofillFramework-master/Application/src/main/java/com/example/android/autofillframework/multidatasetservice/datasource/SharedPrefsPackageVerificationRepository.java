/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.autofillframework.multidatasetservice.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.android.autofillframework.multidatasetservice.SecurityHelper;

import static com.example.android.autofillframework.CommonUtil.TAG;

public class SharedPrefsPackageVerificationRepository implements PackageVerificationDataSource {

    private static final String SHARED_PREF_KEY = "com.example.android.autofillframework"
            + ".multidatasetservice.datasource.PackageVerificationDataSource";
    private static PackageVerificationDataSource sInstance;

    private SharedPrefsPackageVerificationRepository() {
    }

    public static PackageVerificationDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new SharedPrefsPackageVerificationRepository();
        }
        return sInstance;
    }

    @Override
    public void clear(Context context) {
        context.getApplicationContext().getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .apply();
    }

    /*
    * Scrivo sull'xml contenente tutti i package il valore hash dell package percui ho un nuovo
    * set di password e username
    * */

    @Override
    public boolean putPackageSignatures(Context context, String packageName) {
        String hash;
        try {
            hash = SecurityHelper.getFingerprint(context, packageName);
            Log.e("GIULIO sono nella funzione putPackageSignatures" , "Hash for " + packageName + ": " + hash);
            Log.d(TAG, "Hash for " + packageName + ": " + hash);
        } catch (Exception e) {
            Log.w(TAG, "Error getting hash for " + packageName + ": " + e);
            return false;
        }

        if (!containsSignatureForPackage(context, packageName)) {
            // Storage does not yet contain signature for this package name.
            context.getApplicationContext()
                    .getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
                    .edit()
                    .putString(packageName, hash)
                    .apply();
            return true;
        }
        return containsMatchingSignatureForPackage(context, packageName, hash);
    }

    /*
    * Cerco se il packageName passato è gia stato in serito nel file .xml
    * */
    private boolean containsSignatureForPackage(Context context, String packageName) {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(
                SHARED_PREF_KEY, Context.MODE_PRIVATE);
        return prefs.contains(packageName);
    }

    private boolean containsMatchingSignatureForPackage(Context context, String packageName,
            String hash) {
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(
                SHARED_PREF_KEY, Context.MODE_PRIVATE);
        return hash.equals(prefs.getString(packageName, null));
    }
}
