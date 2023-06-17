package com.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@Configuration
public class Observation {

	@Bean
	ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
		observationRegistry.observationConfig().observationHandler(new PerformanceTrackerHandler());
		return new ObservedAspect(observationRegistry);
	}
}
