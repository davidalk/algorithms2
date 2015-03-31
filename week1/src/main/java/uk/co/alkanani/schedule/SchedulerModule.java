package uk.co.alkanani.schedule;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import uk.co.alkanani.domain.Job;

import java.util.Comparator;

public class SchedulerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<Comparator<Job>>(){}).annotatedWith(Names.named("Difference"))
                .to(DifferenceJobComparator.class);

        bind(new TypeLiteral<Comparator<Job>>(){}).annotatedWith(Names.named("Ratio"))
                .to(RatioJobComparator.class);
    }
}
