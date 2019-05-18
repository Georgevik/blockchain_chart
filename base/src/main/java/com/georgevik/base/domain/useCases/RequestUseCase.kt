package com.georgevik.base.domain.useCases

import io.reactivex.Single

interface RequestUseCase<OUTPUT, INPUT> {

    fun execute(input: INPUT): Single<OUTPUT>
}