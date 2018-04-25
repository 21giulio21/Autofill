/**
 * Copyright Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ciao;
import com.google.android.gms.auth.api.credentials.Credential;

public class CodelabUtil {

    /**
     * Check whether or not given username and password pair exist in UsernamesAndPassword class.
     */
    public static boolean isValidCredential(String username, String password) {
        if ((username.equals(com.ciao.UsernamesAndPasswords.username1) && password.equals(com.ciao.UsernamesAndPasswords.password1)) ||
                (username.equals(com.ciao.UsernamesAndPasswords.username2) && password.equals(com.ciao.UsernamesAndPasswords.password2)) ||
                (username.equals(com.ciao.UsernamesAndPasswords.username3) && password.equals(com.ciao.UsernamesAndPasswords.password3))) {
            return true;
        }
        return false;
    }

    // ***************** Add isValidCredential overload here ********************

    public static boolean isValidCredential(Credential credential) {
        String username = credential.getId();
        String password = credential.getPassword();
        return isValidCredential(username, password);
    }

    // ******************* End isValidCredential overload ***********************

    /**
     * Check if given username starts an existing username in the UsernamesAndPassword class.
     */
    public static boolean isValidUsernameSoFar(String username) {
        return com.ciao.UsernamesAndPasswords.username1.startsWith(username) ||
                com.ciao.UsernamesAndPasswords.username2.startsWith(username) ||
                com.ciao.UsernamesAndPasswords.username3.startsWith(username);
    }

    /**
     * Check if the password starts an existing password and matches an existing username in the
     * UsernamesAndPassword class.
     */
    public static boolean isValidPasswordSoFar(String username, String password) {
        if (username.equals(com.ciao.UsernamesAndPasswords.username1) &&
                com.ciao.UsernamesAndPasswords.password1.startsWith(password)) {
            return true;
        } else if (username.equals(com.ciao.UsernamesAndPasswords.username2) &&
                com.ciao.UsernamesAndPasswords.password2.startsWith(password)) {
            return true;
        } else if (username.equals(com.ciao.UsernamesAndPasswords.username3) &&
                com.ciao.UsernamesAndPasswords.password3.startsWith(password)) {
            return true;
        }
        return false;
    }

}
