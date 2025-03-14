package br.com.matheusjuan.todolist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.matheusjuan.todolist.data.model.User

@Entity(tableName = "tb_user")
data class UserEntity(
    @PrimaryKey val id: String,
    val username: String,
    val name: String,
    val createdAt: String
) {
    fun toDomainModel() = User(
        id, username, name, "", createdAt
    )
}
