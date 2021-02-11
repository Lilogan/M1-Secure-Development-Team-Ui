#include <jni.h>
#include <string>

extern "C"
jstring
Java_fr_isen_teamui_api_ApiHelper_baseUrlFromJNI(
        JNIEnv *env,
        __unused jclass clazz) {
    std::string baseURL = "https://6007f1a4309f8b0017ee5022.mockapi.io/api/m1/";
    return env->NewStringUTF(baseURL.c_str());
}

extern "C"
jstring
Java_fr_isen_teamui_database_TeamuiDatabase_passphraseFromJNI(
        JNIEnv *env,
        __unused jclass clazz) {
    std::string passphrase = "f9e683d9cff1e1144516f4443930181f";
    return env->NewStringUTF(passphrase.c_str());
}

