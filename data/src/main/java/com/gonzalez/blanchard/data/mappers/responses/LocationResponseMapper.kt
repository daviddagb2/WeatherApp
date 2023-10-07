package com.gonzalez.blanchard.data.mappers.responses

import com.gonzalez.blanchard.domain.base.models.LocationBO
import com.gonzalez.blanchard.models.LocationResponse

class LocationResponseMapper

fun LocationResponse.toLocationBO(): LocationBO {
    return LocationBO(
        name = this.name ?: "",
        country = this.country ?: "",
        region = this.region ?: "",
        lat = this.latitude ?: "",
        lon = this.longitude ?: "",
        timezoneId = this.timezoneId ?: "",
        localtime = this.localtime ?: "",
        localtimeEpoch = this.localtimeEpoch ?: 0,
        utcOffset = this.utcOffset ?: "",
    )
}
