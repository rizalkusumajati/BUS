package com.riztech.bus.data.mapper

import com.riztech.bus.data.db.BusTable
import com.riztech.bus.data.model.BusApiResponse
import com.riztech.bus.domain.model.DomainEntity
import javax.inject.Inject

class BusMapper @Inject constructor() {

    fun lineDataToDomainEntity(line: BusTable.Line): DomainEntity.Line = DomainEntity.Line(
        line.id,
        line.name,
        line.plc_ip_address
    )

    fun listLineDataToDomainEntity(lines: List<BusTable.Line>): List<DomainEntity.Line> {
        val entities = arrayListOf<DomainEntity.Line>()
        for (line in lines){
            entities.add(lineDataToDomainEntity(line))
        }
        return entities
    }

    fun lineDataNetworkToDataLocal(line: BusApiResponse.Content): BusTable.Line = BusTable.Line(
        line.description,
        line.id,
        line.name,
        line.plc_ip_address
    )

    fun listLineDataNetworkToDataLocal(lines: List<BusApiResponse.Content>): List<BusTable.Line> {
        val data = arrayListOf<BusTable.Line>()
        for (line in lines){
            data.add(lineDataNetworkToDataLocal(line))
        }
        return data
    }


}