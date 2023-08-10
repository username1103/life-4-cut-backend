package com.onebyte.life4cut.sample.domain;

import com.onebyte.life4cut.common.vo.Email;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public Long createSample(Email email, String nickname) {
        Sample sample = sampleRepository.save(Sample.create(nickname, email));

        return sample.getId();
    }
}
