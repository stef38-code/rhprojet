package architecture;

import ch.qos.logback.classic.Logger;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Bean;

import static architecture.ArchitectureConstants.DEFAULT_PACKAGE;
import static com.tngtech.archunit.lang.conditions.ArchConditions.beAnnotatedWith;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
class GeneralCodingRulesTest {

    //Classes
    @ArchTest
    static final ArchRule noAccessToStandardStreams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
    @ArchTest
    static final ArchRule noClassesShouldUseJodatime = NO_CLASSES_SHOULD_USE_JODATIME
            .because("Utilisez plutôt des objets java.time");

    @ArchTest
    static final ArchRule noGenericExceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS
            .because("Throw AlmundoException or any child of this instead");

    @ArchTest
    static final ArchRule noJavaUtilLogging = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING
            .because("Utilisez plutôt org.slf4j.Logger ou @Slf4j");

    //Fields
    @ArchTest
    static final ArchRule loggersShouldBePrivateStaticAndFinal = fields().that().haveRawType(Logger.class)
            .should().bePrivate()
            .andShould().beStatic()
            .andShould().beFinal()
            .andShould().haveName("LOGGER")
            .because("Les variables de tracing doivent être privées, statiques et définitives, et elles doivent être nommées log");


    @ArchTest
    static final ArchRule finalStaticVariablesInUppercase = fields().that().areStatic().and().areFinal()
            .and().doNotHaveName("serialVersionUID")
            .and().doNotHaveName("log")
            .and().doNotHaveModifier(JavaModifier.SYNTHETIC)
            .should().haveNameMatching(".*^[A-Z].*")
            .because("Variables with static and final modifiers should be named in uppercase");

    //Methods
    @ArchTest
    static final ArchRule beanMethodsShouldBePublic = methods().that().areAnnotatedWith(Bean.class).should().bePublic()
            .because("L'annotation @Bean ne fonctionne pas dans les méthodes non publiques");

    @ArchTest
    static final ArchRule do_not_use_field_injection = noFields()
            .should(beAnnotatedWith("org.springframework.beans.factory.annotation.Autowired"))
            .orShould(beAnnotatedWith("org.springframework.beans.factory.annotation.Value"))
            .because("field injection is evil, see http://olivergierke.de/2013/11/why-field-injection-is-evil/");
}
