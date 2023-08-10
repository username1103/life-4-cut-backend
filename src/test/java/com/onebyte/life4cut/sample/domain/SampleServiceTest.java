package com.onebyte.life4cut.sample.domain;

import com.onebyte.life4cut.common.vo.Email;
import com.onebyte.life4cut.fixture.SampleFixtureFactoryFactory;
import com.onebyte.life4cut.sample.repository.SampleRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SampleServiceTest {

    private final SampleRepository sampleRepository = mock(SampleRepositoryImpl.class);

    private final SampleService sampleService = new SampleService(sampleRepository);

    private final SampleFixtureFactoryFactory sampleFixtureFactory = new SampleFixtureFactoryFactory();

    @Nested
    class CreateSample {
        @Test
        @DisplayName("샘플을 생성하고 생성된 샘플의 ID를 반환한다.")
        void createSample() {
            // given
            Email email = Email.of("test@gmail.com");
            String nickname = "nickname";
            
            Sample sample = sampleFixtureFactory.make((entity, builder) -> {
                builder.set("id", 1L);
                builder.set("email", email);
                builder.set("nickname", nickname);
            });

            when(sampleRepository.save(any())).thenReturn(sample);

            // when
            Long sampleId = sampleService.createSample(email, nickname);

            // then
            assertThat(sampleId).isEqualTo(1L);
        }
    }
}
