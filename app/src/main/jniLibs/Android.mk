LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := calculator_lib-prebuilt
LOCAL_SRC_FILES := $(TARGET_ARCH_ABI)/libcalculator_lib.so
LOCAL_EXPORT_C_INCLUDES := $(LOCAL_PATH)/include
include $(PREBUILT_SHARED_LIBRARY)