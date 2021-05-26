package architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static architecture.ArchitectureConstants.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
class LayeredArchitectureTest {
    private static final String CONFIG = "Config";
    private static final String CONTROLLER = "Controller";
    private static final String DTO = "Dto";
    private static final String MAPPER = "Mapper";
    private static final String EXCEPTION = "Exception";
    private static final String MODEL = "Model";
    private static final String REPOSITORY = "Repository";
    private static final String SECURITY = "Security";
    private static final String SERVICE = "Service";
    private static final String UTIL = "Util";

    @ArchTest
    static final ArchRule layeredArchitectureRule = layeredArchitecture()
            //Definition de la structure de base du projet
            .layer(CONFIG).definedBy(CONFIG_PACKAGE)
            .layer(CONTROLLER).definedBy(CONTROLLER_PACKAGE)
            .layer(DTO).definedBy(DTO_PACKAGE)
            .layer(EXCEPTION).definedBy(EXCEPTION_PACKAGE)
            .layer(MODEL).definedBy(MODEL_PACKAGE)
            .layer(REPOSITORY).definedBy(REPOSITORY_PACKAGE)
            .layer(SECURITY).definedBy(SECURITY_PACKAGE)
            .layer(SERVICE).definedBy(SERVICE_PACKAGE)
            .layer(MAPPER).definedBy(MAPPER_PACKAGE)
            .layer(UTIL).definedBy(UTIL_PACKAGE)
            //Definition des liaisons d'accès entre les packages/classes
            .whereLayer(CONTROLLER).mayNotBeAccessedByAnyLayer()
            .whereLayer(MODEL).mayOnlyBeAccessedByLayers(REPOSITORY, SERVICE)
            .whereLayer(REPOSITORY).mayOnlyBeAccessedByLayers(SERVICE)
            // un service peut être dans un contrôler et ou dans un autre service
            // MapStruct genere un @component
            .whereLayer(SERVICE).mayOnlyBeAccessedByLayers(CONTROLLER, SERVICE, MAPPER);

    @Test
    @DisplayName("Contrôle de l'architecutre")
        // @Disabled
    void testLayeredArchitectureRule() {
        JavaClasses jc = new ClassFileImporter().importPackages(DEFAULT_PACKAGE);
        layeredArchitectureRule.check(jc);
    }
}