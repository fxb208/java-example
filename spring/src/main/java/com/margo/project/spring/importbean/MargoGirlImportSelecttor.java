package com.margo.project.spring.importbean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MargoGirlImportSelecttor implements ImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		importingClassMetadata.getAnnotationTypes().forEach(System.out::println);
        return new String[]{MargoGirlImport.class.getName()};
	}

}
