package com.zimo.wangbangqi.utils;

import javassist.bytecode.CodeAttribute;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.util.Collection;

/**
 *
 */
public class CopyUtil {
    /**
     * Copy properties of orig to dest Exception the Entity and Collection Type
     *
     * @param dest
     * @param orig
     * @return
     */
    public static Object copyProperties(Object dest,Object orig){
        if(dest == null || orig == null ){
            return dest;
        }
        //
        PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(dest);

        try {
            for (int i=0; i<descriptors.length; i++){
                Class destType = descriptors[i].getPropertyType();
                Class origType = PropertyUtils.getPropertyType(orig,descriptors[i].getName());
                if (destType != null && destType.equals(origType) && !destType.equals(Class.class)){
                    if (!Collection.class.isAssignableFrom(origType)){
                        try {
                            Object value = PropertyUtils.getProperty(orig, descriptors[i].getName());
                            PropertyUtils.setProperty(dest, descriptors[i].getName(), value);
                        } catch (Exception e){

                        }
                    }
                }
            }

        } catch (Exception ex){
            throw new CodeAttribute.RuntimeCopyException(ex.getMessage());
        }
        return dest;
    }
}
