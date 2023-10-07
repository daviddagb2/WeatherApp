package com.gonzalez.blanchard.data.mappers.responses

import com.gonzalez.blanchard.domain.base.models.ErrorBO
import com.gonzalez.blanchard.domain.base.models.ErrorDetailBO
import com.gonzalez.blanchard.models.ErrorResponse

fun ErrorResponse.toErrorBO(): ErrorBO {
    return ErrorBO(
        success = this.success ?: false,
        error = this.error?.toErrorDetailBO() ?: ErrorDetailBO(
            code = 0,
            type = "",
            info = "",
        ),
    )
}
