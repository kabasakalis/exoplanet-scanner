package org.kabasakalis.interceptor;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

/**
 * A bean consuming data from the "exoplanet-discovered" Kafka topic and applying some conversion.
 * The result is pushed to the "exoplanet-stream" stream which is an in-memory stream.
 */
@ApplicationScoped
public class Processor {

  private static final String EXOPLANET_DISCOVERED = "Exoplanet discovered: ";

  @Incoming("exoplanet-discovered")
  @Outgoing("exoplanet-processed")
  @Broadcast
  public String process(int exoplanet) {
    return EXOPLANET_DISCOVERED + exoplanet;
  }

}
