package com.im.core;

import com.im.model.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

public class AppBeanUtils {

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

    public static void copyNotNullProperties(Account fromObject, Account toObject) {
        String[] nullPropertyNames = AppBeanUtils.getNullPropertyNames(fromObject);
        BeanUtils.copyProperties(fromObject, toObject, nullPropertyNames);
    }
}
