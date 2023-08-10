package com.onebyte.life4cut.fixture;

import com.navercorp.fixturemonkey.ArbitraryBuilder;
import com.onebyte.life4cut.sample.domain.Sample;
import jakarta.persistence.EntityManager;

import java.util.function.BiConsumer;

public class SampleFixtureFactoryFactory extends DefaultFixtureFactory<Sample> {


    public Sample make(BiConsumer<Sample, ArbitraryBuilder<Sample>> builder) {
        return fixtureMonkey.giveMeBuilder(Sample.class).thenApply(builder).build().sample();

    }
}
