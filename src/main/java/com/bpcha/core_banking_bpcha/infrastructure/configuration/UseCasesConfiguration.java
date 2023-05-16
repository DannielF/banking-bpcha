package com.bpcha.core_banking_bpcha.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@RequiredArgsConstructor
@ComponentScan(basePackages = "com.bpcha.core_banking_bpcha.domain.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        }, useDefaultFilters = false)
public class UseCasesConfiguration {
}
