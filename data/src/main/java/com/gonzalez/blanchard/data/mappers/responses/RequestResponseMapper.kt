package com.gonzalez.blanchard.data.mappers.responses

import com.gonzalez.blanchard.domain.base.models.RequestBO
import com.gonzalez.blanchard.models.RequestResponse

fun RequestResponse.toRequestBO(): RequestBO {
    return RequestBO(
        type = this.type ?: "",
        query = this.query ?: "",
        language = this.language ?: "",
        unit = this.unit ?: "",
        
    )
}
