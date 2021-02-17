package com.mstf.basekotlinmvvm.data.local.db.dao

import androidx.room.*
import com.mstf.basekotlinmvvm.data.model.db.SampleEntity

@Dao
interface SampleDao {
    @Delete
    fun delete(sampleEntity: SampleEntity)

    @Query("SELECT * FROM sample_entity WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String?): SampleEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(sampleEntity: SampleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(sampleEntities: List<SampleEntity>)

    @Query("SELECT * FROM sample_entity")
    fun loadAll(): List<SampleEntity>?

    @Query("SELECT * FROM sample_entity WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: List<Int>): List<SampleEntity>?
}