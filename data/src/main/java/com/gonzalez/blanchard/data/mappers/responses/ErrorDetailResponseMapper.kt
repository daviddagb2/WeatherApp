package com.gonzalez.blanchard.data.mappers.responses

import com.gonzalez.blanchard.domain.base.models.ErrorDetailBO
import com.gonzalez.blanchard.models.ErrorDetailResponse

fun ErrorDetailResponse.toErrorDetailBO(): ErrorDetailBO {
    return ErrorDetailBO(
        code = this.code ?: 0,
        type = this.type ?: "",
        info = this.info ?: "",
    )
}
