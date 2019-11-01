package com.hospital.processor;

import com.hospital.annotations.MedicalRecordType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianhua.shi on 2019/9/15
 * @project hospital-api-spec
 */
public class MedicalRecordProcessor implements BeanFactoryPostProcessor {

    private static final String MEDICAL_RECORD_PACKAGE  =  "com.hospital.handler.biz";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        Map<String,Class> medicalRecordHandlerMap = new HashMap<>();

        ClassScanner.scan(MEDICAL_RECORD_PACKAGE, MedicalRecordType.class).forEach(clazz -> {
            // 获取注解中的类型值
            String type = clazz.getAnnotation(MedicalRecordType.class).value();
            // 将注解中的类型值作为key，对应的类作为value，保存在Map中
            medicalRecordHandlerMap.put(type, clazz);
        });
        // 初始化HandlerContext，将其注册到spring容器中
        HandlerContext context = new HandlerContext(medicalRecordHandlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);


    }
}
