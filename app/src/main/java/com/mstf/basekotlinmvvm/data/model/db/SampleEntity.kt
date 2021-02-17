package com.mstf.basekotlinmvvm.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample_entity")
class SampleEntity {

    @ColumnInfo(name = "created_at")
    var createdAt: String? = null

    @PrimaryKey
    var id: Long? = null

    var name: String? = null

    @ColumnInfo(name = "updated_at")
    var updatedAt: String? = null
}