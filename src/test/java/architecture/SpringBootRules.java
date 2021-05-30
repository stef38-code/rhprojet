package architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static architecture.ArchitectureConstants.DEFAULT_PACKAGE;
import static com.tngtech.archunit.lang.conditions.ArchConditions.beAnnotatedWith;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
public class SpringBootRules {
    /**
     * Ne plus utiliser @Autowired
     */
    @ArchTest
    static final ArchRule do_not_use_field_injection = noFields()
            .should(beAnnotatedWith("org.springframework.beans.factory.annotation.Autowired"))
            .orShould(beAnnotatedWith("org.springframework.beans.factory.annotation.Value"))
            .because("l'injection par Autowired n'est pas autorisée," +
                    " utilisez private final ..... et l'annotation @RequiredArgsConstructor au niveau de la classe, " +
                    "see http://olivergierke.de/2013/11/why-field-injection-is-evil/");


}
