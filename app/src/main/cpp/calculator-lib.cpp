#include <jni.h>
#include <string>
static JavaVM *javaVm = nullptr;
jclass store_listener= nullptr;

extern "C" JNIEXPORT jstring JNICALL
Java_com_ndkdemoexample_activity_MainActivity_stringFromJNI(JNIEnv* env,jobject /* this */) {
    std::string hello = "WelCome TO NDK Calculation Demo";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_ndkdemoexample_activity_MainActivity_add( JNIEnv *env, jobject, jint x, jint y) {

    //return an integer
    return x + y;
}

//Subtraction function
extern "C" JNIEXPORT jint JNICALL
Java_com_ndkdemoexample_activity_MainActivity_sub( JNIEnv *env, jobject, jint x, jint y) {

    //return an integer
    return x - y;
}

//Multiplication function
extern "C" JNIEXPORT jint JNICALL
Java_com_ndkdemoexample_activity_MainActivity_multiply( JNIEnv *env, jobject, jint x, jint y) {

    //return an integer
    return x * y;
}

//Division function
extern "C" JNIEXPORT jint JNICALL
Java_com_ndkdemoexample_activity_MainActivity_divide( JNIEnv *env, jobject, jint x, jint y) {

    //return an integer
    return x / y;
}


// call back from the CPP to android
extern "C"
JNIEXPORT jobject JNICALL
Java_com_ndkdemoexample_activity_JNICallBackScreen_initCallBack(JNIEnv *env,jobject,jobject jniCallBack)
{
    env ->GetJavaVM(&javaVm);
    store_listener = static_cast<jclass>(env->NewGlobalRef(jniCallBack));
    return nullptr;

}

extern "C"
JNIEXPORT jobject JNICALL
Java_com_ndkdemoexample_activity_JNICallBackScreen_changeValue(JNIEnv *env, jobject thiz, jint value) {

    if(store_listener != nullptr){
        jclass clazz =env->GetObjectClass(store_listener);
        jmethodID storeMethod = env->GetMethodID(clazz,"callBackWithValue","(I)V");
        env->CallVoidMethod(store_listener,storeMethod,value);
    }else
    {

    }
    return nullptr;
}