package org.kabasakalis.publisher;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * A bean producing random exoplanets every 5 seconds.
 * The prices are written to a Kafka topic (exoplanet-discovered). The Kafka configuration is specified in the application configuration.
 */
@ApplicationScoped
public class ExoplanetPublisher {

  private Random random = new Random();

  @Outgoing("exoplanet-discovered")
  public Flowable<Integer> generate() {
    return Flowable.interval(5, TimeUnit.SECONDS)
            .map(tick -> random.nextInt(100));
  }

}