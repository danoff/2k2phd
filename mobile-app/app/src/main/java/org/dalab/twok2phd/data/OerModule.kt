package org.dalab.twok2phd.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.dalab.twok2phd.domain.OerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class OerModule {
    @Binds
    @Singleton
    abstract fun bindOerRepository(impl: FakeOerRepository): OerRepository
}
