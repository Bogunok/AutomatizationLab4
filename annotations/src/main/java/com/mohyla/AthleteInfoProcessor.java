package com.mohyla;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.example.annotations.GenerateAthleteInfo")
@SupportedSourceVersion(SourceVersion.RELEASE_17) // Updated to support Java 17
public class AthleteInfoProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateAthleteInfo.class)) {
            GenerateAthleteInfo info = element.getAnnotation(GenerateAthleteInfo.class);
            String className = element.getSimpleName() + "Info";
            String packageName = processingEnv.getElementUtils().getPackageOf(element).getQualifiedName().toString();

            try {
                JavaFileObject file = processingEnv.getFiler().createSourceFile(packageName + ".generated." + className);
                try (Writer writer = file.openWriter()) {
                    writer.write("package " + packageName + ".generated;\n\n");
                    writer.write("public class " + className + " {\n\n");
                    writer.write("    public static String getSport() {\n");
                    writer.write("        return \"" + info.sport() + "\";\n");
                    writer.write("    }\n\n");
                    writer.write("}\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}