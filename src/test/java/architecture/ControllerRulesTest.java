package architecture;


import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static architecture.ArchitectureConstants.*;
import static architecture.CommonRules.*;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
class ControllerRulesTest {

    // Classes
    @ArchTest
    static final ArchRule component_annotation_is_not_allowed = componentAnnotationIsNotAllowedRule(CONTROLLER_PACKAGE);

    @ArchTest
    static final ArchRule classes_should_be_annotated = classes()
            .that().resideInAPackage(CONTROLLER_PACKAGE).should()
            .beAnnotatedWith(RestController.class)
            .andShould().notBeAnnotatedWith(Controller.class)
            .because(String.format(ANNOTATED_EXPLANATION, CONTROLLER_SUFFIX, "@RestController") + ", and not with @Controller");


    // Fields
    @ArchTest
    static final ArchRule fields_should_not_be_public = fieldsShouldNotBePublic(CONTROLLER_PACKAGE);

    // Constructors
    @ArchTest
    static final ArchRule constructors_should_not_be_private = publicConstructorsRule(CONTROLLER_PACKAGE);

    // Methods
    @ArchTest
    static final ArchRule bean_methods_are_not_allowed = beanMethodsAreNotAllowedRule(CONTROLLER_PACKAGE);

    @ArchTest
    static final ArchRule private_methods_are_not_allowed = privateMethodsAreNotAllowedRule(CONTROLLER_PACKAGE);

    @ArchTest
    static final ArchRule static_methods_are_not_allowed = staticMethodsAreNotAllowedRule(CONTROLLER_PACKAGE);

    @ArchTest
    static final ArchRule methods_should_return_response_entity = methods()
            .that().arePublic().and()
            .areDeclaredInClassesThat().resideInAPackage(CONTROLLER_PACKAGE).should()
            .haveRawReturnType(ResponseEntity.class)
            .because("Controller endpoints should return a ResponseEntity object");

    @ArchTest
    static final ArchRule methods_should_be_annotated_with_valid_annotations = methods()
            .that().arePublic().and()
            .areDeclaredInClassesThat().resideInAPackage(CONTROLLER_PACKAGE)
            .should().beAnnotatedWith(PostMapping.class)
            .orShould().beAnnotatedWith(GetMapping.class)
            .orShould().beAnnotatedWith(DeleteMapping.class)
            .orShould().beAnnotatedWith(PatchMapping.class)
            .orShould().beAnnotatedWith(PutMapping.class)
            .because("Controller methods should be annotated only with valid options of REST (POST, PUT, PATCH, GET, and DELETE)");

    @Test
    void test() {
        JavaClasses jc = new ClassFileImporter().importPackages(DEFAULT_PACKAGE);
        methods_should_return_response_entity.check(jc);
    }
}