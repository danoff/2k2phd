package org.dalab.twok2phd.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.dalab.twok2phd.analytics.InMemoryTelemetryRepository
import org.dalab.twok2phd.analytics.TelemetryRepository
import org.dalab.twok2phd.domain.oer.FakeOerRecommendationRepository
import org.dalab.twok2phd.domain.oer.OerRecommendationRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindTelemetryRepository(
        repository: InMemoryTelemetryRepository
    ): TelemetryRepository

    @Binds
    @Singleton
    abstract fun bindOerRecommendationRepository(
        repository: FakeOerRecommendationRepository
    ): OerRecommendationRepository
}
